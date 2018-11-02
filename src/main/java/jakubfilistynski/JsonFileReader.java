package jakubfilistynski;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;

import org.json.JSONArray;
import org.json.JSONObject;

class JsonFileReader {

  JsonFileReader() {}

  static void load(Invoice invoice) {
    info();
    System.out.println("\n");
    Scanner in = new Scanner(System.in);
    try {
      System.out.println("Enter full file's name.");
      String filePath = "./Invoices/" + in.nextLine();
      File file = new File(filePath);
      String content = FileUtils.readFileToString(file, "utf-8");
      JSONObject jsonObject = new JSONObject(content);
      invoice.setSellerFirstName(jsonObject.get("Seller First Name").toString());
      invoice.setSellerLastName(jsonObject.get("Seller Last Name").toString());
      invoice.setCustomerFirstName(jsonObject.get("Customer First Name").toString());
      invoice.setCustomerLastName(jsonObject.get("Customer Last Name").toString());
      List<Product> tmpList = new LinkedList<>();
      JSONArray jsonArray = jsonObject.getJSONArray("Products");
      for (int i = 0; i < jsonArray.length(); i++) {
        JSONArray tmpArray = jsonArray.getJSONArray(i);
        tmpList.add(new Product(tmpArray.getString(0), tmpArray.getInt(1),
            tmpArray.getDouble(2), tmpArray.getDouble(3)));
      }
      invoice.setProductList(tmpList);
    } catch (FileNotFoundException ie) {
      System.out.println("This file doesn't exist. Try again.");
    } catch (EmptyLineException | IOException e) {
      e.printStackTrace();
    }
  }

  private static void info() {
    File folder = new File("./Invoices/");
    File[] listOfFiles = folder.listFiles();
    Pattern myPattern = Pattern.compile(".*\\.json");

    assert listOfFiles != null : "Wrong data.";
    for (File file : listOfFiles) {
      Matcher matcher = myPattern.matcher(file.getName());
      if (file.isFile() && matcher.find()) {
        System.out.println(file.getName());
      }
    }
  }

}
