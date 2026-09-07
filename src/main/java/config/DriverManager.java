package config;


//here we keep only WebDriver info
//WebDriver is an interface
//Interface is like a class where there are methods with no body

import org.openqa.selenium.WebDriver;

public class DriverManager {
    //Here we initialize the driver with getter and setter method

    private static WebDriver driver;
    //private static String name;

    public static WebDriver getDriver(){
        return driver;
    }

    public static void setDriver(WebDriver d){
        driver = d;
    }

}
