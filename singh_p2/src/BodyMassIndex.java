public class BodyMassIndex {
  double height;
  double weight;
  double bmi;

  public BodyMassIndex(double height, double weight) {
    this.height = height;
    this.weight = weight;
    this.bmi = calculateBMI();
  }

  private double calculateBMI() {
    return 703 * weight / Math.pow(height, 2);
  }


}
