package Project001.MavenProjectExample;

import com.browserstack.local.Local; // Import BrowserStack Local
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.net.URL;
import java.util.HashMap;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseTest {

    public static WebDriver driver;
    private Local bsLocal; // Create an instance of the Local class

    // --- !! EASY SWITCH !! ---
    private static final boolean RUN_LOCALLY = false;
    // -------------------------

    // --- Configuration for BrowserStack ---
    public static final String USERNAME = "firdovsisgandaro1";
    public static final String AUTOMATE_KEY = "VnrqBwTUcc91QYyiii7r";
    // --------------------------------------

    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @BeforeSuite
    public void initializeBrowser() throws Exception {
        if (RUN_LOCALLY) {
            System.out.println("--- Running tests locally ---");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        } else {
            System.out.println("--- Setting up BrowserStack connection ---");

            // --- Start the BrowserStack Local Tunnel ---
            bsLocal = new Local();
            HashMap<String, String> bsLocalArgs = new HashMap<String, String>();
            bsLocalArgs.put("key", AUTOMATE_KEY);
            bsLocal.start(bsLocalArgs);
            System.out.println("BrowserStack Local tunnel is running: " + bsLocal.isRunning());
            // -----------------------------------------

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("browserName", "Chrome");

            String buildName = "My Test Build - " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

            HashMap<String, Object> bstackOptions = new HashMap<String, Object>();
            bstackOptions.put("os", "Windows");
            bstackOptions.put("osVersion", "11");
            bstackOptions.put("browserVersion", "latest");
            bstackOptions.put("buildName", buildName);
            bstackOptions.put("sessionName", "My First BrowserStack Test");
            bstackOptions.put("local", "true"); // IMPORTANT: Tell BrowserStack to use the tunnel

            caps.setCapability("bstack:options", bstackOptions);

            driver = new RemoteWebDriver(new URL(URL), caps);
            driver.manage().window().maximize();
        }
    }

    @AfterSuite
    public void tearDownBrowser() throws Exception {
        System.out.println("--- Closing browser connection ---");
        if (driver != null) {
            driver.quit();
        }
        // --- Stop the BrowserStack Local Tunnel ---
        if (bsLocal != null) {
            bsLocal.stop();
            System.out.println("BrowserStack Local tunnel stopped.");
        }
        // ----------------------------------------
    }
}

