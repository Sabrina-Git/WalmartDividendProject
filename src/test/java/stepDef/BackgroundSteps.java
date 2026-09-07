package stepDef;

import config.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class BackgroundSteps {

    @Given("user launches the application")
    public void user_launches_the_application() {
        DriverManager.getDriver().get("https://uprightforum.tech/login");

    }


}
