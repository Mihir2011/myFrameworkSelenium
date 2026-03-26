package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavascriptHelper {

    protected JavascriptExecutor js;
    protected WaitUtils wait;

    public JavascriptHelper(WebDriver driver) {
        js = (JavascriptExecutor) driver;
        wait = new WaitUtils(driver);
    }

    private boolean isElementInViewport(WebElement element) {
        return (Boolean) js.executeScript(
                "var rect = arguments[0].getBoundingClientRect();" +
                        "return (" +
                        "rect.top >= 0 && " +
                        "rect.left >= 0 && " +
                        "rect.bottom <= (window.innerHeight || document.documentElement.clientHeight) && " +
                        "rect.right <= (window.innerWidth || document.documentElement.clientWidth));",
                element
        );
    }

    public WebElement scrollToElementIfNotVisible(WebElement element) {
        if (!isElementInViewport(element)) {
            js.executeScript("arguments[0].scrollIntoView({block: 'center', behavior: 'smooth'});", element);
        }
        return element;
    }
}
