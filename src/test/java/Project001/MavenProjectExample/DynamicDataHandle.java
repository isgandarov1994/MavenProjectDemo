package Project001.MavenProjectExample;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

public class DynamicDataHandle extends BaseTest {

	@Test
	public void DynamicWebPage() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();

		for (int i = 0; i < 3; i++) {
			driver.get("https://www.jqueryscript.net/demo/Simple-Math-Captcha-Plugin-for-jQuery-ebcaptcha/demo/");
			
			String calculator = driver.findElement(By.id("ebcaptchatext")).getText();
			String str1 = calculator.substring(8, 9);
			String str2 = calculator.substring(12);
			int sum = Integer.valueOf(str1) + Integer.valueOf(str2);

			driver.findElement(By.id("ebcaptchainput")).sendKeys(String.valueOf(sum));
			Thread.sleep(2000);

			boolean chkEnbl = driver.findElement(By.xpath("//input[@type='submit']")).isEnabled();

			if (chkEnbl) {
				System.out.println("Calculation is correct");
			} else {
				System.out.println("Calculation is incorrect");
				AssertJUnit.fail();
			}

			softAssert.assertAll();
			driver.navigate().refresh();
		}
	}
}