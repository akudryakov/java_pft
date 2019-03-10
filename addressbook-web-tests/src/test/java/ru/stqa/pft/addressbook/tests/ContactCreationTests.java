package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;


public class ContactCreationTests extends TestBase {

  @Test
  public void testUserCreation() throws Exception {
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
                    "test1")
    );
    app.getNavigationHelper().goToHomePage();
  }

}
