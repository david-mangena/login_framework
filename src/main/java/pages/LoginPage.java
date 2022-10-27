package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    //Fields
    private WebDriver driver;
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By submitBtn = By.cssSelector("#login > button");
    private By flash_messages = By.id("flash");


    //Constructor
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public String getFlashMessage(){
        return driver.findElement(flash_messages).getText();
    }


    //input username method
    public void setUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
    }

    //input password method
    public void setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    //Clicking the login button
    public SecureAreaPage clickSubmitBtn(){
        driver.findElement(submitBtn).click();
        return new SecureAreaPage(driver);
    }
}
