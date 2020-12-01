import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ContactApp {
  private final Scanner in = new Scanner(System.in);
  private static String fileExtension = ".tmp";

  public void mainMenu() {
    while(true) {
      int input = -1;

      System.out.print(
              "Main Menu\n" +
                      "---------\n" +
                      "\n" +
                      "1) create a new list\n" +
                      "2) load an existing list\n" +
                      "3) quit\n" +
                      "\n");

      do {
        System.out.print("> ");
        try {
          input = Integer.parseInt(in.nextLine());
        } catch (NumberFormatException e) {
          System.out.println("WARNING: input must be an integer");
        }
      } while(input < 1 || input > 3);

      switch(input) {
        case 1:
          ContactList list = new ContactList();
          if(list != null)
            System.out.println("new contact list has been created");
          contactListMenu(list);
          break;
        case 2:
          loadContactList();
          break;
        case 3:
          return;
      }
    }
  }

  private void contactListMenu(ContactList list) {
    while (true) {
      int input = -1;

      System.out.println(
              "List Operation Menu\n" +
              "---------\n" +
              "\n" +
              "1) view the list\n" +
              "2) add an item\n" +
              "3) edit an item\n" +
              "4) remove an item\n" +
              "5) save the current list\n" +
              "6) quit to the main menu");

      do {
        System.out.print("> ");
        try {
          input = Integer.parseInt(in.nextLine());
        } catch (NumberFormatException e) {
          System.out.println("WARNING: input must be an integer");
        }
      } while(input < 1 || input > 8);

      switch(input) {
        case 1:
          printList(list);
          System.out.print("Press ENTER to continue");
          in.nextLine();
          break;
        case 2:
          addContactItem(list);
          break;
        case 3:
          editContactList(list);
          break;
        case 4:
          printList(list);
          removeContactItem(list);
          break;
        case 5:
          saveContactList(list);
          break;
        case 6:
          return;
      }
    }
  }

  private void removeContactItem(ContactList list) {
    try {
      System.out.print("Which contact will you remove? ");
      list.remove(Integer.parseInt(in.nextLine()));
    } catch (IndexOutOfBoundsException e) {
      System.out.println("WARNING: invalid index; contact item not removed\n");
    } catch (NumberFormatException e) {
      System.out.println("WARNING: input must be an integer");
    }
  }


  private void addContactItem(ContactList list) {
    try {
      list.add(createContactItem());
    } catch (IllegalArgumentException | InputMismatchException e) {
      System.out.println("WARNING: " + e.getMessage() + "; contact not created\n");
    }
  }

  private void editContactList(ContactList list) {
    int index;
    String firstName, lastName, phoneNumber, emailAddress;

    try {
      printList(list);
      System.out.print("Which contact will you edit? ");
      index = in.nextInt();
      in.nextLine();
      System.out.print("Enter a new first name for contact " + index + ": ");
      firstName = in.nextLine();
      System.out.print("Enter a new last name for contact " + index + ": ");
      lastName = in.nextLine();
      System.out.print("Enter a new phone number (xxx-xxx-xxxx) for contact " + index + ": ");
      phoneNumber = in.nextLine();
      System.out.print("Enter a new email address (x@y.z) for contact " + index + ": ");
      emailAddress = in.nextLine();

      list.edit(index, firstName, lastName, phoneNumber, emailAddress);
    } catch (IndexOutOfBoundsException e) {
      System.out.println("WARNING: invalid index; contact not edited\n");
    } catch (IllegalArgumentException e) {
      System.out.println("WARNING: " + e.getMessage() + "; contact not edited\n");
    }
  }

  public ContactItem createContactItem() {
    String firstName, lastName, phoneNumber, emailAddress;

    System.out.print("First name: ");
    firstName = in.nextLine();
    System.out.print("Last name: ");
    lastName = in.nextLine();
    System.out.print("Phone number (xxx-xxx-xxxx): ");
    phoneNumber = in.nextLine();
    System.out.print("Email address (x@y.z): ");
    emailAddress = in.nextLine();

    System.out.println();

    return new ContactItem(firstName, lastName, phoneNumber, emailAddress);
  }

  private void printList(ContactList list) {
    System.out.println(list);
  }

  private void saveContactList(ContactList list) {
    try {
      System.out.print("Enter the filename to save as (no file extension): ");
      String name = in.nextLine();
      list.save(name + fileExtension);
    } catch (IllegalStateException e) {
      System.out.println("WARNING: " + e.getMessage() + "; contact list not saved\n");
    }
  }

  private void loadContactList() {
    try {
      System.out.print("Enter the filename to load (no file extension): ");
      String name = in.nextLine();
      contactListMenu(ContactList.load(name + fileExtension));
    } catch (IOException e) {
      System.out.println("WARNING: file not found\n");
    }
  }
}
