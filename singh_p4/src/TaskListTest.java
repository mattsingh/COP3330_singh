import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;

public class TaskListTest {
  @Test
  public void addingTaskItemsIncreasesSize() {
    TaskList tasks = new TaskList();
    tasks.add(new TaskItem("Title", "Description", LocalDate.parse("2020-01-01")));
    assertEquals(tasks.getSize(), 1);
    tasks.add(new TaskItem("Title", "Description", LocalDate.parse("2020-01-01")));
    assertEquals(tasks.getSize(), 2);
  }
  @Test
  public void completingTaskItemChangesStatus() {
    TaskList tasks = new TaskList();
    tasks.add(new TaskItem("Title", "Description", LocalDate.parse("2020-01-01")));
    tasks.markCompleted(0);
    assertEquals(tasks.get(0).isCompleted(), true);
  }
  @Test
  public void completingTaskItemFailsWithInvalidIndex() {
    assertThrows(IndexOutOfBoundsException.class, () -> {
      TaskList tasks = new TaskList();
      tasks.add(new TaskItem("Title", "Description", LocalDate.parse("2020-01-01")));
      tasks.markCompleted(1);
    });
  }
  @Test
  public void editingTaskItemChangesValues() {
    TaskList tasks = new TaskList();
    tasks.add(new TaskItem("Title", "Description", LocalDate.parse("2020-01-01")));
    tasks.edit(0, "newTitle", "newDescription", LocalDate.parse("2020-01-30"));
    assertEquals(tasks.get(0).getTitle(), "newTitle");
    assertEquals(tasks.get(0).getDescription(), "newDescription");
    assertEquals(tasks.get(0).getDueDate(), LocalDate.parse("2020-01-30"));
  }
  @Test
  public void editingTaskItemDescriptionChangesValue() {
    TaskList tasks = new TaskList();
    tasks.add(new TaskItem("Title", "Description", LocalDate.parse("2020-01-01")));
    tasks.edit(0, "newTitle", "newDescription", LocalDate.parse("2020-01-30"));
    assertEquals(tasks.get(0).getDescription(), "newDescription");
  }
  @Test
  public void editingTaskItemDescriptionFailsWithInvalidIndex() {
    assertThrows(IndexOutOfBoundsException.class, () -> {
      TaskList tasks = new TaskList();
      tasks.add(new TaskItem("Title", "Description", LocalDate.parse("2020-01-01")));
      tasks.edit(1, "newTitle", "newDescription", LocalDate.parse("2020-01-30"));
    });
  }
  @Test
  public void editingTaskItemDueDateChangesValue() {
    TaskList tasks = new TaskList();
    tasks.add(new TaskItem("Title", "Description", LocalDate.parse("2020-01-01")));
    tasks.edit(0, "newTitle", "newDescription", LocalDate.parse("2020-01-30"));
    assertEquals(tasks.get(0).getDueDate(), LocalDate.parse("2020-01-30"));
  }
  @Test
  public void editingTaskItemDueDateFailsWithInvalidIndex() {
    assertThrows(IndexOutOfBoundsException.class, () -> {
      TaskList tasks = new TaskList();
      tasks.add(new TaskItem("Title", "Description", LocalDate.parse("2020-01-01")));
      tasks.edit(1, "newTitle", "newDescription", LocalDate.parse("2020-01-30"));
    });
  }
  @Test
  public void editingTaskItemTitleChangesValue() {
    TaskList tasks = new TaskList();
    tasks.add(new TaskItem("Title", "Description", LocalDate.parse("2020-01-01")));
    tasks.edit(0, "newTitle", "newDescription", LocalDate.parse("2020-01-30"));
    assertEquals(tasks.get(0).getTitle(), "newTitle");
  }
  @Test
  public void editingTaskItemTitleFailsWithInvalidIndex() {
    assertThrows(IndexOutOfBoundsException.class, () -> {
      TaskList tasks = new TaskList();
      tasks.add(new TaskItem("Title", "Description", LocalDate.parse("2020-01-01")));
      tasks.edit(1, "newTitle", "newDescription", LocalDate.parse("2020-01-30"));
    });
  }
  @Test
  public void gettingTaskItemDescriptionFailsWithInvalidIndex() {
    assertThrows(IndexOutOfBoundsException.class, () -> {
      TaskList tasks = new TaskList();
      tasks.add(new TaskItem("Title", "Description", LocalDate.parse("2020-01-01")));
      tasks.get(1).getDescription();
    });
  }
  @Test
  public void gettingTaskItemDescriptionSucceedsWithValidIndex() {
    TaskList tasks = new TaskList();
    tasks.add(new TaskItem("Title", "Description", LocalDate.parse("2020-01-01")));
    assertEquals(tasks.get(0).getDescription(), "Description");
  }
  @Test
  public void gettingTaskItemDueDateFailsWithInvalidIndex() {
    assertThrows(IndexOutOfBoundsException.class, () -> {
      TaskList tasks = new TaskList();
      tasks.add(new TaskItem("Title", "Description", LocalDate.parse("2020-01-01")));
      tasks.get(1).getDueDate();
    });
  }
  @Test
  public void gettingTaskItemDueDateSucceedsWithValidIndex() {
    TaskList tasks = new TaskList();
    tasks.add(new TaskItem("Title", "Description", LocalDate.parse("2020-01-01")));
    assertEquals(tasks.get(0).getDueDate(), LocalDate.parse("2020-01-01"));
  }
  @Test
  public void gettingTaskItemTitleFailsWithInvalidIndex() {
    assertThrows(IndexOutOfBoundsException.class, () -> {
      TaskList tasks = new TaskList();
      tasks.add(new TaskItem("Title", "Description", LocalDate.parse("2020-01-01")));
      tasks.get(1).getTitle();
    });
  }
  @Test
  public void gettingTaskItemTitleSucceedsWithValidIndex() {
    TaskList tasks = new TaskList();
    tasks.add(new TaskItem("Title", "Description", LocalDate.parse("2020-01-01")));
    assertEquals(tasks.get(0).getTitle(), "Title");
  }
  @Test
  public void newTaskListIsEmpty() {
    TaskList tasks = new TaskList();
    assertEquals(tasks.getSize(), 0);
  }
  @Test
  public void removingTaskItemsDecreasesSize() {
    TaskList tasks = new TaskList();
    tasks.add(new TaskItem("Title", "Description", LocalDate.parse("2020-01-01")));
    assertEquals(tasks.getSize(), 1);
    tasks.remove(0);
    assertEquals(tasks.getSize(), 0);

  }
  @Test
  public void removingTaskItemsFailsWithInvalidIndex() {
    assertThrows(IndexOutOfBoundsException.class, () -> {
      TaskList tasks = new TaskList();
      tasks.add(new TaskItem("Title", "Description", LocalDate.parse("2020-01-01")));
      tasks.remove(1);
    });
  }
  @Test
  public void savedTaskListCanBeLoaded() throws IOException {
    TaskList tasks = new TaskList();
    tasks.add(new TaskItem("Title", "Description", LocalDate.parse("2020-01-01")));
    tasks.add(new TaskItem("Title 2", "Description 2", LocalDate.parse("2020-12-01")));
    tasks.save("test.tmp");
    TaskList loadedTask = TaskList.load(("test.tmp"));
    for (int i = 0; i < loadedTask.getSize(); i++) {
      assertEquals(tasks.get(i).toString(), loadedTask.get(i).toString());
    }
  }
  @Test
  public void uncompletingTaskItemChangesStatus() {
    TaskList tasks = new TaskList();
    tasks.add(new TaskItem("Title", "Description", LocalDate.parse("2020-01-01")));
    tasks.unmarkCompleted(0);
    assertEquals(tasks.get(0).isCompleted(), false);
  }
  @Test
  public void uncompletingTaskItemFailsWithInvalidIndex() {
   assertThrows(IndexOutOfBoundsException.class, () -> {
     TaskList tasks = new TaskList();
     tasks.add(new TaskItem("Title", "Description", LocalDate.parse("2020-01-01")));
     tasks.unmarkCompleted(1);
    });
  }
}
