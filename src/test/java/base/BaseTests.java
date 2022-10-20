package base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTests {

    private WebDriver driver;
    protected HomePage homePage;
    String BASEURL = "https://the-internet.herokuapp.com/";

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(BASEURL);
        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void captureScreenShots(ITestResult testResult) {

        if(ITestResult.FAILURE == testResult.getStatus()){
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            File destination = new File(System.getProperty("user.dir") +
                    "/resources/screenshots/Failed/"+ testResult.getName() + "_" + testResult.getStartMillis() +".png");
            try {
                FileHandler.copy(source, destination);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            File destination = new File(System.getProperty("user.dir") +
                    "/resources/screenshots/Passed/"+ testResult.getName() + "_" + testResult.getStartMillis() +".png");
            try {
                FileHandler.copy(source, destination);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @AfterMethod()
    public void tearDown() {
        driver.quit();
    }
}
