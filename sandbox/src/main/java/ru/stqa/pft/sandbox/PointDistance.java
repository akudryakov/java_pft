package ru.stqa.pft.sandbox;

public class PointDistance {
  public static void main(String[] args) {
    //реализация с использованием функции distance класса PointDistance
    Point p1 = new Point(4, -3);
    Point p2 = new Point(1, 0);
    System.out.println("Distance between point1 " + " x =" + p1.x + " , " + "y =" + p1.y + " and point2" + " x =" + p2.x + " , " + "y =" + p2.y + " = " + distance(p1, p2));

    //реализация с вызовом метода класса Point
    System.out.println("Distance between point1 " + " x =" + p1.x + " , " + "y =" + p1.y + " and point2" + " x =" + p2.x + " , " + "y =" + p2.y + " = " + p1.distance(p2));
  }

  public static double distance(Point p1, Point p2) {
    return Math.sqrt(((p1.x - p2.x) * (p1.x - p2.x)) + ((p1.y - p2.y) * (p1.y - p2.y)));
  }

}
