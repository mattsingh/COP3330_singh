import java.io.Serializable;

public class ContactItem implements Serializable {

  private String firstName;
  private String lastName;
  private String phoneNumber;
  private String emailAddress;

  public ContactItem(String firstName, String lastName, String phoneNumber, String emailAddress) {
    if(firstName.isBlank() || lastName.isBlank() || phoneNumber.isBlank() ||emailAddress.isBlank())
      throw new IllegalArgumentException("a contact must have at least one field");
    this.firstName = firstName;
    this.lastName = lastName;
    this.phoneNumber = phoneNumber;
    this.emailAddress = emailAddress;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }
}
