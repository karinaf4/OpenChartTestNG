package SoftAssertClass;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertLogic {
    @Test
    public int getSum(int num1,int num2){
        return num1+num2;
    }
    @Test
    public void test(){  //HARD ASSERT
        Assert.assertEquals(getSum(1,5),6);
        System.out.println("test1");
        Assert.assertEquals(getSum(3,7),10);
        System.out.println("test2");
        Assert.assertEquals(getSum(5,9),14);
        System.out.println("test3");
    }
 @Test
    public void softAssert(){ // it's going to execute everything even if we have a failure
     SoftAssert softAssert=new SoftAssert();
     Assert.assertEquals(getSum(1,5),6);
     System.out.println("test1");
     Assert.assertEquals(getSum(3,7),100000);
     System.out.println("test2");
     Assert.assertEquals(getSum(5,9),14);
     System.out.println("test3");
     softAssert.assertAll();
 }

}
