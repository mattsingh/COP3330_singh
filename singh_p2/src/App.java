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

  private static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData) {
    double total = 0;
    for(BodyMassIndex i : bmiData)
      total += i.bmi;
    System.out.println("The BMI Average is " + total / bmiData.size());
  }

  private static void displayBmiInfo(BodyMassIndex bmi) {
    System.out.println("Body Mass Index: " + bmi.bmi);
  }

  private static double getUserWeight() {
    System.out.print("Enter your weight (pounds) : ");
    return in.nextDouble();
  }

  private static double getUserHeight() {
    System.out.print("Enter your height (inches) : ");
    return in.nextDouble();
  }

  private static boolean moreInput() {
    System.out.print("Enter \"Y\" or \"N\": ");
    String input = in.next();
    while (!("Y".equals(input) || "N".equals(input))) {
      System.out.println("Invalid");
      input = in.next();
    }
    return input.equals("Y");
  }
}
