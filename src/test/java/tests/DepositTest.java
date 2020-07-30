package tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import pages.DepositPage;
import pages.LoginPage;
import pages.ProfilePage;
import support.Domains;
import support.TestSettings;

public class DepositTest extends DepositPage implements Domains {
    TestSettings testSettings = new TestSettings();
    LoginPage loginPage = new LoginPage();
    DepositPage depositPage = new DepositPage();
    ProfilePage profilePage = new ProfilePage();

    @Before
    public void runBeforeTest () {

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
            for (int i = 0; i < 10; i++) {
                getElementsXpath(testSettings.chromeDriver, depositBox, i).click();
                waitElementByName(testSettings.chromeWaiter, amountName);
                getElementByName(testSettings.chromeDriver, amountName).sendKeys(Keys.CONTROL + "a");
                getElementByName(testSettings.chromeDriver, amountName).sendKeys(Keys.DELETE);
                if (isClickableName(testSettings.chromeWaiter, phoneName)) {
                    setElementByName(testSettings.chromeDriver, amountName, wrongAmountRub);
                    setElementByName(testSettings.chromeDriver, phoneName, wrongPhone);
                    if (isClickableXpath(testSettings.chromeWaiter, confirmButton)) {
                        System.out.println("passed");
                    }
                } else {
                    setElementByName(testSettings.chromeDriver, amountName, wrongAmountRub);
                    if(isClickableXpath(testSettings.chromeWaiter, confirmButton)) {
                        System.out.println("passed");
                    }}
            }
            testSettings.chromeDriver.close();

        } catch (Exception e) {
            testSettings.runErrorCatch(testSettings.chromeDriver,"runValidationCheck", e);
            System.out.println(e);
            testSettings.chromeDriver.close();
        }
    }
}
