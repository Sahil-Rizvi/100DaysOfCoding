package practice;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class DayNine {
    public static int longestDistinctSubArray(Integer[] arr){
        var mappings = new HashMap<Integer,Integer>();
        var start = -1;
        var maxSize = 0;
        for(var i=0;i<arr.length;i++){
            var prevIndex = mappings.get(arr[i]);
            if(prevIndex!=null){
                start = Math.max(start,prevIndex);
            }
            mappings.put(arr[i], i);
            maxSize = Math.max(maxSize, i-start);
        }
        return maxSize;
    }

    @Test
    public void test(){
        Assert.assertEquals(5,DayNine.longestDistinctSubArray(new Integer[]{1, 2, 3, 4, 5, 1, 2, 3}));
    }
}
