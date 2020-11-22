import java.util.ArrayList;

public class ContactList {

  ArrayList<ContactItem> contacts = new ArrayList<>();

  public void add(ContactItem item) {
    contacts.add(item);
  }

  public ContactItem edit(int index, String firstName, String lastName, String phoneNumber, String emailAddress) {
    contacts.set(index, new ContactItem(firstName, lastName, phoneNumber, emailAddress));
  }

  public ContactItem remove(int index) {
    contacts.remove(index);
  }

  public ContactItem get(int index) {
    return contacts.get(index);
  }

  public int getSize() {
    return contacts.size();
  }
}
