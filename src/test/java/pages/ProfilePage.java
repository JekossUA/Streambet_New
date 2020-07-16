package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
    public String betHistoryXpath = "/html/body/div[1]/div/div/section/div/div/div[1]/div[3]/div/a[1]";
    public String historyBox = "/html/body/div[1]/div/div/section/div/div/div[2]/div[2]/div";
    public String betHistoryCalculatedXpath = "/html/body/div[1]/div/div/section/div/div/div[2]/div[1]/button[2]";
    public String depositXpath = "/html/body/div[1]/div/div/section/div/div/div[1]/div[3]/div/a[2]";
    public String withdrawalXpath = "/html/body/div[1]/div/div/section/div/div/div[2]/div[1]/button[2]";
    public String paymentHistoryXpath = "/html/body/div[1]/div/div/section/div/div/div[1]/div[3]/div/a[3]";
    public String paymentHistoryWithdrawalXpath = "/html/body/div[1]/div/div/section/div/div/div[2]/div[1]/button[2]";
    public String settingsXpath = "/html/body/div[1]/div/div/section/div/div/div[1]/div[3]/div/div[4]/div";
    public String resetPasswordButton = "/html/body/div[1]/div/div/section/div/div/div[2]/div/div[2]/div/div[5]/a";

    // get element
    public WebElement getElementXpath (ChromeDriver driver, String element) {
        return driver.findElement(By.xpath(element));
    }

    //waiter
    public void waitClickableXpath(WebDriverWait wait, String element) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(element)));
    }
    public void waitElementXpath (WebDriverWait wait, String element) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(element)));
    }

}
