package tests;

import org.junit.Test;
import pages.RegistrationPage;
import support.*;


public class RegistrationTest extends RegistrationPage implements Domains {
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
            getElementXpath(testSettings.chromeDriver, checkbox).click();
            setElementDropdown(testSettings.chromeDriver, walletDropdownId, walletNumberTag, 2);
            getElementXpath(testSettings.chromeDriver, confirmButton).click();
            waitElementXpath(testSettings.chromeWaiter, successPage);

            if(getElementXpath(testSettings.chromeDriver, successPage).isDisplayed()) {
                System.out.println("Positive test passed!");
            } else  {
                System.out.println("Positive test failed");
                testSettings.screenshotBuilder.createScreenshot("RegistrationTest_Positive", testSettings.chromeDriver);
            }
            testSettings.chromeDriver.close();
        } catch (Exception e) {
            testSettings.runErrorCatch(testSettings.chromeDriver, "RegistrationTest_Positive", e);
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
            getElementXpath(testSettings.chromeDriver, checkbox).click();
            setElementDropdown(testSettings.chromeDriver, walletDropdownId, walletNumberTag, 2);
            getElementXpath(testSettings.chromeDriver, confirmButton).click();
            waitElementXpath(testSettings.chromeWaiter, loginWarning);
            if(getElementXpath(testSettings.chromeDriver, loginWarning).isDisplayed()) {
                System.out.println("RegistrationTest_WrongLogin passed!");
            } else  {
                System.out.println("RegistrationTest_WrongLogin failed");
                testSettings.screenshotBuilder.createScreenshot("RegistrationTest_WrongLogin", testSettings.chromeDriver);
            }
            testSettings.chromeDriver.close();
        }catch (Exception e) {
            testSettings.runErrorCatch(testSettings.chromeDriver, "RegistrationTest_WrongLogin", e);
        }
    }
    @Test// more then 32 symbols
    public void RegistrationTest_HugeLogin ()throws Exception {
        TestSettings testSettings = new TestSettings();
        testSettings.runMaximizeWindow();
        try {
            testSettings.chromeDriver.get(REGISTRATION);
            waitElementId(testSettings.chromeWaiter, loginId);

            setElementById(testSettings.chromeDriver, loginId, "qfjgitosngsdkfuthfjsnfhfysjrnshfns");
            setElementById(testSettings.chromeDriver, emailId, randomUsers.setRandomEmail());
            String randomPass = randomUsers.setRandomPhoneNum();
            setElementById(testSettings.chromeDriver, passwordId, randomPass);
            setElementById(testSettings.chromeDriver, repeatPasswordId, randomPass);
            getElementXpath(testSettings.chromeDriver, checkbox).click();
            setElementDropdown(testSettings.chromeDriver, walletDropdownId, walletNumberTag, 2);
            getElementXpath(testSettings.chromeDriver, confirmButton).click();
            waitElementXpath(testSettings.chromeWaiter, loginWarning);
            if(getElementXpath(testSettings.chromeDriver, loginWarning).isDisplayed()) {
                System.out.println("RegistrationTest_HugeLogin passed!");
            } else  {
                System.out.println("RegistrationTest_HugeLogin failed");
                testSettings.screenshotBuilder.createScreenshot("RegistrationTest_HugeLogin", testSettings.chromeDriver);
            }
            testSettings.chromeDriver.close();
        }catch (Exception e) {
            testSettings.runErrorCatch(testSettings.chromeDriver, "RegistrationTest_HugeLogin", e);
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
            setElementById(testSettings.chromeDriver, emailId, "evgqa66@yopmail.com");
            String randomPass = randomUsers.setRandomPhoneNum();
            setElementById(testSettings.chromeDriver, passwordId, randomPass);
            setElementById(testSettings.chromeDriver, repeatPasswordId, randomPass);
            getElementXpath(testSettings.chromeDriver, checkbox).click();
            setElementDropdown(testSettings.chromeDriver, walletDropdownId, walletNumberTag, 2);
            getElementXpath(testSettings.chromeDriver, confirmButton).click();
            waitElementXpath(testSettings.chromeWaiter, emailWarning);

            if(getElementXpath(testSettings.chromeDriver, emailWarning).isDisplayed()) {
                System.out.println("RegistrationTest_ExistingEmail passed!");
            } else  {
                System.out.println("RegistrationTest_ExistingEmail failed");
                testSettings.screenshotBuilder.createScreenshot("RegistrationTest_ExistingEmail", testSettings.chromeDriver);
            }
            testSettings.chromeDriver.close();
        }catch (Exception e) {
            testSettings.runErrorCatch(testSettings.chromeDriver, "RegistrationTest_ExistingEmail", e);
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
            getElementXpath(testSettings.chromeDriver, checkbox).click();
            setElementDropdown(testSettings.chromeDriver, walletDropdownId, walletNumberTag, 2);
            getElementXpath(testSettings.chromeDriver, confirmButton).click();
            waitElementXpath(testSettings.chromeWaiter, emailWarning);
            if(getElementXpath(testSettings.chromeDriver, emailWarning).isDisplayed()) {
                System.out.println("RegistrationTest_WrongEmail passed!");
            } else  {
                System.out.println("RegistrationTest_WrongEmail failed");
                testSettings.screenshotBuilder.createScreenshot("RegistrationTest_WrongEmail", testSettings.chromeDriver);
            }
            testSettings.chromeDriver.close();
        }catch (Exception e) {
            testSettings.runErrorCatch(testSettings.chromeDriver, "RegistrationTest_WrongEmail", e);
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
            getElementXpath(testSettings.chromeDriver, checkbox).click();
            setElementDropdown(testSettings.chromeDriver, walletDropdownId, walletNumberTag, 2);
            getElementXpath(testSettings.chromeDriver, confirmButton).click();
            waitElementXpath(testSettings.chromeWaiter, emailWarning);
            if(getElementXpath(testSettings.chromeDriver, emailWarning).isDisplayed()) {
                System.out.println("RegistrationTest_WrongEmail passed!");
            } else  {
                System.out.println("RegistrationTest_WrongEmail failed");
                testSettings.screenshotBuilder.createScreenshot("RegistrationTest_WrongEmail", testSettings.chromeDriver);
            }
            testSettings.chromeDriver.close();
        }catch (Exception e) {
            testSettings.runErrorCatch(testSettings.chromeDriver, "RegistrationTest_EmptyEmail", e);
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
            getElementXpath(testSettings.chromeDriver, checkbox).click();
            setElementDropdown(testSettings.chromeDriver, walletDropdownId, walletNumberTag, 2);
            getElementXpath(testSettings.chromeDriver, confirmButton).click();
            waitElementXpath(testSettings.chromeWaiter, passwordWarning);
            if(getElementXpath(testSettings.chromeDriver, passwordWarning).isDisplayed()) {
                System.out.println("RegistrationTest_WrongPass passed!");
            } else  {
                System.out.println("RegistrationTest_WrongPass failed");
                testSettings.screenshotBuilder.createScreenshot("RegistrationTest_WrongPass", testSettings.chromeDriver);
            }
            testSettings.chromeDriver.close();
        }catch (Exception e) {
            testSettings.runErrorCatch(testSettings.chromeDriver, "RegistrationTest_WrongPass", e);
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
            getElementXpath(testSettings.chromeDriver, checkbox).click();
            setElementDropdown(testSettings.chromeDriver, walletDropdownId, walletNumberTag, 2);
            getElementXpath(testSettings.chromeDriver, confirmButton).click();
            waitElementXpath(testSettings.chromeWaiter, passwordWarning);
            if(getElementXpath(testSettings.chromeDriver, passwordWarning).isDisplayed()) {
                System.out.println("RegistrationTest_WrongPass passed!");
            } else  {
                System.out.println("RegistrationTest_WrongPass failed");
                testSettings.screenshotBuilder.createScreenshot("RegistrationTest_WrongPass", testSettings.chromeDriver);
            }
            testSettings.chromeDriver.close();
        }catch (Exception e) {
            testSettings.runErrorCatch(testSettings.chromeDriver, "RegistrationTest_EmptyPass", e);
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
            getElementXpath(testSettings.chromeDriver, checkbox).click();
            setElementDropdown(testSettings.chromeDriver, walletDropdownId, walletNumberTag, 2);
            getElementXpath(testSettings.chromeDriver, confirmButton).click();
            waitElementXpath(testSettings.chromeWaiter, repeatPasswordWarning);

            if(getElementXpath(testSettings.chromeDriver, repeatPasswordWarning).isDisplayed()) {
                System.out.println("RegistrationTest_WrongRepeatPass passed!");
            } else  {
                System.out.println("RegistrationTest_WrongRepeatPass failed");
                testSettings.screenshotBuilder.createScreenshot("RegistrationTest_WrongRepeatPass", testSettings.chromeDriver);
            }
            testSettings.chromeDriver.close();
        }catch (Exception e) {
            testSettings.runErrorCatch(testSettings.chromeDriver, "RegistrationTest_WrongRepeatPass", e);
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
            getElementXpath(testSettings.chromeDriver, checkbox).click();
            setElementDropdown(testSettings.chromeDriver, walletDropdownId, walletNumberTag, 2);
            getElementXpath(testSettings.chromeDriver, confirmButton).click();
            waitElementXpath(testSettings.chromeWaiter, repeatPasswordWarning);
            if(getElementXpath(testSettings.chromeDriver, repeatPasswordWarning).isDisplayed()) {
                System.out.println("RegistrationTest_EmptyRepeatPass passed!");
            } else  {
                System.out.println("RegistrationTest_EmptyRepeatPass failed");
                testSettings.screenshotBuilder.createScreenshot("RegistrationTest_EmptyRepeatPass", testSettings.chromeDriver);
            }
            testSettings.chromeDriver.close();
        }catch (Exception e) {
            testSettings.runErrorCatch(testSettings.chromeDriver, "RegistrationTest_EmptyRepeatPass", e);
        }
    }
    @Test
    public void RegistrationTest_CheckboxMissed () throws Exception{
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
            setElementDropdown(testSettings.chromeDriver, walletDropdownId, walletNumberTag, 2);
            getElementXpath(testSettings.chromeDriver, confirmButton).click();

            if(!isClickable(testSettings.chromeWaiter, confirmButton)) {
                System.out.println("RegistrationTest_CheckboxMissed passed!");
            } else {
                System.out.println("RegistrationTest_CheckboxMissed failed!");
                testSettings.screenshotBuilder.createScreenshot("RegistrationTest_CheckboxMissed", testSettings.chromeDriver);
            }
            testSettings.chromeDriver.close();
        }catch (Exception e) {
            testSettings.runErrorCatch(testSettings.chromeDriver, "RegistrationTest_CheckboxMissed", e);
        }
    }
//    @Test // need to finish
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
//            testSettings.runErrorCatch(testSettings.chromeDriver, "RegistrationTest_WalletMissed", e);
//        }
//    }
    @Test
    public void RegistrationTest_AllFieldsMissed ()throws Exception {
        TestSettings testSettings = new TestSettings();
        testSettings.runMaximizeWindow();
        try {
            testSettings.chromeDriver.get(REGISTRATION);
            waitElementId(testSettings.chromeWaiter, loginId);
            getElementXpath(testSettings.chromeDriver, checkbox).click();
            getElementXpath(testSettings.chromeDriver, confirmButton).click();
            waitElementXpath(testSettings.chromeWaiter, emailWarning);
            if  (     getElementXpath(testSettings.chromeDriver, emailWarning).isDisplayed() &&
                      getElementXpath(testSettings.chromeDriver, passwordWarning).isDisplayed()
                )
            {
                System.out.println("RegistrationTest_AllFieldsMissed passed!");
            } else  {
                System.out.println("RegistrationTest_AllFieldsMissed failed");
                testSettings.screenshotBuilder.createScreenshot("RegistrationTest_AllFieldsMissed", testSettings.chromeDriver);
            }
            testSettings.chromeDriver.close();
        }catch (Exception e) {
            testSettings.runErrorCatch(testSettings.chromeDriver, "RegistrationTest_AllFieldsMissed", e);
        }
    }
}
