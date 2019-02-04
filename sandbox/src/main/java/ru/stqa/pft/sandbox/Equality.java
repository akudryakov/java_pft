package ru.stqa.pft.sandbox;

public class Equality {

  public static void main(String[] arqs) {
  String s1 = "firefox";
  String s2 = new String(s1); //Новый объект т.ч они не будут == На стадии компиляции может определить что они смотрят на один объект (не учитываются расчеты) eq для объектов а == для чисел

  System.out.println(s1==s2);
  System.out.println(s1.equals(s2));
  }
}
