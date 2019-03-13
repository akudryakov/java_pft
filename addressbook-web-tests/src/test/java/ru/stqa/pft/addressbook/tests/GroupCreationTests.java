package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().goToGroupPage();
        List<GroupData> before = app.getGroupHelper().getGroupList();
        GroupData group = new GroupData("test1",null,null);
        app.getGroupHelper().createGroup(group);
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() + 1);

        int max = 0;  //получаем максимальынй id сравнением в цикле
        for (GroupData g : after) {
            if (g.getId() > max) {
                max = g.getId();
            }
        }

        Comparator<? super GroupData> byId = new Comparator<GroupData>() { //получаем максимальный id с помощью компоратора
            @Override
            public int compare(GroupData o1, GroupData o2) {
                return Integer.compare(o1.getId(), o2.getId());
            }
        };
        int max1 = after.stream().max(byId).get().getId();
        group.setId(max1);


        before.add(group); //предсказываем рузельтат
        Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
    }

}
