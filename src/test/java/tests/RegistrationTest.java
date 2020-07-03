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
            waitElementId(testSettings.chromeWaiter, loginId);

            setElementById(testSettings.chromeDriver, loginId, randomUsers.setRandomFirstName());
            setElementById(testSettings.chromeDriver, emailId, randomUsers.setRandomEmail());
            String randomPass = randomUsers.setRandomPhoneNum();
            setElementById(testSettings.chromeDriver, passwordId, randomPass);
            setElementById(testSettings.chromeDriver, repeatPasswordId, randomPass);
            getElement(testSettings.chromeDriver, checkbox).click();
            setElementDropdown(testSettings.chromeDriver, walletDropdownId, walletNumberTag, 2);
            getElement(testSettings.chromeDriver, confirmButton).click();
            waitElementXpath(testSettings.chromeWaiter, betLineContainer);

            if(getElement(testSettings.chromeDriver, betLineContainer).isDisplayed()) {
                System.out.println("Positive test passed!");
                testSettings.chromeDriver.close();
            }

        } catch (Exception e) {
            testSettings.screenshotBuilder.createScreenshot("RegistrationTest_Positive", testSettings.chromeDriver);
            testSettings.chromeDriver.close();
            System.out.println(e);
        }
    }
    @Test //less then 3 symbols
    public void RegistrationTest_WrongLogin ()throws Exception {
        TestSettings testSettings = new TestSettings();
        testSettings.runMaximizeWindow();
        try {
            testSettings.chromeDriver.get(REGISTRATION);
            waitElementId(testSettings.chromeWaiter, loginId);

            setElementById(testSettings.chromeDriver, loginId, "q");
            setElementById(testSettings.chromeDriver, emailId, randomUsers.setRandomEmail());
            String randomPass = randomUsers.setRandomPhoneNum();
            setElementById(testSettings.chromeDriver, passwordId, randomPass);
            setElementById(testSettings.chromeDriver, repeatPasswordId, randomPass);
            getElement(testSettings.chromeDriver, checkbox).click();
            setElementDropdown(testSettings.chromeDriver, walletDropdownId, walletNumberTag, 2);
            getElement(testSettings.chromeDriver, confirmButton).click();
            waitElementXpath(testSettings.chromeWaiter, loginWarning);

            if(getElement(testSettings.chromeDriver, loginWarning).isDisplayed()) {
                System.out.println("RegistrationTest_WrongLogin passed!");
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
            waitElementId(testSettings.chromeWaiter, loginId);

            setElementById(testSettings.chromeDriver, loginId, "qfjgitosngsd");
            setElementById(testSettings.chromeDriver, emailId, randomUsers.setRandomEmail());
            String randomPass = randomUsers.setRandomPhoneNum();
            setElementById(testSettings.chromeDriver, passwordId, randomPass);
            setElementById(testSettings.chromeDriver, repeatPasswordId, randomPass);
            getElement(testSettings.chromeDriver, checkbox).click();
            setElementDropdown(testSettings.chromeDriver, walletDropdownId, walletNumberTag, 2);
            getElement(testSettings.chromeDriver, confirmButton).click();
            waitElementXpath(testSettings.chromeWaiter, loginWarning);

            if(getElement(testSettings.chromeDriver, loginWarning).isDisplayed()) {
                System.out.println("RegistrationTest_HugeLogin passed!");
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
            waitElementId(testSettings.chromeWaiter, loginId);

            setElementById(testSettings.chromeDriver, loginId, randomUsers.setRandomFirstName());
            setElementById(testSettings.chromeDriver, emailId, "evgqa1220@yopmail.com");
            String randomPass = randomUsers.setRandomPhoneNum();
            setElementById(testSettings.chromeDriver, passwordId, randomPass);
            setElementById(testSettings.chromeDriver, repeatPasswordId, randomPass);
            getElement(testSettings.chromeDriver, checkbox).click();
            setElementDropdown(testSettings.chromeDriver, walletDropdownId, walletNumberTag, 2);
            getElement(testSettings.chromeDriver, confirmButton).click();
            waitElementXpath(testSettings.chromeWaiter, emailWarning);

            if(getElement(testSettings.chromeDriver, emailWarning).isDisplayed()) {
                System.out.println("RegistrationTest_ExistingEmail passed!");
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
            waitElementId(testSettings.chromeWaiter, loginId);

            setElementById(testSettings.chromeDriver, loginId, randomUsers.setRandomFirstName());
            setElementById(testSettings.chromeDriver, emailId, "sdwd@d");
            String randomPass = randomUsers.setRandomPhoneNum();
            setElementById(testSettings.chromeDriver, passwordId, randomPass);
            setElementById(testSettings.chromeDriver, repeatPasswordId, randomPass);
            getElement(testSettings.chromeDriver, checkbox).click();
            setElementDropdown(testSettings.chromeDriver, walletDropdownId, walletNumberTag, 2);
            getElement(testSettings.chromeDriver, confirmButton).click();
            waitElementXpath(testSettings.chromeWaiter, emailWarning);

            if(getElement(testSettings.chromeDriver, emailWarning).isDisplayed()) {
                System.out.println("RegistrationTest_WrongEmail passed!");
                testSettings.chromeDriver.close();
            }

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
            waitElementId(testSettings.chromeWaiter, loginId);

            setElementById(testSettings.chromeDriver, loginId, randomUsers.setRandomFirstName());
            String randomPass = randomUsers.setRandomPhoneNum();
            setElementById(testSettings.chromeDriver, passwordId, randomPass);
            setElementById(testSettings.chromeDriver, repeatPasswordId, randomPass);
            getElement(testSettings.chromeDriver, checkbox).click();
            setElementDropdown(testSettings.chromeDriver, walletDropdownId, walletNumberTag, 2);
            getElement(testSettings.chromeDriver, confirmButton).click();
            waitElementXpath(testSettings.chromeWaiter, emailWarning);

            if(getElement(testSettings.chromeDriver, emailWarning).isDisplayed()) {
                System.out.println("RegistrationTest_WrongEmail passed!");
                testSettings.chromeDriver.close();
            }

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
            waitElementId(testSettings.chromeWaiter, loginId);

            setElementById(testSettings.chromeDriver, loginId, randomUsers.setRandomFirstName());
            setElementById(testSettings.chromeDriver, emailId, randomUsers.setRandomEmail());
            String randomPass = "1234sa";
            setElementById(testSettings.chromeDriver, passwordId, randomPass);
            setElementById(testSettings.chromeDriver, repeatPasswordId, randomPass);
            getElement(testSettings.chromeDriver, checkbox).click();
            setElementDropdown(testSettings.chromeDriver, walletDropdownId, walletNumberTag, 2);
            getElement(testSettings.chromeDriver, confirmButton).click();
            waitElementXpath(testSettings.chromeWaiter, passwordWarning);

            if(getElement(testSettings.chromeDriver, passwordWarning).isDisplayed()) {
                System.out.println("RegistrationTest_WrongPass passed!");
                testSettings.chromeDriver.close();
            }

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
            waitElementId(testSettings.chromeWaiter, loginId);

            setElementById(testSettings.chromeDriver, loginId, randomUsers.setRandomFirstName());
            setElementById(testSettings.chromeDriver, emailId, randomUsers.setRandomEmail());
            String randomPass = randomUsers.setRandomPhoneNum();
            setElementById(testSettings.chromeDriver, passwordId, "");
            setElementById(testSettings.chromeDriver, repeatPasswordId, randomPass);
            getElement(testSettings.chromeDriver, checkbox).click();
            setElementDropdown(testSettings.chromeDriver, walletDropdownId, walletNumberTag, 2);
            getElement(testSettings.chromeDriver, confirmButton).click();
            waitElementXpath(testSettings.chromeWaiter, passwordWarning);

            if(getElement(testSettings.chromeDriver, passwordWarning).isDisplayed()) {
                System.out.println("RegistrationTest_WrongPass passed!");
                testSettings.chromeDriver.close();
            }

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
            waitElementId(testSettings.chromeWaiter, loginId);

            setElementById(testSettings.chromeDriver, loginId, randomUsers.setRandomFirstName());
            setElementById(testSettings.chromeDriver, emailId, randomUsers.setRandomEmail());
            String randomPass = randomUsers.setRandomPhoneNum();
            setElementById(testSettings.chromeDriver, passwordId, randomPass);
            setElementById(testSettings.chromeDriver, repeatPasswordId, "123123");
            getElement(testSettings.chromeDriver, checkbox).click();
            setElementDropdown(testSettings.chromeDriver, walletDropdownId, walletNumberTag, 2);
            getElement(testSettings.chromeDriver, confirmButton).click();
            waitElementXpath(testSettings.chromeWaiter, repeatPasswordWarning);

            if(getElement(testSettings.chromeDriver, repeatPasswordWarning).isDisplayed()) {
                System.out.println("RegistrationTest_WrongRepeatPass passed!");
                testSettings.chromeDriver.close();
            }

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
            waitElementId(testSettings.chromeWaiter, loginId);

            setElementById(testSettings.chromeDriver, loginId, randomUsers.setRandomFirstName());
            setElementById(testSettings.chromeDriver, emailId, randomUsers.setRandomEmail());
            String randomPass = randomUsers.setRandomPhoneNum();
            setElementById(testSettings.chromeDriver, passwordId, randomPass);
            setElementById(testSettings.chromeDriver, repeatPasswordId, "");
            getElement(testSettings.chromeDriver, checkbox).click();
            setElementDropdown(testSettings.chromeDriver, walletDropdownId, walletNumberTag, 2);
            getElement(testSettings.chromeDriver, confirmButton).click();
            waitElementXpath(testSettings.chromeWaiter, repeatPasswordWarning);

            if(getElement(testSettings.chromeDriver, repeatPasswordWarning).isDisplayed()) {
                System.out.println("RegistrationTest_EmptyRepeatPass passed!");
                testSettings.chromeDriver.close();
            }

        }catch (Exception e) {
            testSettings.screenshotBuilder.createScreenshot("RegistrationTest_EmptyRepeatPass", testSettings.chromeDriver);
            testSettings.chromeDriver.close();
        }
    }

//    @Test
//    public void RegistrationTest_CheckboxMissed () throws Exception{
//        TestSettings testSettings = new TestSettings();
//        testSettings.runMaximizeWindow();
//        try {
//            testSettings.chromeDriver.get(REGISTRATION);
//            waitElementId(testSettings.chromeWaiter, loginId);
//
//            setElementById(testSettings.chromeDriver, loginId, randomUsers.setRandomFirstName());
//            setElementById(testSettings.chromeDriver, emailId, randomUsers.setRandomEmail());
//            String randomPass = randomUsers.setRandomPhoneNum();
//            setElementById(testSettings.chromeDriver, passwordId, randomPass);
//            setElementById(testSettings.chromeDriver, repeatPasswordId, randomPass);
////            getElement(testSettings.chromeDriver, checkbox).click();
//            setElementDropdown(testSettings.chromeDriver, walletDropdownId, walletNumberTag, 2);
////            getElement(testSettings.chromeDriver, confirmButton).click();
////            waitElementXpath(testSettings.chromeWaiter, repeatPasswordWarning);
//
//            if(waitElementClickableXpath(testSettings.chromeWaiter, checkbox) == false) {
//                System.out.println("RegistrationTest_CheckboxMissed passed!");
//                testSettings.chromeDriver.close();
//            }
//
//        }catch (Exception e) {
//            testSettings.screenshotBuilder.createScreenshot("RegistrationTest_CheckboxMissed", testSettings.chromeDriver);
//            testSettings.chromeDriver.close();
//        }
//    }

//    @Test
//    public void RegistrationTest_WalletMissed ()throws Exception {
//        TestSettings testSettings = new TestSettings();
//        testSettings.runMaximizeWindow();
//        String undefined = "undefined";
//        try {
//            testSettings.chromeDriver.get(REGISTRATION);
//            waitEmailInput(testSettings.chromeWaiter);
//
//            setUserLogin(testSettings.chromeDriver, randomUsers.setRandomFirstName());
//            setUserEmail(testSettings.chromeDriver, randomUsers.setRandomEmail());
//            String randomPass = randomUsers.setRandomPhoneNum();
//            setUserPassword(testSettings.chromeDriver, randomPass);
//            setRepeatUserPassword(testSettings.chromeDriver, randomPass);
//            getCheckbox(testSettings.chromeDriver).click();
//            getConfirmButton(testSettings.chromeDriver).click();
//            String some = testSettings.chromeDriver.findElement(By.id("selectId")).getCssValue(undefined);
//            System.out.println(some);
//
//            if (some != null) {
//                testSettings.chromeDriver.close();
//                System.out.println("RegistrationTest_WalletMissed passed!");
//            }
//
//        }catch (Exception e) {
//            testSettings.screenshotBuilder.createScreenshot("RegistrationTest_WalletMissed", testSettings.chromeDriver);
//            testSettings.chromeDriver.close();
//        }
//    }

    @Test//when checkbox selected
    public void RegistrationTest_AllFieldsMissed ()throws Exception {
        TestSettings testSettings = new TestSettings();
        testSettings.runMaximizeWindow();
        try {
            testSettings.chromeDriver.get(REGISTRATION);
            waitElementId(testSettings.chromeWaiter, loginId);

            getElement(testSettings.chromeDriver, checkbox).click();
            getElement(testSettings.chromeDriver, confirmButton).click();
            waitElementXpath(testSettings.chromeWaiter, emailWarning);

            if(     getElement(testSettings.chromeDriver, emailWarning).isDisplayed() &&
                    getElement(testSettings.chromeDriver, passwordWarning).isDisplayed() &&
                    getElement(testSettings.chromeDriver, repeatPasswordWarning).isDisplayed() &&
                    getElement(testSettings.chromeDriver, walletWarning).isDisplayed())
            {
                System.out.println("RegistrationTest_AllFieldsMissed passed!");
                testSettings.chromeDriver.close();
            }

        }catch (Exception e) {
            testSettings.screenshotBuilder.createScreenshot("RegistrationTest_AllFieldsMissed", testSettings.chromeDriver);
            testSettings.chromeDriver.close();
        }
    }
}
