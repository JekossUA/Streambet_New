package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

    //get registration fields
    public void setUserLogin(ChromeDriver chromeDriver, String loginText) {
        chromeDriver.findElement(By.id("loginId")).sendKeys(loginText);
    }
    public void setUserEmail(ChromeDriver chromeDriver, String email) {
        chromeDriver.findElement(By.id("emeilId")).sendKeys(email);
    }
    public void setUserPassword(ChromeDriver chromeDriver, String password) {
        chromeDriver.findElement(By.id("passwordId")).sendKeys(password);
    }
    public void setRepeatUserPassword(ChromeDriver chromeDriver, String repeatPassword) {
        chromeDriver.findElement(By.id("passwordRepeatId")).sendKeys(repeatPassword);
    }
    public WebElement getCheckbox (ChromeDriver chromeDriver) {
        return chromeDriver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/section/div/section/div[2]/div[2]/div[5]/div/label"));
    }
    public void setWallet(ChromeDriver chromeDriver,Integer walletNumber) {
        WebElement walletDropdown = chromeDriver.findElement(By.id("selectId"));
        walletDropdown.click();
        walletDropdown.findElements(By.tagName("option")).get(walletNumber).click();
    }
    public WebElement getConfirmButton (ChromeDriver chromeDriver) {
        return chromeDriver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/section/div/section/div[2]/div[2]/div[7]/button"));
    }

    //waiters
    public void waitEmailInput(WebDriverWait chromeWaiter) {
        chromeWaiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("emeilId")));
    }
    public void waitFooter(WebDriverWait chromeWaiter) {
        chromeWaiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.tagName("footer")));
    }
    public void waitSuccessPage (WebDriverWait chromeWaiter) {
        chromeWaiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.tagName("h5")));
    }
    public void waitExistingEmailWarning (WebDriverWait chromeWaiter) {
        chromeWaiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"__next\"]/div/div/section/div/section/div[2]/div[2]/div[2]/div/div")));
    }
    public void waitPasswordWarning (WebDriverWait chromeWaiter) {
        chromeWaiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"__next\"]/div/div/section/div/section/div[2]/div[2]/div[3]/div/div")));
    }
    public void waitRepeatPasswordWarning (WebDriverWait chromeWaiter) {
        chromeWaiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"__next\"]/div/div/section/div/section/div[2]/div[2]/div[4]/div/div")));
    }

    //warnings
    public boolean getLoginWarning (WebDriver chromeDriver) {
        return chromeDriver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/section/div/section/div[2]/div[2]/div[1]/div/div")).isDisplayed();
    }
    public boolean getExistingEmailWarning(WebDriver chromeDriver) {
        return chromeDriver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/section/div/section/div[2]/div[2]/div[2]/div/div")).isDisplayed();
    }
    public boolean getPasswordWarning (WebDriver chromeDriver) {
        return chromeDriver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/section/div/section/div[2]/div[2]/div[3]/div/div")).isDisplayed();
    }
    public boolean getRepeatPasswordWarning (WebDriver chromeDriver) {
        return chromeDriver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/section/div/section/div[2]/div[2]/div[4]/div/div")).isDisplayed();
    }
    public boolean getSuccessPage (WebDriver chromeDriver) {
        return chromeDriver.findElement(By.tagName("h5")).isDisplayed();
    }

}
