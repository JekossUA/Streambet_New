package tests;

import org.junit.Test;
import pages.MainPage;
import support.Domain;
import support.TestSettings;

public class MainPageTest extends MainPage implements Domain {

    @Test
    public void MainPage_Positive() {
        TestSettings testSettings = new TestSettings();
        testSettings.runMaximizeWindow();
        try {
            testSettings.chromeDriver.get(MAINPAGE);
            waitNavigationButtons(testSettings.chromeWaiter);
            getUserCorner(testSettings.chromeDriver, 3).click();

        } catch (Exception e) {

        }
    }
}
