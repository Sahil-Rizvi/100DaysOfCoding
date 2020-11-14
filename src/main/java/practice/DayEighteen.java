package practice;

import org.junit.Assert;
import org.junit.Test;

public class DayEighteen {
    private static int getMajorityElement(int[] arr){
        var majorityIndex = 0;
        var count = 1;
        for(var i=1;i<arr.length;i++){
            if(arr[i] == arr[majorityIndex]){
                count++;
            }
            else{
                count--;
            }
            if(count==0){
                count=1;
                majorityIndex=i;
            }
        }

        var actualCount = 0;
        for(var i=0;i<arr.length;i++){
            if(arr[i]==arr[majorityIndex]){
                actualCount++;
            }
        }
        if(actualCount>arr.length/2){
            return arr[majorityIndex];
        }
        return -1;
    }

    @Test
    public void test(){
        Assert.assertEquals(2, getMajorityElement(new int[]{2, 2, 2, 2, 5, 5, 2, 3, 3}));
        Assert.assertEquals(4, getMajorityElement(new int[]{3, 3, 4, 2, 4, 4, 2, 4, 4}));
        Assert.assertEquals(2, getMajorityElement(new int[]{1, 8, 7, 4, 1, 2, 2, 2, 2, 2, 2}));
    }
}
