package practice;

import org.junit.Assert;
import org.junit.Test;

public class DayTen {

    private static int findMinimumUtil(Integer[] arr, int low, int high) {
        if(low>high){
            return arr[0];
        }
        // one element
        if(low == high){
            return arr[low];
        }
        // not rotated
        if(arr[low] < arr[high]){
            return arr[low];
        }
        // if only two elements
        if(low+1 == high){
            return arr[high];
        }
        var mid = low + (high-low)/2;
        if((arr[mid-1] < arr[mid]) && (arr[mid]> arr[mid+1])){
            return arr[mid+1];
        }
        if(arr[mid] > arr[high]){
            return findMinimumUtil(arr, mid+1, high);
        }
        return findMinimumUtil(arr, low, mid);
    }

    public static int findMinimum(Integer[] arr){
        return findMinimumUtil(arr, 0, arr.length-1);
    }

    public static void main(String... args){
        System.out.println(findMinimum(new Integer[]{5, 6, 1, 2, 3, 4}));
    }

    @Test
    public void test(){
        Assert.assertEquals(1,findMinimum(new Integer[]{2, 1}));
    }



}
