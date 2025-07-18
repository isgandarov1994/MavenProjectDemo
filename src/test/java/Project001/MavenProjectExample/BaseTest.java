package Project001.MavenProjectExample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    public static WebDriver driver;

    @BeforeSuite
    public void initializeBrowser() {
        System.out.println("--- SUITE SETUP: Opening one browser for all tests ---");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void tearDownBrowser() {
        System.out.println("--- SUITE TEARDOWN: Closing the browser ---");
        if (driver != null) {
            driver.quit();
        }
    }
}