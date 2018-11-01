package jakubfilistynski;

import java.util.Scanner;

/**
 * This class is responsible for interface.
 */
class Interface {
  private Invoice invoice = new Invoice();

  /**
   * Interface constructor.
   */
  Interface() {
    String command = "";
    Scanner in = new Scanner(System.in);
    Info.write();
    Info.ready();
    while (!command.equals("exit")) {
      command = in.nextLine();
      switch (command) {
        case "new":
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
          System.out.println("save");
          break;
        case "load":
          System.out.println("load");
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
