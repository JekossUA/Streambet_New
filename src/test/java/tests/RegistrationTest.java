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

            setUserLogin(testSettings.chromeDriver, randomUsers.setRandomFirstName());
            setUserEmail(testSettings.chromeDriver, randomUsers.setRandomEmail());
            String randomPass = randomUsers.setRandomPhoneNum();
            setUserPassword(testSettings.chromeDriver, randomPass);
            setRepeatUserPassword(testSettings.chromeDriver, randomPass);
            getCheckbox(testSettings.chromeDriver).click();
            setWallet(testSettings.chromeDriver, randomUsers.setRandomWallet());
            getConfirmButton(testSettings.chromeDriver).click();
            waitSuccessPage(testSettings.chromeWaiter);

            testSettings.chromeDriver.close();
            System.out.println("Registration passed!");

        } catch (Exception e) {
            testSettings.screenshotBuilder.createScreenshot("RegistrationTest_Positive", testSettings.chromeDriver);
            testSettings.chromeDriver.close();
        }
    }
    @Test
    public void RegistrationTest_WrongLogin ()throws Exception {
        TestSettings testSettings = new TestSettings();
        testSettings.runMaximizeWindow();
        try {
            testSettings.chromeDriver.get(REGISTRATION);
            waitEmailInput(testSettings.chromeWaiter);

            setUserLogin(testSettings.chromeDriver, "fF");
            setUserEmail(testSettings.chromeDriver, randomUsers.setRandomEmail());
            String randomPass = randomUsers.setRandomPhoneNum();
            setUserPassword(testSettings.chromeDriver, randomPass);
            setRepeatUserPassword(testSettings.chromeDriver, randomPass);
            getCheckbox(testSettings.chromeDriver).click();
            setWallet(testSettings.chromeDriver, randomUsers.setRandomWallet());
            getConfirmButton(testSettings.chromeDriver).click();

            if (getLoginWarning(testSettings.chromeDriver)) {
                System.out.println("Test passed!");
                testSettings.chromeDriver.close();
            }

        }catch (Exception e) {
            testSettings.screenshotBuilder.createScreenshot("RegistrationTest_WrongLogin", testSettings.chromeDriver);
            System.out.println(e);
            testSettings.chromeDriver.close();
        }
    }

    @Test// more then 10 symbols
    public void RegistrationTest_HugeLogin ()throws Exception {
        TestSettings testSettings = new TestSettings();
        testSettings.runMaximizeWindow();
        try {
            testSettings.chromeDriver.get(REGISTRATION);
            waitEmailInput(testSettings.chromeWaiter);

            setUserLogin(testSettings.chromeDriver, randomUsers.setRandomFirstName() + "wrfsawdsd" );
            setUserEmail(testSettings.chromeDriver, randomUsers.setRandomEmail());
            String randomPass = randomUsers.setRandomPhoneNum();
            setUserPassword(testSettings.chromeDriver, randomPass);
            setRepeatUserPassword(testSettings.chromeDriver, randomPass);
            getCheckbox(testSettings.chromeDriver).click();
            setWallet(testSettings.chromeDriver, randomUsers.setRandomWallet());
            getConfirmButton(testSettings.chromeDriver).click();

            if (getLoginWarning(testSettings.chromeDriver)) {
                System.out.println("Test passed!");
                testSettings.chromeDriver.close();
            }

        }catch (Exception e) {
            testSettings.screenshotBuilder.createScreenshot("RegistrationTest_HugeLogin", testSettings.chromeDriver);
            System.out.println(e);
            testSettings.chromeDriver.close();
        }
    }

    @Test
    public void RegistrationTest_ExistingEmail ()throws Exception {
        TestSettings testSettings = new TestSettings();
        testSettings.runMaximizeWindow();
        try {
            testSettings.chromeDriver.get(REGISTRATION);
            waitEmailInput(testSettings.chromeWaiter);

            setUserLogin(testSettings.chromeDriver, randomUsers.setRandomFirstName());
            setUserEmail(testSettings.chromeDriver, "evgqa1220@yopmail.com");
            String randomPass = randomUsers.setRandomPhoneNum();
            setUserPassword(testSettings.chromeDriver, randomPass);
            setRepeatUserPassword(testSettings.chromeDriver, randomPass);
            getCheckbox(testSettings.chromeDriver).click();
            setWallet(testSettings.chromeDriver, randomUsers.setRandomWallet());
            getConfirmButton(testSettings.chromeDriver).click();
            waitExistingEmailWarning(testSettings.chromeWaiter);

            if (getExistingEmailWarning(testSettings.chromeDriver)) {
                System.out.println("Test passed!");
                testSettings.chromeDriver.close();
            }

        }catch (Exception e) {
            testSettings.screenshotBuilder.createScreenshot("RegistrationTest_ExistingEmail", testSettings.chromeDriver);
            System.out.println(e);
            testSettings.chromeDriver.close();
        }
    }

    @Test
    public void RegistrationTest_WrongEmail () throws Exception{
        TestSettings testSettings = new TestSettings();
        testSettings.runMaximizeWindow();
        try {
            testSettings.chromeDriver.get(REGISTRATION);
            waitEmailInput(testSettings.chromeWaiter);

        }catch (Exception e) {
            testSettings.screenshotBuilder.createScreenshot("RegistrationTest_WrongEmail", testSettings.chromeDriver);
            testSettings.chromeDriver.close();
        }
    }

    @Test
    public void RegistrationTest_EmptyEmail ()throws Exception {
        TestSettings testSettings = new TestSettings();
        testSettings.runMaximizeWindow();
        try {
            testSettings.chromeDriver.get(REGISTRATION);
            waitEmailInput(testSettings.chromeWaiter);

        }catch (Exception e) {
            testSettings.screenshotBuilder.createScreenshot("RegistrationTest_EmptyEmail", testSettings.chromeDriver);
            testSettings.chromeDriver.close();
        }
    }

    @Test //contains less then 8 symbols
    public void RegistrationTest_WrongPass ()throws Exception {
        TestSettings testSettings = new TestSettings();
        testSettings.runMaximizeWindow();
        try {
            testSettings.chromeDriver.get(REGISTRATION);
            waitEmailInput(testSettings.chromeWaiter);

        }catch (Exception e) {
            testSettings.screenshotBuilder.createScreenshot("RegistrationTest_WrongPass", testSettings.chromeDriver);
            testSettings.chromeDriver.close();
        }
    }

    @Test
    public void RegistrationTest_EmptyPass ()throws Exception {
        TestSettings testSettings = new TestSettings();
        testSettings.runMaximizeWindow();
        try {
            testSettings.chromeDriver.get(REGISTRATION);
            waitEmailInput(testSettings.chromeWaiter);

        }catch (Exception e) {
            testSettings.screenshotBuilder.createScreenshot("RegistrationTest_EmptyPass", testSettings.chromeDriver);
            testSettings.chromeDriver.close();
        }
    }

    @Test
    public void RegistrationTest_WrongRepeatPass ()throws Exception {
        TestSettings testSettings = new TestSettings();
        testSettings.runMaximizeWindow();
        try {
            testSettings.chromeDriver.get(REGISTRATION);
            waitEmailInput(testSettings.chromeWaiter);

        }catch (Exception e) {
            testSettings.screenshotBuilder.createScreenshot("RegistrationTest_WrongRepeatPass", testSettings.chromeDriver);
            testSettings.chromeDriver.close();
        }
    }

    @Test
    public void RegistrationTest_EmptyRepeatPass ()throws Exception {
        TestSettings testSettings = new TestSettings();
        testSettings.runMaximizeWindow();
        try {
            testSettings.chromeDriver.get(REGISTRATION);
            waitEmailInput(testSettings.chromeWaiter);

        }catch (Exception e) {
            testSettings.screenshotBuilder.createScreenshot("RegistrationTest_EmptyRepeatPass", testSettings.chromeDriver);
            testSettings.chromeDriver.close();
        }
    }

    @Test
    public void RegistrationTest_CheckboxMissed () throws Exception{
        TestSettings testSettings = new TestSettings();
        testSettings.runMaximizeWindow();
        try {
            testSettings.chromeDriver.get(REGISTRATION);
            waitEmailInput(testSettings.chromeWaiter);

        }catch (Exception e) {
            testSettings.screenshotBuilder.createScreenshot("RegistrationTest_CheckboxMissed", testSettings.chromeDriver);
            testSettings.chromeDriver.close();
        }
    }

    @Test
    public void RegistrationTest_WalletMissed ()throws Exception {
        TestSettings testSettings = new TestSettings();
        testSettings.runMaximizeWindow();
        try {
            testSettings.chromeDriver.get(REGISTRATION);
            waitEmailInput(testSettings.chromeWaiter);

        }catch (Exception e) {
            testSettings.screenshotBuilder.createScreenshot("RegistrationTest_WalletMissed", testSettings.chromeDriver);
            testSettings.chromeDriver.close();
        }
    }

    @Test//when checkbox selected
    public void RegistrationTest_AllFieldsMissed ()throws Exception {
        TestSettings testSettings = new TestSettings();
        testSettings.runMaximizeWindow();
        try {
            testSettings.chromeDriver.get(REGISTRATION);
            waitEmailInput(testSettings.chromeWaiter);

        }catch (Exception e) {
            testSettings.screenshotBuilder.createScreenshot("RegistrationTest_AllFieldsMissed", testSettings.chromeDriver);
            testSettings.chromeDriver.close();
        }
    }
}
