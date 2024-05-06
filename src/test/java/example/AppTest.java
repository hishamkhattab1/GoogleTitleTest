package example;

//import java.io.IOException;
import java.net.MalformedURLException;

//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.net.URL;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;


public class AppTest 
{
    /* @BeforeSuite
    public void startContainer()
    {
        try{
        ProcessBuilder builder = new ProcessBuilder("docker compose up -d");
        builder.redirectErrorStream(true);
        builder.start();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }  */


    @Test
    public void Testing() throws MalformedURLException{
       
        System.out.println("Starting Test");

        URL hubUrl = new URL("http://192.168.180.185:4444/wd/hub");
        
        ChromeOptions options = new ChromeOptions();
        System.out.println("Adding Chrome Options");

        options.addArguments("--headless"); 
        //options.addArguments("--remote-debugging-port=9222");
        System.out.println("Adding Chrome Options headless and remote debugging port");

        System.out.println("New web driver ");

        RemoteWebDriver driver = new RemoteWebDriver(hubUrl, options);
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

   /*  @AfterSuite
    public void stopContainer()
    {
        try{
        ProcessBuilder builder = new ProcessBuilder("docker compose down -d");
        builder.redirectErrorStream(true);
        builder.start();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    } */
}
   