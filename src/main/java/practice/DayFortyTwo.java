package practice;

import org.junit.Assert;
import org.junit.Test;

public class DayFortyTwo {

    private boolean canReach(int[] arr, int index){
        if(index>=arr.length-1){
            return true;
        }
        if(arr[index]==0){
            return false;
        }
        var ans = false;
        for(var i = index+1; i<=index+arr[index]; i++){
            ans = canReach(arr,i);
            if(ans){
                break;
            }
        }
        return ans;
    }

    private boolean canReach1(int[] arr){
        var maxReachSoFar = 0;
        for(var i=0;i<arr.length;i++){
            if(i>maxReachSoFar){
                break;
            }
            maxReachSoFar = Math.max(maxReachSoFar, i + arr[i]);
        }
        return maxReachSoFar >= arr.length-1;
    }


    @Test
    public void test(){
        var arr = new int[]{1, 3, 1, 2, 0, 1};
        Assert.assertTrue(canReach(arr,0));
        Assert.assertTrue(canReach1(arr));

        arr = new int[]{1, 2, 1, 0, 0};
        Assert.assertFalse(canReach(arr,0));
        Assert.assertFalse(canReach1(arr));

    }


}
