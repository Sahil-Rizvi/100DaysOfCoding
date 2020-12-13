package practice;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SubSetSum {


    public static boolean isSubsetSum(int[] arr, int index, int sum){
        if(sum==0){
            return true;
        }
        if(index == arr.length){
            return false;
        }
        if(arr[index]<=sum){
            return isSubsetSum(arr, index+1, sum-arr[index]) || isSubsetSum(arr, index+1, sum);
        }
        return isSubsetSum(arr, index+1, sum);
    }

    private static class Result{
        boolean flag;
        List<Integer> list;
        Result(boolean flag, List<Integer> list){
            this.flag = flag;
            this.list = list;
        }
    }

    public static Result getSubsetSumPath(int[] arr, int index , int sum){
        if(sum==0){
            return new Result(true, new ArrayList<>());
        }

        if(arr.length==index){
            return new Result(false, new ArrayList<>());
        }

        if(arr[index]<=sum){
            var res = getSubsetSumPath(arr, index+1, sum-arr[index]);
            if(res.flag){
                var l1 = new ArrayList<Integer>(res.list.size()+1);
                l1.add(null);
                for(var j = 0;j<res.list.size();j++){
                    l1.add(res.list.get(j));
                }
                l1.set(0, arr[index]);
                return new Result(true, l1);
            } else{
                return getSubsetSumPath(arr, index+1, sum);
            }
        }
        return getSubsetSumPath(arr, index+1, sum);
    }


    public static boolean subSetSumDp(int[] arr, int sum){
        var dp = new boolean[arr.length+1][sum+1];

        for(var i=1;i<=sum;i++){
            dp[0][i] = false;
        }

        for(var i=0;i<=arr.length;i++){
            dp[i][0] = true;
        }

        for(var i=1;i<=arr.length;i++){
            for(var j=1;j<=sum;j++){
                if(arr[i-1]<=j){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[arr.length][sum];
    }

    @Test
    public void test(){
        Assert.assertTrue(isSubsetSum(new int[]{3, 34, 4, 12, 5, 2}, 0, 9));
        Assert.assertFalse(isSubsetSum(new int[]{3, 34, 4, 12, 5, 2}, 0, 30));

        var res = getSubsetSumPath(new int[]{3, 34, 4, 12, 5, 2}, 0, 9);
        System.out.println(res.flag);
        System.out.println(res.list);

        res = getSubsetSumPath(new int[]{3, 34, 4, 12, 5, 2}, 0, 30);
        System.out.println(res.flag);
        System.out.println(res.list);

        res = getSubsetSumPath(new int[]{3, 4, 5, 2}, 0, 9);
        System.out.println(res.flag);
        System.out.println(res.list);

        Assert.assertTrue(subSetSumDp(new int[]{3, 34, 4, 12, 5, 2}, 9));


    }
}
