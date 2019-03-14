package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @Test
  public void ContactModificationTests(){
    app.getNavigationHelper().goToHomePage();
    ContactData contract = new ContactData(
            "Test Name",
            "Test Last Name",
            "Test Address",
            "test@testmail.test",
            "3",
            "test1");//если нет групп с таким именем тест будет падать. Нужно узнать как "читать" имя существующей группы и использовать его

    ContactData contractMod = new ContactData(
            "TestMod Name",
            "TestMod Last Name",
            "TestMod Address",
            "testMod@testmail.test",
            "32",
            "test1"); //если нет групп с таким именем тест будет падать. Нужно узнать как "читать" имя существующей группы и использовать его


    if (! app.getContactHelper().isThereAContract()) {
      app.getContactHelper().createContract(contract);
      app.getNavigationHelper().goToHomePage();
    }
    List<ContactData> before = app.getContactHelper().getContractList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().fillUsersInfo((contractMod),false);
    app.getContactHelper().update();
    app.getNavigationHelper().goToHomePage();
    List<ContactData> after = app.getContactHelper().getContractList();
    Assert.assertEquals(after.size(),before.size());

    before.remove(before.size() - 1);
    before.add(contractMod);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);

    Assert.assertEquals(before,after);
  }
}
