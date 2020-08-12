package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import pages.DepositPage;
import pages.LoginPage;
import pages.ProfilePage;
import support.Domains;
import support.TestSettings;

import java.net.MalformedURLException;

public class DepositTest extends DepositPage implements Domains {
    TestSettings testSettings = new TestSettings();
    LoginPage loginPage = new LoginPage();
    ProfilePage profilePage = new ProfilePage();

    public DepositTest() throws MalformedURLException {
    }

    @Before
    public void runBeforeTest () {
        try{
            testSettings.setWindowSize(testSettings.chromeDriver);
            testSettings.chromeDriver.get(LOGIN);
            loginPage.waitElementXpath(testSettings.chromeWaiter, loginPage.confirmButton);
            loginPage.setElementById(testSettings.chromeDriver, loginPage.loginId, "evgqa66@yopmail.com");
            loginPage.setElementById(testSettings.chromeDriver, loginPage.passwordId, "12345678");
            loginPage.getElementXpath(testSettings.chromeDriver, loginPage.confirmButton).click();
            loginPage.waitElementXpath(testSettings.chromeWaiter, loginPage.footer);
            testSettings.chromeDriver.get(PROFILE);
            waitElementXpath(testSettings.chromeWaiter, profileSettingsBox);
            profilePage.getElementXpath(testSettings.chromeDriver, profilePage.depositXpath).click();
            waitElementXpath(testSettings.chromeWaiter, depositBox);
        } catch (Exception e) {
            testSettings.runErrorCatch(testSettings.chromeDriver,"runBeforeTest", e);
            System.out.println(e);
            testSettings.chromeDriver.close();
        }
    }

    @Test
    public void runValidationCheck () {
        try {
            for (int i = 0; i < 10; i++) {
                getElementsXpath(testSettings.chromeDriver, depositBox, i).click();
                waitElementByName(testSettings.chromeWaiter, amountName);
                getElementByName(testSettings.chromeDriver, amountName).sendKeys(Keys.CONTROL + "a");
                getElementByName(testSettings.chromeDriver, amountName).sendKeys(Keys.DELETE);
                if (isClickableName(testSettings.chromeWaiter, accountName)) {
                    setElementByName(testSettings.chromeDriver, amountName, wrongAmountRub);
                    setElementByName(testSettings.chromeDriver, accountName, wrongPhone);
                    if (!isClickableXpath(testSettings.chromeWaiter, confirmButton)) {
                        System.out.println("runValidationCheck number " + i + " passed");
                    } else {
                        System.out.println("runValidationCheck number " + i + " failed");
                        testSettings.screenshotBuilder.createScreenshot("runValidationCheck", testSettings.chromeDriver);
                        testSettings.chromeDriver.close();
                        assert false;
                    }
                } else {
                    setElementByName(testSettings.chromeDriver, amountName, wrongAmountRub);
                    if(!isClickableXpath(testSettings.chromeWaiter, confirmButton)) {
                        System.out.println("runValidationCheck number " + i + " passed");
                    } else {
                        System.out.println("runValidationCheck number " + i + " failed");
                        testSettings.screenshotBuilder.createScreenshot("runValidationCheck", testSettings.chromeDriver);
                        testSettings.chromeDriver.close();
                        assert false;
                    }
                }
            }
            testSettings.chromeDriver.close();

        } catch (Exception e) {
            testSettings.runErrorCatch(testSettings.chromeDriver,"runValidationCheck", e);
            System.out.println(e);
            testSettings.chromeDriver.close();
        }
    }
    @Test
    public void runPositiveVisa () {
        try {
            waitElementByName(testSettings.chromeWaiter, amountName);
            setElementByName(testSettings.chromeDriver, amountName,correctAmountRub);
            getElementXpath(testSettings.chromeDriver, confirmButton).click();
            if(urlFractionRedirectionCheck(testSettings.chromeWaiter, "card")) {
                System.out.println("runPositiveVisa passed");
            } else {
                System.out.println("runPositiveVisa failed");
                testSettings.screenshotBuilder.createScreenshot("runPositiveVisa", testSettings.chromeDriver);
                testSettings.chromeDriver.close();
                assert false;
            }
            testSettings.chromeDriver.close();
        } catch (Exception e) {
            testSettings.runErrorCatch(testSettings.chromeDriver,"runPositiveVisa", e);
            System.out.println(e);
            testSettings.chromeDriver.close();
        }
    }
    @Test
    public void runPositiveQiwi () {
        try {
            getElementsXpath(testSettings.chromeDriver, depositBox, 1).click();
            waitElementByName(testSettings.chromeWaiter, amountName);
            setElementByName(testSettings.chromeDriver, amountName,correctAmountRub);
            setElementByName(testSettings.chromeDriver, accountName, correctAccountPhone);
            getElementXpath(testSettings.chromeDriver, confirmButton).click();
            if(urlFractionRedirectionCheck(testSettings.chromeWaiter, "oplata.qiwi")) {
                System.out.println("runPositiveQiwi passed");
            } else {
                System.out.println("runPositiveQiwi failed");
                testSettings.screenshotBuilder.createScreenshot("runPositiveQiwi", testSettings.chromeDriver);
                testSettings.chromeDriver.close();
                assert false;
            }
            testSettings.chromeDriver.close();
        } catch (Exception e) {
            testSettings.runErrorCatch(testSettings.chromeDriver,"runPositiveQiwi", e);
            System.out.println(e);
            testSettings.chromeDriver.close();
        }
    }

    @After
    public void closeDriver () throws Exception {
        TestSettings testSettings = new TestSettings();
        testSettings.chromeDriver.close();
    }
}
