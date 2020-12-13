package practice;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Test2 {

    public static int noOfSteps(int n){
        if(n<0){
            return 0;
        }
        if(n==0 || n==1){
            return 1;
        }

        return noOfSteps(n-1) + noOfSteps(n-2);
    }

    public static int noOfStepsK(int n, int k){
        if(n<0){
            return 0;
        }
        if(n==0 || n==1){
            return 1;
        }

        var result = 0;
        for(var i=1;i<=k;i++){
            result += noOfStepsK(n-i,k);
        }
        return result;
    }

    public static int noOfStepsMemoization(int n, int[] arr){
        if(n<0){
            return 0;
        }
        if(n==0){
            arr[n] = 1;
            return 1;
        }
        if(arr[n]!=-1){
            return arr[n];
        }

        arr[n] = noOfStepsMemoization(n-1,arr) + noOfStepsMemoization(n-2,arr);
        return arr[n];
    }


    public static int noOfStepsMemoization2D(int n, int k, int[][] arr){
        if(n<0){
            return 0;
        }
        if(n==0 || n==k){
            arr[n][k] = 1;
            return arr[n][k];
        }
        if(k==1){
            arr[n][k] = n;
            return arr[n][k];
        }
        if(arr[n][k]!=-1){
            return arr[n][k];
        }

        for(var i=1;i<=k;i++){
            arr[n][k] += noOfStepsMemoization2D(n-i,k,arr);
        }
        return arr[n][k];
    }


    public static int noOfStepsDP(int n){
        if(n<0){
            return 0;
        }
        if(n==0){
            return 1;
        }

        var dp = new int[n+1];
        Arrays.fill(dp,-1);
        dp[0] = 1;
        dp[1] = 1;
        for(var i =2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static int noOfStepsDP2D(int n, int k){
        if(n<0){
            return 0;
        }
        if(n==0){
            return 1;
        }

        var dp = new int[n+1];
        Arrays.fill(dp,0);

        dp[0] = 1;

        for(var i=1;i<=n;i++){
            for(var j=1;j<=k;j++){
                if(i>=j){
                    dp[i] += dp[i-j];
                }
            }
        }

        return dp[n];
    }

    @Test
    public void test(){
        var n = 4;
        var arr = new int[n+1];
        Arrays.fill(arr,-1);

        var n1 = 4;
        var k1 = 2;

        Assert.assertEquals(5, noOfSteps(4));
        Assert.assertEquals(5, noOfStepsK(4,2));

        Assert.assertEquals(5, noOfStepsMemoization(4,arr));
        Assert.assertEquals(5, noOfStepsDP(4));
        Assert.assertEquals(5, noOfStepsDP2D(n1,k1));

    }

}
