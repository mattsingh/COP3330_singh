import java.time.LocalDate;

public class TaskItem {

  private String title;
  private String description;
  private LocalDate dueDate;
  private boolean completed;


  public TaskItem(String title, String description, LocalDate dueDate) {
    this.title = title;
    this.description = description;
    this.dueDate = dueDate;
    this.completed = false;
  }

  @Override
  public String toString() {
    return (completed ? "*** " : "") + "[" + dueDate + "]" + " " + title + ": " + description;
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

  public boolean isCompleted() {
    return completed;
  }

  public void setCompleted(boolean completed) {
    this.completed = completed;
  }
}
