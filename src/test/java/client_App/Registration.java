package client_App;

import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.Domain;

public class Registration implements Domain {
    @Test
    public void RegistrationTest () {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver-v-0.26.0");
        FirefoxDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver,10);

        driver.get(REGISTRATION);
    }
}
