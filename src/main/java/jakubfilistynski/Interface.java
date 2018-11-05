// Copyright[2018] Jakub Filistyński
// Interface.java

package jakubfilistynski;

import java.util.Scanner;

/**
 * This class is responsible for interface.
 */
class Interface {


  /**
   * Interface constructor.
   */
  Interface() {}

  /**
   * This method is responsible for interface.
   */
  static void init() {
    String command = "";
    Scanner in = new Scanner(System.in);
    Invoice invoice = new Invoice(true);
    Info.ready();
    System.out.println("What do you want to do?\nnew - Create new invoice.\n"
        + "load - Load existing invoice.\n" + "exit - Shut down the program.");
    while (!(command.equals("exit") || command.equals("new") || command.equals("load"))) {
      command = in.nextLine();
      switch (command) {
        case "new":
          invoice = new Invoice(false);
          break;
        case "load":
          invoice = new Invoice(true);
          invoice.load();
          break;
        case "exit":
          System.exit(0);
          break;
        default:
          System.out.println("Invalid command.");
      }
    }
    Info.write();
    Info.ready();
    while (!command.equals("exit")) {
      command = in.nextLine();
      switch (command) {
        case "new":
          invoice.create();
          invoice = new Invoice(false);
          break;
        case "add":
          invoice.add();
          break;
        case "delete":
          invoice.delete();
          break;
        case "display":
          invoice.display();
          break;
        case "save":
          invoice.save();
          break;
        case "load":
          invoice.load();
          break;
        case "info":
          Info.write();
          break;
        case "exit":
          System.exit(0);
          break;
        default:
          System.out.println("Invalid command. Use info for more information.");
      }
      Info.ready();
    }
  }
}
