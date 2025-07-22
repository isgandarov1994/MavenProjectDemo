package stepdefinitions;

import base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.util.HashMap;

public class Hooks {

    // --- !! EASY SWITCH !! ---
    private static final boolean RUN_LOCALLY = false;
    // -------------------------

    // --- Configuration for BrowserStack ---
    public static final String USERNAME = "firdovsisgandaro1";
    public static final String AUTOMATE_KEY = "VnrqBwTUcc91QYyiii7r";
    // --------------------------------------

    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @Before
    public void initializeBrowser() throws Exception {
        if (RUN_LOCALLY) {
            System.out.println("--- Running tests locally ---");
            BaseTest.driver = new ChromeDriver();
            BaseTest.driver.manage().window().maximize();
        } else {
            System.out.println("--- Setting up BrowserStack connection ---");
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("browserName", "Chrome");

            HashMap<String, Object> bstackOptions = new HashMap<>();
            bstackOptions.put("os", "Windows");
            bstackOptions.put("osVersion", "11");
            bstackOptions.put("buildName", "My Cucumber Build");
            bstackOptions.put("sessionName", "Cucumber Test");
            caps.setCapability("bstack:options", bstackOptions);

            BaseTest.driver = new RemoteWebDriver(new URL(URL), caps);
            BaseTest.driver.manage().window().maximize();
        }
    }

    @After
    public void tearDownBrowser() {
        if (BaseTest.driver != null) {
            BaseTest.driver.quit();
        }
    }
}

