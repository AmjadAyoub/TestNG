package review1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HardAssertion {

    WebDriver driver;

    @BeforeMethod (alwaysRun = true)
    public void launchTheWebsite(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();


    }


    @Test
    public void invalidCredentials(){
        //username
        WebElement userName = driver.findElement(By.xpath("//input[@name='txtUsername']"));
        userName.sendKeys("admin");
        //password
        WebElement password = driver.findElement(By.xpath("//input[@id = 'txtPassword']"));
        password.sendKeys("abracadabra");
        //login
        WebElement logIn = driver.findElement(By.xpath("//*[@id='btnLogin']"));
        logIn.click();

        // inspect credentials
        WebElement errorsMSG=  driver.findElement(By.xpath("//span[text()='Invalid credentials']"));
        String ActualErrorMsg= errorsMSG.getText();
        //  System.out.println(ActualError);
        String ExpectedErrorMsg="Invalid credentials";
  /*  if(ActualErrorMsg.equalsIgnoreCase(ExpectedErrorMsg)) {
        System.out.println("The error message is there");
    }  else {
        System.out.println("The error message is not there");
    }  */
        // Assertion: Assertequals compares two strings
        Assert.assertEquals(ActualErrorMsg,ExpectedErrorMsg);

        // confirm that the error message is displayed

        System.out.println("I am here after 1st assertion");
        boolean isDisplayed= errorsMSG.isDisplayed();
        //Assertion will pass if the parameter boolean is "true" . Will fail if the parameter boolean is false
        Assert.assertTrue(isDisplayed);
        // Assert.assertTrue(!isDisplayed);  to make is fail, we can add !
        System.out.println(isDisplayed);

    }

    @AfterMethod (alwaysRun = true)
    public void closeBrowser(){
        driver.quit();
    }

}


