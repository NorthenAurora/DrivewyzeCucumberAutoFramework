package cucumberHooks;

import base.BasePage;
//import org.junit.Before;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;

import java.util.Properties;

public class Hooks {

    private BasePage basePage;
    private WebDriver driver;
    private ConfigReader configReader;
    Properties prop;

    @Before(order = 0)
    public void openAndLoadFile() {
        configReader = new ConfigReader();
        prop = configReader.init_prop();
    }

    @Before(order = 1)
    public void launchBrowser() {
        String browserType = prop.getProperty("browser");

        basePage = new BasePage();
        driver = basePage.init_driver(browserType);
        driver.get(prop.getProperty("url"));
    }

    @After(order = 1)
    public void tearDown(Scenario sc){
        if(sc.isFailed()){
            String screenShotName = sc.getName().replaceAll("", "_");
            //use TakesScreenshot interface
            byte[] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES); // previously we used files now we use BYTES
            sc.attach(sourcePath, "image/png", screenShotName);
        }
    }

    @After(order = 0)
    public void quitBrowser(){
        driver.quit();
    }








}
