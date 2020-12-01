import java.io.Serializable;
import java.util.InputMismatchException;

public class ContactItem implements Serializable {

  private final String firstName;
  private final String lastName;
  private final String phoneNumber;
  private final String emailAddress;

  public ContactItem(String firstName, String lastName, String phoneNumber, String emailAddress) {
    if(firstName.isBlank() && lastName.isBlank() && phoneNumber.isBlank() && emailAddress.isBlank())
      throw new IllegalArgumentException("a contact must have at least one field");

    if(!phoneNumber.isBlank() && !phoneNumber.matches("^\\d\\d\\d-\\d\\d\\d-\\d\\d\\d\\d$"))
      throw new InputMismatchException("phone number is not in the correct format");

    //regex from https://stackoverflow.com/a/201378/12431864
    if(!emailAddress.isBlank() && !emailAddress.matches("(?:[a-z0-9!#$%&'*+=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)])"))
      throw new InputMismatchException("email address is not in the correct format");
    this.firstName = firstName;
    this.lastName = lastName;
    this.phoneNumber = phoneNumber;
    this.emailAddress = emailAddress;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

}
