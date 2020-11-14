package practice;

public class DayThirteen {

    private static int maximumSumSubArray(int[] array){
        if(array.length==0){
            return 0;
        }
        var maxSum = array[0];
//        var start = 0;
//        var end = start;
        var curSum = maxSum;
        for(var i=1;i<array.length;i++){
            if(curSum+array[i] >= array[i]){
                curSum = curSum+array[i];
            }
            else{
                curSum = array[i];
//                start = i;
//                end = start;
            }
            if(curSum>maxSum){
                maxSum = curSum;
//                end = i;
            }
        }
        return maxSum;
    }

    public static int maximumCircularSumSubArray(int[] array){
        var kadaneSum1 = maximumSumSubArray(array);
        var areAllNegative = true;
        var minimum = Integer.MAX_VALUE;
        var sum = 0;
        for(var i =0;i<array.length;i++){
            sum+=array[i];
            if(array[i]>0 && areAllNegative){
                areAllNegative = false;
            }
            minimum = Math.min(minimum, array[i]);
            array[i]*=-1;
        }
        if(areAllNegative){
            return minimum;
        }

        var kadaneSum2 = maximumSumSubArray(array);
        return Math.max(kadaneSum1, kadaneSum2 + sum);
    }

    public static int simpler(int[] array){
        if(array.length==1){
            return array[0];
        }
        var curMax = array[0];
        var maxSoFar = curMax;

        var curMin = array[0];
        var minSoFar = curMin;

        var sum = curMax;
        for(var i=1;i<array.length;i++){
            curMax = Math.max(curMax+array[i], array[i]);
            maxSoFar = Math.max(maxSoFar, curMax);

            curMin = Math.min(curMin+array[i], array[i]);
            minSoFar = Math.min(minSoFar, curMin);

            sum+=array[i];
        }

        if(sum == minSoFar){
            return maxSoFar;
        }
        return Math.max(maxSoFar, sum - minSoFar);
    }
    public static void main(String... args){
        var array = new int[]{-1, 40, -14, 7, 6, 5, -4, -1};
        System.out.println(simpler(array));
    }

}
