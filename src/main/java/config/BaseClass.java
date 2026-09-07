package config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Driver;
import java.time.Duration;
import java.util.*;

public class BaseClass {
//In the base class we provide a value of the driver
    static WebDriver driver;
    //driver info // driver manager
    static String myBrowser;
    static String myBaseURL;

    //this method is to connect with env.properties and get the properties value

    public static void loadEnv() throws IOException {
        //connecting with the file
        FileInputStream fis = new FileInputStream("C:\\Users\\sabri\\IdeaProjects\\WalmartDividend\\src\\main\\resources\\env.properties");
        Properties prop = new Properties();
        prop.load(fis);
        myBrowser = prop.getProperty("browser");
        //myBaseURL = prop.getProperty("BaseURL_QA");

        System.out.println(myBrowser);
    }

    public static void initializeDriver() throws IOException{
        loadEnv();

        if(myBrowser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup(); // get the current version of the driver
            driver = new ChromeDriver(); //open the chrome browser

            //List<String> list = new ArrayList<>();

        }
        else if (myBrowser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup(); // get the current version of the driver
            driver = new FirefoxDriver(); //open the
        }
        else {
            System.out.println("Check your driver");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        DriverManager.setDriver(driver);
    }

//    public static void main(String[] args) throws IOException {
//        initializeDriver();
//        DriverManager.getDriver().get("https://uprightforum.tech");
//
//        CommonUtility.screenshot();
//
//        String myCurrentURL = DriverManager.getDriver().getCurrentUrl();
//        System.out.println(myCurrentURL);
//
//        String myTitle = DriverManager.getDriver().getTitle();
//        System.out.println(myTitle);
////locators- id, class, name, linktext, partiallinktext
//        WebElement myLink = DriverManager.getDriver().findElement(By.linkText("Practice"));
//        myLink.click();
//
//
//        String pageSource = DriverManager.getDriver().getPageSource();
//        Files.write(Paths.get("pagesource.txt"),pageSource.getBytes());
//
//        //DriverManager.getDriver().quit();
// //List <WebElement> openWindow = DriverManager.getDriver().findElements(())
//
//        String firstWindow = DriverManager.getDriver().getWindowHandle();
//        System.out.println("Current Window ID " +firstWindow); //current window id
//
//       WebElement buttonClick = DriverManager.getDriver().findElement(By.xpath("//button[contains (text(), 'open window')]"));
//     CommonUtility.elementPresent(5, buttonClick);
//       buttonClick.click();
//
//        Set<String> Windows = DriverManager.getDriver().getWindowHandles();
//        System.out.println("Multiple Window IDs " +Windows);
//
//        // we use list or set to retrieve multiple window ids in WindowHandles
//        //WindowID retrieves a single window id
//
//
//        System.out.println(Windows.size());
//
//        CommonUtility.screenshot();
//
//                    }
}
