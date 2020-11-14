package practice;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

public class DayTwelve1 {
    public static boolean oneToOneMapping(String s1, String s2){
        if(s1.length()!=s2.length()){
            return false;
        }
        var mapping = new HashMap<Character, Character>();
        var marked = new Boolean[256];
        Arrays.fill(marked,false);
        for(var i=0;i<s1.length();i++){
            if(!mapping.containsKey(s1.charAt(i))){
                if(marked[s2.charAt(i)]){
                    return false;
                }
                marked[s2.charAt(i)] = true;
                mapping.put(s1.charAt(i), s2.charAt(i));
            }
            else{
                if(mapping.get(s1.charAt(i))!=s2.charAt(i)){
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    public void test(){
        Assert.assertTrue(DayTwelve1.oneToOneMapping("abc", "bcd"));
        Assert.assertFalse(DayTwelve1.oneToOneMapping("foo", "bar"));
        Assert.assertFalse(DayTwelve1.oneToOneMapping("ac", "bb"));
    }
}
