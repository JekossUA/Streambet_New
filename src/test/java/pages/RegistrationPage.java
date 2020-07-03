package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RegistrationPage {

    public String loginId = "loginId";
    public String emailId = "emeilId";
    public String passwordId = "passwordId";
    public String repeatPasswordId = "passwordRepeatId";
    public String checkbox = "//*[@id=\"__next\"]/div/div/section/div/section/div[2]/div[2]/div[5]/div/label";
    public String walletDropdownId = "selectId";
    public String walletNumberTag = "option";
    public String confirmButton = "/html/body/div[1]/div/div/section/div/section/div[2]/div[2]/div[7]/button";
    public String betLineContainer = "/html/body/div[1]/div/div/div/div/div[2]/div[1]/div[2]";
    public String loginWarning = "//*[@id=\"__next\"]/div/div/section/div/section/div[2]/div[2]/div[1]/div/div";
    public String emailWarning = "//*[@id=\"__next\"]/div/div/section/div/section/div[2]/div[2]/div[2]/div/div";
    public String passwordWarning = "//*[@id=\"__next\"]/div/div/section/div/section/div[2]/div[2]/div[3]/div/div";
    public String repeatPasswordWarning = "//*[@id=\"__next\"]/div/div/section/div/section/div[2]/div[2]/div[4]/div/div";
    public String walletWarning = "";


    //get registration fields
    public void setElementById (ChromeDriver chromeDriver, String fieldId , String inputValue) {
        chromeDriver.findElement(By.id(fieldId)).sendKeys(inputValue);
    }
    public WebElement getElement (ChromeDriver chromeDriver, String element) {
        return chromeDriver.findElement(By.xpath(element));
    }


    public void setElementDropdown (ChromeDriver chromeDriver,String elementId, String elementDropdownTag, Integer elementNumber) {
        WebElement elementDropdown = chromeDriver.findElement(By.id(elementId));
        elementDropdown.click();
        elementDropdown.findElements(By.tagName(elementDropdownTag)).get(elementNumber).click();
    }

    //waiters
    public void waitElementId (WebDriverWait chromeWaiter, String elementID) {
        chromeWaiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(elementID)));
    }
    public void waitElementXpath (WebDriverWait chromeWaiter, String elementXpath) {
        chromeWaiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(elementXpath)));
    }
    public void waitElementClickableXpath (WebDriverWait chromeWaiter, String elementXpath) {
        chromeWaiter.until(ExpectedConditions.elementToBeClickable(By.xpath(elementXpath)));
    }

}
