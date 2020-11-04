import java.time.LocalDate;
import java.util.ArrayList;

public class TaskList {

  ArrayList<TaskItem> tasks = new ArrayList<>();

  public TaskList() {
    System.out.println("new task list has been created");
  }

  public void add(TaskItem item) {
    tasks.add(item);
  }

  public TaskItem edit(int index, String title, String description, LocalDate dueDate) {
    tasks.get(index).setTitle(title);
    tasks.get(index).setDescription(description);
    tasks.get(index).setDueDate(dueDate);
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

  public void markCompleted(int index) {
    tasks.get(index).setCompleted(true);
  }

  public void unmarkCompleted(int index) {
    tasks.get(index).setCompleted(false);
  }
}
