package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

    //get registration fields
    public void getLoginInput (ChromeDriver chromeDriver, String loginText) {
        chromeDriver.findElement(By.id("loginId")).sendKeys(loginText);
    }
    public void getEmailInput(ChromeDriver chromeDriver, String email) {
        chromeDriver.findElement(By.id("emeilId")).sendKeys(email);
    }
    public void getPasswordInput (ChromeDriver chromeDriver, String password) {
        chromeDriver.findElement(By.id("passwordId")).sendKeys(password);
    }
    public void getPasswordRepeatInput (ChromeDriver chromeDriver, String repeatPassword) {
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

    //get warnings and waiters
    public void waitEmailInput(WebDriverWait chromeWaiter) {
        chromeWaiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("emeilId")));
    }
    public void waitFooter(WebDriverWait chromeWaiter) {
        chromeWaiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.tagName("footer")));
    }
    public void waitSuccessPage (WebDriverWait chromeWaiter) {
        chromeWaiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.tagName("h5")));
    }
}
