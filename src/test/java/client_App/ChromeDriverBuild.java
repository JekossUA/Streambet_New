package client_App;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverBuild {
    public static ChromeDriver chromeDriver () {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        return new ChromeDriver();
    }
}
