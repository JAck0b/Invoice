package jakubfilistynski;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

class JsonFileWrite {

  JsonFileWrite(String sellerFirstName, String sellerLastName, String customerFirstName,
                String customerLastName, List<Product> productList) {
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

//    System.out.println(jsonObject.toString());
    save(jsonObject);
  }

  private void save(JSONObject obj) {
    try {
      FileWriter file = new FileWriter("./file.txt");
      file.write(obj.toString());
      file.flush();
      file.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
