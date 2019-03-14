package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

  @Test
  public void ContactDeletionTests(){
   app.getNavigationHelper().goToHomePage();
   if (! app.getContactHelper().isThereAContract()) {
      app.getContactHelper().createContract(new ContactData(
              "Test Name",
              "Test Last Name",
              "Test Address",
              "4",
              "test@testmail.test",
              "test1") //если нет групп с таким именем тест будет падать. Нужно узнать как "читать" имя существующей группы и использовать его
      );
    }
   app.getNavigationHelper().goToHomePage();
   List<ContactData> before = app.getContactHelper().getContractList();
   app.getContactHelper().selectContact(before.size() - 1);
   app.getContactHelper().deleteContact();
   app.getNavigationHelper().goToHomePage();
   List<ContactData> after = app.getContactHelper().getContractList();
   Assert.assertEquals(after.size(),before.size() - 1 );
   before.remove(before.size() - 1);
   Assert.assertEquals(before, after);
  }
}
