import dataFactories.RegisterDataFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjectsModels.HomePageObject;
import pageObjectsModels.LoginPageObject;
import pageObjectsModels.RegisterPageObject;

public class RegisterPageTestCases extends Base {
    private final SoftAssert softAssert = new SoftAssert();

    @Test
    public void clickOnRegisterPageLink() {
//        Page Object Models
        var homePageObj = new HomePageObject(driver);
        var registerPageObj = new RegisterPageObject(driver);
        var loginPageObj = new LoginPageObject(driver);

//        click on register
        homePageObj.clickOnRegister();

//        Check Register Account title to verify user redirected to  register page
        String registerAccountText = registerPageObj.getRegisterAccountTitle();
        Assert.assertEquals(registerAccountText, "Register Account", "User not redirected to register page");

//        Click on Login page link
        registerPageObj.clickOnLoginPageLink();
        String returningCustomerTitle = loginPageObj.getReturningCustomerTitle();
        Assert.assertEquals(returningCustomerTitle, "Returning Customer", "User not redirected to Login page");
    }

    @Test
    public void registerWithBlankData() {
//        Page Object Models
        var homePageObj = new HomePageObject(driver);
        var registerPageObj = new RegisterPageObject(driver);

//        click on register
        homePageObj.clickOnRegister();

//        Check Register Account title to verify user redirected to  register page
        String registerAccountText = registerPageObj.getRegisterAccountTitle();
        Assert.assertEquals(registerAccountText, "Register Account", "User not redirected to register page");

//        Register with blank data
        var user = RegisterDataFactory.blankData();
        registerPageObj.fillRegisterForm(user);

//        Verify error message
        String warningMsg = registerPageObj.getWarningMsg();
        softAssert.assertEquals(warningMsg, "Warning: You must agree to the Privacy Policy!", "Warning message not displayed or mismatched");

        String firstNameErrorMsg = registerPageObj.getFirstNameErrorText();
        softAssert.assertEquals(firstNameErrorMsg, "First Name must be between 1 and 32 characters!", "First name error message not displayed or mismatched");

        String lastNameErrorMsg = registerPageObj.getLastNameErrorText();
        softAssert.assertEquals(lastNameErrorMsg, "Last Name must be between 1 and 32 characters!", "Last name error message not displayed or mismatched");

        String emailErrorMsg = registerPageObj.getEmailErrorText();
        softAssert.assertEquals(emailErrorMsg, "E-Mail Address does not appear to be valid!", "Email error message not displayed or mismatched");

        String telephoneErrorMsg = registerPageObj.getTelephoneErrorText();
        softAssert.assertEquals(telephoneErrorMsg, "Telephone must be between 3 and 32 characters!", "Telephone error message not displayed or mismatched");

        String passwordErrorMsg = registerPageObj.getPasswordErrorText();
        softAssert.assertEquals(passwordErrorMsg, "Password must be between 4 and 20 characters!", "Password error message not displayed or mismatched");
    }

    @Test
    public void passwordAndConfirmPasswordNotMatched() {
//        Page Object Models
        var homePageObj = new HomePageObject(driver);
        var registerPageObj = new RegisterPageObject(driver);

//        click on register
        homePageObj.clickOnRegister();

//        Check Register Account title to verify user redirected to  register page
        String registerAccountText = registerPageObj.getRegisterAccountTitle();
        Assert.assertEquals(registerAccountText, "Register Account", "User not redirected to register page");

//        Register with mismatched password & Confirm Password
        var user = RegisterDataFactory.passwordMismatched();
        registerPageObj.agreePrivacyPolicy();
        registerPageObj.fillRegisterForm(user);

//        Verify error message
        String confirmMsg = registerPageObj.getConfirmPasswordErrorText();
        Assert.assertEquals(confirmMsg, "Password confirmation does not match password!", "Confirm Password error message not displayed or mismatched");
    }

    @Test
    public void verifyToEnterAlphabeticalValuesInPhoneNumber(){
//        Page Object Models
        var homePageObj = new HomePageObject(driver);
        var registerPageObj = new RegisterPageObject(driver);

//        click on register
        homePageObj.clickOnRegister();

//        Check Register Account Title
        String registerAccountTitle = registerPageObj.getRegisterAccountTitle();
        Assert.assertEquals(registerAccountTitle, "Register Account", "User not redirected to register page");

//        Agree privacy policy
        registerPageObj.agreePrivacyPolicy();

//        Enter alphabetical values in phone number
        var user = RegisterDataFactory.alphabeticalValuesInPhoneNumber();
        registerPageObj.fillRegisterForm(user);

        String telephoneErrorMsg = registerPageObj.getTelephoneErrorText();
        Assert.assertEquals(telephoneErrorMsg, "Telephone does not appear to be valid!", "Telephone error message not displayed or mismatched");
    }
}
