package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By addUserLink = By.cssSelector("button[type='add']");

    private By firstnameText = By.xpath("//html/body/table/tbody/tr[1]/td[1]");

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

}
