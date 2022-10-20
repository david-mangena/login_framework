package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

    private final WebDriver driver;
    private By forgotPwdEmail = By.id("email");
    private By retrvPwd = By.cssSelector("#form_submit > i");
    private By erroMsg = By.tagName("h1");

    public ForgotPasswordPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterEmail(String email){
        driver.findElement(forgotPwdEmail).sendKeys(email);
    }

    public void clickRetrvPwdBtn(){
        driver.findElement(retrvPwd).submit();
    }

    public String getErrorMsg(){
      return  driver.findElement(erroMsg).getText();
    }
}

