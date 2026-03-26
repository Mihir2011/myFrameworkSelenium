import dataFactories.RegisterDataFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectsModels.HomePageObject;
import pageObjectsModels.RegisterPageObject;


public class TestCases extends Base {
    @Test
    public void clickOnCurrency() {
        var homePageData = new HomePageObject(driver);
        homePageData.addToCartProduct("MacBook", "iPhone");

//        homePageData.clickOnBlackCartBtn();
        System.out.println(homePageData.getListOfCartItems());
    }

    @Test
    public void clickOnCurrency2() {
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
