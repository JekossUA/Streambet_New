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

            waitElementXpath(testSettings.chromeWaiter, header);
            if (getElementXpath(testSettings.chromeDriver, header).isDisplayed()) {
                System.out.println("header displayed!");
            } else {
                System.out.println("header don't display");
                testSettings.screenshotBuilder.createScreenshot("header ", testSettings.chromeDriver );
            }

            waitElementXpath(testSettings.chromeWaiter, navigationButtons);
            if (getElementXpath(testSettings.chromeDriver, navigationButtons).isDisplayed()) {
                System.out.println("navigationButtons displayed!");
            } else {
                System.out.println("navigationButtons don't display");
                testSettings.screenshotBuilder.createScreenshot("navigationButtons", testSettings.chromeDriver );
            }

            waitElementXpath(testSettings.chromeWaiter, usersCorner);
            if (getElementXpath(testSettings.chromeDriver, usersCorner).isDisplayed()) {
                System.out.println("usersCorner displayed!");
            } else {
                System.out.println("usersCorner don't display");
                testSettings.screenshotBuilder.createScreenshot("usersCorner", testSettings.chromeDriver );
            }

            waitElementXpath(testSettings.chromeWaiter, gameFilters);
            if (getElementXpath(testSettings.chromeDriver, gameFilters).isDisplayed()) {
                System.out.println("gameFilters displayed!");
            } else {
                System.out.println("gameFilters don't display");
                testSettings.screenshotBuilder.createScreenshot("gameFilters", testSettings.chromeDriver );
            }

            waitElementXpath(testSettings.chromeWaiter, betLineContainer);
            if (getElementXpath(testSettings.chromeDriver, betLineContainer).isDisplayed()) {
                System.out.println("betLineContainer displayed!");
            } else {
                System.out.println("betLineContainer don't display");
                testSettings.screenshotBuilder.createScreenshot("betLineContainer", testSettings.chromeDriver );
            }

            waitElementXpath(testSettings.chromeWaiter, sideBar);
            if (getElementXpath(testSettings.chromeDriver, sideBar).isDisplayed()) {
                System.out.println("sideBar displayed!");
            } else {
                System.out.println("sideBar don't display");
                testSettings.screenshotBuilder.createScreenshot("sideBar", testSettings.chromeDriver );
            }
            testSettings.chromeDriver.close();
        } catch (Exception e) {
            testSettings.runErrorCatch(testSettings.chromeDriver, "MainPage_Positive", e);
        }
    }
    @Test
    public void MainPage_NavButtons_Streams () {
        TestSettings testSettings = new TestSettings();
        testSettings.runMaximizeWindow();
        try {
            testSettings.chromeDriver.get(MAINPAGE);
            waitElementXpath(testSettings.chromeWaiter, navigationButtons);
            getElementsContainerXpath(testSettings.chromeDriver, navigationButtons, 1).click();
            waitElementXpath(testSettings.chromeWaiter, streamPage);
            waitUrl(testSettings.chromeWaiter, STREAMS);
            String currentUrl = testSettings.chromeDriver.getCurrentUrl();
            if(currentUrl.equals(STREAMS)) {
                System.out.println("MainPage_NavButtons_Streams passed");
            } else {
                System.out.println("MainPage_NavButtons_Streams failed");
                testSettings.screenshotBuilder.createScreenshot("MainPage_NavButtons_Streams", testSettings.chromeDriver);
            }
            testSettings.chromeDriver.close();
        } catch (Exception e) {
            testSettings.runErrorCatch(testSettings.chromeDriver, "MainPage_NavButtons_Streams", e);
        }
    }
    @Test
    public void MainPage_NavButtons_Sport () {
        TestSettings testSettings = new TestSettings();
        testSettings.runMaximizeWindow();
        try {
            testSettings.chromeDriver.get(MAINPAGE);
            waitElementXpath(testSettings.chromeWaiter, navigationButtons);
            getElementsContainerXpath(testSettings.chromeDriver, navigationButtons, 2).click();
            waitElementXpath(testSettings.chromeWaiter, sportPageSlider);
            waitUrl(testSettings.chromeWaiter, SPORT);
            String currentUrl = testSettings.chromeDriver.getCurrentUrl();
            if(currentUrl.equals(SPORT)) {
                System.out.println("MainPage_NavButtons_Sport passed");
            } else {
                System.out.println("MainPage_NavButtons_Sport failed");
                testSettings.screenshotBuilder.createScreenshot("MainPage_NavButtons_Sport", testSettings.chromeDriver);
            }
            testSettings.chromeDriver.close();
        } catch (Exception e) {
            testSettings.runErrorCatch(testSettings.chromeDriver, "MainPage_NavButtons_Sport", e);
        }
    }
    @Test
    public void MainPage_NavButtons_Slot () {
        TestSettings testSettings = new TestSettings();
        testSettings.runMaximizeWindow();
        try {
            testSettings.chromeDriver.get(MAINPAGE);
            waitElementXpath(testSettings.chromeWaiter, navigationButtons);
            getElementsContainerXpath(testSettings.chromeDriver, navigationButtons, 3).click();
            waitElementXpath(testSettings.chromeWaiter, slotsPage);
            waitUrl(testSettings.chromeWaiter, SLOTS);
            String currentUrl = testSettings.chromeDriver.getCurrentUrl();
            if(currentUrl.equals(SLOTS)) {
                System.out.println("MainPage_NavButtons_Slot passed");
            } else {
                System.out.println("MainPage_NavButtons_Slot failed");
                testSettings.screenshotBuilder.createScreenshot("MainPage_NavButtons_Slot", testSettings.chromeDriver);
            }
            testSettings.chromeDriver.close();
        } catch (Exception e) {
            testSettings.runErrorCatch(testSettings.chromeDriver, "MainPage_NavButtons_Slot", e);
        }
    }
    @Test
    public void MainPage_GameFilters () {
        TestSettings testSettings = new TestSettings();
        testSettings.runMaximizeWindow();
        try {
            testSettings.chromeDriver.get(MAINPAGE);
            waitElementXpath(testSettings.chromeWaiter, gameFilters);
            for (int i = 0; i<=13; i++) {
                getElementsContainerXpath(testSettings.chromeDriver, gameFilters, i).click();
                getElementsContainerXpath(testSettings.chromeDriver, gameFilters, i).click();
                waitElementXpath(testSettings.chromeWaiter, betLineContainer);
                if (getElementXpath(testSettings.chromeDriver, betLineContainer).isDisplayed()) {
                    System.out.println("filter number " + i +  " - worked");
                } else {
                    System.out.println("filter number " + i +  " - is not worked");
                    testSettings.screenshotBuilder.createScreenshot("filter failed ", testSettings.chromeDriver);
                }
            }
            testSettings.chromeDriver.close();
        } catch (Exception e) {
            testSettings.runErrorCatch(testSettings.chromeDriver, "MainPage_GameFilters", e);
        }
    }
    @Test
    public void MainPage_BetLineFilters () {
        TestSettings testSettings = new TestSettings();
        testSettings.runMaximizeWindow();
        try {
            testSettings.chromeDriver.get(MAINPAGE);
            waitElementXpath(testSettings.chromeWaiter, betLineContainer);
            getElementXpath(testSettings.chromeDriver, liveMatchesFilter).click();
            waitElementXpath(testSettings.chromeWaiter, betLineContainer);
            if (getElementXpath(testSettings.chromeDriver, betLineContainer).isDisplayed()) {
                System.out.println("Live matches passed");
            } else {
                System.out.println("Live matches failed");
                testSettings.screenshotBuilder.createScreenshot("Live matches", testSettings.chromeDriver);
            }
            getElementXpath(testSettings.chromeDriver, allMatchesFilter).click();
            waitElementXpath(testSettings.chromeWaiter, betLineContainer);
            if (getElementXpath(testSettings.chromeDriver, betLineContainer).isDisplayed()) {
                System.out.println("allMatchesFilter passed");
            } else {
                System.out.println("allMatchesFilter failed");
                testSettings.screenshotBuilder.createScreenshot("allMatchesFilter", testSettings.chromeDriver);
            }
            getElementXpath(testSettings.chromeDriver, eventsFilter).click();
            waitElementXpath(testSettings.chromeWaiter, betLineContainer);
            if (getElementXpath(testSettings.chromeDriver, betLineContainer).isDisplayed()) {
                System.out.println("eventsFilter passed");
            } else {
                System.out.println("eventsFilter failed");
                testSettings.screenshotBuilder.createScreenshot("eventsFilter", testSettings.chromeDriver);
            }
            getElementXpath(testSettings.chromeDriver, daysFilter).click();
            waitElementXpath(testSettings.chromeWaiter, betLineContainer);
            if (getElementXpath(testSettings.chromeDriver, betLineContainer).isDisplayed()) {
                System.out.println("daysFilter passed");
            } else {
                System.out.println("daysFilter failed");
                testSettings.screenshotBuilder.createScreenshot("daysFilter", testSettings.chromeDriver);
            }
            testSettings.chromeDriver.close();
        } catch (Exception e) {
            testSettings.runErrorCatch(testSettings.chromeDriver, "MainPage_BetLineFilters", e);
        }
    }
    @Test
    public void MainPage_LiveMatches_WatchButton() {
        TestSettings testSettings = new TestSettings();
        testSettings.runMaximizeWindow();
        try {
            testSettings.chromeDriver.get(MAINPAGE);
            waitElementXpath(testSettings.chromeWaiter, firstLiveStream);
            getElementXpath(testSettings.chromeDriver, watchButton).click();
            waitElementXpath(testSettings.chromeWaiter, iframe);
            if(getElementXpath(testSettings.chromeDriver, iframe).isDisplayed()) {
                System.out.println("iframe displayed");
            } else {
                System.out.println("iframe did not displayed");
                testSettings.screenshotBuilder.createScreenshot("MainPage_LiveMatches_WatchButton", testSettings.chromeDriver);
            }
            testSettings.chromeDriver.close();
        } catch (Exception e) {
            testSettings.runErrorCatch(testSettings.chromeDriver, "MainPage_LiveMatches_WatchButton", e);
        }
    }
    @Test
    public void MainPage_LiveMatches_SideButton() {
        TestSettings testSettings = new TestSettings();
        testSettings.runMaximizeWindow();
        try{
            testSettings.chromeDriver.get(MAINPAGE);
            waitElementXpath(testSettings.chromeWaiter, firstLiveStream);
            getElementXpath(testSettings.chromeDriver, liveSideButton).click();
            waitElementXpath(testSettings.chromeWaiter, iframe);
            if(getElementXpath(testSettings.chromeDriver, iframe).isDisplayed()) {
                System.out.println("iframe displayed");
            } else {
                System.out.println("iframe did not displayed");
                testSettings.screenshotBuilder.createScreenshot("MainPage_LiveMatches_SideButton", testSettings.chromeDriver);
            }
            testSettings.chromeDriver.close();
        }catch (Exception e) {
            testSettings.runErrorCatch(testSettings.chromeDriver, "MainPage_LiveMatches_SideButton", e);
        }
    }
    @Test // finish test here
    public void MainPage_OpenBetLine () {
        TestSettings testSettings = new TestSettings();
        testSettings.runMaximizeWindow();
        try {
            testSettings.chromeDriver.get(MAINPAGE);
            waitElementXpath(testSettings.chromeWaiter, betLineSideButton);
            getElementXpath(testSettings.chromeDriver, betLineSideButton).click();

            testSettings.chromeDriver.close();

        } catch (Exception e) {
            testSettings.runErrorCatch(testSettings.chromeDriver, "MainPage_OpenBetLine", e);
        }
    }
}

