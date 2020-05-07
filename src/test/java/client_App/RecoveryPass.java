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

public class RecoveryPass implements Domain {
    @Test
    public void recoveryPassTest () {
        ChromeDriver chromeDriver = chromeDriver ();
        WebDriverWait chromeWaiter = new WebDriverWait(chromeDriver, 10);

//        FirefoxDriver firefoxDriver = firefoxDriver();
//        WebDriverWait firefoxWaiter = new WebDriverWait(firefoxDriver,10);

        chromeDriver.get(RECOVERYPASS);
        chromeWaiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"__next\"]/div/div/section" +
                "/div/section/div[2]/div[2]/div[1]/input")));
        chromeDriver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/section" +
                "/div/section/div[2]/div[2]/div[1]/input")).sendKeys("evgqa66@yopmail.com");
        chromeDriver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/section/div/section/div[2]/div[2]/div[2]/button")).click();
        chromeDriver.close();
    }
}
