package practice;

import org.junit.Assert;
import org.junit.Test;

public class DaySixtyThree {

    public static int solve(int x, int y, int b){
        return x*b | y*(1-b);
    }

    @Test
    public void test(){
        Assert.assertEquals(5, solve(5,10,1));
        Assert.assertEquals(10, solve(5,10,0));
    }
}
