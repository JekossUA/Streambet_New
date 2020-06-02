package tests;

import org.openqa.selenium.firefox.FirefoxDriver;

public  class GekoDriver {
    public static FirefoxDriver firefoxDriver () {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver-v-0.26.0");
        return new FirefoxDriver();
    }
}
