package stepdefinitions;

import base.BasePage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.ForDriversPage;
import pages.HomePage;

public class ForDriversPageSteps {
    private HomePage homePage = new HomePage(BasePage.getDriver());
    private ForDriversPage forDriversPage;
    private static String actualForDriversPageTitle;

    @And("user navigates to the For Drivers page")
    public void user_navigates_to_the_for_drivers_page() throws InterruptedException {
        forDriversPage = homePage.goToForeDriversPage();
    }

    @When("user gets the title of the For Drivers page")
    public void user_gets_the_title_of_the_for_drivers_page() {
        actualForDriversPageTitle = forDriversPage.getForDriversPageTitle();
    }

    @Then("the For Drivers page title should be {string}")
    public void the_for_drivers_page_title_should_be(String expectedForDriversPageTitle) {
        Assert.assertEquals(expectedForDriversPageTitle, actualForDriversPageTitle);
    }


    @When("user clicks on the play button on the video")
    public void user_clicks_on_the_play_button_on_the_video() throws InterruptedException {
        forDriversPage.playVideo();
    }

    @Then("user clicks on the stop button")
    public void user_clicks_on_the_stop_button() {
        forDriversPage.stopVideo();
    }

}
