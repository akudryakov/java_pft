package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {

  @Test
  public void ContactDeletionTests(){
   app.getNavigationHelper().goToHomePage();

    if (! app.getContactHelper().isThereAContract()) {
      app.getContactHelper().createContract(new ContactData(
              "Test Name",
              "Test Middle Name",
              "Test Last Name",
              "Test Nickname",
              "me",
              "Test Corp.",
              "Test Address",
              "1",
              "2",
              "3",
              "4",
              "test@testmail.test",
              "test2@testmail.test",
              "test3@testmail.test",
              "test1") //если нет групп с таким именем тест будет падать. Нужно узнать как "читать" имя существующей группы и использовать его
      );
    }
   app.getContactHelper().selectContact();
   app.getContactHelper().deleteContact();
   app.getNavigationHelper().goToHomePage();
  }
}
