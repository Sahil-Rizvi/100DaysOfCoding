package practice;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class DayFour1 {

    public static int solveMinSwaps(Integer[] arr){
        var positions = new Integer[arr.length];
        Arrays.fill(positions,-1);
        for(var i=0;i<arr.length;i++){
            positions[arr[i]] = i;
        }
        var minSwaps = 0;
        for(var i=0;i<arr.length;i+=2){
            if(arr[i]/2 == arr[i+1]/2){
                continue;
            }
            else{
                var partner = -1;
                if(arr[i]%2==0){
                    partner = arr[i]/2*2+1;
                }
                else{
                    partner = arr[i]/2*2;
                }
                var temp = arr[i+1];
                arr[i+1] = arr[positions[partner]];
                arr[positions[partner]] = temp;

                positions[temp] = positions[partner];
                positions[partner] = i+1;
                minSwaps++;
            }
        }
        return minSwaps;
    }


    @Test
    public void testSolveMinSwaps(){
        var couples = new Integer[]{1,2,5,0,3,4};
        Assert.assertEquals(2,solveMinSwaps(couples));
    }
}
