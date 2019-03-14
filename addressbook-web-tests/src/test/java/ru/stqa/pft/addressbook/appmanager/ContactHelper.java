package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends BaseHelper {


  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submit() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void fillUsersInfo(ContactData contactData, boolean creation) {
    type(By.name("firstname"),contactData.getName());
    type(By.name("lastname"),contactData.getLastName());
    type(By.name("address"),contactData.getAddress());
    type(By.name("email"),contactData.getEmail1());


    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void addNewUser() {
    click(By.linkText("add new"));
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
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

  public List<ContactData> getContractList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element: elements) {
      String name = element.findElement(By.xpath("//*[@id=\"maintable\"]/tbody/tr[" + (2 + elements.indexOf(element)) + "]/td[3]")).getText();
      //String name = element.findElement(By.xpath("//*[@id=\"maintable\"]/tbody/tr[2]/td[3]")).getText(); - не работает обычный хпасс т.к. берется всегда вторая строка таблицы
      String lastName = element.findElement(By.xpath("//*[@id=\"maintable\"]/tbody/tr[" + (2 + elements.indexOf(element)) + "]/td[2]")).getText();
      //String lastName = element.findElement(By.xpath("//*[@id=\"maintable\"]/tbody/tr[2]/td[2]")).getText();  - не работает т.к. берется всегда 2 строка таблицы
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      ContactData contact = new ContactData(id, name, lastName, null, null, null,null);
      contacts.add(contact);
    }
    return contacts;
  };
}
