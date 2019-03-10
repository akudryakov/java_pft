package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void ContactModificationTests(){
    app.getNavigationHelper().goToHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().submitContactModification();
    app.getContactHelper().fillUsersInfo(new ContactData(
            "MODTest Name",
            "MODTest Middle Name",
            "MODTest Last Name",
            "MODTest Nickname",
            "MODme",
            "MODTest Corp.",
            "MODTest Address",
            "MOD1",
            "MOD2",
            "MOD3",
            "MOD4",
            "MODtest@testmail.test",
            "MODtest2@testmail.test",
            "MODtest3@testmail.test",
            null
            ),
            false
    );
    app.getContactHelper().update();
    app.getNavigationHelper().goToHomePage();
  }
}
