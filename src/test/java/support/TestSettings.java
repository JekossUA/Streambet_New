package support;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.MalformedURLException;
import java.net.URL;

public class TestSettings implements Domains {
    static String dockerHost = DOCKERHOST;

    public TestSettings() throws MalformedURLException {
    }

    public static RemoteWebDriver chromeDriver () throws MalformedURLException {
        ChromeOptions chromeOptions = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver_84");

        URL gamelan = new URL(dockerHost);
        chromeOptions.addArguments("incognito","disable-extensions");
        return new RemoteWebDriver(gamelan, chromeOptions);
    }
    public RemoteWebDriver chromeDriver = chromeDriver ();
    public WebDriverWait chromeWaiter = new WebDriverWait(chromeDriver, 5);
    public ScreenshotBuilder screenshotBuilder = new ScreenshotBuilder();

    public void setWindowSize (RemoteWebDriver driver) {
        driver.manage().window().maximize();
    }

    public void runErrorCatch (RemoteWebDriver driver, String testName, Exception exception) {
        screenshotBuilder.createScreenshot(testName,  chromeDriver);
        System.out.println(exception);
        driver.close();
        assert false;
    }
}
