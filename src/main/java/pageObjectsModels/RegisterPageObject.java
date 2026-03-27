package pageObjectsModels;

import dataObjects.RegisterPageDataObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPageObject extends BasePageObject {
    //    Locators
    private final By registerAccountTitle = By.xpath("//div[@id = 'content']/h1");
    private final By firstName = By.id("input-firstname");
    private final By lastName = By.id("input-lastname");
    private final By email = By.id("input-email");
    private final By telephone = By.id("input-telephone");
    private final By password = By.id("input-password");
    private final By confirmPassword = By.id("input-confirm");
    private final By continueBtn = By.xpath("//input[@value = 'Continue']");
    private final By privacyPolicy = By.xpath("//input[@name = 'agree']");
    private final By subscribeYes = By.xpath("//label[text() = 'Subscribe']/following-sibling::div//input[@value = '1']");
    private final By subscribeNo = By.xpath("//label[text() = 'Subscribe']/following-sibling::div//input[@value = '0']");
    private final By loginPageLink = By.partialLinkText("login page");

    //    dynamic locator
    private By errorFieldByName(String fieldName) {
        return By.xpath("//label[text() = '" + fieldName + "']/following-sibling::div/div");
    }

    //    Error locators
    private final By warningMsg = By.xpath("//div[contains(@class, 'alert-danger')]");

    //    Constructor
    public RegisterPageObject(WebDriver driver) {
        super(driver);
    }

    //    Actions
    public String getRegisterAccountTitle() {
        return seleniumHelper.getText(registerAccountTitle);
    }

    public void enterFirstName(String fName) {
        seleniumHelper.enterText(firstName, fName);
    }

    public void enterLastName(String lName) {
        seleniumHelper.enterText(lastName, lName);
    }

    public void enterEmail(String mail) {
        seleniumHelper.enterText(email, mail);
    }

    public void enterTelephone(String number) {
        seleniumHelper.enterText(telephone, number);
    }

    public void enterPassword(String pass) {
        seleniumHelper.enterText(password, pass);
    }

    public void enterConfirmPassword(String cPass) {
        seleniumHelper.enterText(confirmPassword, cPass);
    }

    public void clickOnContinueBtn() {
        seleniumHelper.clickOnElement(continueBtn);
    }

    public void agreePrivacyPolicy() {
        seleniumHelper.clickOnElement(privacyPolicy);
    }

    public void subscribeStatus(String status) {
        if (status.equalsIgnoreCase("Yes")) {
            seleniumHelper.clickOnElement(subscribeYes);
        } else {
            seleniumHelper.clickOnElement(subscribeNo);
        }
    }

    public void clickOnLoginPageLink() {
        seleniumHelper.clickOnElement(loginPageLink);
    }

//    Get error messages

    public String getWarningMsg() {
        return seleniumHelper.getText(warningMsg);
    }

    public String getFirstNameErrorText() {
        return seleniumHelper.getText(errorFieldByName("First Name"));
    }

    public String getLastNameErrorText() {
        return seleniumHelper.getText(errorFieldByName("Last Name"));
    }

    public String getEmailErrorText() {
        return seleniumHelper.getText(errorFieldByName("E-Mail"));
    }

    public String getTelephoneErrorText() {
        return seleniumHelper.getText(errorFieldByName("Telephone"));
    }

    public String getPasswordErrorText() {
        return seleniumHelper.getText(errorFieldByName("Password"));
    }

    public String getConfirmPasswordErrorText() {
        return seleniumHelper.getText(errorFieldByName("Password Confirm"));
    }

//    get displayed methods
    public boolean isWarningMsgDisplayed() {
        return seleniumHelper.isElementDisplayed(warningMsg);
    }

    public boolean isFirstNameErrorMsgDisplayed() {
        return seleniumHelper.isElementDisplayed(errorFieldByName("First Name"));
    }

    public boolean isLastNameErrorMsgDisplayed() {
        return seleniumHelper.isElementDisplayed(errorFieldByName("Last Name"));
    }

    public boolean isEmailErrorMsgDisplayed() {
        return seleniumHelper.isElementDisplayed(errorFieldByName("E-Mail"));
    }

    public boolean isTelephoneErrorMsgDisplayed() {
        return seleniumHelper.isElementDisplayed(errorFieldByName("Telephone"));
    }

    public boolean isPasswordErrorMsgDisplayed() {
        return seleniumHelper.isElementDisplayed(errorFieldByName("Password"));
    }

    public boolean isConfirmPasswordErrorMsgDisplayed() {
        return seleniumHelper.isElementDisplayed(errorFieldByName("Password Confirm"));
    }

    //    Methods
    public void fillRegisterForm(RegisterPageDataObject registerData) {
        enterFirstName(registerData.getFirstName());
        enterLastName(registerData.getLastName());
        enterEmail(registerData.getEmail());
        enterTelephone(registerData.getTelephone());
        enterPassword(registerData.getPassword());
        enterConfirmPassword(registerData.getConfirmPassword());
        subscribeStatus(registerData.getSubscribe());
        clickOnContinueBtn();
    }


}
