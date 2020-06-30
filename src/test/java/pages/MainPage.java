package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    public String header = "//*[@id=\"__next\"]/div/header/div";
    public String navigationButtons = "//*[@id=\"__next\"]/div/header/div/div/nav/ul/li";
    public String usersCorner = "//*[@id=\"__next\"]/div/header/div/div/div/div";
    public String gameFilters = "//*[@id=\"__next\"]/div/div/div/div/div[2]/div[1]/div[1]/div";
    public String betLineContainer = "//*[@id=\"__next\"]/div/div/div/div/div[2]/div[1]/div[2]";
    public String sideBar = "//*[@id=\"__next\"]/div/div/div/div/div[2]/div[2]";
    public String streamPage = "//*[@id=\"__next\"]/div/div";
    public String sportPageSlider = "//*[@id=\"__next\"]/div/div/div/div/div[1]/div[2]/div/div/div/div/div/div/div[1]";
    public String slotsPage = "//*[@id=\"__next\"]/div/div/div/div/div/div[2]";
    public String newsPage = "//*[@id=\"__next\"]/div/div";

    //main page element
    public WebElement getElement (WebDriver driver, String element) {
        return driver.findElement(By.xpath(element));
    }
    public WebElement getElementsContainer (WebDriver driver, String elementContainer, int item) {
        return driver.findElements(By.xpath(elementContainer)).get(item);
    }

    //waiters
    public void waitElement (WebDriverWait wait, String element) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(element)));
    }
    public void waitUrl (WebDriverWait wait, String url) {
        wait.until(ExpectedConditions.urlToBe(url));
    }

}
