package utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.logging.Logger;

public class BaseActions {
    public static Logger logger = Logger.getLogger(String.valueOf(BaseActions.class));
    public static WebDriver webDriver;
    public static WebDriverWait wait;

    public void initializeDriver(){
        Driver driver = new Driver();
        //TODO haburayi driver çekmeden direkt go to yazarak çalıştırsam daha iyi gibin
        webDriver = driver.setup();
        wait = new WebDriverWait(webDriver, 30);
    }

    public void tearDrop(){
        if (webDriver!=null){
            webDriver.quit();
        }
    }

    public void goToHomepage() {
        webDriver.manage().deleteAllCookies();
        webDriver.navigate().to("http://www.uitestingplayground.com/");
    }


    public void waitUntilElementVisible(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public String getText(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return webDriver.findElement(by).getText();
    }

    public String getTitle() {
        return webDriver.getTitle();
    }

    public void waintUntilElementInvisible(By by){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }
    public void waitUntilVisibleAndClick(By by){
        waitUntilElementVisible(by);
        webDriver.findElement(by).click();
    }

    public void sendKeys(By by,String keys){
        webDriver.findElement(by).sendKeys(keys);
    }

    public void clickWithAction(By by){
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webDriver.findElement(by)).click().build().perform();
    }


    public WebElement swipeUntilElement(By by){
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webDriver.findElement(by)).build().perform();
        return webDriver.findElement(by);
    }

    void deleteScreenShots(){
        File folder = new File(".gauge/screenshots");
        File fList[] = folder.listFiles();

        for (File f : fList) {
            if (f.getName().endsWith(".png")) {
                f.delete();
            }}

    }

}
