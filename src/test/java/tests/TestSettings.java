package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestSettings extends ChromeDriverBuilder {

    ChromeDriver chromeDriver = chromeDriver ();
    WebDriverWait chromeWaiter = new WebDriverWait(chromeDriver, 10);
    Screenshot screenshot = new Screenshot();

    public void runMaximizeWindow () {
        chromeDriver.manage().window().maximize();
    }
}
