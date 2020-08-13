package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RegistrationPage {

    public String loginId = "loginId";
    public String emailId = "emeilId";
    public String passwordId = "passwordId";
    public String repeatPasswordId = "passwordRepeatId";
    public String checkbox = "/html/body/div[1]/div/div/section/div/section/div[2]/div[2]/div[5]/div/label[1]"; // css selector label[css_test_checkbox="css_test_checkbox"]
    public String walletDropdownId = "selectId";
    public String walletNumberTag = "option";
    public String confirmButton = "/html/body/div[1]/div/div/section/div/section/div[2]/div[2]/div[7]/button"; //css selector button[css_test_confirm_button = 'css_test_confirm_button']
    public String loginWarning = "/html/body/div[1]/div/div/section/div/section/div[2]/div[2]/div[1]/div/div";
    public String emailWarning = "/html/body/div[1]/div/div/section/div/section/div[2]/div[2]/div[2]/div/div";
    public String passwordWarning = "/html/body/div[1]/div/div/section/div/section/div[2]/div[2]/div[3]/div/div";
    public String repeatPasswordWarning = "/html/body/div[1]/div/div/section/div/section/div[2]/div[2]/div[4]/div/div";
    public String successPage = "/html/body/div[1]/div/div/section/div/section/div[2]/div/h5";


    //get registration fields
    public void setElementById (RemoteWebDriver chromeDriver, String fieldId , String inputValue) {
        chromeDriver.findElement(By.id(fieldId)).sendKeys(inputValue);
    }
    public WebElement getElementXpath(RemoteWebDriver chromeDriver, String element) {
        return chromeDriver.findElement(By.xpath(element));
    }


    public void setElementDropdown (RemoteWebDriver chromeDriver,String elementId, String elementDropdownTag, Integer elementNumber) {
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

    public boolean isClickable (WebDriverWait chromeWaiter, String elementXpath) {
        try {
            chromeWaiter.until(ExpectedConditions.elementToBeClickable(By.xpath(elementXpath)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
