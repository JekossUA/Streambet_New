package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import support.Domain;
import static tests.ChromeDriverBuild.*;

public class LoginTest extends LoginPage implements Domain {
    @Test
    public void LoginTest_Positive()  {
        ChromeDriver chromeDriver = chromeDriver ();
        WebDriverWait chromeWaiter = new WebDriverWait(chromeDriver, 10);

        try {
            chromeDriver.get(LOGIN);
            chromeWaiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("loginId")));

            getLoginInput(chromeDriver, "evgqa1220@yopmail.com");
            getPasswordInput(chromeDriver, "12345678");
            getAuthorizationButton(chromeDriver).click();
            getFooter(chromeWaiter);
            String token = chromeDriver.getLocalStorage().getItem("token");
            if (token != null) {
                System.out.println("Login passed");
            } else {
                System.out.println("Login failed");
            }
        } finally {
            chromeDriver.close();
        }

    }

    @Test
    public void LoginTest_Negative_EmptyLogin() {
        ChromeDriver chromeDriver = chromeDriver ();
        WebDriverWait chromeWaiter = new WebDriverWait(chromeDriver, 10);
        try {
            chromeDriver.get(LOGIN);
            chromeWaiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("loginId")));

            getLoginInput(chromeDriver, "");
            getPasswordInput(chromeDriver, "12345678");
            getAuthorizationButton(chromeDriver).click();
            getWarningTextWaiter(chromeWaiter);
            String warningText = getWarningEmail(chromeDriver).getText();
            if (warningText !=null) {
                System.out.println("Empty login passed");
            } else {
                System.out.println("Empty login failed");
            }
        }finally {
            chromeDriver.close();
        }


    }
    @Test
    public void LoginTest_Negative_EmptyPassword() {
        ChromeDriver chromeDriver = chromeDriver ();
        WebDriverWait chromeWaiter = new WebDriverWait(chromeDriver, 10);
        try {
            chromeDriver.get(LOGIN);
            chromeWaiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("loginId")));

            getLoginInput(chromeDriver, "evgqa1220@yopmail.com");
            getPasswordInput(chromeDriver, "");
            getAuthorizationButton(chromeDriver).click();
            chromeWaiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#__next > div > div > section" +
                    " > div > section > div.OverlayForms_overlay-form__3Wo8U > div.OverlayForms_overlay-form__wrapper__s9rus > div:nth-child(2) > div > div")));
            chromeDriver.findElement(By.cssSelector("#__next > div > div > section > div > section > div.OverlayForms_overlay-form__3Wo8U " +
                    "> div.OverlayForms_overlay-form__wrapper__s9rus > div:nth-child(2) > div > div"));

            System.out.println("Empty password passed");

        } finally {
            chromeDriver.close();
        }
    }
    @Test
    public void LoginTest_Negative_EmptyFields() {
        ChromeDriver chromeDriver = chromeDriver ();
        WebDriverWait chromeWaiter = new WebDriverWait(chromeDriver, 10);
        try {
            chromeDriver.get(LOGIN);
            chromeWaiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("loginId")));

            getAuthorizationButton(chromeDriver).click();
            chromeWaiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#__next > div > div > section > " +
                    "div > section > div.OverlayForms_overlay-form__3Wo8U " +
                    "> div.OverlayForms_overlay-form__wrapper__s9rus > div:nth-child(1) > div > div")));
            chromeDriver.findElement(By.cssSelector("#__next > div > div > section > div > section > div.OverlayForms_overlay-form__3Wo8U " +
                    "> div.OverlayForms_overlay-form__wrapper__s9rus > div:nth-child(1) > div > div"));

            chromeDriver.close();
            System.out.println("Empty fields passed");
        }finally {
            chromeDriver.close();
        }


    }
    @Test
    public void LoginTest_Negative_WrongLogin() {
        ChromeDriver chromeDriver = chromeDriver ();
        WebDriverWait chromeWaiter = new WebDriverWait(chromeDriver, 10);
        try {
            chromeDriver.get(LOGIN);
            chromeWaiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("loginId")));

            getLoginInput(chromeDriver, "evgqa12dqwqdq20@yopmail.com");
            getPasswordInput(chromeDriver, "12345678");
            getAuthorizationButton(chromeDriver).click();
            chromeWaiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#__next > div > div > section > " +
                    "div > section > div.OverlayForms_overlay-form__3Wo8U " +
                    "> div.OverlayForms_overlay-form__wrapper__s9rus > div:nth-child(1) > div > div")));
            chromeDriver.findElement(By.cssSelector("#__next > div > div > section > div > section > div.OverlayForms_overlay-form__3Wo8U " +
                    "> div.OverlayForms_overlay-form__wrapper__s9rus > div:nth-child(1) > div > div"));

            System.out.println("Wrong login passed");
        }finally {
            chromeDriver.close();
        }

    }
    @Test
    public void LoginTest_Negative_WrongPassword() {
        ChromeDriver chromeDriver = chromeDriver ();
        WebDriverWait chromeWaiter = new WebDriverWait(chromeDriver, 10);
        try{
            chromeDriver.get(LOGIN);
            chromeWaiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("loginId")));

            getLoginInput(chromeDriver, "evgqa1220@yopmail.com");
            getPasswordInput(chromeDriver, "123456efw78");
            getAuthorizationButton(chromeDriver).click();
            chromeWaiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#__next > div > div > section > " +
                    "div > section > div.OverlayForms_overlay-form__3Wo8U " +
                    "> div.OverlayForms_overlay-form__wrapper__s9rus > div:nth-child(1) > div > div")));
            chromeDriver.findElement(By.cssSelector("#__next > div > div > section > div > section > div.OverlayForms_overlay-form__3Wo8U " +
                    "> div.OverlayForms_overlay-form__wrapper__s9rus > div:nth-child(1) > div > div"));

            System.out.println("Wrong password passed");
        } finally {
            chromeDriver.close();
        }


    }
}
