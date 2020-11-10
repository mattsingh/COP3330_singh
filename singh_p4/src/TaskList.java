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

  public int getSize() {
    return tasks.size();
  }

  public TaskItem get(int index) {
    return tasks.get(index);
  }

  public void save(String name) {
    try {
      FileOutputStream fos = new FileOutputStream(name);
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(this);
      oos.close();
      fos.close();
    } catch(IOException ex) {
      ex.printStackTrace();
    }
  }
  public static TaskList load(String name) {
    try {
      FileInputStream fis = new FileInputStream(name);
      ObjectInputStream ois = new ObjectInputStream(fis);
      TaskList tasks = (TaskList) ois.readObject();
      ois.close();
      fis.close();
      return tasks;
    } catch(IOException ex) {
      ex.printStackTrace();
    } catch(ClassNotFoundException ex) {
      ex.printStackTrace();
    }
    return null;
  }
}
