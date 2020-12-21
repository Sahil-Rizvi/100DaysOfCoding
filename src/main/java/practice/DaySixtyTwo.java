package practice;

import org.junit.Assert;
import org.junit.Test;

public class DaySixtyTwo {

    private static String encode(String string){
        if(string==null || string.isEmpty()){
            return string;
        }
        StringBuilder stringBuilder = new StringBuilder();
        var count = 1;

        for(var i=1;i<string.length();i++){
            if(string.charAt(i) == string.charAt(i-1)){
                count++;
            } else {
                stringBuilder.append(count).append(string.charAt(i-1));
                count = 1;
            }
        }
        return stringBuilder.append(count).append(string.charAt(string.length()-1)).toString();
    }

    @Test
    public void test(){
        Assert.assertEquals("4A3B2C1D2A",encode("AAAABBBCCDAA"));
        Assert.assertEquals("",encode(""));
        Assert.assertNull(encode(null));
        Assert.assertEquals("1A",encode("A"));
        Assert.assertEquals("1A5B1A",encode("ABBBBBA"));
    }


}
