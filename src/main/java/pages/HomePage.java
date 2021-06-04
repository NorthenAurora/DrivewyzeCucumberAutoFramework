package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementUtil;

public class HomePage {

    private WebDriver driver;
    private ElementUtil elementUtil;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    private By drivewyzeLogo = By.xpath("//img[@alt='Drivewyze']");
    private By foreDriversLink = By.linkText("For Drivers");


    public String getHomePageTitle() {
        return driver.getTitle();
    }

    public boolean verifyHomePageLog() {
        return elementUtil.doIsDisplayed(drivewyzeLogo);
    }

    public boolean verifyForDriversLink() {
        return elementUtil.doIsDisplayed(foreDriversLink);
    }

    public ForDriversPage goToForeDriversPage() throws InterruptedException {
        Thread.sleep(3000);
        elementUtil.doClick(foreDriversLink);
        return new ForDriversPage(driver);
    }
}
