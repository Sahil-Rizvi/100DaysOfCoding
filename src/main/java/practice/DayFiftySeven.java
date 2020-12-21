package practice;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DayFiftySeven {

    public static int maxProfit(List<Integer> prices){
        var minimumSoFar = prices.get(0);
        var maximumProfit = 0;
        for(var i=1;i<prices.size();i++){
            maximumProfit = Math.max(prices.get(i) - minimumSoFar,maximumProfit);
            minimumSoFar = Math.min(minimumSoFar, prices.get(i));
        }
        return maximumProfit;
    }

    @Test
    public void test(){
        Assert.assertEquals(5, maxProfit(Arrays.asList(9, 11, 8, 5, 7, 10)));
        Assert.assertEquals(8, maxProfit(Arrays.asList(2, 3, 10, 6, 4, 8, 1)));
        Assert.assertEquals(2, maxProfit(Arrays.asList(7, 9, 5, 6, 3, 2)));
        Assert.assertEquals(0, maxProfit(Arrays.asList(90, 80, 70, 60, 50)));
        Assert.assertEquals(5, maxProfit(Arrays.asList(7, 1, 5, 3, 6, 4)));
        Assert.assertEquals(0, maxProfit(Arrays.asList(7, 6, 4, 3, 1)));
    }

}
