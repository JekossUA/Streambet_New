package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.Domain;
import support.Support;

import static tests.ChromeDriverBuild.*;

public class Registration extends Support implements Domain {
    ChromeDriver chromeDriver = chromeDriver ();
    WebDriverWait chromeWaiter = new WebDriverWait(chromeDriver, 10);
    @Test
    public void RegistrationTest_Positive() {
        try {
            chromeDriver.get(REGISTRATION);
            chromeWaiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("loginId")));
            chromeDriver.findElement(By.id("loginId")).sendKeys(setRandomFirstName());
            chromeDriver.findElement(By.id("emeilId")).sendKeys(setRandomEmail());

            String password = setRandomPhoneNum();
            chromeDriver.findElement(By.id("passwordId")).sendKeys(password);
            chromeDriver.findElement(By.id("passwordRepeatId")).sendKeys(password);
            chromeDriver.findElement(By.cssSelector("#__next > div > div > section > div > section > div.OverlayForms_overlay-" +
                    "form__3Wo8U > div.OverlayForms_overlay-form__wrapper__s9rus > div:nth-child(5) > div > label")).click();

            WebElement currenciesDropdown = chromeDriver.findElement(By.id("selectId"));
            currenciesDropdown.click();
            currenciesDropdown.findElements(By.tagName("option")).get(2).click();

            chromeDriver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/section/div/section/div[2]/div[2]/div[7]/button")).click();
            chromeWaiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"__next\"]/div/div/section/div/section/div[2]/div/h5")));
            String registrSuccessText = chromeDriver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/section/div/section/div[2]/div/h5")).getText();
            if(registrSuccessText != null) {
                System.out.println("Registration passed");
            } else {
                System.out.println("Failed");
            }
        }finally {
            chromeDriver.close();
        }
    }
}
