package tests;

import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import pages.ProfilePage;
import support.Domains;
import support.TestSettings;

public class ProfileTests extends ProfilePage implements Domains {
    TestSettings testSettings = new TestSettings();

    @Before
    public void runBeforeTest () {
        LoginPage loginPage = new LoginPage();
        try {
            testSettings.runMaximizeWindow();
            testSettings.chromeDriver.get(LOGIN);
            loginPage.waitElementXpath(testSettings.chromeWaiter, loginPage.confirmButton);
            loginPage.setElementById(testSettings.chromeDriver, loginPage.loginId, "evgqa66@yopmail.com");
            loginPage.setElementById(testSettings.chromeDriver, loginPage.passwordId, "12345678");
            loginPage.getElementXpath(testSettings.chromeDriver, loginPage.confirmButton).click();
            loginPage.waitElementXpath(testSettings.chromeWaiter, loginPage.footer);
        } catch (Exception e) {
            testSettings.screenshotBuilder.createScreenshot("runBeforeTest", testSettings.chromeDriver);
            System.out.println(e);
        }
    }
    @Test
    public void ProfileTest_BetHistory () {
        try {
            testSettings.chromeDriver.get(PROFILE);
            waitElementXpath(testSettings.chromeWaiter, resetPasswordButton);
            getElementXpath(testSettings.chromeDriver, betHistoryXpath).click();
            waitElementXpath(testSettings.chromeWaiter, historyBox);
            if(getElementXpath(testSettings.chromeDriver, historyBox).isDisplayed()){
                System.out.println("Active history displayed");
            } else {
                System.out.println("Active history doesn't display");
                testSettings.screenshotBuilder.createScreenshot("Active bets", testSettings.chromeDriver);
            }
            getElementXpath(testSettings.chromeDriver, betHistoryCalculatedXpath).click();
            waitElementXpath(testSettings.chromeWaiter, historyBox);
            if (getElementXpath(testSettings.chromeDriver, historyBox).isDisplayed()) {
                System.out.println("Settled history displayed");
            } else {
                System.out.println("Settled history doesn't display");
                testSettings.screenshotBuilder.createScreenshot("Settled bets", testSettings.chromeDriver);
            }
            testSettings.chromeDriver.close();
        } catch (Exception e) {
            testSettings.runErrorCatch(testSettings.chromeDriver, "ProfileTest_BetHistory", e);
        }

    }
    @Test
    public void ProfileTest_Deposit_Withdrawal () {
        try {
            testSettings.chromeDriver.get(PROFILE);
            waitElementXpath(testSettings.chromeWaiter, resetPasswordButton);
            getElementXpath(testSettings.chromeDriver, depositXpath).click();
            waitElementXpath(testSettings.chromeWaiter, historyBox);
            if(getElementXpath(testSettings.chromeDriver, historyBox).isDisplayed()){
                System.out.println("deposit displayed");
            } else {
                System.out.println("deposit doesn't display");
                testSettings.screenshotBuilder.createScreenshot("deposit", testSettings.chromeDriver);
            }
            getElementXpath(testSettings.chromeDriver, withdrawalXpath).click();
            waitElementXpath(testSettings.chromeWaiter, historyBox);
            if (getElementXpath(testSettings.chromeDriver, historyBox).isDisplayed()) {
                System.out.println("Withdrawal displayed");
            } else {
                System.out.println("Withdrawal doesn't display");
                testSettings.screenshotBuilder.createScreenshot("Withdrawal", testSettings.chromeDriver);
            }
            testSettings.chromeDriver.close();
        } catch (Exception e) {
            testSettings.runErrorCatch(testSettings.chromeDriver, "ProfileTest_Deposit_Withdrawal", e);
        }
    }
    @Test
    public void ProfileTest_PaymentHistory () {
        try {
            testSettings.chromeDriver.get(PROFILE);
            waitElementXpath(testSettings.chromeWaiter, resetPasswordButton);
            getElementXpath(testSettings.chromeDriver, paymentHistoryXpath).click();
            waitElementXpath(testSettings.chromeWaiter, historyBox);
            if(getElementXpath(testSettings.chromeDriver, historyBox).isDisplayed()){
                System.out.println("deposit history displayed");
            } else {
                System.out.println("deposit history doesn't display");
                testSettings.screenshotBuilder.createScreenshot("deposit history", testSettings.chromeDriver);
            }
            getElementXpath(testSettings.chromeDriver, paymentHistoryWithdrawalXpath).click();
            waitElementXpath(testSettings.chromeWaiter, historyBox);
            if (getElementXpath(testSettings.chromeDriver, historyBox).isDisplayed()) {
                System.out.println("Withdrawal history displayed");
            } else {
                System.out.println("Withdrawal history doesn't display");
                testSettings.screenshotBuilder.createScreenshot("Withdrawal history", testSettings.chromeDriver);
            }
            testSettings.chromeDriver.close();
        } catch (Exception e) {
            testSettings.runErrorCatch(testSettings.chromeDriver, "ProfileTest_PaymentHistory", e);
        }
    }

//    public void runProfileTests () throws Exception {
//        runBeforeTest();
//        ProfileTest_BetHistory();
//        runBeforeTest();
//        ProfileTest_Deposit_Withdrawal();
//        runBeforeTest();
//        ProfileTest_PaymentHistory();
//    }
}
