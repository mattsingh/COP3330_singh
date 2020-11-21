import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class TaskList implements Serializable {

  ArrayList<TaskItem> tasks = new ArrayList<>();

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

  public void markCompleted(int index) {
    tasks.get(index).setCompleted(true);
  }

  public void unmarkCompleted(int index) {
    tasks.get(index).setCompleted(false);
  }

  public int getSize() {
    return tasks.size();
  }

  public TaskItem get(int index) {
    return tasks.get(index);
  }

  public void save(String name) {
    if(tasks.isEmpty())
      throw new IllegalStateException("task list is empty");
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(name))) {
      oos.writeObject(this);
    } catch(IOException ex) {
      ex.printStackTrace();
    }
  }
  public static TaskList load(String name) throws IOException {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(name))) {
      return (TaskList) ois.readObject();
    } catch(ClassNotFoundException ex) {
      ex.printStackTrace();
    }
    return null;
  }
}
