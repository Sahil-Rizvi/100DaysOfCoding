package practice;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class DaySixteen1 {

    private static final int MAX_LENGTH = 256;;

    public static ArrayList<Integer> findAnagramIndices(String s,String w){
        var indices = new ArrayList<Integer>();
        var window = w.length();
        if(s.length()<w.length()){
            return indices;
        }

        var countS = new Integer[MAX_LENGTH];
        var countW = new Integer[MAX_LENGTH];
        Arrays.fill(countS,0);
        Arrays.fill(countW,0);
        for(var i=0;i<window;i++){
            countW[w.charAt(i)]++;
            countS[s.charAt(i)]++;
        }

        for(var i= window;i<s.length();i++){
            if(isAnagram(countS,countW)){
                indices.add(i-window);
            }
            countS[s.charAt(i)]++;
            countS[s.charAt(i-window)]--;
        }

        if(isAnagram(countS,countW)){
            indices.add(s.length()-window);
        }
        return indices;
    }

    private static boolean isAnagram(Integer[] countS, Integer[] countW) {
        for(var i=0;i<MAX_LENGTH;i++){
            if(countS[i]!=countW[i]){
                return false;
            }
        }
        return true;
    }

    @Test
    public void test(){
        Assert.assertEquals(Arrays.asList(0,5,6),findAnagramIndices("BACDGABCDA","ABCD"));
        Assert.assertEquals(Arrays.asList(0,1,4),findAnagramIndices("AAABABAA","AABA"));
        Assert.assertEquals(Arrays.asList(0,3,4),findAnagramIndices("abxaba","ab"));
    }
}
