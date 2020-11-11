import org.junit.jupiter.api.*;
import java.time.LocalDate;

public class TaskListTest {
  @Test
  public void addingTaskItemsIncreasesSize() {
    TaskList tasks = new TaskList();
    tasks.add(new TaskItem("Title", "Description", LocalDate.parse("2020-01-01")));
    Assertions.assertEquals(tasks.getSize(), 1);
    tasks.add(new TaskItem("Title", "Description", LocalDate.parse("2020-01-01")));
    Assertions.assertEquals(tasks.getSize(), 2);
  }
  @Test
  public void completingTaskItemChangesStatus() {
    TaskList tasks = new TaskList();
    tasks.add(new TaskItem("Title", "Description", LocalDate.parse("2020-01-01")));
    tasks.markCompleted(0);
    Assertions.assertEquals(tasks.get(0).isCompleted(), true);
  }
  @Test
  public void completingTaskItemFailsWithInvalidIndex() {
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
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
    Assertions.assertEquals(tasks.get(0).getTitle(), "newTitle");
    Assertions.assertEquals(tasks.get(0).getDescription(), "newDescription");
    Assertions.assertEquals(tasks.get(0).getDueDate(), LocalDate.parse("2020-01-30"));
  }
  @Test
  public void editingTaskItemDescriptionChangesValue() {
    TaskList tasks = new TaskList();
    tasks.add(new TaskItem("Title", "Description", LocalDate.parse("2020-01-01")));
    tasks.edit(0, "newTitle", "newDescription", LocalDate.parse("2020-01-30"));
    Assertions.assertEquals(tasks.get(0).getDescription(), "newDescription");
  }
  @Test
  public void editingTaskItemDescriptionFailsWithInvalidIndex() {
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
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
    Assertions.assertEquals(tasks.get(0).getDueDate(), LocalDate.parse("2020-01-30"));
  }
  @Test
  public void editingTaskItemDueDateFailsWithInvalidIndex() {
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
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
    Assertions.assertEquals(tasks.get(0).getTitle(), "newTitle");
  }
  @Test
  public void editingTaskItemTitleFailsWithInvalidIndex() {
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
      TaskList tasks = new TaskList();
      tasks.add(new TaskItem("Title", "Description", LocalDate.parse("2020-01-01")));
      tasks.edit(1, "newTitle", "newDescription", LocalDate.parse("2020-01-30"));
    });
  }
  @Test
  public void gettingTaskItemDescriptionFailsWithInvalidIndex() {
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
      TaskList tasks = new TaskList();
      tasks.add(new TaskItem("Title", "Description", LocalDate.parse("2020-01-01")));
      tasks.get(1).getDescription();
    });
  }
  @Test
  public void gettingTaskItemDescriptionSucceedsWithValidIndex() {
    TaskList tasks = new TaskList();
    tasks.add(new TaskItem("Title", "Description", LocalDate.parse("2020-01-01")));
    Assertions.assertEquals(tasks.get(0).getDescription(), "Description");
  }
  @Test
  public void gettingTaskItemDueDateFailsWithInvalidIndex() {
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
      TaskList tasks = new TaskList();
      tasks.add(new TaskItem("Title", "Description", LocalDate.parse("2020-01-01")));
      tasks.get(1).getDueDate();
    });
  }
  @Test
  public void gettingTaskItemDueDateSucceedsWithValidIndex() {
    TaskList tasks = new TaskList();
    tasks.add(new TaskItem("Title", "Description", LocalDate.parse("2020-01-01")));
    Assertions.assertEquals(tasks.get(0).getDueDate(), LocalDate.parse("2020-01-01"));
  }
  @Test
  public void gettingTaskItemTitleFailsWithInvalidIndex() {
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
      TaskList tasks = new TaskList();
      tasks.add(new TaskItem("Title", "Description", LocalDate.parse("2020-01-01")));
      tasks.get(1).getTitle();
    });
  }
  @Test
  public void gettingTaskItemTitleSucceedsWithValidIndex() {
    TaskList tasks = new TaskList();
    tasks.add(new TaskItem("Title", "Description", LocalDate.parse("2020-01-01")));
    Assertions.assertEquals(tasks.get(0).getTitle(), "Title");
  }
  @Test
  public void newTaskListIsEmpty() {
    TaskList tasks = new TaskList();
    Assertions.assertEquals(tasks.getSize(), 0);
  }
  @Test
  public void removingTaskItemsDecreasesSize() {
    TaskList tasks = new TaskList();
    tasks.add(new TaskItem("Title", "Description", LocalDate.parse("2020-01-01")));
    Assertions.assertEquals(tasks.getSize(), 1);
    tasks.remove(0);
    Assertions.assertEquals(tasks.getSize(), 0);

  }
  @Test
  public void removingTaskItemsFailsWithInvalidIndex() {
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
      TaskList tasks = new TaskList();
      tasks.add(new TaskItem("Title", "Description", LocalDate.parse("2020-01-01")));
      tasks.remove(1);
    });
  }
  @Test
  public void savedTaskListCanBeLoaded() {
    TaskList tasks = new TaskList();
    tasks.add(new TaskItem("Title", "Description", LocalDate.parse("2020-01-01")));
    tasks.add(new TaskItem("Title 2", "Description 2", LocalDate.parse("2020-12-01")));
    tasks.save("test.tmp");
    TaskList loadedTask = TaskList.load(("test.tmp"));
    for (int i = 0; i < loadedTask.getSize(); i++) {
      Assertions.assertEquals(tasks.get(i).toString(), loadedTask.get(i).toString());
    }
  }
  @Test
  public void uncompletingTaskItemChangesStatus() {
    TaskList tasks = new TaskList();
    tasks.add(new TaskItem("Title", "Description", LocalDate.parse("2020-01-01")));
    tasks.unmarkCompleted(0);
    Assertions.assertEquals(tasks.get(0).isCompleted(), false);
  }
  @Test
  public void uncompletingTaskItemFailsWithInvalidIndex() {
   Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
     TaskList tasks = new TaskList();
     tasks.add(new TaskItem("Title", "Description", LocalDate.parse("2020-01-01")));
     tasks.unmarkCompleted(1);
    });
  }
}
