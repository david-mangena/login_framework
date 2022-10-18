package base;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureAreaPage;

public class LoginTest extends BaseTests{

    @Test(priority = 1,dataProvider = "LoginData")
    public void loginSuccessfulTest(String Username, String Password, boolean Success){

        //login functionality
        LoginPage loginPage = homePage.clickFormAuthenticationLink("Form Authentication");
        loginPage.setUsername(Username);
        loginPage.setPassword(Password);
        SecureAreaPage secureAreaPage = loginPage.clickSubmitBtn();
        Assert.assertTrue(Success,secureAreaPage._getFlashMessage());
        LoginPage logoutPage = secureAreaPage.clickLogoutBtn();
        Assert.assertTrue(Success,logoutPage.getFlashMessage());
    }

    @DataProvider()
    public Object[][] LoginData(){
     Object[][] data = new Object[2][3];
     data[0][0] = "Forgot Password"; data[0][1] = "SuperSecretPassword!"; data[0][2] = 1;
     data[1][0] = "tomsmith2"; data[1][1] = "SuperSecretPassword!2"; data[1][2] = "1";
     return data;
    }
}
