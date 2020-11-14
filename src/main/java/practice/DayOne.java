package practice;

import java.util.Arrays;
import java.util.HashSet;

public class DayOne {


    // time complexity : O(n^2)
    // space complexity : O(1)
    public static boolean solveNaive(Integer[] arr, Integer target){
        for(var i=0;i< arr.length;i++){
            for( var j=0; j< arr.length; j++){
                if((i!= j ) && arr[i] + arr[j] == target){
                    return true;
                }
            }
        }
        return false;
    }


    // time complexity : O(n)
    // space complexity : O(n)
    public static boolean solveUsingHashSet(Integer[] arr, Integer target){
        var visited = new HashSet<Integer>();
        for(var element: arr){
            if(visited.contains(target - element)){
                return true;
            }
            visited.add(element);
        }
        return false;
    }

    // time complexity : O(nlogn) due to sorting
    // space complexity : O(1)
    public static boolean solveUsing2Pointers(Integer[] arr, Integer target){
        Arrays.sort(arr);
        var start = 0;
        var end = arr.length - 1;
        while( start < end ){
            var tempSum = arr[start] + arr[end];
            if (target == tempSum){
                return true;
            }
            if(tempSum < target){
                start++;
            }
            else{
                end--;
            }
        }
        return false;
    }

    // time complexity : O(n)
    // space complexity : O(n)
    public static boolean solveUsingRemainderApproach(Integer[] arr, Integer target){
        var remainderArray = new Integer[target];
        Arrays.fill(remainderArray, 0);
        Arrays.stream(arr).filter(el -> el < target).forEach(el -> remainderArray[el%target]++);
        var i = 1;
        for( ; i < remainderArray.length/2; i++){
            if(remainderArray[i]> 0 && remainderArray[target-i]> 0){
                return true;
            }
        }
        if( i== remainderArray.length/2){
            if((target&1) == 0){
                if( remainderArray[target/2] > 1){
                    return true;
                }
            }
            else{
                if(remainderArray[target/2] > 0 && remainderArray[target - target/2]> 0){
                    return true;
                }
            }
        }
        return false;
    }

    // time complexity : O(nlogn)
    // space complexity : O(1)
    public static boolean solveUsingBinarySearch(Integer[] arr, Integer target){
        Arrays.sort(arr);
        for(var i=0; i < arr.length; i++){
            var j = binarySearch(arr, target- arr[i]);
            if(j == -1){
                continue;
            }
            else if( i != j){
                return true;
            }
            else if(j+1<arr.length && arr[j+1] == target){
                return true;
            }
            else if(j-1>=0 && arr[j-1] == target){
                return true;
            }
        }
        return false;
    }

    private static Integer binarySearch(Integer[] arr, Integer targetElement){
        var start = 0;
        var end = arr.length-1 ;
        while(start<=end){
            var mid = (start + end)/2;
            if(arr[mid] == targetElement){
                return mid;
            }
            if( arr[mid] < targetElement){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return -1;
    }

    @Deprecated
    private static Integer binarySearchRec(Integer[] arr, Integer targetElement, Integer low, Integer high){
        if(low>high){
            return -1;
        }
        if(low == high){
            if(arr[low] == targetElement)
               return low;
            return -1;
        }
        var mid = low + (high - low)/2;
        if(arr[mid] == targetElement){
            return mid;
        }
        if(arr[mid] < targetElement){
            return binarySearchRec(arr, targetElement, low+1, high);
        }
        else{
            return binarySearchRec(arr, targetElement, low, high - 1);
        }
    }








    public static void main(String... args){
        var arr = new Integer[]{  1, 4, 45, 6, 10, 8};
        var k = 16;
        System.out.println(DayOne.solveNaive(arr, k));
        System.out.println(DayOne.solveUsingHashSet(arr, k));
        System.out.println(DayOne.solveUsing2Pointers(arr, k));
        System.out.println(DayOne.solveUsingRemainderApproach(arr, k));
        System.out.println(DayOne.solveUsingBinarySearch(arr, k));
//        Arrays.sort(arr);
//        Arrays.stream(arr).forEach(System.out::println);
//        System.out.println(DayOne1.binarySearch(arr, 13));
//        System.out.println(DayOne1.binarySearchRec(arr, 13, 0, arr.length- 1));

    }

}
