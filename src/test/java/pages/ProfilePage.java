package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
    public String betHistoryXpath = "/html/body/div[1]/div/div/section/div/div/div[1]/div[3]/div/div[1]/div";
    public String getBetHistoryCalculatedXpath = "/html/body/div[1]/div/div/section/div/div/div[2]/div[1]/button[2]";
    public String depositXpath = "/html/body/div[1]/div/div/section/div/div/div[1]/div[3]/div/div[2]/div/div";
    public String withdrawalXpath = "/html/body/div[1]/div/div/section/div/div/div[2]/div[1]/button[2]";
    public String paymentHistoryXpath = "/html/body/div[1]/div/div/section/div/div/div[1]/div[3]/div/div[3]/div/div";
    public String getPaymentHistoryWithdrawalXpath = "/html/body/div[1]/div/div/section/div/div/div[2]/div[1]/button[2]";
    public String settingsXpath = "/html/body/div[1]/div/div/section/div/div/div[1]/div[3]/div/div[4]/div";
    public String resetPasswordButton = "/html/body/div[1]/div/div/section/div/div/div[2]/div/div[2]/div/div[5]/a";

    // get element
    public void getElementXpath (ChromeDriver driver, String element) {
        driver.findElement(By.xpath(element));
    }

    //waiter
    public void waitClickableXpath(WebDriverWait wait, String element) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(element)));
    }
    public void waitElementXpath (WebDriverWait wait, String element) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(element)));
    }

}
