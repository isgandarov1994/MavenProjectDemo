package Project001.MavenProjectExample;

import org.testng.annotations.Test;
import java.time.Duration; // Import Duration
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions; // Import ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait; // Import WebDriverWait

public class MouseOperations extends BaseTest {

	@Test
	public void dragAndDrop() throws InterruptedException {
		Actions action = new Actions(driver);

		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(0);

		// --- ADDED WAIT ---
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement source = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("draggable")));
		WebElement destination = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("droppable")));
		// ------------------

		action.dragAndDrop(source, destination).build().perform();
		Thread.sleep(3000);
	}
}