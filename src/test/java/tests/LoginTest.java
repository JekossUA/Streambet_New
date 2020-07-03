package tests;

import org.junit.Test;
import pages.LoginPage;
import support.*;



public class LoginTest extends LoginPage implements Domain {


    @Test
    public void LoginTest_Positive() throws Exception  {
        TestSettings testSettings = new TestSettings();
        testSettings.runMaximizeWindow();
        try {
            testSettings.chromeDriver.get(LOGIN);
            waitElement(testSettings.chromeWaiter, emailId);

            setElementById(testSettings.chromeDriver, emailId, "evgqa1220@yopmail.com");
            setElementById(testSettings.chromeDriver, passwordId, "12345678");
            getElement(testSettings.chromeDriver, confirmButton).click();
            waitElement(testSettings.chromeWaiter, footer);
            String token = testSettings.chromeDriver.getLocalStorage().getItem("token");
            if (token != null) {
                System.out.println("Login passed");
                System.out.println(token);
                testSettings.chromeDriver.close();
            }
        } catch (Exception e){
            testSettings.screenshotBuilder.createScreenshot("LoginTest_Positive", testSettings.chromeDriver);
            System.out.println(e);
            testSettings.chromeDriver.close();
        }
    }

    @Test
    public void LoginTest_Negative_EmptyLogin() throws Exception {
        TestSettings testSettings = new TestSettings();
        testSettings.runMaximizeWindow();
        try {
            testSettings.chromeDriver.get(LOGIN);
            waitElement(testSettings.chromeWaiter, emailId);

            setElementById(testSettings.chromeDriver, passwordId, "12345678");
            getElement(testSettings.chromeDriver, confirmButton).click();
            waitElement(testSettings.chromeWaiter, emailWarning);
            if (getElement(testSettings.chromeDriver, emailWarning).isDisplayed()) {
                System.out.println("Empty login passed");
                testSettings.chromeDriver.close();
            }
        }catch (Exception e){
            testSettings.screenshotBuilder.createScreenshot("LoginTest_Negative_EmptyLogin", testSettings.chromeDriver);
            System.out.println(e);
            testSettings.chromeDriver.close();
        }

    }
    @Test
    public void LoginTest_Negative_EmptyPassword() throws Exception {
        TestSettings testSettings = new TestSettings();
        testSettings.runMaximizeWindow();
        try {
            testSettings.chromeDriver.get(LOGIN);
            waitElement(testSettings.chromeWaiter, passwordId);

            setElementById(testSettings.chromeDriver, emailId, "evgqa1220@yopmail.com");
            getElement(testSettings.chromeDriver, confirmButton).click();
            waitElement(testSettings.chromeWaiter, passwordWarning);
            if (getElement(testSettings.chromeDriver, passwordWarning).isDisplayed()) {
                System.out.println("Empty password passed");
                testSettings.chromeDriver.close();
            }

        } catch (Exception e){
            testSettings.screenshotBuilder.createScreenshot("LoginTest_Negative_EmptyPassword", testSettings.chromeDriver);
            System.out.println(e);
            testSettings.chromeDriver.close();
        }
    }
    @Test
    public void LoginTest_Negative_EmptyFields() throws Exception {
        TestSettings testSettings = new TestSettings();
        testSettings.runMaximizeWindow();
        try {
            testSettings.chromeDriver.get(LOGIN);
            waitElement(testSettings.chromeWaiter, passwordId);

            getElement(testSettings.chromeDriver, confirmButton).click();
            waitElement(testSettings.chromeWaiter, emailWarning);
            waitElement(testSettings.chromeWaiter, passwordWarning);
            if
            (       getElement(testSettings.chromeDriver, emailWarning).isDisplayed() &&
                    getElement(testSettings.chromeDriver, passwordWarning).isDisplayed())
            {
                System.out.println("Empty fields passed");
                testSettings.chromeDriver.close();
            }
        }catch (Exception e){
            testSettings.screenshotBuilder.createScreenshot("LoginTest_Negative_EmptyFields", testSettings.chromeDriver);
            System.out.println(e);
            testSettings.chromeDriver.close();
        }
    }
    @Test
    public void LoginTest_Negative_WrongLogin() throws Exception {
        TestSettings testSettings = new TestSettings();
        testSettings.runMaximizeWindow();
        try {
            testSettings.chromeDriver.get(LOGIN);
            waitElement(testSettings.chromeWaiter, emailId);

            setElementById(testSettings.chromeDriver, emailId, "evgaddadaqa1220@yopmail.com");
            setElementById(testSettings.chromeDriver, passwordId, "12345678");
            getElement(testSettings.chromeDriver, confirmButton).click();
            waitElement(testSettings.chromeWaiter, emailWarning);
            if (getElement(testSettings.chromeDriver, emailWarning).isDisplayed()) {
                System.out.println("Wrong login passed");
                testSettings.chromeDriver.close();
            }
        }catch (Exception e){
            testSettings.screenshotBuilder.createScreenshot("LoginTest_Negative_WrongLogin", testSettings.chromeDriver);
            System.out.println(e);
            testSettings.chromeDriver.close();
        }
    }
    @Test
    public void LoginTest_Negative_WrongPassword() throws Exception {
        TestSettings testSettings = new TestSettings();
        testSettings.runMaximizeWindow();
        try{
            testSettings.chromeDriver.get(LOGIN);
            waitElement(testSettings.chromeWaiter, passwordId);

            setElementById(testSettings.chromeDriver, emailId, "evgqa1220@yopmail.com");
            setElementById(testSettings.chromeDriver, passwordId, "123446445678");
            getElement(testSettings.chromeDriver, confirmButton).click();
            waitElement(testSettings.chromeWaiter, passwordWarning);
            if (getElement(testSettings.chromeDriver, passwordWarning).isDisplayed()) {
                System.out.println("Wrong password passed");
                testSettings.chromeDriver.close();
            }
        } catch (Exception e){
            testSettings.screenshotBuilder.createScreenshot("LoginTest_Negative_WrongPassword", testSettings.chromeDriver);
            System.out.println(e);
            testSettings.chromeDriver.close();
        }
    }
}
