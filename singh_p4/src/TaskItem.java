import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class TaskItem {
  private static Scanner in = new Scanner(System.in);

  private String title;
  private String description;
  private LocalDate dueDate;

  public TaskItem() {
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
  }

  @Override
  public String toString() {
    return "[" + dueDate + "]" + " " + title + ": " + description;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public LocalDate getDueDate() {
    return dueDate;
  }

  public void setDueDate(LocalDate dueDate) {
    this.dueDate = dueDate;
  }
}
