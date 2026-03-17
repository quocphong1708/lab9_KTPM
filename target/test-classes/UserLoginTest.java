package tests;

import framework.models.UserData;
import framework.utils.JsonReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class UserLoginTest {

    @DataProvider(name = "jsonUsers")
    public Object[][] getUsers() {
        List<UserData> users = JsonReader.readUsers();

        Object[][] data = new Object[users.size()][1];
        for (int i = 0; i < users.size(); i++) {
            data[i][0] = users.get(i);
        }
        return data;
    }

    @Test(dataProvider = "jsonUsers")
    public void testLogin(UserData user) {

        System.out.println("Test: " + user.getDescription());

        // giả lập login
        boolean actualResult =
                !user.getUsername().isEmpty() &&
                !user.getPassword().isEmpty() &&
                user.getPassword().equals("123456");

        Assert.assertEquals(actualResult, user.isExpectSuccess());
    }
}