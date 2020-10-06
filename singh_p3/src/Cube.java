public class Cube extends Shape3D {
  private double edge;

  public Cube(double edge) {
    this.edge = edge;
  }

  @Override
  public String getName() {
    return "cube";
  }

  @Override
  public double getArea() {
    return 6 * Math.pow(edge, 2);
  }

  @Override
  public double getVolume() {
    return Math.pow(edge, 3);
  }
}
