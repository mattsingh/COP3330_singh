import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class ContactListTest {
    @Test
    public void addingItemsIncreasesSize() {
        ContactList contacts = new ContactList();
        assertEquals(0, contacts.getSize());
        contacts.add(new ContactItem("first", "last", "000-000-0000", "email@address.email"));
        assertEquals(1, contacts.getSize());
    }

    @Test
    public void editingItemsFailsWithAllBlankValues() {
        assertThrows(IllegalArgumentException.class, () -> {
            ContactList contacts = new ContactList();
            contacts.add(new ContactItem("first", "last", "000-000-0000", "email@address.email"));
            contacts.edit(0, "", "", "", "");
        });
    }

    @Test
    public void editingItemsFailsWithInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            ContactList contacts = new ContactList();
            contacts.add(new ContactItem("first", "last", "000-000-0000", "email@address.email"));
            contacts.edit(1, "first", "last", "000-000-0000", "email@address.email");
        });
    }

    @Test
    public void editingSucceedsWithBlankFirstName() {
        ContactList contacts = new ContactList();
        contacts.add(new ContactItem("first", "last", "000-000-0000", "email@address.email"));
        contacts.edit(0, "", "last", "000-000-0000", "email@address.email");
    }

    @Test
    public void editingSucceedsWithBlankLastName() {
        ContactList contacts = new ContactList();
        contacts.add(new ContactItem("first", "last", "000-000-0000", "email@address.email"));
        contacts.edit(0, "first", "", "000-000-0000", "email@address.email");
    }

    @Test
    public void editingSucceedsWithBlankPhone() {
        ContactList contacts = new ContactList();
        contacts.add(new ContactItem("first", "last", "000-000-0000", "email@address.email"));
        contacts.edit(0, "first", "last", "", "email@address.email");
    }

    @Test
    public void editingSucceedsWithNonBlankValues() {
        ContactList contacts = new ContactList();
        contacts.add(new ContactItem("first", "last", "000-000-0000", "email@address.email"));
        contacts.edit(0, "first", "last", "000-000-0000", "email@address.email");
    }

    @Test
    public void newListIsEmpty() {
        ContactList contacts = new ContactList();
        assertEquals(0, contacts.getSize());
    }

    @Test
    public void removingItemsDecreasesSize() {
        ContactList contacts = new ContactList();
        contacts.add(new ContactItem("first", "last", "000-000-0000", "email@address.email"));
        assertEquals(1 ,contacts.getSize());
        contacts.remove(0);
        assertEquals(0, contacts.getSize());
    }

    @Test
    public void removingItemsFailsWithInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            ContactList contacts = new ContactList();
            contacts.add(new ContactItem("first", "last", "000-000-0000", "email@address.email"));
            contacts.remove(1);
        });
    }

    @Test
    public void savedContactListCanBeLoaded() throws IOException {
        String fileName = "contacts_test_save.tmp";
        ContactList contacts = new ContactList();
        contacts.add(new ContactItem("first", "last", "000-000-0000", "email@address.email"));
        contacts.save(fileName);
        assertEquals(contacts.toString(), ContactList.load(fileName).toString());
    }
}
