package config;

import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CommonUtility {

    public static void screenshot() throws IOException{

        //takescreenshot, webdriver
        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM-dd-YYYY_HH-mm-ss"));
        TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
        File memoryLocation = ts.getScreenshotAs(OutputType.FILE);
        FileHandler.copy(memoryLocation, new File("C:\\Users\\sabri\\IdeaProjects\\WalmartDividend\\src\\test\\ScreenShotFolder\\ screenshot" +"-" +dateTime +".png"));
    }

    public void alertTobePresent(int time) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
    }

        public static void elementPresent (int time, WebElement element){
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(time));
            wait.until(ExpectedConditions.visibilityOf(element));
        }



//    public void scrollDown(){
//        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
//        js.executeScript("window.scrollBy(0, 500)");
//
//    }

    public void scrollDown(int pixels) {
        JavascriptExecutor js =
                (JavascriptExecutor) DriverManager.getDriver();

        js.executeScript("window.scrollBy(0, arguments[0]);", pixels);
    }

    public void scrollIntoView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }



        public static void main (String[]args){
//        short reg = 13434;
//        byte newReg = (byte) reg;
//        System.out.println(newReg);

            // System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM-dd-YYYY_HH-mm-ss")));


        }
    }

