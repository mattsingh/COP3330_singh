import java.util.Scanner;

public class App {
  private static Scanner in = new Scanner(System.in);

  public static void main(String[] args) {
    mainMenu();
  }

  private static void mainMenu() {
    int input = 0;

    while(true) {
      System.out.print(
          "Main Menu\n" +
          "---------\n" +
          "\n" +
          "1) create a new list\n" +
          "2) load an existing list\n" +
          "3) quit\n" +
          "\n");

      do {
        System.out.print("> ");
        input = in.nextInt();
      } while(input < 1 || input > 3);

      switch(input) {
        case 1:
          createTaskList();
          break;
        case 2:
          loadTaskList();
          break;
        case 3:
          break;
      }
    }
  }
  private static void taskListMenu(TaskList list) {
    int input = 0;

    while (true) {
      System.out.println(
          "List Operation Menu\n" +
          "---------\n" +
          "\n" +
          "1) view the list\n" +
          "2) add an item\n" +
          "3) edit an item\n" +
          "4) remove an item\n" +
          "5) mark an item as completed\n" +
          "6) unmark an item as completed\n" +
          "7) save the current list\n" +
          "8) quit to the main menu\n" +
          "\n");

      do {
        System.out.print("> ");
        input = in.nextInt();
      } while(input < 1 || input > 8);

      switch(input) {
        case 1:
          break;
        case 2:
          break;
        case 3:
          break;
        case 4:
          break;
        case 5:
          break;
        case 6:
          break;
        case 7:
          break;
        case 8:
          break;
      }
    }
  }
}