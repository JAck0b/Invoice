// Copyright[2018] Jakub Filistyński
// Info.java

package jakubfilistynski;

/**
 * This class is responsible for displaying all commands.
 */
public class Info {

  /**
   * Empty constructor.
   */
  public Info() {}

  /**
   * Method which print information about commands.
   */
  static void write() {
    System.out.println("new - Create new invoice.\n"
        + "add - Add new product.\n"
        + "delete - Delete product\n"
        + "info - Display all commands.\n"
        + "display - Display invoice.\n"
        + "save - Save current invoice.\n"
        + "load - Load existing invoice.\n"
        + "exit - Shut down program.");
  }

  /**
   * Method which print special symbol at the beggining of new line.
   */
  static void ready() {
    System.out.print("$ ");
  }
}
