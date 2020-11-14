package practice;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class DayTwelve {

    public static boolean isOneToOneMapping(String str1, String str2){
        if(str1.length()!=str2.length()){
            return false;
        }
        var i = 0;
        var j = 0;
        while(i < str1.length() && j < str2.length()){
            var count1 = 1;
            var count2 = 1;
            while (i+1 < str1.length() && str1.charAt(i) == str1.charAt(i+1)){
                count1++;
                i++;
            }
            while (j+1 < str2.length() && str2.charAt(j) == str2.charAt(j+1)){
                count2++;
                j++;
            }
            if(count1!=count2){
                return false;
            }
            i++;
            j++;
        }
        return true;
    }

//    public static boolean areIsomorphic(String str1, String str2){
//        if(str1.length()!=str2.length()){
//            return false;
//        }
//        final var MAX_SIZE = 256;
//        var mapping = new int[MAX_SIZE];
//        Arrays.fill(mapping,-1);
//        var isMarked = new boolean[MAX_SIZE];
//        Arrays.fill(isMarked, false);
//        for(var i=0;i<str1.length();i++){
//            var check = mapping[str1.charAt(i)];
//            if(check==-1){ // seen first time in str1
//                if(isMarked[str2.charAt(i)]){
//                    return false;
//                }
//                isMarked[str2.charAt(i)] = true;
//                mapping[str1.charAt(i)] = str2.charAt(i);
//            } else{
//                if(check!=str2.charAt(i)){
//                    return false;
//                }
//            }
//        }
//
//        return true;
//    }


    public static boolean areIsomorphic(String str1,String str2){
        if(str1.length()!=str2.length()){
            return false;
        }
        final int MAX_SIZE = 256;
        var mappings = new int[MAX_SIZE];
        Arrays.fill(mappings,-1);
        var isAlreadyMapped = new boolean[MAX_SIZE];
        Arrays.fill(isAlreadyMapped,false);

        for(var i=0;i<str1.length();i++){
            var mapping = mappings[str1.charAt(i)];
            if(mapping==-1){
                if(isAlreadyMapped[str2.charAt(i)]){
                    return false;
                }
                mappings[str1.charAt(i)] = str2.charAt(i);
                isAlreadyMapped[str2.charAt(i)] = true;
            }
            else if(mapping!=str2.charAt(i)){
                return false;
            }
        }
        return true;
    }

    @Test
    public void testIsOneToOneMapping(){
        var str1 = "aaccccba";
        var str2 = "bbdddebb";
        Assert.assertFalse(isOneToOneMapping(str1, str2));
        Assert.assertFalse(areIsomorphic(str1, str2));
//        str1 = "aab";
//        str2 = "xyz";
//        Assert.assertFalse(isOneToOneMapping(str1, str2));
//        Assert.assertFalse(areIsomorphic(str1, str2));
    }

}
