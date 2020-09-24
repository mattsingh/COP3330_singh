public class BodyMassIndex {
  double height;
  double weight;
  double bmi;
  String category = null;

  public BodyMassIndex(double height, double weight) {
    this.height = height;
    this.weight = weight;
    this.bmi = calculateBMI();
    calculateCategory();
  }

  private void calculateCategory() {
    if(bmi < 18.5)
      category = "Underweight";
    else if(bmi < 25)
      category = "Normal";
    else if(bmi < 30)
      category = "Overweight";
    else
      category = "Obesity";
  }

  private double calculateBMI() {
    return 703 * weight / Math.pow(height, 2);
  }



}
