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
    System.out.printf("The BMI Average is %.2f\n", total / bmiData.size());
  }

  private static void displayBmiInfo(BodyMassIndex bmi) {
    System.out.printf("Body Mass Index: %.2f\n", bmi.bmi);
    System.out.println("BMI Category: " + bmi.category);
  }

  private static double getUserWeight() {
    System.out.print("Enter your weight (pounds) : ");
    double input = in.nextDouble();
    while (input < 0) {
      System.out.println("Invalid");
      System.out.print("Enter your weight (pounds) : ");
      input = in.nextDouble();
    }
    return input;
  }

  private static double getUserHeight() {
    System.out.print("Enter your height (inches) : ");
    double input = in.nextDouble();
    while (input < 0) {
      System.out.println("Invalid");
      System.out.print("Enter your height (inches) : ");
      input = in.nextDouble();
    }
    return input;
  }

  private static boolean moreInput() {
    System.out.print("Enter \"Y\" or \"N\": ");
    String input = in.next();
    while (!("Y".equals(input) || "N".equals(input))) {
      System.out.println("Invalid");
      System.out.print("Enter \"Y\" or \"N\": ");
      input = in.next();
    }
    return input.equals("Y");
  }
}
