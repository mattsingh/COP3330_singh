import java.util.Scanner;

public class App {
  private static Scanner in = new Scanner(System.in);
  private static int input;

  public static void main(String[] args) {
    mainMenu();
  }

  private static void mainMenu() {
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
          TaskList list = new TaskList();
          taskListMenu(list);
          break;
        case 2:
//          loadTaskList();
          break;
        case 3:
          return;
      }
    }
  }

  private static void taskListMenu(TaskList list) {
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
          list.print();
          break;
        case 2:
          list.add();
          break;
        case 3:
          list.print();
          System.out.print("Which task will you edit? ");
          list.edit(in.nextInt());
          break;
        case 4:
          list.print();
          System.out.print("Which task will you remove? ");
          list.remove(in.nextInt());
          break;
        case 5:
          break;
        case 6:
          break;
        case 7:
          break;
        case 8:
          return;
      }
    }
  }
}