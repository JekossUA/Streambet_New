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
//        ChromeDriver chromeDriver = chromeDriver ();
//        WebDriverWait chromeWaiter = new WebDriverWait(chromeDriver, 10);

        FirefoxDriver driver = firefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 20);

        driver.get(RECOVERYPASS);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"__next\"]/div/div/section" +
                "/div/section/div[2]/div[2]/div[1]/input")));
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/section" +
                "/div/section/div[2]/div[2]/div[1]/input")).sendKeys("evgqa66@yopmail.com");
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/section/div/section/div[2]/div[2]/div[2]/button")).click();
        driver.close();
    }
}
