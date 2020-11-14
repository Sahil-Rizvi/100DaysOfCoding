package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DaySixteen {

    public static List<Integer> findAllStartingIndices(String W, String S){
        var list = new ArrayList<Integer>();
        // mlogm
//        W = Stream.of(W.split("")).sorted().collect(Collectors.joining());
        for(var i=0;i<S.length()-W.length()+1;i++){
            var tempString = S.substring(i,i+W.length());
//            if(Stream.of(tempString.split("")).sorted().collect(Collectors.joining()).equals(W)){
//                list.add(i);
//            }
            if(tempString.equals(W)){
                list.add(i);
            }
        }
        return list;
    }

    public static List<Integer> findAllStartingIndices1(String W, String S){
        var list = new ArrayList<Integer>();
        for(var i=0;i<S.length()-W.length()+1;i++){
            var tempString = S.substring(i,i+W.length());
            if(XORTwoStrings(tempString, W)==0){
                list.add(i);
            }
        }
        return list;
    }

    private static int XORTwoStrings(String one,String two){
        var result = 0;
        for(var i=0;i<one.length();i++){
            result ^= one.charAt(i) ^ two.charAt(i);
        }
        return result;
    }


    public static void main(String... args){
        System.out.println(findAllStartingIndices1("ab","abxaba"));
//        System.out.println(findAllStartingIndices("ba",new StringBuilder("abxaba").reverse().toString()));
//        System.out.println(XORTwoStrings("naac","nac1"));
    }
}
