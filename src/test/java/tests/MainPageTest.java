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

            waitElement(testSettings.chromeWaiter, header);
            if (getElement(testSettings.chromeDriver, header).isDisplayed()) {
                System.out.println("header displayed!");
            } else {
                System.out.println("header don't display");
                testSettings.screenshotBuilder.createScreenshot("header ", testSettings.chromeDriver );
            }

            waitElement(testSettings.chromeWaiter, navigationButtons);
            if (getElement(testSettings.chromeDriver, navigationButtons).isDisplayed()) {
                System.out.println("navigationButtons displayed!");
            } else {
                System.out.println("navigationButtons don't display");
                testSettings.screenshotBuilder.createScreenshot("navigationButtons", testSettings.chromeDriver );
            }

            waitElement(testSettings.chromeWaiter, usersCorner);
            if (getElement(testSettings.chromeDriver, usersCorner).isDisplayed()) {
                System.out.println("usersCorner displayed!");
            } else {
                System.out.println("usersCorner don't display");
                testSettings.screenshotBuilder.createScreenshot("usersCorner", testSettings.chromeDriver );
            }

            waitElement(testSettings.chromeWaiter, gameFilters);
            if (getElement(testSettings.chromeDriver, gameFilters).isDisplayed()) {
                System.out.println("gameFilters displayed!");
            } else {
                System.out.println("gameFilters don't display");
                testSettings.screenshotBuilder.createScreenshot("gameFilters", testSettings.chromeDriver );
            }

            waitElement(testSettings.chromeWaiter, betLineContainer);
            if (getElement(testSettings.chromeDriver, betLineContainer).isDisplayed()) {
                System.out.println("betLineContainer displayed!");
            } else {
                System.out.println("betLineContainer don't display");
                testSettings.screenshotBuilder.createScreenshot("betLineContainer", testSettings.chromeDriver );
            }

            waitElement(testSettings.chromeWaiter, sideBar);
            if (getElement(testSettings.chromeDriver, sideBar).isDisplayed()) {
                System.out.println("sideBar displayed!");
            } else {
                System.out.println("sideBar don't display");
                testSettings.screenshotBuilder.createScreenshot("sideBar", testSettings.chromeDriver );
            }

            testSettings.chromeDriver.close();
        } catch (Exception e) {
            System.out.println(e);
            testSettings.chromeDriver.close();
        }
    }

    @Test
    public void MainPage_NavButtons_Streams () {
        TestSettings testSettings = new TestSettings();
        testSettings.runMaximizeWindow();
        try {
            testSettings.chromeDriver.get(MAINPAGE);
            waitElement(testSettings.chromeWaiter, navigationButtons);
            getElementsContainer(testSettings.chromeDriver, navigationButtons, 1).click();
            waitElement(testSettings.chromeWaiter, streamPage);
            waitUrl(testSettings.chromeWaiter, STREAMS);
            String currentUrl = testSettings.chromeDriver.getCurrentUrl();
            if(currentUrl.equals(STREAMS)) {
                System.out.println("MainPage_NavButtons_Streams passed");
                testSettings.chromeDriver.close();
            } else {
                System.out.println("MainPage_NavButtons_Streams failed");
                testSettings.screenshotBuilder.createScreenshot("MainPage_NavButtons_Streams", testSettings.chromeDriver);
                testSettings.chromeDriver.close();
            }
        } catch (Exception e) {
            System.out.println(e);
            testSettings.screenshotBuilder.createScreenshot( "MainPage_NavButtons_Streams", testSettings.chromeDriver);
            testSettings.chromeDriver.close();
        }
    }

    @Test
    public void MainPage_NavButtons_Sport () {
        TestSettings testSettings = new TestSettings();
        testSettings.runMaximizeWindow();
        try {
            testSettings.chromeDriver.get(MAINPAGE);
            waitElement(testSettings.chromeWaiter, navigationButtons);
            getElementsContainer(testSettings.chromeDriver, navigationButtons, 2).click();
            waitElement(testSettings.chromeWaiter, sportPageSlider);
            waitUrl(testSettings.chromeWaiter, SPORT);
            String currentUrl = testSettings.chromeDriver.getCurrentUrl();
            if(currentUrl.equals(SPORT)) {
                System.out.println("MainPage_NavButtons_Sport passed");
                testSettings.chromeDriver.close();
            } else {
                System.out.println("MainPage_NavButtons_Sport failed");
                testSettings.screenshotBuilder.createScreenshot("MainPage_NavButtons_Sport", testSettings.chromeDriver);
                testSettings.chromeDriver.close();
            }
        } catch (Exception e) {
            System.out.println(e);
            testSettings.screenshotBuilder.createScreenshot( "MainPage_NavButtons_Sport", testSettings.chromeDriver);
            testSettings.chromeDriver.close();
        }
    }

    @Test
    public void MainPage_NavButtons_Slot () {
        TestSettings testSettings = new TestSettings();
        testSettings.runMaximizeWindow();
        try {
            testSettings.chromeDriver.get(MAINPAGE);
            waitElement(testSettings.chromeWaiter, navigationButtons);
            getElementsContainer(testSettings.chromeDriver, navigationButtons, 3).click();
            waitElement(testSettings.chromeWaiter, slotsPage);
            waitUrl(testSettings.chromeWaiter, SLOTS);
            String currentUrl = testSettings.chromeDriver.getCurrentUrl();
            if(currentUrl.equals(SLOTS)) {
                System.out.println("MainPage_NavButtons_Slot passed");
                testSettings.chromeDriver.close();
            } else {
                System.out.println("MainPage_NavButtons_Slot failed");
                testSettings.screenshotBuilder.createScreenshot("MainPage_NavButtons_Slot", testSettings.chromeDriver);
                testSettings.chromeDriver.close();
            }
        } catch (Exception e) {
            System.out.println(e);
            testSettings.screenshotBuilder.createScreenshot( "MainPage_NavButtons_Slot", testSettings.chromeDriver);
            testSettings.chromeDriver.close();
        }
    }

    @Test //need to upgrade api response test
    public void MainPage_GameFilters () {
        TestSettings testSettings = new TestSettings();
        testSettings.runMaximizeWindow();
        try {
            testSettings.chromeDriver.get(MAINPAGE);
            waitElement(testSettings.chromeWaiter, gameFilters);
            for (int i = 0; i<=13; i++) {
                getElementsContainer(testSettings.chromeDriver, gameFilters, i).click();
                getElementsContainer(testSettings.chromeDriver, gameFilters, i).click();
                waitElement(testSettings.chromeWaiter, betLineContainer);
                if (getElement(testSettings.chromeDriver, betLineContainer).isDisplayed()) {
                    System.out.println("filter number " + i +  " - worked");
                } else {
                    System.out.println("filter number " + i +  " - is not worked");
                    testSettings.screenshotBuilder.createScreenshot("filter failed ", testSettings.chromeDriver);
                }
            }
            testSettings.chromeDriver.close();

        } catch (Exception e) {
            System.out.println(e);
            testSettings.screenshotBuilder.createScreenshot("MainPage_GameFilters", testSettings.chromeDriver);
        }
    }
}

