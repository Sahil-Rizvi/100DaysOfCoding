package practice;

import org.junit.Assert;
import org.junit.Test;

public class DayTen1 {

    public static int findMinimumRotated(Integer[] arr, int low, int high){
        if(arr == null || arr.length == 0){
            return -1;
        }

        if(low>high){
            return arr[0];
        }
        if(low==high){
            return arr[low];
        }
        if(arr[low] < arr[high]){ // not rotated
            return arr[low];
        }
        if(low+1==high){
            return arr[high];
        }

        var mid = low + (high - low)/2;
        if(arr[mid-1] > arr[mid] && arr[mid] < arr[mid+1]){
            return mid;
        }
        if(arr[mid] > arr[high]){
            return findMinimumRotated(arr, mid+1,high);
        }
        return findMinimumRotated(arr,low,mid-1);
    }

    @Test
    public void test(){
        var array = new Integer[]{2, 1};
        Assert.assertEquals(1, DayTen1.findMinimumRotated(array, 0, array.length-1));
    }
}
