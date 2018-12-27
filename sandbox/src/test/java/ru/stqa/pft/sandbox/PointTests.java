package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
  public void testDistance(){
    Point p1 = new Point(4,0);
    Point p2 = new Point(0,2);

    Assert.assertEquals(p1.distance(p2),4.47213595499958);
  }

  @Test
  public void testZeroDistance() {
    Point p1 = new Point(0, 0);
    Point p2 = new Point(0, 0);
    Assert.assertEquals(p1.distance(p2), 0);
  }

  @Test
  public void testMinusDistance() {
    Point p1 = new Point(-1, -1);
    Point p2 = new Point(1, -1);
    Assert.assertEquals(p1.distance(p2), 2);
  }


}
