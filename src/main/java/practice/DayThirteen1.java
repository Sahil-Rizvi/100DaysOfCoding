package practice;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class DayThirteen1 {

    public static int maxCircularSumArray(int[] arr){
        return Math.max(maxKadane(arr), Arrays.stream(arr).sum() - minKadane(arr));
    }

    private static int maxKadane(int[] arr){
        var curMax = arr[0];
        var maxSoFar = curMax;
        for(var i=1;i<arr.length;i++){
            curMax = Math.max(curMax+arr[i], arr[i]);
            maxSoFar = Math.max(curMax,maxSoFar);
        }
        return maxSoFar;
    }

    private static int minKadane(int[] arr){
        var curMin = arr[0];
        var minSoFar = curMin;
        for(var i=1;i<arr.length;i++){
            curMin = Math.min(curMin+arr[i], arr[i]);
            minSoFar = Math.min(curMin,minSoFar);
        }
        return minSoFar;
    }

    @Test
    public void test(){
        Assert.assertEquals(22,maxCircularSumArray(new int[]{8, -8, 9, -9, 10, -11, 12}));
        Assert.assertEquals(23,maxCircularSumArray(new int[]{10, -3, -4, 7, 6, 5, -4, -1}));
        Assert.assertEquals(52,maxCircularSumArray(new int[]{-1, 40, -14, 7, 6, 5, -4, -1}));
    }
}
