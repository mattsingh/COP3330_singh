import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactItemTest {
    @Test
    public void creationFailsWithAllBlankValues() {
        assertThrows(IllegalArgumentException.class, () -> new ContactItem("", "", "", ""));
    }

    @Test
    public void creationSucceedsWithBlankEmail() {
        assertDoesNotThrow(() -> new ContactItem("first", "last", "000-000-0000", ""));
    }

    @Test
    public void creationSucceedsWithBlankFirstName() {
        assertDoesNotThrow(() -> new ContactItem("", "last", "000-000-0000", "email@address.email"));
    }

    @Test
    public void creationSucceedsWithBlankLastName() {
        assertDoesNotThrow(() -> new ContactItem("first", "", "000-000-0000", "email@address.email"));
    }

    @Test
    public void creationSucceedsWithBlankPhone() {
        assertDoesNotThrow(() -> new ContactItem("first", "last", "", "email@address.email"));
    }

    @Test
    public void creationSucceedsWithNonBlankValues() {
        assertDoesNotThrow(() -> new ContactItem("first", "last", "000-000-0000", "email@address.email"));
    }

    /*
    these ones are a bit different because instead of editing a contact,
    the program overwrites one and the original is handled by the garbage collector
    */
    @Test
    public void editingFailsWithAllBlankValues() {
        assertThrows(IllegalArgumentException.class, () -> {
            ContactList contacts = new ContactList();
            contacts.add(new ContactItem("first", "last", "000-000-0000", "email@address.email"));
            contacts.edit(0, "", "", "", "");
        });
    }

    @Test
    public void editingSucceedsWithBlankEmail() {
        ContactList contacts = new ContactList();
        contacts.add(new ContactItem("first", "last", "000-000-0000", "email@address.email"));
        contacts.edit(0, "first", "last", "000-000-0000", "");
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
    public void testToString() {

        ContactItem contact = new ContactItem("first", "last", "000-000-0000", "email@address.email");
        assertEquals(
                "Name: first last\n" +
                "Phone: 000-000-0000\n" +
                "Email: email@address.email\n"
                , contact.toString());
    }
}
