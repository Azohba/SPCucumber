package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;

public class BaseActions {

    public static Logger logger = Logger.getLogger(String.valueOf(BaseActions.class));
    public static WebDriver webDriver;
    public static WebDriverWait wait;

    public void initializeDriver(){
        Driver driver = new Driver();
        webDriver = driver.setup();
        wait = new WebDriverWait(webDriver, 30);
    }

    public void tearDrop(){
        if (webDriver!=null){
            webDriver.quit();
        }
    }


    public void getScreenShot(String scenarioName,String stepName) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        TakesScreenshot ts = (TakesScreenshot) webDriver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        FileUtils.copyFile(source,new File("reports/screenshots/" + sdf.format(timestamp.getTime())+ "-"+scenarioName+"-" + stepName+".png"));
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
