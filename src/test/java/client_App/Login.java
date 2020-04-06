package client_App;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.Domain;

public class Login implements Domain {
    @Test
    public void LoginTest ()  {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver-v-0.26.0");
        FirefoxDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver,10);

        driver.get(LOGIN);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("loginId")));

        driver.findElement(By.id("loginId")).sendKeys("EvgQA");
        driver.findElement(By.id("passwordId")).sendKeys("12345678");

        // ned to find element button and finish test
//        driver.findElement(By.)
//        driver.close();
    }
}
