package stepdefinitions;

import base.BasePage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.HomePage;

public class HomePageSteps {
    private static String actualHomePageTitle;
    private HomePage homePage = new HomePage(BasePage.getDriver());

    @Given("user is on the home page")
    public void user_is_on_the_home_page() {
        // BasePage.getDriver().get("https://drivewyze.com/");
    }

    @When("user gets the title of the page")
    public void user_gets_the_title_of_the_page() {
        actualHomePageTitle = homePage.getHomePageTitle();
    }

    @Then("page title should be {string}")
    public void page_title_should_be(String expectedHomePageTitle) {
        Assert.assertEquals(expectedHomePageTitle, actualHomePageTitle);
    }

    @Then("logo should present on the page")
    public void logo_should_present_on_the_page() {
        Assert.assertTrue(homePage.verifyHomePageLog());
    }

    @Then("For Drivers link should be displayed")
    public void for_drivers_link_should_be_displayed() {
        Assert.assertTrue(homePage.verifyForDriversLink());
    }

}
