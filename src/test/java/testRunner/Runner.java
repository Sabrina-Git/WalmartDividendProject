package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(

        features = "C:\\Users\\sabri\\IdeaProjects\\WalmartDividend\\src\\main\\java\\features\\uprightLogin.feature",
        glue="stepDef"
//        ,plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
//        tags= "@smoke"
)


public class Runner extends AbstractTestNGCucumberTests {


}
