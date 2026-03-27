package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumHelper {
    protected WebDriver driver;
    protected WaitUtils wait;
    protected JavascriptHelper js;

    public SeleniumHelper(WebDriver driver){
        this.driver = driver;
        this.wait = new WaitUtils(driver);
        this.js = new JavascriptHelper(driver);
    }

    public WebElement scrollToElements(By element){
        return js.scrollToElementIfNotVisible(wait.waitUntilElementToBeClickable(element));
    }

    public boolean isElementDisplayed(By by){
        WebElement element = null;
        try {
            element = wait.waitUntilElementToBeVisible(by);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return element != null;
    }

    public void enterText(By by,  String text){
        var element = wait.waitUntilElementToBeVisible(by);
        js.scrollToElementIfNotVisible(element);
        element.clear();
        element.sendKeys(text);
    }

    public String getText(By by){
        var element = wait.waitUntilElementToBeVisible(by);
        js.scrollToElementIfNotVisible(element);
        return element.getText();
    }

    public String getPageTitle() throws InterruptedException {
        wait.waitForPageContentLoaded();
        return driver.getTitle();
    }
}
