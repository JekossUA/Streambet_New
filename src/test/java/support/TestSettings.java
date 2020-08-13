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

        URL remoteUrl = new URL(dockerHost);
        chromeOptions.addArguments("--no-sandbox", "--start-maximized", "--disable-dev-shm-usage");
        return new RemoteWebDriver(remoteUrl, chromeOptions);
    }
    public RemoteWebDriver chromeDriver = chromeDriver();
    public WebDriverWait chromeWaiter = new WebDriverWait(chromeDriver, 5);
    public ScreenshotBuilder screenshotBuilder = new ScreenshotBuilder();

    public void runErrorCatch (RemoteWebDriver driver, String testName, Exception exception) {
        screenshotBuilder.createScreenshot(testName,  chromeDriver);
        System.out.println(exception);
        assert false;
    }
}
