package base;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ForgotPasswordPage;

public class ForgotPwdTest extends BaseTests {

    @Test(priority = 2, dataProvider = "LoginData")
    public void forgotPwdTest(String LinkText, String Email, boolean ErrorMessage){

        ForgotPasswordPage forgotPasswordPage = homePage.clickForgotPwd(LinkText);
        forgotPasswordPage.enterEmail(Email);
        forgotPasswordPage.clickRetrvPwdBtn();
        Assert.assertTrue(ErrorMessage, forgotPasswordPage.getErrorMsg());
    }

    //DataBase
    @DataProvider()
    public Object[][] LoginData(){
        Object[][] data = new Object[4][3];
        data[0][0] = "Forgot Password"; data[0][1] = "just@do.it"; data[0][2] = false;
        data[1][0] = "Forgot Password"; data[1][1] = "just@do.it"; data[1][2] = true;
        data[2][0] = "Forgot Password"; data[2][1] = "just@do.it"; data[2][2] = true;
        data[3][0] = "Forgot Password"; data[3][1] = "just@do.it"; data[3][2] = false;
        return data;
    }

}
