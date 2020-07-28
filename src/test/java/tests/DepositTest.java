package tests;

import org.junit.Before;
import org.junit.Test;
import pages.DepositPage;
import pages.LoginPage;
import pages.ProfilePage;
import support.Domains;
import support.TestSettings;

public class DepositTest extends DepositPage implements Domains {
    TestSettings testSettings = new TestSettings();

    @Before
    public void runBeforeTest () {
        LoginPage loginPage = new LoginPage();
        DepositPage depositPage = new DepositPage();
        ProfilePage profilePage = new ProfilePage();
        try {
            testSettings.runMaximizeWindow();
            testSettings.chromeDriver.get(LOGIN);
            loginPage.waitElementXpath(testSettings.chromeWaiter, loginPage.confirmButton);
            loginPage.setElementById(testSettings.chromeDriver, loginPage.loginId, "evgqa66@yopmail.com");
            loginPage.setElementById(testSettings.chromeDriver, loginPage.passwordId, "12345678");
            loginPage.getElementXpath(testSettings.chromeDriver, loginPage.confirmButton).click();
            loginPage.waitElementXpath(testSettings.chromeWaiter, loginPage.footer);
            testSettings.chromeDriver.get(PROFILE);
            waitElementXpath(testSettings.chromeWaiter, depositPage.profileSettingsBox);
            profilePage.getElementXpath(testSettings.chromeDriver, profilePage.depositXpath).click();
            waitElementXpath(testSettings.chromeWaiter, depositBox);
        } catch (Exception e) {
            testSettings.screenshotBuilder.createScreenshot("runBeforeTest", testSettings.chromeDriver);
            System.out.println(e);
        }
    }
    @Test
    public  void runValidationCheck () {
        try {
            for (int i=0; i<=depositBox.length(); i++) {
                getElementsXpath(testSettings.chromeDriver, depositBox, i).click();
                waitElementByName(testSettings.chromeWaiter, amountName);
                setElementByName(testSettings.chromeDriver, amountName, wrongAmountRub);
                if(isClickable(testSettings.chromeWaiter, phoneName)){
                    setElementByName(testSettings.chromeDriver, phoneName, wrongPhone);
                    getElementXpath(testSettings.chromeDriver, confirmButton).click();
                    waitElementXpath(testSettings.chromeWaiter, amountError);
                    waitElementXpath(testSettings.chromeWaiter, phoneError);
                    if(getElementXpath(testSettings.chromeDriver, amountError).isDisplayed() &&
                            getElementXpath(testSettings.chromeDriver, phoneError).isDisplayed()){
                        System.out.println("runValidationCheck passed");
                    } else {
                        testSettings.screenshotBuilder.createScreenshot("runValidationCheck failed ", testSettings.chromeDriver);
                    }
                } else if (!isClickable(testSettings.chromeWaiter, phoneName)) {
                    getElementXpath(testSettings.chromeDriver, confirmButton).click();
                    waitElementXpath(testSettings.chromeWaiter, amountError);
                    if(getElementXpath(testSettings.chromeDriver, amountError).isDisplayed()) {
                        System.out.println("runValidationCheck passed");
                    } else  {
                        testSettings.screenshotBuilder.createScreenshot("runValidationCheck failed ", testSettings.chromeDriver);
                    }
                } else  {
                    testSettings.screenshotBuilder.createScreenshot("runValidationCheck failed ", testSettings.chromeDriver);
                }
                testSettings.chromeDriver.close();
            }

        } catch (Exception e) {
            testSettings.runErrorCatch(testSettings.chromeDriver,"runValidationCheck", e);
            System.out.println(e);
        }
    }
}
