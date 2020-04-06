package client_App;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.Domain;
import static client_App.GekoDriver.*;

public class Login implements Domain {
    @Test
    public void LoginTest_Positive()  {
        FirefoxDriver driver = firefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver,10);

        driver.get(LOGIN);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("loginId")));

        driver.findElement(By.id("loginId")).sendKeys("EvgQA");
        driver.findElement(By.id("passwordId")).sendKeys("12345678");
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/section/div/section/div[2]/div[2]/div[3]/button")).click();
        driver.close();

    }
}
