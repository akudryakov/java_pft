package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;


public class ContactCreationTests extends TestBase {

  @Test
  public void testUserCreation(){
    ContactData contract = new ContactData(
            "Test Name",
            "Test Last Name",
            "Test Address",
            "test@testmail.test",
            "3",
            "test1");//если нет групп с таким именем тест будет падать. Нужно узнать как "читать" имя существующей группы и использовать его

    List<ContactData> before = app.getContactHelper().getContractList();
    app.getContactHelper().createContract(contract);
    app.getNavigationHelper().goToHomePage();
    List<ContactData> after = app.getContactHelper().getContractList();
    Assert.assertEquals(after.size(),before.size() + 1 );

    before.add(contract);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(),c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);
  }

}
