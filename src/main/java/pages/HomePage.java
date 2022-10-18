package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    //Fields
    private WebDriver driver;

    //Constructor
    public HomePage(WebDriver driver){
        this.driver = driver;
    }


//    clicking on the form authentication link
    public LoginPage clickFormAuthenticationLink(String linkText){
        clickLinkText(linkText);
        return new LoginPage(driver);
    }

    public void clickLinkText(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }

    public ForgotPasswordPage clickForgotPwd(String linkText){
        clickLinkText(linkText);
        return new ForgotPasswordPage(driver);
    }
}
