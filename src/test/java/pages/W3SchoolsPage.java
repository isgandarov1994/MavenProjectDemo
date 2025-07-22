package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class W3SchoolsPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private String originalWindow;

    private By iframeResult = By.id("iframeResult");
    private By tryItButton = By.xpath("//button[normalize-space()='Try it']");

    public W3SchoolsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToPage() {
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
    }

    public void openAndSwitchToNewWindow() {
        originalWindow = driver.getWindowHandle();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeResult));

        // --- THIS IS THE FIX ---
        // Wait for the button to be clickable before clicking it
        wait.until(ExpectedConditions.elementToBeClickable(tryItButton)).click();
        // -----------------------

        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public String getOriginalWindowTitle() {
        driver.switchTo().window(originalWindow);
        return driver.getTitle();
    }

    public String getNewWindowTitle() {
        return driver.getTitle();
    }
}

