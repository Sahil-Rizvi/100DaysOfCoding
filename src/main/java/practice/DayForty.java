package practice;

import org.junit.Test;

import java.util.Arrays;

public class DayForty {

    private static class Result{
        int first;
        int second;
    }

    public static Result solve(Integer[] arr){
        var xorOfAllNumbers  =  Arrays.stream(arr).mapToInt(Integer::intValue).reduce(0, (a,b) -> a^b);
        // find rightmost set bit
        xorOfAllNumbers = xorOfAllNumbers & -xorOfAllNumbers; // -xorOfAllNumbers is same as ~(xorOfAllNumbers - 1)

        var result = new Result();
        for(Integer element:arr){
            if((element & xorOfAllNumbers)>0){
                result.first^= element;
            } else{
                result.second^= element;
            }
        }
        return result;
    }


    @Test
    public void test(){
        var test = new Integer[]{1,2,1,3};
        var ans = solve(test);
        System.out.println(ans.first);
        System.out.println(ans.second);
    }

}
