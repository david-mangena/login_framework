package baseTests;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    private WebDriver driver;
    protected HomePage homepage;
    String BASEURL ="http://www.way2automation.com/angularjs-protractor/webtables/";

    @BeforeSuite
    public void setup(){
        ChromeOptions options= new ChromeOptions();
//        options.addArguments("--headless");
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(BASEURL);
        homepage = new HomePage(driver);
    }

    @AfterMethod
    public void captureScreenShots(ITestResult testResult) {
        if (ITestResult.FAILURE == testResult.getStatus()) {

            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            File destination = new File(System.getProperty("user.dir")+"/resources/screenshots/failResults/" +testResult.getName()+"_FAIL" +testResult.getStartMillis() +".png");

            try {
                FileHandler.copy(source, destination);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else{
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            File destination = new File(System.getProperty("user.dir")+"/resources/screenshots/passResults/" +testResult.getName()+"_PASS" +testResult.getStartMillis() +".png");

            try {
                FileHandler.copy(source,destination);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

    @AfterSuite
    //after class to close our browser
    public void tearDown() {
        //CLOSE THE BROWSER
        driver.quit();
    }
}




