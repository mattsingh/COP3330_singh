import java.time.DateTimeException;
import java.time.LocalDate;
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
          System.out.println("new task list has been created");
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
        in.nextLine(); //clear buffer
      } while(input < 1 || input > 8);

      switch(input) {
        case 1:
          list.print();
          in.nextLine();
          break;
        case 2:
          list.add(createTaskItem());
          break;
        case 3:
          int index;
          String title, description;
          LocalDate dueDate;

          list.print();
          System.out.print("Which task will you edit? ");
          index = in.nextInt();
          in.nextLine();
          System.out.print("Enter a new title for task " + index + ": ");
          title = in.nextLine();
          System.out.print("Enter a new description for task " + index + ": ");
          description = in.nextLine();
          System.out.print("Enter a new task due date (YYYY-MM-DD) for task " + index + ": ");
          dueDate = LocalDate.parse(in.nextLine());

          list.edit(index, title, description, dueDate);
          break;
        case 4:
          list.print();
          System.out.print("Which task will you remove? ");
          list.remove(in.nextInt());
          break;
        case 5:
          System.out.print("Which task will you mark as completed? ");
          list.markCompleted(in.nextInt());
          break;
        case 6:
          System.out.print("Which task will you unmark as completed? ");
          list.unmarkCompleted(in.nextInt());
          break;
        case 7:
          break;
        case 8:
          return;
      }
    }
  }
  public static TaskItem createTaskItem() {
    String title;
    String description;
    LocalDate dueDate;

    System.out.print("Task title: ");
    title = in.nextLine();
    System.out.print("Task description: ");
    description = in.nextLine();
    while(true) {
      try {
        System.out.print("Task due date (YYYY-MM-DD): ");
        dueDate = LocalDate.parse(in.nextLine());
        break;
      } catch (DateTimeException e) {
        System.out.println("Date must be in the format of YYYY-MM-DD");
      }
    }
    System.out.println();

    return new TaskItem(title, description, dueDate);
  }
}