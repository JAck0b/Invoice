package jakubfilistynski;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Invoice {
  private String sellerFirstName;
  private String sellerLastName;
  private String customerFirstName;
  private String customerLastName;
  private List<Product> productList;

  Invoice() {
    Scanner in = new Scanner(System.in);
    boolean condition = false;

    System.out.println("Enter first name of seller.");
    do {
      try {
        setSellerFirstName(in.nextLine());
        condition = true;
      } catch (EmptyLineException e) {
        System.out.println(e.getMessage());
      }
    } while (!condition);

    condition = false;

    System.out.println("Enter last name of seller.");
    do {
      try {
        setSellerLastName(in.nextLine());
        condition = true;
      } catch (EmptyLineException e) {
        System.out.println(e.getMessage());
      }
    } while (!condition);

    condition = false;

    System.out.println("Enter first name of customer.");
    do {
      try {
        setCustomerFirstName(in.nextLine());
        condition = true;
      } catch (EmptyLineException e) {
        System.out.println(e.getMessage());
      }
    } while (!condition);

    condition = false;

    System.out.println("Enter last name of customer.");
    do {
      try {
        setCustomerLastName(in.nextLine());
        condition = true;
      } catch (EmptyLineException e) {
        System.out.println(e.getMessage());
      }
    } while (!condition);

    productList = new LinkedList<>();
  }

  Invoice(String sellerFirstName, String sellerLastName, String customerFirstName, String customerLastName) {
    this.sellerFirstName = sellerFirstName;
    this.sellerLastName = sellerLastName;
    this.customerFirstName = customerFirstName;
    this.customerLastName = customerLastName;
    productList = new LinkedList<>();
  }

  void setProductList(List<Product> productList) {
    this.productList = productList;
  }

  void setSellerFirstName(String name) throws EmptyLineException {
    if (name.replaceAll("\\s", "").isEmpty()) {
      throw new EmptyLineException("Empty name. Try again.");
    }
    this.sellerFirstName = name;
  }

  void setSellerLastName(String name) throws EmptyLineException {
    if (name.replaceAll("\\s", "").isEmpty()) {
      throw new EmptyLineException("Empty name. Try again.");
    }
    this.sellerLastName = name;
  }

  void setCustomerFirstName(String name) throws EmptyLineException {
    if (name.replaceAll("\\s", "").isEmpty()) {
      throw new EmptyLineException("Empty name. Try again.");
    }
    this.customerFirstName = name;
  }

  void setCustomerLastName(String name) throws EmptyLineException {
    if (name.replaceAll("\\s", "").isEmpty()) {
      throw new EmptyLineException("Empty name. Try again.");
    }
    this.customerLastName = name;
  }

  void add() {
    productList.add(new Product());
  }

  void display() {
    System.out.println("Seller: " + sellerFirstName + " " + sellerLastName);
    System.out.println("Customer: " + customerFirstName + " " + customerLastName);
    System.out.println();
    int counter = 1;
    for (Product x: productList) {
      System.out.println("Id: " + Integer.toString(counter));
      x.info();
      counter++;
    }
    System.out.println("\n");
  }

  void delete() {
    Scanner in = new Scanner(System.in);
    display();
    System.out.println("Enter product's id.");
    try {
      productList.remove(in.nextInt() - 1);
    } catch (IndexOutOfBoundsException ex) {
      System.out.println("Wrong product's id. Try again.");
      in.nextLine();
    } catch (InputMismatchException ie) {
      System.out.println("This is not natural number. Try again.");
      in.nextLine();
    }
  }

  void save() {
    JsonFileWrite.save(sellerFirstName, sellerLastName, customerFirstName,
        customerLastName, productList);
  }

  void load() {
    JsonFileReader.load(this);
  }

  void create() {
    Scanner in = new Scanner(System.in);
    System.out.println("Do you want to save current invoice first? [y/n]");
    do {
      String tmp = in.nextLine();
      if (tmp.equals("y") || tmp.equals("Y")) {
        save();
        break;
      } else if (tmp.equals("n") || tmp.equals("N")) {
        break;
      } else {
        System.out.println("Invalid command.Try again.");
        System.out.println("Do you want to save current invoice first? [y/n]");
      }
    } while (true);
  }
}
