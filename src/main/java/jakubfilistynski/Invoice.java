package jakubfilistynski;

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
    } while(!condition);

    condition = false;

    System.out.println("Enter last name of seller.");
    do {
      try {
        setSellerLastName(in.nextLine());
        condition = true;
      } catch (EmptyLineException e) {
        System.out.println(e.getMessage());
      }
    } while(!condition);

    condition = false;

    System.out.println("Enter first name of customer.");
    do {
      try {
        setCustomerFirstName(in.nextLine());
        condition = true;
      } catch (EmptyLineException e) {
        System.out.println(e.getMessage());
      }
    } while(!condition);

    condition = false;

    System.out.println("Enter last name of customer.");
    do {
      try {
        setCustomerLastName(in.nextLine());
        condition = true;
      } catch (EmptyLineException e) {
        System.out.println(e.getMessage());
      }
    } while(!condition);

    productList = new LinkedList<>();
    data();
  }

  private void setSellerFirstName(String name) throws EmptyLineException{
    if(name.isEmpty()) {
      throw new EmptyLineException("Empty name. Try again.");
    }
    this.sellerFirstName = name;
  }

  private void setSellerLastName(String name) throws EmptyLineException{
    if(name.isEmpty()) {
      throw new EmptyLineException("Empty name. Try again.");
    }
    this.sellerLastName = name;
  }

  private void setCustomerFirstName(String name) throws EmptyLineException{
    if(name.isEmpty()) {
      throw new EmptyLineException("Empty name. Try again.");
    }
    this.customerFirstName = name;
  }

  private void setCustomerLastName(String name) throws EmptyLineException{
    if(name.isEmpty()) {
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
    for (Product x: productList) {
      x.info();
    }
    System.out.println("\n");
  }
  /**
   * Extra temporary method.
   */
  private void data() {
    System.out.println(sellerFirstName + " " + sellerLastName);
    System.out.println(customerFirstName + " " + customerLastName);
  }
}
