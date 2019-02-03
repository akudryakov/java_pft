package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationHelper extends BaseHelper {

  public NavigationHelper(ChromeDriver wd){
    super(wd);
  }

  public void goToHomePage() {
    click(By.linkText("home"));
  }
  public void goToGroupPage() {
    click(By.linkText("groups"));
  }
}
