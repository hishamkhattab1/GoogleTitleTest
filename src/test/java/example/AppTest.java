package example;

import java.net.MalformedURLException;

import org.testng.annotations.Test;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;


public class AppTest 
{
    @Test
    public void Testing() throws MalformedURLException{
       
        System.out.println("Testin");

        URL hubUrl = new URL("http://192.168.100.44:4444/wd/hub");
        
        ChromeOptions options = new ChromeOptions();
        
        //options.addArguments("--headless"); 
        options.addArguments("--remote-debugging-pipe");

        WebDriver driver = new ChromeDriver(options);
        
        driver = new RemoteWebDriver(hubUrl, options);
        
        driver.get("http://www.google.com");

        String actualTitle = driver.getTitle();

        System.out.println(actualTitle);

        String expectedTitle = "Google";

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Test Passed! Title is: " + actualTitle);
        } else {
            System.out.println("Test Failed. Expected title: " + expectedTitle + ", Actual title: " + actualTitle);
        }
        driver.quit();
    }
}
   