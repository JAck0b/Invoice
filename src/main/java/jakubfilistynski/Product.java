// Copyright[2018] Jakub Filistyński
// Product.java

package jakubfilistynski;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class represents product.
 */
class Product {
  private String name;
  private int quantity;
  private double price;
  private double totalCost;

  /**
   * This constructor create new product.
   */
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
        setQuantity(in.nextInt());
        condition = true;
      } catch (InputMismatchException ie) {
        System.out.println("This is not natural number. Try again.");
        in.nextLine();
      } catch (NegativeNumberException ne) {
        System.out.println(ne.getMessage());
        in.nextLine();
      }
    } while (!condition);

    condition = false;

    System.out.println("Enter price of the product.");
    do {
      try {
        setPrice(in.nextDouble());
        condition = true;
      } catch (InputMismatchException ie) {
        System.out.println("This is not real number. Try again.");
        in.nextLine();
      } catch (NegativeNumberException ne) {
        System.out.println(ne.getMessage());
        in.nextLine();
      }
    } while (!condition);

    this.totalCost = quantity * price;
  }

  /**
   * This constructor loads existing product.
   * @param name name of product
   * @param quantity quantity of product
   * @param price price of product
   * @param totalCost total cost of this products
   */
  Product(String name, int quantity, double price, double totalCost) {
    this.name = name;
    this.quantity = quantity;
    this.price = price;
    this.totalCost = totalCost;
  }

  /**
   * Setter of name of product.
   * @param name name of product
   * @throws EmptyLineException empty name of product
   */
  void setName(String name) throws EmptyLineException {
    if (name.replaceAll("\\s", "").isEmpty()) {
      throw new EmptyLineException("Empty name. Try again.");
    }
    this.name = name;
  }

  /**
   * Setter of quantity of product.
   * @param quantity quantity of product
   * @throws NegativeNumberException negative quantity
   */
  void setQuantity(int quantity) throws NegativeNumberException {
    if (quantity <= 0) {
      throw new NegativeNumberException("Negative number.Try again.");
    }
    this.quantity = quantity;
  }

  /**
   * Setter of price of product.
   * @param price price of product
   * @throws NegativeNumberException negative quantity
   */
  void setPrice(double price) throws NegativeNumberException {
    if (price <= 0) {
      throw new NegativeNumberException("Negative number.Try again.");
    }
    this.price = price;
  }

  /**
   * This method print informations about product.
   * @return total cost of this one
   */
  double info() {
    System.out.println("Name: " + name);
    System.out.println("Quantity: " + Integer.toString(quantity));
    System.out.println("Price: " + Double.toString(price));
    System.out.println("Total cost: " + Double.toString(totalCost) + "\n");
    return totalCost;
  }

  /**
   * Getter of name of product.
   * @return name of product
   */
  String getName() {
    return name;
  }

  /**
   * Getter of quantity of product.
   * @return quantity of product
   */
  String getQuantity() {
    return Integer.toString(quantity);
  }

  /**
   * Getter of price of product.
   * @return price of product
   */
  String getPrice() {
    return Double.toString(price);
  }

  /**
   * Getter of total cost of products.
   * @return total cost of products
   */
  String getTotalCost() {
    return Double.toString(totalCost);
  }
}
