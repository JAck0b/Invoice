package jakubfilistynski;

import java.util.InputMismatchException;
import java.util.Scanner;

class Product {
  private String name;
  private int quantity;
  private double price;
  private double totalCost;

  Product() {
    boolean condition = false;
    Scanner in = new Scanner(System.in);

    System.out.println("Enter name of the product.");
    do {
      try {
        setName(in.nextLine());
        condition = true;
      } catch (EmptyLineException e) {
        System.out.println(e.getMessage());
      }
    } while (!condition);

    condition = false;

    System.out.println("Enter quantity of the product.");
    do {
      try {
        quantity = in.nextInt();
        condition = true;
      } catch (InputMismatchException ie) {
        System.out.println("This is not natural number. Try again.");
        in.nextLine();
      }
    } while (!condition);

    condition = false;

    System.out.println("Enter price of the product.");
    do {
      try {
        price = in.nextDouble();
        condition = true;
      } catch (InputMismatchException ie) {
        System.out.println("This is not real number. Try again.");
        in.nextLine();
      }
    } while (!condition);

    this.totalCost = quantity * price;
  }

  private void setName(String name) throws EmptyLineException {
    if (name.replaceAll("\\s", "").isEmpty()) {
      throw new EmptyLineException("Empty name. Try again.");
    }
    this.name = name;
  }

  void info() {
    System.out.println("Name: " + name);
    System.out.println("Quantity: " + Integer.toString(quantity));
    System.out.println("Price: " + Double.toString(price));
    System.out.println("Total cost: " + Double.toString(totalCost) + "\n");
  }
}
