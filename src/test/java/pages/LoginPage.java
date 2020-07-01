package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    String email = "";
    String password = "";
    String confirmButton = "";
    String emailWarning = "";

    //authorization fields
    public void setLogin(ChromeDriver chromeDriver, String loginText) {
        chromeDriver.findElement(By.id("loginId")).sendKeys(loginText);
    }
    public void setPassword(ChromeDriver chromeDriver, String passwordText) {
        chromeDriver.findElement(By.id("passwordId")).sendKeys(passwordText);
    }
    public WebElement getAuthorizationButton (ChromeDriver chromeDriver) {
        return chromeDriver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/section/div/section/div[2]/div[2]/div[3]/button"));
    }

    //warnings
    public WebElement getWarningEmail (ChromeDriver chromeDriver) {
        return chromeDriver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/section/div/section/div[2]/div[2]/div[1]/div/div"));
    }
    public WebElement getWarningPassword (ChromeDriver chromeDriver) {
        return chromeDriver.findElement(By.cssSelector("#__next > div > div > section > div > section > " +
                "div.OverlayForms_overlay-form__3Wo8U > div.OverlayForms_overlay-form__wrapper__s9rus > div:nth-child(2) > div > div"));
    }

    //waiters
    public void waitFooter(WebDriverWait chromeWaiter) {
        chromeWaiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.tagName("footer")));
    }
    public void getWarningEmailWaiter(WebDriverWait chromeWaiter) {
         chromeWaiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"__next\"]/div/div/" +
                "section/div/section/div[2]/div[2]/div[1]/div/div")));
    }
    public void getWarningPasswordWaiter (WebDriverWait chromeWaiter) {
        chromeWaiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#__next > div > div > section >" +
                " div > section > div.OverlayForms_overlay-form__3Wo8U > div.OverlayForms_overlay-form__wrapper__s9rus > div:nth-child(2) > div > div")));
    }
}
