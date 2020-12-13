package practice;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DayFortyFour {

    public List<Integer> nextPermutation(List<Integer> list){
        var i = list.size()-2;
        while(i>=0 && list.get(i) > list.get(i+1)){
            i--;
        }
        if(i>=0){
            var k = list.size()-1;
            while(k>i && list.get(k) < list.get(i)){
                k--;
            }
            if(i!=k){
                Collections.swap(list,i,k);
            }
        }
        var k = list.size()-1;
        for(var j=i+1; j<k;j++,k--){
            Collections.swap(list,j,k);
        }
        return list;
    }

    @Test
    public void test(){
        Assert.assertEquals(Arrays.asList(1,3,2), nextPermutation(Arrays.asList(1,2,3)));
        Assert.assertEquals(Arrays.asList(2,1,3), nextPermutation(Arrays.asList(1,3,2)));
        Assert.assertEquals(Arrays.asList(2,3,1), nextPermutation(Arrays.asList(2,1,3)));
        Assert.assertEquals(Arrays.asList(3,1,2), nextPermutation(Arrays.asList(2,3,1)));
        Assert.assertEquals(Arrays.asList(3,2,1), nextPermutation(Arrays.asList(3,1,2)));
        Assert.assertEquals(Arrays.asList(1,2,3), nextPermutation(Arrays.asList(3,2,1)));
    }

}
