package class03;

import org.testng.annotations.*;

public class Annotations {

    @BeforeTest
    public void beforeTest(){
        System.out.println("I am before Test");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("I am Before class");
    }

    @BeforeMethod
    public  void BeforeMethod(){
        System.out.println("I am Before Method");
    }

    @Test
    public void AFirstTest(){
        System.out.println("I am A 1 Test");
    }

    @Test
    public void BSecondTest(){
        System.out.println("I am B 2 Test");
    }

    @AfterMethod
    public void AfterMethod(){
        System.out.println("I am After Method");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("I am After class");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("I am after Test");
    }
}
