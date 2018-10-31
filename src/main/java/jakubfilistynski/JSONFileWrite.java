package jakubfilistynski;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


import java.io.FileWriter;
import java.io.IOException;

class Tmp {
  String nazwa;
  int ilosc;
  Tmp() {
    nazwa = "kjfd";
    ilosc = 45;
  }
}

class JSONFileWrite {
  public static void main(String[] args) {
    JSONObject obj = new JSONObject();
    obj.put("Name", "Jakub");
    obj.put("Last name", "Filistyński");
    String napis = obj.get("Name").toString();
    System.out.println(napis);
    JSONArray product = new JSONArray();
    product.add("dfj");
    product.add("zupa koza");
    obj.put("Produkt", product);
    product = (JSONArray) obj.get("Produkt");
    for (JSONObject x: (JSONObject) product) {
      System.out.println(x.toString());
    }
//
//
//    try  {
//      FileWriter file = new FileWriter("/home/jakub/Dokumenty/plik.txt");
//      file.write(obj.toJSONString());
//      System.out.println("Successfully Copied JSON Object to File...");
//      System.out.println("\nJSON Object: " + obj);
//      file.flush();
//      file.close();
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
  }
}
