package baseTests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AddUserPage;
import pages.HomePage;

public class AddUserTest extends BaseTest {
    @Test(dataProvider = "UserDetails")
    public void addUserTest(String Firstname, String Lastname, String Username, String Password,String EmailAddress, String CellphoneNumber,String Role ) {
        AddUserPage addUserPage = homepage.clickOnAddUserLink();
        addUserPage.setFirstName(Firstname);
        addUserPage.setLastName(Lastname);
        addUserPage.setUserName(Username);
        addUserPage.setPassword(Password);
        addUserPage.setEmail(EmailAddress);
        addUserPage.setCellphone(CellphoneNumber);
        addUserPage.clickOnCustomer();
        addUserPage.setRole(Role);
        HomePage homepage = addUserPage.clickOnSaveBtn();

        System.out.println("First name here " + Firstname);


        Assert.assertTrue(homepage.getFirstName().contains(Firstname));
        Assert.assertEquals(homepage.getLastName(),Lastname);
    }

    @DataProvider()
    public Object[][] UserDetails() {
        Object[][] data = new Object[3][7];
        data[0][0] = "FName1";data[0][1]="LName5"; data[0][2]="User1"; data[0][3]="Pass1";data[0][4]="admin@mail.com";data[0][5]="082555"; data[0][6]="Admin";
        data[1][0] = "FName2";data[1][1]="LName2"; data[1][2]="User2"; data[1][3]="Pass2";data[1][4]="admin2@mail.com";data[1][5]="082777"; data[1][6]="Sales Team";
        data[2][0] = "FName3";data[2][1]="LName3"; data[2][2]="User3"; data[2][3]="Pass3";data[2][4]="admin2@mail.com";data[2][5]="082777"; data[2][6]="Customer"; //<--- THIS WAS OUTSTANDING
        return data;
    }

}
