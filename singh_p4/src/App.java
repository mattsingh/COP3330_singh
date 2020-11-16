import java.io.InvalidObjectException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class App {
  private static Scanner in = new Scanner(System.in);

  public static void main(String[] args) {
    mainMenu();
  }

  private static void mainMenu() {
    int input = -1;

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
        try {
          input = Integer.parseInt(in.nextLine());
        } catch (NumberFormatException e) {
          System.out.println("WARNING: input must be an integer");
        }
      } while(input < 1 || input > 3);

      switch(input) {
        case 1:
          TaskList list = new TaskList();
          if(list != null)
            System.out.println("new task list has been created");
          taskListMenu(list);
          break;
        case 2:
          loadTaskList();
          break;
        case 3:
          return;
      }
    }
  }

  private static void taskListMenu(TaskList list) {
    int input = -1;
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
        try {
          input = Integer.parseInt(in.nextLine());
        } catch (NumberFormatException e) {
          System.out.println("WARNING: input must be an integer");
        }
      } while(input < 1 || input > 8);

      switch(input) {
        case 1:
          printList(list);
          System.out.print("Press ENTER to continue");
          in.nextLine();
          break;
        case 2:
          addTaskItem(list);
          break;
        case 3:
          editTaskList(list);
          break;
        case 4:
          printList(list);
          removeTaskItem(list);
          break;
        case 5:
          markTaskAsCompleted(list);
          break;
        case 6:
          unmarkTaskAsCompleted(list);
          break;
        case 7:
          saveTaskList(list);
          break;
        case 8:
          return;
      }
    }
  }

  private static void unmarkTaskAsCompleted(TaskList list) {
    try {
      System.out.print("Which task will you unmark as completed? ");
      list.unmarkCompleted(Integer.parseInt(in.nextLine()));
    } catch (IndexOutOfBoundsException e) {
      System.out.println("WARNING: invalid index; task item left as completed\n");
    }
  }

  private static void markTaskAsCompleted(TaskList list) {
    try {
      System.out.print("Which task will you mark as completed? ");
      list.markCompleted(Integer.parseInt(in.nextLine()));
    } catch (IndexOutOfBoundsException e) {
      System.out.println("WARNING: invalid index; task item not marked as completed\n");
    }
  }

  private static void removeTaskItem(TaskList list) {
    try {
      System.out.print("Which task will you remove? ");
      list.remove(Integer.parseInt(in.nextLine()));
    } catch (IndexOutOfBoundsException e) {
      System.out.println("WARNING: invalid index; task item not removed\n");
    }
  }


  private static void addTaskItem(TaskList list) {
    try {
      list.add(createTaskItem());
    } catch (IllegalArgumentException e) {
      System.out.println("WARNING: " + e.getMessage() + "; task not created\n");
    } catch (DateTimeParseException e) {
      System.out.println("WARNING: invalid due date; task not created\n");
    }
  }

  private static void editTaskList(TaskList list) {
    int index;
    String title, description;
    LocalDate dueDate;

    try {
      printList(list);
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
    } catch (DateTimeParseException e) {
      System.out.println("WARNING: invalid due date; task not edited\n");
    } catch (IndexOutOfBoundsException e) {
      System.out.println("WARNING: invalid index; task not edited\n");
    } catch (IllegalArgumentException e) {
      System.out.println("WARNING: " + e.getMessage() + "; task not edited\n");
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
    System.out.print("Task due date (YYYY-MM-DD): ");
    dueDate = LocalDate.parse(in.nextLine());
    System.out.println();

    return new TaskItem(title, description, dueDate);
  }

  private static void printList(TaskList list) {
    System.out.println(
        "Current Tasks\n" +
            "-------------\n");

    for(int i = 0; i < list.getSize(); i++)
      System.out.println(i + ") " + list.get(i));
  }

  private static void saveTaskList(TaskList list) {
    try {
      if(list.getSize() == 0)
        throw new InvalidObjectException("task list is empty");
      System.out.print("Enter the filename to save as: ");
      String name = in.nextLine();
      list.save(name);
    } catch (InvalidObjectException e) {
      System.out.println("WARNING: " + e.getMessage() + "; task list not saved\n");
    }
  }

  private static void loadTaskList() {
    System.out.print("Enter the filename to load: ");
    String name = in.nextLine();
    taskListMenu(TaskList.load(name));
  }
}
