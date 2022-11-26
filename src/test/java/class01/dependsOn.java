package class01;

import org.testng.annotations.Test;

public class dependsOn {

    @Test
    public void Login(){
        // System.out.println("I am logging in successfully"); if login method executes then dashboard method execute because depends on login method
        System.out.println(5/0);
    }

    @Test(dependsOnMethods = {"Login"})
    public void DashBoardVerification(){
        System.out.println("after login in I am verifying the dashboard page");
    }

}
