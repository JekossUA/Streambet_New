package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DepositPage {
   public String amountName = "amount";
   public String phoneName = "phone";
   public String depositBox = "/html/body/div[1]/div/div/section/div/div/div[2]/div[2]/div/div[1]/div/div";
   public String profileSettingsBox = "/html/body/div[1]/div/div/section/div/div/div[2]/div/div[2]";
   public String wrongAmountRub = "299";
   public String wrongPhone = "345678";
   public String confirmButton = "/html/body/div[1]/div/div/section/div/div/div[2]/div[2]/div/div[2]/div/div/button";

    public void setElementByName (ChromeDriver chromeDriver, String fieldName , String inputValue) {
        chromeDriver.findElement(By.name(fieldName)).sendKeys(inputValue);
    }
    public WebElement getElementByName(ChromeDriver chromeDriver, String fieldName) {
        return chromeDriver.findElement(By.name(fieldName));
    }
    public WebElement getElementsXpath(ChromeDriver chromeDriver, String xpath, int index) {
        return chromeDriver.findElements(By.xpath(xpath)).get(index);
    }
    public WebElement getElementXpath(ChromeDriver chromeDriver, String xpath) {
        return chromeDriver.findElement(By.xpath(xpath));
    }

    public void waitElementXpath(WebDriverWait chromeWaiter, String elementName)  {
        chromeWaiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(elementName)));
    }
    public void waitElementByName(WebDriverWait chromeWaiter, String elementName)  {
        chromeWaiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name(elementName)));
    }
    public boolean isClickableName(WebDriverWait chromeWaiter, String elementName) {
        try {
            chromeWaiter.until(ExpectedConditions.elementToBeClickable(By.name(elementName)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean isClickableXpath(WebDriverWait chromeWaiter, String elementXpath) {
        try {
            chromeWaiter.until(ExpectedConditions.elementToBeClickable(By.xpath(elementXpath)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
