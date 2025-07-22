package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class CaptchaPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By captchaText = By.id("ebcaptchatext");
    private By captchaInput = By.id("ebcaptchainput");
    private By submitButton = By.xpath("//input[@type='submit']");

    public CaptchaPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToPage() {
        driver.get("https://www.jqueryscript.net/demo/Simple-Math-Captcha-Plugin-for-jQuery-ebcaptcha/demo/");
    }

    public void solveCaptcha() {
        String calculator = wait.until(ExpectedConditions.visibilityOfElementLocated(captchaText)).getText();
        String str1 = calculator.substring(8, 9);
        String str2 = calculator.substring(12);
        int sum = Integer.valueOf(str1) + Integer.valueOf(str2);
        driver.findElement(captchaInput).sendKeys(String.valueOf(sum));
    }

    public boolean isSubmitButtonEnabled() {
        return driver.findElement(submitButton).isEnabled();
    }
}

