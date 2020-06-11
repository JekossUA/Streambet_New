package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationPage {

    //get registration fields
    public void getLoginInput (ChromeDriver chromeDriver, String loginText) {
        chromeDriver.findElement(By.id("loginId")).sendKeys(loginText);
    }
    public void getEmailInput (ChromeDriver chromeDriver, String email) {
        chromeDriver.findElement(By.id("emeilId")).sendKeys(email);
    }
    public void getPasswordInput (ChromeDriver chromeDriver, String password) {
        chromeDriver.findElement(By.id("passwordId")).sendKeys(password);
    }
    public void getPasswordRepeatInput (ChromeDriver chromeDriver, String repeatPassword) {
        chromeDriver.findElement(By.id("passwordRepeatId")).sendKeys(repeatPassword);
    }
    public void getCheckbox (ChromeDriver chromeDriver) {
        chromeDriver.findElement(By.id("checkboxId"));
    }

}
