// Copyright[2018] Jakub Filistyński
// App.java

package jakubfilistynski;

import java.io.File;

/**
 * Main Class.
 */

public class App {

  /**
   * Main class.
   * @param args default arguments
   */
  public static void main(String[] args) {
    File file = new File("./Invoices");
    if (!file.exists() || !file.isDirectory()) {
      File dir = new File("./Invoices");
      boolean condition = dir.mkdir();
      if (!condition) {
        System.out.println("Folder hasn't created.");
        System.exit(1);
      }
    }
    Interface.init();
  }


}
