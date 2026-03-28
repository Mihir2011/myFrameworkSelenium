import dataFactories.HomePageDataFactory;
import dataFactories.RegisterDataFactory;
import dataObjects.HomePageDataObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectsModels.HomePageObject;
import pageObjectsModels.RegisterPageObject;

import java.util.List;


public class HomePageTestCases extends Base {

    @Test
    public void addToCartOneProduct() {
//        page objects
        var homePageData = new HomePageObject(driver);

//        Fetch data from data factory
        HomePageDataObject items = HomePageDataFactory.addOneProduct();
        homePageData.addToCartProduct(items);

        var actualItems = homePageData.getListOfCartItems();
        var expectedItems = items.getProductsWantsToAdd();

        Assert.assertEquals(actualItems, expectedItems, "Product not added to cart");

        System.out.println(homePageData.getListOfCartItems());
    }

    @Test
    public void addToCartMultipleProducts() {
//        page objects
        var homePageData = new HomePageObject(driver);

//        Fetch data from data factory
        HomePageDataObject items = HomePageDataFactory.addMultipleProducts();
        homePageData.addToCartProduct(items);

        System.out.println(homePageData.getListOfCartItems());
    }

    @Test
    public void clickOnCurrency() {
        var homePageData = new HomePageObject(driver);

        homePageData.selectCurrency("US Dollar");
    }

    @Test
    public void fillRegisterFormWithBlankData() {
//        page objects
        HomePageObject homePageObj = new HomePageObject(driver);
        RegisterPageObject registerPageObj = new RegisterPageObject(driver);

        homePageObj.clickOnRegister();

        String actualText = registerPageObj.getRegisterAccountTitle();
        Assert.assertEquals(actualText, "Register Account", "User not redirected to Register Page");

        var registerData = RegisterDataFactory.blankData();
        registerPageObj.agreePrivacyPolicy();
        registerPageObj.fillRegisterForm(registerData);
    }

    @Test
    public void fillRegisterFormWithValidData() {
//        page objects
        HomePageObject homePageObj = new HomePageObject(driver);
        RegisterPageObject registerPageObj = new RegisterPageObject(driver);

        homePageObj.clickOnRegister();

        String actualText = registerPageObj.getRegisterAccountTitle();
        Assert.assertEquals(actualText, "Register Account", "User not redirected to Register Page");

        var registerData = RegisterDataFactory.validData();
        registerPageObj.agreePrivacyPolicy();
        registerPageObj.fillRegisterForm(registerData);
    }
}
