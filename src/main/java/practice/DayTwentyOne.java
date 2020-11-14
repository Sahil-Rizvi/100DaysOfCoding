package practice;

import org.junit.Assert;
import org.junit.Test;

public class DayTwentyOne {

    public static int swapOddEvenBits(int num){
        return (num & 0xAAAAAAAA)>>1 | (num & 0x55555555)<<1;
    }

    @Test
    public void test(){
        var num = 23;
        Assert.assertEquals(43, swapOddEvenBits(num));
    }
}
