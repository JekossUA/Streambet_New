package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    //main page elements
    public WebElement getHeader (WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"__next\"]/div/header/div"));
    }
    public WebElement getNavigationButtons (WebDriver driver,int buttonNumber ) {
        return driver.findElements(By.xpath("//*[@id=\"__next\"]/div/header/div/div/nav/ul/li")).get(buttonNumber);
    }
    public WebElement getUserCorner (WebDriver driver, int item) {
        return driver.findElements(By.xpath("//*[@id=\"__next\"]/div/header/div/div/div")).get(item);
    }

    //waiters
    public void waitNavigationButtons (WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"__next\"]/div/header/div/div/nav/ul/li")));
    }

}
