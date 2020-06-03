package tests;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverBuilder {
    public static ChromeDriver chromeDriver () {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver_83");
        return new ChromeDriver();
    }
}
