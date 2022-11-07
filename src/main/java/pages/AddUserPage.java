package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddUserPage {

    private WebDriver driver;
    private By firstNameField = By.name("FirstName");
    private By lastNameField = By.name("LastName");
    private By userNameField = By.name("UserName");
    private By passwordField = By.name("Password");
    private By emailField = By.name("Email");
    private By cellphoneField = By.name("Mobilephone");
    private By option1RadioButton = By.cssSelector("input[type='radio'][value='15']");
    private By radioDropDownList = By.name("RoleId");
    private By saveBtn = By.cssSelector("button[ng-click='save(user)']");

    public AddUserPage (WebDriver driver){
        this.driver=driver;
    }

    public void setFirstName(String firstname){
        driver.findElement(firstNameField).sendKeys(firstname);
    }

    public void setLastName(String lastname){
        driver.findElement(lastNameField).sendKeys(lastname);
    }

    public void setUserName(String username){
        driver.findElement(userNameField).sendKeys(username);
    }

    public void setCellphone(String cellphone){
        driver.findElement(cellphoneField).sendKeys(cellphone);
    }

    public void setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public void setEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }



    public void clickOnCustomer(){
       driver.findElement(option1RadioButton).click();
    }

    public void setRole(String role){
        driver.findElement(radioDropDownList).sendKeys(role);
    }

    public HomePage clickOnSaveBtn(){
        driver.findElement(saveBtn).click();
        return new HomePage(driver);
    }


}
