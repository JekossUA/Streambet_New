package client_App;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.Domain;
import static client_App.GekoDriver.*;
import static client_App.ChromeDriverBuild.*;

public class Login implements Domain {
    @Test
    public void LoginTest_Positive()  {
//        ChromeDriver chromeDriver = chromeDriver ();
//        WebDriverWait chromeWaiter = new WebDriverWait(chromeDriver, 10);

        FirefoxDriver firefoxDriver = firefoxDriver();
        WebDriverWait firefoxWaiter = new WebDriverWait(firefoxDriver,10);


        firefoxDriver.get(LOGIN);
        firefoxWaiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("loginId")));

        firefoxDriver.findElement(By.id("loginId")).sendKeys("EvgQA");
        firefoxDriver.findElement(By.id("passwordId")).sendKeys("12345678");
        firefoxDriver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/section/div/section/div[2]/div[2]/div[3]/button")).click();
        firefoxDriver.close();

    }
}
