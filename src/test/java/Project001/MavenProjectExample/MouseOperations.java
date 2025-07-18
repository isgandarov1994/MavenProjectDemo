package Project001.MavenProjectExample;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseOperations extends BaseTest {
	
	@Test
	public void dragAndDrop() throws InterruptedException {
		Actions action = new Actions(driver);
		
		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(0);
		
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement destination = driver.findElement(By.id("droppable"));
		
		action.dragAndDrop(source, destination).build().perform();
		Thread.sleep(3000);
	}
}