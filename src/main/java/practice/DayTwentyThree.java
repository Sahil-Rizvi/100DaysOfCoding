package practice;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

public class DayTwentyThree {

    public boolean isPermutationPalindrome(String s){
        var map = new HashMap<Character,Integer>();
        for(var i=0;i<s.length();i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        var oddCount = 0;
        for(Integer integer: map.values()) {
            if((integer&1)!=0){
                oddCount++;
            }
        }
        return oddCount<=1;
    }

    public boolean isPermutationPalindrome1(String s){
        var map = new Integer[128];
        Arrays.fill(map, 0);
        var numOdds = 0;
        for(var i=0;i<s.length();i++){
            map[s.charAt(i)]++;
            if((map[s.charAt(i)]&1)!=0){
                numOdds++;
            }
            else{
                numOdds--;
            }
        }
        return numOdds<=1;
    }

    @Test
    public void test(){
        Assert.assertTrue(isPermutationPalindrome("racecar"));
        Assert.assertFalse(isPermutationPalindrome("daily"));

        Assert.assertTrue(isPermutationPalindrome1("racecar"));
        Assert.assertFalse(isPermutationPalindrome1("daily"));
    }
}
