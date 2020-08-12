package tests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class TestDocker {
    @Test
    public void runTestDocker () throws MalformedURLException {
        DesiredCapabilities dcap = DesiredCapabilities.chrome();
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver_84");

        URL gamelan = new URL("http://localhost:32768/wd/hub");
        WebDriver driver = new RemoteWebDriver(gamelan, dcap);

        driver.get("https://www.google.com/");
        // Print Title
        System.out.println(driver.getTitle());
    }
}
