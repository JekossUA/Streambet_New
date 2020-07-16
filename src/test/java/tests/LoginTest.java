package tests;

import org.junit.Test;
import pages.LoginPage;
import support.*;

public class LoginTest extends LoginPage implements Domains {

    @Test
    public void LoginTest_Positive() throws Exception  {
        TestSettings testSettings = new TestSettings();
        testSettings.runMaximizeWindow();
        try {
            testSettings.chromeDriver.get(LOGIN);
            waitElementXpath(testSettings.chromeWaiter, confirmButton);
            setElementById(testSettings.chromeDriver, loginId, "evgqa66@yopmail.com");
            setElementById(testSettings.chromeDriver, passwordId, "12345678");
            getElementXpath(testSettings.chromeDriver, confirmButton).click();
            waitElementXpath(testSettings.chromeWaiter, footer);
            String token = testSettings.chromeDriver.getLocalStorage().getItem("token");
            if (token != null) {
                System.out.println("LoginTest_Positive passed");
                System.out.println(token);
            } else  {
                System.out.println("LoginTest_Positive failed");
                testSettings.screenshotBuilder.createScreenshot("LoginTest_Positive", testSettings.chromeDriver);
            }
            testSettings.chromeDriver.close();
        } catch (Exception e){
            testSettings.runErrorCatch(testSettings.chromeDriver, "LoginTest_Positive", e);
        }
    }
    @Test
    public void LoginTest_Negative_EmptyLogin() throws Exception {
        TestSettings testSettings = new TestSettings();
        testSettings.runMaximizeWindow();
        try {
            testSettings.chromeDriver.get(LOGIN);
            waitElementXpath(testSettings.chromeWaiter, confirmButton);
            setElementById(testSettings.chromeDriver, passwordId, "12345678");
            getElementXpath(testSettings.chromeDriver, confirmButton).click();
            waitElementXpath(testSettings.chromeWaiter, emailWarning);
            if (getElementXpath(testSettings.chromeDriver, emailWarning).isDisplayed()) {
                System.out.println("LoginTest_Negative_EmptyLogin passed");
            } else  {
                System.out.println("LoginTest_Negative_EmptyLogin failed");
                testSettings.screenshotBuilder.createScreenshot("LoginTest_Negative_EmptyLogin", testSettings.chromeDriver);
            }
            testSettings.chromeDriver.close();
        }catch (Exception e){
            testSettings.runErrorCatch(testSettings.chromeDriver, "LoginTest_Negative_EmptyLogin", e);
        }

    }
    @Test
    public void LoginTest_Negative_EmptyPassword() throws Exception {
        TestSettings testSettings = new TestSettings();
        testSettings.runMaximizeWindow();
        try {
            testSettings.chromeDriver.get(LOGIN);
            waitElementXpath(testSettings.chromeWaiter, confirmButton);
            setElementById(testSettings.chromeDriver, loginId, "evgqa1220@yopmail.com");
            getElementXpath(testSettings.chromeDriver, confirmButton).click();
            waitElementXpath(testSettings.chromeWaiter, passwordWarning);
            if (getElementXpath(testSettings.chromeDriver, passwordWarning).isDisplayed()) {
                System.out.println("LoginTest_Negative_EmptyPassword passed");
            } else  {
                System.out.println("LoginTest_Negative_EmptyPassword failed");
                testSettings.screenshotBuilder.createScreenshot("LoginTest_Negative_EmptyPassword", testSettings.chromeDriver);
            }
            testSettings.chromeDriver.close();
        } catch (Exception e){
            testSettings.runErrorCatch(testSettings.chromeDriver, "LoginTest_Negative_EmptyPassword", e);
        }
    }
    @Test
    public void LoginTest_Negative_EmptyFields() throws Exception {
        TestSettings testSettings = new TestSettings();
        testSettings.runMaximizeWindow();
        try {
            testSettings.chromeDriver.get(LOGIN);
            waitElementXpath(testSettings.chromeWaiter, confirmButton);
            getElementXpath(testSettings.chromeDriver, confirmButton).click();
            waitElementXpath(testSettings.chromeWaiter, emailWarning);
            waitElementXpath(testSettings.chromeWaiter, passwordWarning);
            if
            (       getElementXpath(testSettings.chromeDriver, emailWarning).isDisplayed() &&
                    getElementXpath(testSettings.chromeDriver, passwordWarning).isDisplayed())
            {
                System.out.println("LoginTest_Negative_EmptyFields passed");
            } else  {
                System.out.println("LoginTest_Negative_EmptyFields failed");
                testSettings.screenshotBuilder.createScreenshot("LoginTest_Negative_EmptyFields", testSettings.chromeDriver);
            }
            testSettings.chromeDriver.close();
        }catch (Exception e){
            testSettings.runErrorCatch(testSettings.chromeDriver, "LoginTest_Negative_EmptyFields", e);
        }
    }
    @Test
    public void LoginTest_Negative_WrongLogin() throws Exception {
        TestSettings testSettings = new TestSettings();
        testSettings.runMaximizeWindow();
        try {
            testSettings.chromeDriver.get(LOGIN);
            waitElementXpath(testSettings.chromeWaiter, confirmButton);
            setElementById(testSettings.chromeDriver, loginId, "evgaddadaqa1220@yopmail.com");
            setElementById(testSettings.chromeDriver, passwordId, "12345678");
            getElementXpath(testSettings.chromeDriver, confirmButton).click();
            waitElementXpath(testSettings.chromeWaiter, emailWarning);
            if (getElementXpath(testSettings.chromeDriver, emailWarning).isDisplayed()) {
                System.out.println("LoginTest_Negative_WrongLogin passed");
            } else  {
                System.out.println("LoginTest_Negative_WrongLogin failed");
                testSettings.screenshotBuilder.createScreenshot("LoginTest_Negative_WrongLogin", testSettings.chromeDriver);
            }
            testSettings.chromeDriver.close();
        }catch (Exception e){
            testSettings.runErrorCatch(testSettings.chromeDriver, "LoginTest_Negative_WrongLogin", e);
        }
    }
    @Test
    public void LoginTest_Negative_WrongPassword() throws Exception {
        TestSettings testSettings = new TestSettings();
        testSettings.runMaximizeWindow();
        try{
            testSettings.chromeDriver.get(LOGIN);
            waitElementXpath(testSettings.chromeWaiter, confirmButton);
            setElementById(testSettings.chromeDriver, loginId, "evgqa1220@yopmail.com");
            setElementById(testSettings.chromeDriver, passwordId, "123446445678");
            getElementXpath(testSettings.chromeDriver, confirmButton).click();
            waitElementXpath(testSettings.chromeWaiter, passwordWarning);
            if (getElementXpath(testSettings.chromeDriver, passwordWarning).isDisplayed()) {
                System.out.println("LoginTest_Negative_WrongPassword passed");
            } else  {
                System.out.println("LoginTest_Negative_WrongPassword failed");
                testSettings.screenshotBuilder.createScreenshot("LoginTest_Negative_WrongPassword", testSettings.chromeDriver);
            }
            testSettings.chromeDriver.close();
        } catch (Exception e){
            testSettings.runErrorCatch(testSettings.chromeDriver, "LoginTest_Negative_WrongPassword", e);
        }
    }
}
