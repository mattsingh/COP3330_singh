import java.io.*;
import java.util.ArrayList;

public class ContactList implements Serializable{

  private ArrayList<ContactItem> contacts = new ArrayList<>();

  public void add(ContactItem item) {
    contacts.add(item);
  }

  public ContactItem edit(int index, String firstName, String lastName, String phoneNumber, String emailAddress) {
    contacts.set(index, new ContactItem(firstName, lastName, phoneNumber, emailAddress));
    return contacts.get(index);
  }

  public ContactItem remove(int index) {
    return contacts.remove(index);
  }

  public ContactItem get(int index) {
    return contacts.get(index);
  }

  public int getSize() {
    return contacts.size();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder()
            .append("Current Contacts\n" +
                    "-------------\n" +
                    "\n");
    for (int i = 0; i < contacts.size(); i++) {
      sb.append(i + ") "+ contacts.get(i));
    }

    return sb.toString();
  }

  public void save(String name) {
    if(contacts.isEmpty())
      throw new IllegalStateException("contact list is empty");
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(name))) {
      oos.writeObject(this);
    } catch(IOException ex) {
      ex.printStackTrace();
    }
  }
  public static ContactList load(String name) throws IOException {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(name))) {
      return (ContactList) ois.readObject();
    } catch(ClassNotFoundException ex) {
      ex.printStackTrace();
    }
    return null;
  }
}
