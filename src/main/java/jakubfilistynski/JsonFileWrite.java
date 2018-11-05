// Copyright[2018] Jakub Filistyński
// JsonFileWrite.java

package jakubfilistynski;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * This class is responsible for writting invoice into json's file.
 */
class JsonFileWrite {

  /**
   * Empty constructor.
   */
  JsonFileWrite() {}

  /**
   * This method prepare's data to save and saves them.
   * @param sellerFirstName seller's first name
   * @param sellerLastName seller's last name
   * @param customerFirstName customer's first name
   * @param customerLastName customer's last name
   * @param productList list of products
   */
  static void save(String sellerFirstName, String sellerLastName, String customerFirstName,
                    String customerLastName, List<Product> productList) {
    boolean condition = false;
    Scanner in = new Scanner(System.in);
    String name;
    System.out.println("Enter file's name.");
    do {
      name = in.nextLine();
      if (name.replaceAll("\\s", "").isEmpty()) {
        System.out.println("Empty line. Try again.");
        continue;
      }
      if (!name.matches("[a-zA-Z]+")) {
        System.out.println("Invalid name. Try again.");
        continue;
      }
      condition = true;
    } while (!condition);
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("Seller First Name", sellerFirstName);
    jsonObject.put("Seller Last Name", sellerLastName);
    jsonObject.put("Customer First Name", customerFirstName);
    jsonObject.put("Customer Last Name", customerLastName);
    JSONArray products = new JSONArray();
    for (Product x: productList) {
      JSONArray tmp = new JSONArray();
      tmp.put(x.getName());
      tmp.put(x.getQuantity());
      tmp.put(x.getPrice());
      tmp.put(x.getTotalCost());
      products.put(tmp);
    }
    jsonObject.put("Products", products);

    push(jsonObject, name);
  }

  /**
   * This class saves data into file.
   * @param obj ready json's object
   * @param path name of file
   */
  private static void push(JSONObject obj, String path) {
    try {
      final String filePath = "./Invoices/" + path + ".json";
      FileWriter file = new FileWriter(filePath);
      file.write(obj.toString());
      file.flush();
      file.close();
    } catch (IOException e) {
      System.out.println("Failure. Try again.");
    }
  }

}
