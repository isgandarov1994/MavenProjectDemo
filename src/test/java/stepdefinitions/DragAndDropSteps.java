package stepdefinitions;

import base.BaseTest; // Import BaseTest to access the static driver
import io.cucumber.java.en.*;
import pages.DroppablePage;

// DO NOT extend BaseTest here anymore
public class DragAndDropSteps {
    private DroppablePage droppablePage;

    @Given("I am on the droppable page")
    public void i_am_on_the_droppable_page() {
        // Access the driver directly from the BaseTest class
        droppablePage = new DroppablePage(BaseTest.driver);
        droppablePage.navigateToPage();
    }

    @When("I perform the drag and drop action")
    public void i_perform_the_drag_and_drop_action() {
        droppablePage.performDragAndDrop();
    }

    @Then("the element should be dropped successfully")
    public void the_element_should_be_dropped_successfully() {
        System.out.println("Drag and drop completed.");
    }
}

