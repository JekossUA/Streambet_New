package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    public String loginId = "loginId";
    public String passwordId = "passwordId";
    public String confirmButton = "/html/body/div[1]/div/div/section/div/section/div[2]/div[2]/div[3]/button"; //cssSelector button[css_test_confirm_button='css_test_confirm_button']
    public String emailWarning = "/html/body/div[1]/div/div/section/div/section/div[2]/div[2]/div[1]/div/div"; //
    public String passwordWarning = "/html/body/div[1]/div/div/section/div/section/div[2]/div[2]/div[2]/div/div"; //
    public String footer = "//*[@id=\"__next\"]/div/footer";

    //find elements
    public void setElementById (RemoteWebDriver chromeDriver, String fieldId , String inputValue) {
        chromeDriver.findElement(By.id(fieldId)).sendKeys(inputValue);
    }
    public WebElement getElementXpath(RemoteWebDriver chromeDriver, String elementName) {
        return chromeDriver.findElement(By.xpath(elementName));
    }

    //waiter
    public void waitElementXpath(WebDriverWait chromeWaiter, String elementName)  {
        chromeWaiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(elementName)));
    }
}
