package client_App;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.Domain;
import static client_App.GekoDriver.*;
import static client_App.ChromeDriverBuild.*;

public class Login implements Domain {

    @Test
    public void LoginTest_Positive()  {
        ChromeDriver chromeDriver = chromeDriver ();
        WebDriverWait chromeWaiter = new WebDriverWait(chromeDriver, 10);

//        FirefoxDriver firefoxDriver = firefoxDriver();
//        WebDriverWait firefoxWaiter = new WebDriverWait(firefoxDriver,10);


        chromeDriver.get(LOGIN);
        chromeWaiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("loginId")));

        chromeDriver.findElement(By.id("loginId")).sendKeys("evgqa1220@yopmail.com");
        chromeDriver.findElement(By.id("passwordId")).sendKeys("12345678");
        chromeDriver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/section/div/section/div[2]/div[2]/div[3]/button")).click();

//        String token = chromeDriver.getLocalStorage().getItem("Key");
//        if (token != null) {
//            System.out.println(token);
//            chromeDriver.close();
//        }
        chromeDriver.close();
        System.out.println("Login passed");
    }
    @Test
    public void LoginTest_Negative_1() {
        ChromeDriver chromeDriver = chromeDriver ();
        WebDriverWait chromeWaiter = new WebDriverWait(chromeDriver, 10);

        chromeDriver.get(LOGIN);
        chromeWaiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("loginId")));

        chromeDriver.findElement(By.id("loginId")).sendKeys("");
        chromeDriver.findElement(By.id("passwordId")).sendKeys("12345678");
        chromeDriver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/section/div/section/div[2]/div[2]/div[3]/button")).click();
        chromeWaiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#__next > div > div > section > " +
                "div > section > div.OverlayForms_overlay-form__3Wo8U " +
                "> div.OverlayForms_overlay-form__wrapper__s9rus > div:nth-child(1) > div > div")));
        chromeDriver.findElement(By.cssSelector("#__next > div > div > section > div > section > div.OverlayForms_overlay-form__3Wo8U " +
                "> div.OverlayForms_overlay-form__wrapper__s9rus > div:nth-child(1) > div > div"));

        chromeDriver.close();
        System.out.println("Empty login passed");
    }
    @Test
    public void LoginTest_Negative_2() {
        ChromeDriver chromeDriver = chromeDriver ();
        WebDriverWait chromeWaiter = new WebDriverWait(chromeDriver, 10);

        chromeDriver.get(LOGIN);
        chromeWaiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("loginId")));

        chromeDriver.findElement(By.id("loginId")).sendKeys("evgqa1220@yopmail.com");
        chromeDriver.findElement(By.id("passwordId")).sendKeys("");
        chromeDriver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/section/div/section/div[2]/div[2]/div[3]/button")).click();
        chromeWaiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#__next > div > div > section" +
                " > div > section > div.OverlayForms_overlay-form__3Wo8U > div.OverlayForms_overlay-form__wrapper__s9rus > div:nth-child(2) > div > div")));
        chromeDriver.findElement(By.cssSelector("#__next > div > div > section > div > section > div.OverlayForms_overlay-form__3Wo8U " +
                "> div.OverlayForms_overlay-form__wrapper__s9rus > div:nth-child(2) > div > div"));

        chromeDriver.close();
        System.out.println("Empty password passed");
    }
    @Test
    public void LoginTest_Negative_3() {
        ChromeDriver chromeDriver = chromeDriver ();
        WebDriverWait chromeWaiter = new WebDriverWait(chromeDriver, 10);

        chromeDriver.get(LOGIN);
        chromeWaiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("loginId")));

        chromeDriver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/section/div/section/div[2]/div[2]/div[3]/button")).click();
        chromeWaiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#__next > div > div > section > " +
                "div > section > div.OverlayForms_overlay-form__3Wo8U " +
                "> div.OverlayForms_overlay-form__wrapper__s9rus > div:nth-child(1) > div > div")));
        chromeDriver.findElement(By.cssSelector("#__next > div > div > section > div > section > div.OverlayForms_overlay-form__3Wo8U " +
                "> div.OverlayForms_overlay-form__wrapper__s9rus > div:nth-child(1) > div > div"));

        chromeDriver.close();
        System.out.println("Empty fields passed");
    }
    @Test
    public void LoginTest_Negative_4() {
        ChromeDriver chromeDriver = chromeDriver ();
        WebDriverWait chromeWaiter = new WebDriverWait(chromeDriver, 10);

        chromeDriver.get(LOGIN);
        chromeWaiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("loginId")));

        chromeDriver.findElement(By.id("loginId")).sendKeys("evgqa122222220@yopmail.com");
        chromeDriver.findElement(By.id("passwordId")).sendKeys("12345678");
        chromeDriver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/section/div/section/div[2]/div[2]/div[3]/button")).click();
        chromeWaiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#__next > div > div > section > " +
                "div > section > div.OverlayForms_overlay-form__3Wo8U " +
                "> div.OverlayForms_overlay-form__wrapper__s9rus > div:nth-child(1) > div > div")));
        chromeDriver.findElement(By.cssSelector("#__next > div > div > section > div > section > div.OverlayForms_overlay-form__3Wo8U " +
                "> div.OverlayForms_overlay-form__wrapper__s9rus > div:nth-child(1) > div > div"));

        chromeDriver.close();
        System.out.println("Wrong login passed");
    }
    @Test
    public void LoginTest_Negative_5() {
        ChromeDriver chromeDriver = chromeDriver ();
        WebDriverWait chromeWaiter = new WebDriverWait(chromeDriver, 10);

        chromeDriver.get(LOGIN);
        chromeWaiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("loginId")));

        chromeDriver.findElement(By.id("loginId")).sendKeys("evgqa1220@yopmail.com");
        chromeDriver.findElement(By.id("passwordId")).sendKeys("1234567833");
        chromeDriver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/section/div/section/div[2]/div[2]/div[3]/button")).click();
        chromeWaiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#__next > div > div > section > " +
                "div > section > div.OverlayForms_overlay-form__3Wo8U " +
                "> div.OverlayForms_overlay-form__wrapper__s9rus > div:nth-child(1) > div > div")));
        chromeDriver.findElement(By.cssSelector("#__next > div > div > section > div > section > div.OverlayForms_overlay-form__3Wo8U " +
                "> div.OverlayForms_overlay-form__wrapper__s9rus > div:nth-child(1) > div > div"));

        chromeDriver.close();
        System.out.println("Wrong password passed");
    }
}
