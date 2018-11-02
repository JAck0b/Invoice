package jakubfilistynski;

import java.util.Scanner;

/**
 * This class is responsible for interface.
 */
class Interface {
  private Invoice invoice;

  /**
   * Interface constructor.
   */
  Interface() {
    invoice = new Invoice();
    String command = "";
    Scanner in = new Scanner(System.in);
    Info.write();
    Info.ready();
    while (!command.equals("exit")) {
      command = in.nextLine();
      switch (command) {
        case "new":
          invoice.create();
          invoice = new Invoice();
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
