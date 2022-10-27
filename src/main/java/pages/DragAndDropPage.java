package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class DragAndDropPage {

    //Fields
    private WebDriver driver;
    private By column_a_box = By.id("column-a");
    private By column_b_box = By.id("column-b");

    public DragAndDropPage(WebDriver driver){
        this.driver = driver;
    }

    public void DragFrom_boxA_to_boxB(){
         WebElement col_A = driver.findElement(column_a_box);
         WebElement col_B = driver.findElement(column_b_box);

        Actions actions = new Actions(driver);
        actions
                .dragAndDrop(col_A, col_B)
                .build()
                .perform();
    }
}
