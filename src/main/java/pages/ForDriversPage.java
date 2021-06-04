package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementUtil;

import java.util.concurrent.TimeUnit;

public class ForDriversPage {
    private WebDriver driver;
    private ElementUtil elementUtil;


    public ForDriversPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    private By playButton = By.xpath("//button[@aria-label='Play']");
    private By video = By.xpath("//video[@controlslist='nodownload']");

    public String getForDriversPageTitle(){
        return driver.getTitle();
    }

    public void playVideo() throws InterruptedException {
        Thread.sleep(1000);
        driver.switchTo().frame("fitvid0");
        elementUtil.scrollInToView(playButton);
        Thread.sleep(2000);
        elementUtil.doClick(playButton);
        Thread.sleep(7000);
    }

    public void stopVideo()  {
        elementUtil.doClick(video);
    }

}
