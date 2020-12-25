package practice;

import org.junit.Assert;
import org.junit.Test;

public class DaySixtyTwo {


    private static String encode(String string){
        if(string==null || string.isEmpty()){
            return string;
        }
        var count = 1;
        var stringBuilder = new StringBuilder();
        for(var i=1;i<string.length();i++){
            if(string.charAt(i) == string.charAt(i-1)){
                count++;
            } else{
                stringBuilder.append(count).append(string.charAt(i-1));
                count = 1;
            }
        }
        return stringBuilder.append(count).append(string.charAt(string.length()-1)).toString();
    }

    private static String decode(String string){
        if(string==null || string.isEmpty()){
            return string;
        }
        var stringBuilder = new StringBuilder();
        var count = 0;
        for(var i=0;i<string.length();i++){
            if(Character.isDigit(string.charAt(i))){
                count = count*10 + string.charAt(i)-48;
            } else {
                stringBuilder.append(String.valueOf(string.charAt(i)).repeat(count));
                count=0;
            }
        }
        return stringBuilder.toString();
    }

    @Test
    public void test(){
        Assert.assertEquals("4A3B2C1D2A", encode("AAAABBBCCDAA"));
        Assert.assertEquals("", encode(""));
        Assert.assertNull(encode(null));
        Assert.assertEquals("1A", encode("A"));
        Assert.assertEquals("1A5B1A", encode("ABBBBBA"));


        Assert.assertEquals("AAAABBBCCDAA", decode("4A3B2C1D2A"));
        Assert.assertEquals("", decode(""));
        Assert.assertNull(decode(null));
        Assert.assertEquals("A", decode("1A"));
        Assert.assertEquals("ABBBBBA", decode("1A5B1A"));

    }


}
