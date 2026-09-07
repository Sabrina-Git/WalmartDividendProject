package stepDef;

import config.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pageObjects.UprightLoginPage;

public class UprightLoginSteps {

    UprightLoginPage obj = new UprightLoginPage();
    @Then("user should be on the login page")
    public void user_should_be_on_the_login_page() {
        //obj.loginPageVerification();
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(obj.verifyURL(),"https://uprightforum.tech/login/");
         soft.assertAll(); // will print error in console
        System.out.println("Step-1");
    }

    @Then("Username field should be displayed")
    public void username_field_should_be_displayed() {
        System.out.println("Step-2");
        obj.checkUserNameField();
    }

    @Then("Password field should be displayed")
    public void password_field_should_be_displayed() {
        System.out.println("Step-3");
        obj.checkPasswordField();
    }

    @Then("Keep me signed in checkbox should be unchecked")
    public void keep_me_signed_in_checkbox_should_be_unchecked() {
        System.out.println("Step-4");
        obj.keepMeSignedIn();
    }
    @When("user enter username")
    public void user_enter_username() {
        obj.enterUsername("TestUser");

    }
    @When("user enter password")
    public void user_enter_password() {
        obj.enterPassword("Test@123");

    }
    @When("user click on LoginButton")
    public void user_click_on_login_button() throws InterruptedException {
        obj.clickLoginButton();
        Thread.sleep(10);

    }
    @Then("verify user should be navigated to the profile page")
    public void verify_user_should_be_navigated_to_the_profile_page() {
          obj.verifyProfilePage();
    }


    //--------------------------------------------------------------

    @When("user enters valid or invalid {string} and {string}")
    public void userEntersValidOrInvalidUsernameAndPassword(String userName, String password) {
        obj.enterUsername(userName);
        obj.enterPassword(password);
    }

    @Then("verify that user receive an error {string}")
    public void verifyThatUserReceiveAnErrorExpectedMessage(String errorMessage) {
        //obj.checkErrorMessage(errorMessage);

        SoftAssert soft = new SoftAssert();
        soft.assertEquals(obj.checkErrorMessage(), errorMessage);
        soft.assertAll();
    }

}
