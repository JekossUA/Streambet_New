package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.LoginPage;
import support.*;



public class LoginTest extends LoginPage implements Domain {

    @Test
    public void LoginTest_Positive() throws Exception  {
        TestSettings testSettings = new TestSettings();
        testSettings.runMaximizeWindow();
        try {
            testSettings.chromeDriver.get(LOGIN);
            testSettings.chromeWaiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("loginId")));

            setLogin(testSettings.chromeDriver, "evgqa1220@yopmail.com");
            setPassword(testSettings.chromeDriver, "12345678");
            getAuthorizationButton(testSettings.chromeDriver).click();
            waitFooter(testSettings.chromeWaiter);
            String token = testSettings.chromeDriver.getLocalStorage().getItem("token");
            if (token != null) {
                System.out.println("Login passed");
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
            testSettings.chromeWaiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("loginId")));

            setLogin(testSettings.chromeDriver, "");
            setPassword(testSettings.chromeDriver, "12345678");
            getAuthorizationButton(testSettings.chromeDriver).click();
            getWarningEmailWaiter(testSettings.chromeWaiter);
            String warningText = getWarningEmail(testSettings.chromeDriver).getText();
            if (warningText !=null) {
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
            testSettings.chromeWaiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("loginId")));

            setLogin(testSettings.chromeDriver, "evgqa1220@yopmail.com");
            setPassword(testSettings.chromeDriver, "");
            getAuthorizationButton(testSettings.chromeDriver).click();
            getWarningPasswordWaiter(testSettings.chromeWaiter);
            String waringText = getWarningPassword(testSettings.chromeDriver).getText();

            if (waringText !=null) {
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
            testSettings.chromeWaiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("loginId")));
            getAuthorizationButton(testSettings.chromeDriver).click();
            getWarningEmailWaiter(testSettings.chromeWaiter);
            getWarningPasswordWaiter(testSettings.chromeWaiter);
            String emailWarningText = getWarningEmail(testSettings.chromeDriver).getText();
            String passwordWarningText = getWarningPassword(testSettings.chromeDriver).getText();

            if(emailWarningText !=null && passwordWarningText !=null) {
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
            testSettings.chromeWaiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("loginId")));

            setLogin(testSettings.chromeDriver, "evgqa12dqwqdq20@yopmail.com");
            setPassword(testSettings.chromeDriver, "12345678");
            getAuthorizationButton(testSettings.chromeDriver).click();
            getWarningEmailWaiter(testSettings.chromeWaiter);
            String warningText = getWarningEmail(testSettings.chromeDriver).getText();
            if (warningText !=null) {
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
            testSettings.chromeWaiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("loginId")));

            setLogin(testSettings.chromeDriver, "evgqa1220@yopmail.com");
            setPassword(testSettings.chromeDriver, "123456efw78");
            getAuthorizationButton(testSettings.chromeDriver).click();
            getWarningPasswordWaiter(testSettings.chromeWaiter);
            String waringText = getWarningPassword(testSettings.chromeDriver).getText();

            if (waringText !=null) {
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
