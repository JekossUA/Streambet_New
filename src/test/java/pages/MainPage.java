package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.PublicKey;

public class MainPage {

    public String header = "//*[@id=\"__next\"]/div/header/div";
    public String navigationButtons = "//*[@id=\"__next\"]/div/header/div/div/nav/ul/li";
    public String usersCorner = "//*[@id=\"__next\"]/div/header/div/div/div/div";
    public String gameFilters = "//*[@id=\"__next\"]/div/div/div/div/div[2]/div[1]/div[1]/div";
    public String betLineContainer = "/html/body/div[1]/div/div/div/div/div[2]/div[1]/div[2]";
    public String sideBar = "//*[@id=\"__next\"]/div/div/div/div/div[2]/div[2]";
    public String streamPage = "//*[@id=\"__next\"]/div/div";
    public String sportPageSlider = "/html/body/div[1]/div/div/div/div/div[1]/div[2]";
    public String slotsPage = "//*[@id=\"__next\"]/div/div/div/div/div/div[2]";
    public String eventsFilter = "/html/body/div[1]/div/div/div/div/div[2]/div[1]/div[2]/div[1]/div/button[1]";
    public String daysFilter = "/html/body/div[1]/div/div/div/div/div[2]/div[1]/div[2]/div[1]/div/button[2]";
    public String allGamessFilter = "/html/body/div[1]/div/div/div/div/div[2]/div[1]/div[2]/div[1]/button[1]";
    public String liveMatchesFilter = "/html/body/div[1]/div/div/div/div/div[2]/div[1]/div[2]/div[1]/button[2]";
    public String prematchFilter = "/html/body/div[1]/div/div/div/div/div[2]/div[1]/div[2]/div[1]/button[3]";
    public String totalizatorFilter = "/html/body/div[1]/div/div/div/div/div[2]/div[1]/div[2]/div[1]/button[4]";
    public String firstLiveStream = "/html/body/div[1]/div/div/div/div/div[2]/div[1]/div[2]/div[3]/div[2]";
    public String watchButton = "/html/body/div[1]/div/div/div/div/div[2]/div[1]/div[2]/div[3]/div[2]/div[1]/div[2]/a";
    public String iframeTotalizator = "/html/body/div[1]/div/div/div/div/div/div[2]/div/div[1]/iframe";
    public String iframePrematch = "/html/body/div[1]/div/div/div/div/div/div[2]/div[1]/iframe";
    public String liveSideButton = "/html/body/div[1]/div/div/div/div/div[2]/div[1]/div[2]/div[3]/div[2]/div[3]/a";
    public String prematchSideButton = "/html/body/div[1]/div/div/div/div/div[2]/div[1]/div[2]/div[2]/div[1]/div[2]/div[3]/a";
    public String prematchSlider = "/html/body/div[1]/div/div/div/div/div/div[1]/div[1]";

    //main page element
    public WebElement getElementXpath(WebDriver driver, String element) {
        return driver.findElement(By.xpath(element));
    }
    public WebElement getElementsContainerXpath(WebDriver driver, String elementContainer, int item) {
        return driver.findElements(By.xpath(elementContainer)).get(item);
    }

    //waiters
    public void waitElementXpath(WebDriverWait wait, String element) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(element)));
    }
    public void waitUrl (WebDriverWait wait, String url) {
        wait.until(ExpectedConditions.urlToBe(url));
    }

}
