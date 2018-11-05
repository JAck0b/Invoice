// Copyright[2018] Jakub Filistyński
// Invoice.java

package jakubfilistynski;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * This class represents invoice.
 */
class Invoice {
  private String sellerFirstName;
  private String sellerLastName;
  private String customerFirstName;
  private String customerLastName;
  private List<Product> productList;

  /**
   * Constructor.
   * @param condition switch which constructor should be used
   */
  Invoice(boolean condition) {
    if (condition) {
      productList = new LinkedList<>();
    } else {
      init();
    }
  }

  /**
   * This method is responsible for getting data from user.
   */
  private void init() {
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

  /**
   * Setter of product list.
   * @param productList list of products in invoice
   */
  void setProductList(List<Product> productList) {
    this.productList = productList;
  }

  /**
   * Setter of seller's first name.
   * @param name seller's first name
   * @throws EmptyLineException empty name exception
   */
  void setSellerFirstName(String name) throws EmptyLineException {
    if (name.replaceAll("\\s", "").isEmpty()) {
      throw new EmptyLineException("Empty name. Try again.");
    }
    this.sellerFirstName = name;
  }

  /**
   * Setter of seller's last name.
   * @param name seller's last name
   * @throws EmptyLineException empty name exception
   */
  void setSellerLastName(String name) throws EmptyLineException {
    if (name.replaceAll("\\s", "").isEmpty()) {
      throw new EmptyLineException("Empty name. Try again.");
    }
    this.sellerLastName = name;
  }

  /**
   * Setter of customer's first name.
   * @param name customer's first name
   * @throws EmptyLineException empty name exception
   */
  void setCustomerFirstName(String name) throws EmptyLineException {
    if (name.replaceAll("\\s", "").isEmpty()) {
      throw new EmptyLineException("Empty name. Try again.");
    }
    this.customerFirstName = name;
  }

  /**
   * Setter of customer's last name.
   * @param name customer's last name
   * @throws EmptyLineException empty name exception
   */
  void setCustomerLastName(String name) throws EmptyLineException {
    if (name.replaceAll("\\s", "").isEmpty()) {
      throw new EmptyLineException("Empty name. Try again.");
    }
    this.customerLastName = name;
  }

  /**
   * This method adds new product to the list of products.
   */
  void add() {
    productList.add(new Product());
  }

  /**
   * This method displays informations about invoice.
   */
  void display() {
    System.out.println("Seller: " + sellerFirstName + " " + sellerLastName);
    System.out.println("Customer: " + customerFirstName + " " + customerLastName);
    System.out.println();
    double sum = 0;
    int counter = 1;
    for (Product x: productList) {
      System.out.println("Id: " + Integer.toString(counter));
      sum += x.info();
      counter++;
    }
    System.out.println("Total cost = " + Double.toString(sum));
    System.out.println("\n");
  }

  /**
   * This method deletes particular product form list of products.
   */
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

  /**
   * This method saves invoice.
   */
  void save() {
    JsonFileWrite.save(sellerFirstName, sellerLastName, customerFirstName,
        customerLastName, productList);
  }

  /**
   * This method loads existing invoice.
   */
  void load() {
    JsonFileReader.load(this);
  }

  /**
   * This method creates new invoice and sometimes saves current one.
   */
  void create() {
    Scanner in = new Scanner(System.in);
    System.out.println("Do you want to save current invoice first? [y/n]");
    label:
    do {
      String tmp = in.nextLine();
      switch (tmp) {
        case "y":
        case "Y":
          save();
          break label;
        case "n":
        case "N":
          break label;
        default:
          System.out.println("Invalid command.Try again.");
          System.out.println("Do you want to save current invoice first? [y/n]");
          break;
      }
    } while (true);
  }
}
