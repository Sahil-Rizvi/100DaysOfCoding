package practice;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DaySixtyOne {

    private static int finalMax;

    private static int longestIncreasingSubsequenceLengthUtil(int[] arr, int length){
        if(length==1){
            return 1;
        }

        var maxEndingHere = 1;
        for(var i=1;i<length;i++){
            var res = longestIncreasingSubsequenceLengthUtil(arr, i);
            if(arr[i-1] < arr[length-1] && res + 1 > maxEndingHere){
                maxEndingHere = res+1;
            }
        }
        if(finalMax < maxEndingHere){
            finalMax = maxEndingHere;
        }
        return maxEndingHere;
    }

    public static int longestIncreasingSubsequenceLength(int[] arr){
        longestIncreasingSubsequenceLengthUtil(arr, arr.length);
        return finalMax;
    }

    public static int longestIncreasingSubsequenceLengthDP(int[] arr){
        var dp = new int[arr.length];
        dp[0] = 1;

        for(var i=1;i<arr.length;i++){
            for(var j=0;j<i;j++){
                if(arr[j] < arr[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        var maxOptional = Arrays.stream(dp).max();
        return maxOptional.getAsInt();
    }

    private static int ceil(List<Integer> arr, int key){
        var low = 0;
        var high = arr.size()-1;
        while(high - low > 1){
            var mid = low + (high-low)/2;
            if(arr.get(mid) >= key){
                high = mid;
            } else{
                low = mid;
            }
        }
        return high;
    }



    public static int solve(int[] arr){
        var list = new ArrayList<Integer>(arr.length);
        list.add(arr[0]);
        for(var i=1;i<arr.length;i++){
            if(arr[i] < list.get(0)){
                list.set(0, arr[i]);
            } else if(arr[i] > list.get(list.size()-1)){
                list.add(arr[i]);
            } else{
                list.set(ceil(list, arr[i]), arr[i]);
            }
        }
        return list.size();
    }



    @Test
    public void test(){
        var a = new int[]{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        System.out.println(longestIncreasingSubsequenceLength(a));
        System.out.println(longestIncreasingSubsequenceLengthDP(a));
        System.out.println(solve(a));
    }
}