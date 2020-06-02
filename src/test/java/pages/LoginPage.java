package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    //get authorization fields
    public void getLoginInput (ChromeDriver chromeDriver, String loginText) {
        chromeDriver.findElement(By.id("loginId")).sendKeys(loginText);
    }
    public void getPasswordInput (ChromeDriver chromeDriver, String passwordText) {
        chromeDriver.findElement(By.id("passwordId")).sendKeys(passwordText);
    }
    public WebElement getAuthorizationButton (ChromeDriver chromeDriver) {
        return chromeDriver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/section/div/section/div[2]/div[2]/div[3]/button"));
    }

    //get warnings and waiters
    public WebElement getWarningEmail (ChromeDriver chromeDriver) {
        return chromeDriver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/section/div/section/div[2]/div[2]/div[1]/div/div"));
    }

    public void getFooter (WebDriverWait chromeWaiter) {
        chromeWaiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.tagName("footer")));
    }
    public void getWarningTextWaiter (WebDriverWait chromeWaiter) {
         chromeWaiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"__next\"]/div/div/" +
                "section/div/section/div[2]/div[2]/div[1]/div/div")));
    }
}
