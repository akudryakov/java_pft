package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends BaseHelper {


  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submit() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void fillUsersInfo(ContactData contactData, boolean creation) {
    type(By.name("firstname"),contactData.getName());
    type(By.name("middlename"),contactData.getMiddleName());
    type(By.name("lastname"),contactData.getLastName());
    type(By.name("nickname"),contactData.getNickname());
    type(By.name("title"),contactData.getTitle());
    type(By.name("company"),contactData.getCompany());
    type(By.name("address"),contactData.getAddress());
    type(By.name("home"),contactData.getHome());
    type(By.name("mobile"),contactData.getMobile());
    type(By.name("work"),contactData.getWork());
    type(By.name("fax"),contactData.getFax());
    type(By.name("email"),contactData.getEmail1());
    type(By.name("email2"),contactData.getEmail2());
    type(By.name("email3"),contactData.getEmail3());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void addNewUser() {
    click(By.linkText("add new"));
  }

  public void selectContact() {
    click(By.name("selected[]"));
  }

  public void deleteContact() {
    click(By.xpath("//input[@value='Delete']"));
    wd.switchTo().alert().accept();
  }

  public void submitContactModification() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

  public void update() {
    click(By.xpath("//div[@id='content']/form/input[22]"));
  }

  public void createContract(ContactData contract) {
    addNewUser();
    fillUsersInfo(contract,true );
    submit();
  }

  public boolean isThereAContract() {
    return isElementPresent(By.name("selected[]"));
  }
}
