package utils;
import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.SecureRandom;
import java.util.List;

public class ElementUtil {
    private WebDriver driver;
    private JavascriptExecutor js;

     public ElementUtil(WebDriver driver){
        this.driver= driver;
       this.js = (JavascriptExecutor)driver;
    }

    public WebElement getElement(By locator){
        WebElement element = driver.findElement(locator);
        return element;
    }

    public List<WebElement> getElements(By locator){
        return driver.findElements(locator);
    }

    public void doSendKeys(By locator, String parameter){
        getElement(locator).sendKeys(parameter);
    }

    public void doClick(By locator){
        getElement(locator).click();
    }

    public boolean doIsDisplayed(By locator){
        return  getElement(locator).isDisplayed();
    }

    public String doGetText(By locator){
        return getElement(locator).getText();
    }

    public void scrollInToView(By locator){
        WebElement element = driver.findElement(locator);
         js.executeScript("arguments[0].scrollIntoView(true);",element);
    }

    public void waitForElementToBeVisible(By locator, int timeOut){
        WebElement element = getElement(locator);
        WebDriverWait  wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementPresent(By locator, int timeOut){
        WebElement element = getElement(locator);
        WebDriverWait  wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public boolean compareDropdownOptions(By locator, String[] expected){
        List<WebElement> options = getAllDropdownOptions(locator);
        int i= 0;
        for (WebElement opt: options){
            if(!opt.getText().equals(expected[i])){
                return false;
            }

            i++;
        }
        return true;
    }

    public List<WebElement> getAllDropdownOptions(By locator){

        Select select = new Select(getElement(locator));
        List<WebElement> op = select.getOptions();
        return op;
    }

    public String randomString(int len){
        String abc = "012345678abcdefghijklmnopqrstuvwxyz";

        SecureRandom sr = new SecureRandom();
        StringBuilder sb = new StringBuilder(len);
        for(int i=0; i<len; i++){
            sb.append(abc.charAt(sr.nextInt(abc.length())));
        }
        return sb.toString();
    }


}
