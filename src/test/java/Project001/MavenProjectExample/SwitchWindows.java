package Project001.MavenProjectExample;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.Duration; // Import Duration
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions; // Import ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait; // Import WebDriverWait
import org.testng.asserts.SoftAssert;

public class SwitchWindows extends BaseTest {

	String url  = "https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open";
	String tryButtonXpath = "//button[normalize-space()='Try it']";
	String win1Title = "W3Schools Tryit Editor";
	String win2Title = "W3Schools Online Web Tutorials";

	@Test
	public void switchWind() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();

		driver.get(url);

		// --- ADDED WAIT ---
		// Wait up to 10 seconds for the iframe to be available before switching
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("iframeResult")));
		// ------------------

		driver.findElement(By.xpath(tryButtonXpath)).click();
		String win1 = null, win2 = null;

		Set<String> winIds = driver.getWindowHandles();
		Iterator<String> itr = winIds.iterator();

		if(itr.hasNext()) {
			win1 = itr.next();
			win2 = itr.next();
		}

		driver.switchTo().window(win1);
		String actualWin1 = driver.getTitle();
		System.out.println("Win1 Title: "+driver.getTitle());

		driver.switchTo().window(win2);
		Thread.sleep(3000);

		String actualWin2 = driver.getTitle();
		System.out.println("Win2 Title: "+driver.getTitle());

		AssertJUnit.assertEquals(win1Title, actualWin1);
		AssertJUnit.assertEquals(win2Title, actualWin2);

		softAssert.assertAll();
	}
}