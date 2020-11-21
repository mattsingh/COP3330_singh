import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class TaskItemTest {
  @Test
  public void creatingTaskItemFailsWithInvalidDueDate() {
    assertThrows(DateTimeParseException.class, () -> {
      new TaskItem("Title", "Description", LocalDate.parse("2020-1-1"));
    });
  }
  @Test
  public void creatingTaskItemFailsWithInvalidTitle() {
    assertThrows(IllegalArgumentException.class, () -> {
      new TaskItem("", "Description", LocalDate.parse("2020-01-01"));
    });
  }
  @Test
  public void creatingTaskItemSucceedsWithValidDueDate() {
    new TaskItem("Title", "Description", LocalDate.parse("2020-01-01"));
  }
  @Test
  public void creatingTaskItemSucceedsWithValidTitle() {
    new TaskItem("Title", "Description", LocalDate.parse("2020-01-01"));
  }
  @Test
  public void settingTaskItemDueDateFailsWithInvalidDate() {
    assertThrows(DateTimeParseException.class, () -> {
      TaskList list = new TaskList();
      list.add(new TaskItem("Title", "Description", LocalDate.parse("2020-01-01")));
      list.edit(0, "Title", "Description", LocalDate.parse("2020-1-01"));
    });
  }
  @Test
  public void settingTaskItemDueDateSucceedsWithValidDate() {
    TaskList list = new TaskList();
    list.add(new TaskItem("Title", "Description", LocalDate.parse("2020-01-01")));
    list.edit(0, "Title", "Description", LocalDate.parse("2020-01-01"));
  }
  @Test
  public void settingTaskItemTitleFailsWithInvalidTitle() {
    assertThrows(IllegalArgumentException.class, () -> {
      TaskList list = new TaskList();
      list.add(new TaskItem("Title", "Description", LocalDate.parse("2020-01-01")));
      list.edit(0, "", "Description", LocalDate.parse("2020-01-01"));
    });
  }
  @Test
  public void settingTaskItemTitleSucceedsWithValidTitle() {
    TaskList list = new TaskList();
    list.add(new TaskItem("Title", "Description", LocalDate.parse("2020-01-01")));
    list.edit(0, "Title", "Description", LocalDate.parse("2020-01-01"));
  }
}
