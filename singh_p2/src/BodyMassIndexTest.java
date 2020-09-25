import org.junit.Test;
import static org.junit.Assert.*;


public class BodyMassIndexTest {
  @Test
  public void testEachBMICategory() {
    BodyMassIndex test1 = new BodyMassIndex(70, 100);
    BodyMassIndex test2 = new BodyMassIndex(70, 150);
    BodyMassIndex test3 = new BodyMassIndex(70, 200);
    BodyMassIndex test4 = new BodyMassIndex(70, 250);

    assertEquals(test1.category, "Underweight");
    assertEquals(test2.category, "Normal");
    assertEquals(test3.category, "Overweight");
    assertEquals(test4.category, "Obesity");
  }
}
