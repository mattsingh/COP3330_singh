import java.util.Scanner;

public class AppSelector {
  private final Scanner in = new Scanner(System.in);

  public static void main(String[] args) {
    AppSelector as = new AppSelector();
    as.appMenu();
  }

  private void appMenu() {
    while(true) {
      int input = -1;

      System.out.print(
          "Select Your Application\n" +
          "-----------------------\n" +
          "\n" +
          "1) task list\n" +
          "2) contact list\n" +
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
          TaskApp taskApp = new TaskApp();
          taskApp.mainMenu();
          break;
        case 2:
          ContactApp contactApp = new ContactApp();
          contactApp.mainMenu();
          break;
        case 3:
          return;
      }
    }
  }
}
