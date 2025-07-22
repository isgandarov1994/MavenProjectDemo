package stepdefinitions;

import base.BaseTest; // Import BaseTest
import io.cucumber.java.en.*;
import pages.W3SchoolsPage;
import org.testng.Assert;

public class SwitchWindowsSteps {
    private W3SchoolsPage w3SchoolsPage;

    @Given("I am on the W3Schools window switching page")
    public void i_am_on_the_w3schools_window_switching_page() {
        // Access the driver directly from the BaseTest class
        w3SchoolsPage = new W3SchoolsPage(BaseTest.driver);
        w3SchoolsPage.navigateToPage();
    }

    @When("I open a new window and switch to it")
    public void i_open_a_new_window_and_switch_to_it() {
        w3SchoolsPage.openAndSwitchToNewWindow();
    }

    @Then("I can verify the titles of both windows")
    public void i_can_verify_the_titles_of_both_windows() {
        String newWindowTitle = w3SchoolsPage.getNewWindowTitle();
        String originalWindowTitle = w3SchoolsPage.getOriginalWindowTitle();

        Assert.assertEquals(newWindowTitle, "W3Schools Online Web Tutorials");
        Assert.assertEquals(originalWindowTitle, "W3Schools Tryit Editor");
    }
}

