package practice;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DayFortyNine {

    public static boolean canBePartitionedRec(int[] arr){
        var sumOfArray = Arrays.stream(arr).sum();
        if((sumOfArray & 1)!=0){
            return false;
        }
        return subSetSumProblemRec(arr, arr.length, sumOfArray/2);
    }


    public static boolean canBePartitionedDP(int[] arr){
        var sumOfArray = Arrays.stream(arr).sum();
        if((sumOfArray & 1)!=0){
            return false;
        }
        return subSetSumProblemDP(arr,sumOfArray/2);
    }


    private static boolean subSetSumProblemRec(int[] arr, int index, int sum){
        if(sum==0){
            return true;
        }
        if(index==0){
            return false;
        }

        if(arr[index-1]<=sum){
            return subSetSumProblemRec(arr, index-1, sum-arr[index-1]) || subSetSumProblemRec(arr, index-1, sum);
        }
        return subSetSumProblemRec(arr, index-1, sum);
    }


    private static boolean subSetSumProblemDP(int[] arr, int sum){
        var dp = new boolean[arr.length+1][sum+1];

        for(var i=0;i<=arr.length;i++){
            dp[i][0] = true;
        }

        for(var i=1;i<=sum;i++){
            dp[0][i] = false;
        }

        for(var i=1;i<=arr.length;i++){
            for(var j=1;j<=sum;j++){
                if( arr[i-1] <= j ){
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                } else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[arr.length][sum];
    }


    @Test
    public void test(){
        Assert.assertTrue(canBePartitionedRec(new int[] {15, 5, 20, 10, 35, 15, 10}));
        Assert.assertFalse(canBePartitionedRec(new int[] {15, 5, 20, 10, 35}));

        Assert.assertTrue(canBePartitionedDP(new int[] {15, 5, 20, 10, 35, 15, 10}));
        Assert.assertFalse(canBePartitionedDP(new int[] {15, 5, 20, 10, 35}));

        Assert.assertTrue(solveUsingPowerSet(Arrays.asList(15, 5, 20, 10, 35, 15, 10)));
        Assert.assertFalse(solveUsingPowerSet(Arrays.asList(15, 5, 20, 10, 35)));

    }

    public static ArrayList<ArrayList<Integer>> powerSet(List<Integer> list, int index){
        if(list.size()==index){
            var t = new ArrayList<ArrayList<Integer>>();
            t.add(new ArrayList<>());
            return t;
        }

        var resTemp = powerSet(list, index+1);
        var result = new ArrayList<>(resTemp);
        for(var el: resTemp){
            var temp = new ArrayList<>(el);
            temp.add(list.get(index));
            result.add(temp);
        }
        return result;
    }

    public static boolean solveUsingPowerSet(List<Integer> l){
        var sum = l.stream().mapToInt(Integer::intValue).sum();
        if((sum&1)!=0){
            return false;
        }
        for(var set: powerSet(l, 0)){
            if(set.stream().mapToInt(Integer::intValue).sum()==sum/2){
                return true;
            }
        }
        return false;
    }

}
