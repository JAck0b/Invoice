package jakubfilistynski;


import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

class JsonFileReader {

  JsonFileReader() {}
  static void load(Invoice invoice) {
    final String filePath = "./kuba.json";
    try {
      File file = new File("./kuba.json");
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
    } catch (IOException ie) {
      ie.printStackTrace();
    } catch (EmptyLineException e) {
      e.printStackTrace();
    }
  }
}
