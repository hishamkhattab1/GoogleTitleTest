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
       
        System.out.println("Starting Test");

        //URL hubUrl = new URL("http://192.168.100.44:4444/wd/hub");
        
        ChromeOptions options = new ChromeOptions();
        System.out.println("Adding Chrome Options");

        options.addArguments("--headless"); 
        options.addArguments("--remote-debugging-port=9222");
        System.out.println("Adding Chrome Options headless and remote debugging port");

        WebDriver driver = new ChromeDriver(options);
        System.out.println("New web driver ");

        driver = new RemoteWebDriver(new URL("http://192.168.180.185:4444/wd/hub"), options);
        System.out.println("Assiging the URL and options to the new Driver");

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
   