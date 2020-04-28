package client_App;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.Domain;
import support.Support;

import static client_App.GekoDriver.firefoxDriver;
import static client_App.ChromeDriverBuild.*;

public class Registration extends Support implements Domain {
    @Test
    public void RegistrationTest_Positive() {
//        ChromeDriver chromeDriver = chromeDriver ();
//        WebDriverWait chromeWaiter = new WebDriverWait(chromeDriver, 10);

        FirefoxDriver driver = firefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver,20);

        driver.get(REGISTRATION);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("loginId")));
        driver.findElement(By.id("loginId")).sendKeys(setRandomFirstName());
        driver.findElement(By.id("emeilId")).sendKeys(setRandomEmail());

        String password = setRandomPhoneNum();
        driver.findElement(By.id("passwordId")).sendKeys(password);
        driver.findElement(By.id("passwordRepeatId")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/section/div/section/div[2]/div[2]/div[5]/label")).click();

        WebElement currenciesDropdown = driver.findElement(By.id("selectId"));
        currenciesDropdown.click();
        currenciesDropdown.findElements(By.tagName("option")).get(2).click();

        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/section/div/section/div[2]/div[2]/div[7]/button")).click();

        driver.close();

    }
}
