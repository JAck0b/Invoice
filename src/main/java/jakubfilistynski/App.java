package jakubfilistynski;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

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
      dir.mkdir();
    }
    Interface inter = new Interface();
  }
}
