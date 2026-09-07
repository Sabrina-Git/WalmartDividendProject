package stepDef;

import config.BaseClass;
import config.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks {

    @Before
    public void setUp() throws IOException{
        BaseClass.initializeDriver(); //browser open
    }
    @After
    public void tearDown(){
        DriverManager.getDriver().quit();
    }
}
