package pageObjects;

import config.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class UprightLoginPage {

//    WebDriver driver;
//
//    public UprightLoginPage(WebDriver driver) {
//        this.driver = driver;
//    }
//

By loginButtonPath = By.id("um-submit-btn");
By userNameField = By.xpath("//input[@name ='username-44']");
By passwordField = By.xpath("//input[@name ='user_password-44']");
By keepMeSignedIn = By.xpath("//span[@class ='um-field-checkbox-option']");
By profilePageCheck = By.xpath("//a[@href='https://uprightforum.tech/profile/']");
By loginText  = By.xpath("//a[text() ='Log In']");
By forgotPassword = By.xpath("//a[@href='https://uprightforum.tech/login/password-reset/']");
By fbLink = By.xpath("//a[@href='https://www.facebook.com/uprighttechsolutions']");
By linkedInLink = By.xpath("//a[@href='http://122562.test:8088/']");

By forgotPasswordText = By.xpath("//a[contains(text(),'Forgot your password?')]");
By forgotPassword2 = By.linkText("Forgot your password?");

By errorMessageText = By.id("um-error-for-user_password-44");



public void loginPageVerification(){

    boolean loginButtonDisplay = DriverManager.getDriver().findElement(loginButtonPath).isDisplayed();
    if(loginButtonDisplay == true){
        System.out.println("I am on login page");
    }
    else if (loginButtonDisplay == false){
        System.out.println("I am not on the login page");
    }
}


public void checkUserNameField(){
    boolean userNameDisplayed = DriverManager.getDriver().findElement(userNameField).isDisplayed();
    if(userNameDisplayed == true){
        System.out.println("I am on login page");
    }
    else if (userNameDisplayed == false){
        System.out.println("I am not on the login page");
    }
}

    public void checkPasswordField(){
    try {
        boolean passwordDisplayed = DriverManager.getDriver().findElement(passwordField).isDisplayed();
        Assert.assertEquals(passwordDisplayed, true, "Password field not available");

    } catch (Exception e){
        System.out.println(e);

    }
    }

    public void keepMeSignedIn(){
        WebElement checkBox = DriverManager.getDriver().findElement(keepMeSignedIn);
           boolean checkboxSelected = checkBox.isSelected();
           Assert.assertEquals(checkboxSelected, false);

    }


    public void enterUsername (String username){
    WebElement UserNameField = DriverManager.getDriver().findElement(userNameField);
    //UserNameField.sendKeys("TestUser");
        UserNameField.sendKeys(username);
    }

    public void enterPassword (String password){
        WebElement PasswordEnter = DriverManager.getDriver().findElement(passwordField);
        // PasswordEnter.sendKeys("Test@123");
        PasswordEnter.sendKeys(password);

    }

    public void clickLoginButton (){
    WebElement LoginButtonClick = DriverManager.getDriver().findElement(loginButtonPath);
    LoginButtonClick.click();

    }


    public void verifyProfilePage(){
        boolean profilePageDisplayed = DriverManager.getDriver().findElement(profilePageCheck).isDisplayed();
        if(profilePageDisplayed == true){
            System.out.println("I am on profile page");
        }
        else if (profilePageDisplayed == false){
            System.out.println("I am not on the profile page");
        }
    }

    public void forgotPasswordMethod (){
        WebElement forgotPasswordClick = DriverManager.getDriver().findElement(forgotPassword);
        forgotPasswordClick.click();

    }


    public String checkErrorMessage() {
//        boolean errorMessageDisplayed = DriverManager.getDriver().findElement(errorMessageText).isDisplayed();
//        if (errorMessageDisplayed == true) {
//            System.out.println("Error Message Displayed");
//        } else if (errorMessageDisplayed == false) {
//            System.out.println("Error Message not Displayed");
//        }

        String messageText = DriverManager.getDriver().findElement(errorMessageText).getText();
        return messageText;

    }

public String verifyURL(){
    String url = DriverManager.getDriver().getCurrentUrl();
    return url;
}
}
