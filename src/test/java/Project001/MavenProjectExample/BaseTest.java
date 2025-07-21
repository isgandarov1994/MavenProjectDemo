package Project001.MavenProjectExample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.net.URL;
import java.util.HashMap; // Import HashMap

public class BaseTest {

    public static WebDriver driver;

    // --- !! EASY SWITCH !! ---
    // Set to 'true' to run on your local machine.
    // Set to 'false' to run on BrowserStack.
    private static final boolean RUN_LOCALLY = false; // Set to false for this test
    // -------------------------

    // --- Configuration for BrowserStack ---
    // Replace "YOUR_USERNAME" and "YOUR_ACCESS_KEY" with your actual credentials
    public static final String USERNAME = "firdovsisgandaro1";
    public static final String AUTOMATE_KEY = "VnrqBwTUcc91QYyiii7r";
    // --------------------------------------

    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @BeforeSuite
    public void initializeBrowser() throws Exception {
        if (RUN_LOCALLY) {
            // --- Setup for LOCAL execution ---
            System.out.println("--- Running tests locally ---");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        } else {
            // --- Setup for BROWSERSTACK execution ---
            System.out.println("--- Setting up BrowserStack connection ---");

            // Use DesiredCapabilities for W3C standard format
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("browserName", "Chrome"); // Standard W3C capability

            // Create a HashMap for BrowserStack-specific options
            HashMap<String, Object> bstackOptions = new HashMap<String, Object>();
            bstackOptions.put("os", "Windows");
            bstackOptions.put("osVersion", "11");
            bstackOptions.put("browserVersion", "latest");
            bstackOptions.put("buildName", "Demo Test");
            bstackOptions.put("sessionName", "Windwows11+Chrome");

            // Nest the BrowserStack options inside the 'bstack:options' capability
            caps.setCapability("bstack:options", bstackOptions);


            // This line creates the connection to BrowserStack
            driver = new RemoteWebDriver(new URL(URL), caps);
            driver.manage().window().maximize();
        }
    }

    @AfterSuite
    public void tearDownBrowser() {
        System.out.println("--- Closing browser connection ---");
        if (driver != null) {
            driver.quit();
        }
    }
}

