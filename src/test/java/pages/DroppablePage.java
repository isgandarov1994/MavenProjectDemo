package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class DroppablePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By iframe = By.tagName("iframe");
    private By draggableBox = By.id("draggable");
    private By droppableBox = By.id("droppable");

    public DroppablePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToPage() {
        driver.get("https://jqueryui.com/droppable/");
    }

    public void performDragAndDrop() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));
        WebElement source = wait.until(ExpectedConditions.visibilityOfElementLocated(draggableBox));
        WebElement destination = wait.until(ExpectedConditions.visibilityOfElementLocated(droppableBox));
        new Actions(driver).dragAndDrop(source, destination).build().perform();
    }
}

