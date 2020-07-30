package support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestSettings {

    public static ChromeDriver chromeDriver () {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver_84");
        return new ChromeDriver();
    }
    public ChromeDriver chromeDriver = chromeDriver ();
    public WebDriverWait chromeWaiter = new WebDriverWait(chromeDriver, 5);
    public ScreenshotBuilder screenshotBuilder = new ScreenshotBuilder();

    public void runMaximizeWindow () {
        chromeDriver.manage().window().maximize();
    }

    public void runErrorCatch (WebDriver driver, String testName, Exception exception) {
        screenshotBuilder.createScreenshot(testName, chromeDriver);
        System.out.println(exception);
        driver.close();
        assert false;
    }
}
