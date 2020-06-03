package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.Domain;

import static tests.ChromeDriverBuilder.*;

public class RecoveryPass implements Domain {
    ChromeDriver chromeDriver = chromeDriver ();
    WebDriverWait chromeWaiter = new WebDriverWait(chromeDriver, 10);
    @Test
    public void recoveryPassTest () {


        chromeDriver.get(RECOVERYPASS);
        chromeWaiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"__next\"]/div/div/section" +
                "/div/section/div[2]/div[2]/div[1]/input")));
        chromeDriver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/section" +
                "/div/section/div[2]/div[2]/div[1]/input")).sendKeys("evgqa66@yopmail.com");
        chromeDriver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/section/div/section/div[2]/div[2]/div[2]/button")).click();
        chromeDriver.close();
    }
}
