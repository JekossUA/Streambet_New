package tests;

import org.junit.Test;
import pages.RegistrationPage;
import support.*;


public class RegistrationTest extends RegistrationPage implements Domain {
    RandomUsers randomUsers = new RandomUsers();

    @Test
    public void RegistrationTest_Positive() throws Exception {
        TestSettings testSettings = new TestSettings();
        testSettings.runMaximizeWindow();
        try {
            testSettings.chromeDriver.get(REGISTRATION);
            waitEmailInput(testSettings.chromeWaiter);

            getLoginInput(testSettings.chromeDriver, randomUsers.setRandomFirstName());
            getEmailInput(testSettings.chromeDriver, randomUsers.setRandomEmail());
            String randomPass = randomUsers.setRandomPhoneNum();
            getPasswordInput(testSettings.chromeDriver, randomPass);
            getPasswordRepeatInput(testSettings.chromeDriver, randomPass);
            getCheckbox(testSettings.chromeDriver).click();
            setWallet(testSettings.chromeDriver, randomUsers.setRandomWallet());
            getConfirmButton(testSettings.chromeDriver).click();
            waitSuccessPage(testSettings.chromeWaiter);
            System.out.println("Registration passed!");
            testSettings.chromeDriver.close();

        } catch (Exception e) {
            testSettings.screenshotBuilder.createScreenshot("RegistrationTest_Positive", testSettings.chromeDriver);
            testSettings.chromeDriver.close();
        }
    }
}
