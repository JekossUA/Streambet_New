package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    public String loginId = "loginId";
    public String passwordId = "passwordId";
    public String confirmButton = "/html/body/div[1]/div/div/section/div/section/div[2]/div[2]/div[3]/button";
    public String emailWarning = "//*[@id=\"__next\"]/div/div/section/div/section/div[2]/div[2]/div[1]/div/div ";
    // password warning has cssSelector. Need to change on xPath
    public String passwordWarning = "#__next > div > div > section > div > section > div.OverlayForms_overlay-form__3Wo8U > div.OverlayForms_overlay-form__wrapper__s9rus > div:nth-child(2) > div > div";
    public String footer = "//*[@id=\"__next\"]/div/footer";

    //find elements
    public void setElementById (ChromeDriver chromeDriver, String fieldId , String inputValue) {
        chromeDriver.findElement(By.id(fieldId)).sendKeys(inputValue);
    }
    public WebElement getElementXpath(ChromeDriver chromeDriver, String elementName) {
        return chromeDriver.findElement(By.xpath(elementName));
    }

    //waiter
    public void waitElementXpath(WebDriverWait chromeWaiter, String elementName)  {
        chromeWaiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(elementName)));
    }
}
