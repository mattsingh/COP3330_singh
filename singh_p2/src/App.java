import java.util.ArrayList;
import java.util.Scanner;

public class App {
  public static Scanner in = new Scanner(System.in);

  public static void main(String[] args) {
    ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

    while (moreInput()) {
      double height = getUserHeight();
      double weight = getUserWeight();

      BodyMassIndex bmi = new BodyMassIndex(height, weight);
      bmiData.add(bmi);

      displayBmiInfo(bmi);
    }

    displayBmiStatistics(bmiData);
  }

  private static boolean moreInput() {
    String input = null;
    while (input != "Y" || input != "N")
      input = in.nextLine();
    if (input == "Y")
      return true;
    else
      return false;
  }
}
