package review1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class SoftAssertions {
    WebDriver driver;
    @BeforeMethod(alwaysRun = true)
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
        String ExpectedErrorMsg="Invalid credential";

        // if we want to use soft assertion we call it from the class SoftAssert by declaring an instance
        SoftAssert soft = new SoftAssert();
        //assertion
        soft.assertEquals(ActualErrorMsg,ExpectedErrorMsg);

        System.out.println("I am here after 1st assertion"); // this line will execute whether the assertion fail or not because soft assertion is used
        // check if the webelement error message is displayed
        boolean isDisplayed= errorsMSG.isDisplayed();
        //Assertion
        soft.assertTrue(isDisplayed);
        System.out.println(isDisplayed); // it will execute true if the boolean is true even though the first assertion fails
        //assert all the assertions that have been made
        soft.assertAll(); // this always to be entered at the end of all assertions. should be the last statement of your test case.
        // nothing should be executed after it. It gives us a consolidation report of how many assertions failed

    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        driver.quit();
    }

}
