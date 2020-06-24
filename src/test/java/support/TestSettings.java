package support;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestSettings {

    public static ChromeDriver chromeDriver () {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver_83");
        return new ChromeDriver();
    }
    public ChromeDriver chromeDriver = chromeDriver ();
    public WebDriverWait chromeWaiter = new WebDriverWait(chromeDriver, 5);
    public ScreenshotBuilder screenshotBuilder = new ScreenshotBuilder();

    public void runMaximizeWindow () {
        chromeDriver.manage().window().maximize();
    }
}
