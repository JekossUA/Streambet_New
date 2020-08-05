package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import pages.LoginPage;
import pages.ProfilePage;
import pages.WithdrawalPage;
import support.Domains;
import support.TestSettings;

public class WithdrawalTest extends WithdrawalPage implements Domains {
    TestSettings testSettings = new TestSettings();
    LoginPage loginPage = new LoginPage();
    ProfilePage profilePage = new ProfilePage();
    @Before
    public void rubBeforeTest () {
        testSettings.runMaximizeWindow();
        testSettings.chromeDriver.get(LOGIN);
        loginPage.waitElementXpath(testSettings.chromeWaiter, loginPage.confirmButton);
        loginPage.setElementById(testSettings.chromeDriver, loginPage.loginId, "evgqa66@yopmail.com");
        loginPage.setElementById(testSettings.chromeDriver, loginPage.passwordId, "12345678");
        loginPage.getElementXpath(testSettings.chromeDriver, loginPage.confirmButton).click();
        loginPage.waitElementXpath(testSettings.chromeWaiter, loginPage.footer);
        testSettings.chromeDriver.get(PROFILE);
        waitElementXpath(testSettings.chromeWaiter, profileSettingsBox);
        profilePage.getElementXpath(testSettings.chromeDriver, profilePage.depositXpath).click();
        waitElementXpath(testSettings.chromeWaiter, withdrawalBoxElement);
        getElementXpath(testSettings.chromeDriver, withdrawalButton).click();
    }

    @Test
    public void runValidationVisa () {
        try {
            waitElementByName(testSettings.chromeWaiter, amountName);
            setElementByName(testSettings.chromeDriver, amountName, amount299RUB);
            setElementByName(testSettings.chromeDriver, accountName, accountViza);
            if(!isClickableXpath(testSettings.chromeWaiter, confirmButton)) {
                System.out.println("runValidationViza passed");
            } else {
                System.out.println("runValidationViza failed");
                testSettings.screenshotBuilder.createScreenshot("runValidationViza ", testSettings.chromeDriver);
                testSettings.chromeDriver.close();
                assert false;
            }
            testSettings.chromeDriver.close();
        } catch (Exception e) {
            testSettings.runErrorCatch(testSettings.chromeDriver, "runValidationCheck", e);
            System.out.println(e);
            testSettings.chromeDriver.close();
        }
    }
    @Test
    public void runValidationOther () {
        try {
            for(int i = 1; i<=8; i++) {
                getElementsXpath(testSettings.chromeDriver, withdrawalBoxElement, i).click();
                waitElementByName(testSettings.chromeWaiter, amountName);
                getElementByName(testSettings.chromeDriver, amountName).sendKeys(Keys.CONTROL + "a");
                getElementByName(testSettings.chromeDriver, amountName).sendKeys(Keys.DELETE);
                setElementByName(testSettings.chromeDriver, amountName, amount99RUB);
                setElementByName(testSettings.chromeDriver, accountName, accountViza);
                if(!isClickableXpath(testSettings.chromeWaiter, confirmButton)) {
                    System.out.println("runValidationOther number" + i + " passed");
                } else {
                    System.out.println("runValidationOther number " + i + " failed");
                    testSettings.screenshotBuilder.createScreenshot("runValidationOther number " + i, testSettings.chromeDriver);
                    testSettings.chromeDriver.close();
                    assert false;
                }
            }
            testSettings.chromeDriver.close();
        } catch (Exception e) {
            testSettings.runErrorCatch(testSettings.chromeDriver, "runValidationCheck", e);
            System.out.println(e);
            testSettings.chromeDriver.close();
        }
    }

    @After
    public void rejectWithdrawals () {

    }
}
