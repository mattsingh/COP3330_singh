import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskList {
  private static Scanner in = new Scanner(System.in);
  ArrayList<TaskItem> tasks = new ArrayList<>();

  public TaskList() {
    System.out.println("new task list has been created");
  }

  public void add() {
    tasks.add(TaskItem.createTaskItem());
  }

  public TaskItem edit(int index) {
    System.out.print("Enter a new title for task " + index + ": ");
    tasks.get(index).setTitle(in.nextLine());
    System.out.print("Enter a new description for task " + index + ": ");
    tasks.get(index).setDescription(in.nextLine());
    System.out.print("Enter a new task due date (YYYY-MM-DD) for task " + index + ": ");
    tasks.get(index).setDueDate(LocalDate.parse(in.nextLine()));
    return tasks.get(index);
  }

  public TaskItem remove(int index) {
    return tasks.remove(index);
  }

  public void print() {
    System.out.println(
        "Current Tasks\n" +
        "-------------\n");

    for(int i = 0; i < tasks.size(); i++)
      System.out.println(i + ") " + tasks.get(i));
  }
}
