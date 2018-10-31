package jakubfilistynski;




import org.json.JSONArray;
import org.json.JSONObject;

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
    String napis = obj.getString("Name");
    System.out.println(napis);
    JSONArray product = new JSONArray();
    product.put("zupa psia");
    product.put("zupa koza");
    obj.put("Produkt", product);
    for (int i = 0; i < obj.getJSONArray("Produkt").length(); i++) {
      System.out.println(obj.getJSONArray("Produkt").getString(i));
    }
////
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
