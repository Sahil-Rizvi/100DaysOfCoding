package practice;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

public class DayTwentyFive {


    public static int findDuplicateElement(Integer[] arr){
        return Arrays.stream(arr).mapToInt(Integer::intValue).sum() - IntStream.range(1, arr.length).sum();
    }

    public static int findDuplicateElementUsingXOR(Integer[] arr){
        return Arrays.stream(arr).mapToInt(Integer::intValue).reduce(0, (first,second) -> first^second) ^ IntStream.range(1, arr.length).reduce(0, (first,second) -> first^second);
    }


    @Test
    public void test(){
        Assert.assertEquals(5,findDuplicateElement(new Integer[]{4,1,2,5,3,5}));
        Assert.assertEquals(5,findDuplicateElementUsingXOR(new Integer[]{4,1,2,5,3,5}));
    }

}
