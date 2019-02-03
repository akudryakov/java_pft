package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupModification() {
    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGpoupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("test10", "test20", "test30"));
    app.getGroupHelper().submitGroupModification();
    app.getNavigationHelper().goToGroupPage();
  }
}
