package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By addUserLink = By.cssSelector("button[type='add']");

    private By firstnameText = By.xpath("//html/body/table/tbody/tr[1]/td[1]");
    private By lastNameText = By.cssSelector("body > table > tbody > tr:nth-child(1) > td:nth-child(2)");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }



    public AddUserPage clickOnAddUserLink(){
        driver.findElement(addUserLink).click();
        return new AddUserPage(driver);
    }

    public String getFirstName(){
        return driver.findElement(firstnameText).getText();
    }

    public String getLastName(){
        return driver.findElement(lastNameText).getText();
    }

}
