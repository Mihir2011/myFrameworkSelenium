package pageObjectsModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomePageObject extends BasePageObject {
    //    Locators
    private final By currency = By.xpath("//span[text() = 'Currency']/parent::button");
    private final By myAccount = By.xpath("//a[@title = 'My Account']");
    private final By register = By.xpath("//a[@title = 'My Account']/following-sibling::ul//a[text() = 'Register']");
    private final By login = By.xpath("//a[@title = 'My Account']/following-sibling::ul//a[text() = 'Login']");
    private final By searchBox = By.name("search");
    private final By searchBtn = By.xpath("//input[@name = 'search']/following-sibling::span/button");
    private final By blackCartBtn = By.xpath("//div[@id = 'cart']/button");
    private final By shoppingCartBtn = By.xpath("//a[@title = 'Shopping Cart']");
    private final By listOfCartItems = By.xpath("//ul[@class='dropdown-menu pull-right']//td[@class='text-left']/a");
    private final By successItemAddMessage = By.xpath("//div[contains(@class, 'alert-success')]");

    //    Dynamic Locators
    private By currencyDropDown(String currency) {
        return By.xpath("//span[text() = 'Currency']/parent::button/following-sibling::ul//button[contains(text(), '" + currency + "')]");
    }

    private By addToCartItemBtn(String itemName) {
        return By.xpath("//a[contains(text(), '" + itemName + "')]/ancestor::div[@class = 'caption']/following-sibling::div//button[contains(@onclick, 'cart.add')]");
    }

    //    Constructor
    public HomePageObject(WebDriver driver) {
        super(driver);
    }

    //    Actions
    public void clickOnCurrency() {
        wait.waitUntilElementToBeClickable(currency).click();
    }

    public void selectCurrency(String currency) {
        clickOnCurrency();
        wait.waitUntilElementToBeClickable(currencyDropDown(currency)).click();
    }

    public void clickOnMyAccount() {
        wait.waitUntilElementToBeClickable(myAccount).click();
    }

    public void clickOnRegister() {
        clickOnMyAccount();
        wait.waitUntilElementToBeClickable(register).click();
    }

    public void clickOnLogin() {
        clickOnMyAccount();
        wait.waitUntilElementToBeClickable(login).click();
    }

    public void searchTheProduct(String productName) {
        wait.waitUntilElementToBeVisible(searchBox).sendKeys(productName);
        wait.waitUntilElementToBeClickable(searchBtn).click();
    }

    public void addToCartProduct(String... itemName) {
        var itemWantToAdd = new ArrayList<>(Arrays.asList(itemName));
        itemWantToAdd.forEach(x -> wait.waitUntilElementToBeClickable(addToCartItemBtn(x)).click());
    }

    public void clickOnShoppingCart() {
        wait.waitUntilElementToBeClickable(shoppingCartBtn).click();
    }

    public void clickOnBlackCartBtn() {
        wait.waitUntilElementToBeClickable(blackCartBtn).click();
    }

    public void successAddToCartMessage() {
        wait.waitUntilElementToBeVisible(successItemAddMessage);
    }

    public List<String> getListOfCartItems() {
        successAddToCartMessage();
        clickOnBlackCartBtn();

        return wait.waitUntilElementsToBeVisible(listOfCartItems).stream().map(WebElement::getText).toList();
    }
}
