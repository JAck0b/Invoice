package jakubfilistynski;

import java.util.Scanner;

/**
 * This class is responsible for interface.
 */

class Interface {
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
        case "add":
          System.out.println("add");
          break;
        case "delete":
          System.out.println("delete");
          break;
        case "display":
          System.out.println("display");
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
