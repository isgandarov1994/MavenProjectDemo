package stepdefinitions;

import base.BaseTest; // Import BaseTest
import io.cucumber.java.en.*;
import pages.CaptchaPage;
import org.testng.Assert;

public class CaptchaSteps {
    private CaptchaPage captchaPage;

    @Given("I am on the captcha page")
    public void i_am_on_the_captcha_page() {
        // Access the driver directly from the BaseTest class
        captchaPage = new CaptchaPage(BaseTest.driver);
        captchaPage.navigateToPage();
    }

    @When("I solve the math problem")
    public void i_solve_the_math_problem() {
        captchaPage.solveCaptcha();
    }

    @Then("the form should be enabled for submission")
    public void the_form_should_be_enabled_for_submission() {
        Assert.assertTrue(captchaPage.isSubmitButtonEnabled(), "Submit button was not enabled.");
    }
}

