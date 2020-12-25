package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DaySixtyFive {

    private static boolean isPalindrome(String s){
        return new StringBuilder(s).reverse().toString().equals(s);
    }

    public static ArrayList<List<Integer>> solve(List<String> words){
        var result = new ArrayList<List<Integer>>();
        for(var i=0;i<words.size();i++){
            for(var j=0;j<words.size();j++){
                if(i!=j){
                    if(isPalindrome(words.get(i).concat(words.get(j)))){
                        result.add(List.of(i,j));
                    }
                }
            }
        }
        return result;
    }

    private static String reverse(String s){
        return new StringBuilder(s).reverse().toString();
    }

    public static ArrayList<List<Integer>> solveOptimized(List<String> words){
        var indexMapping = new HashMap<String , Integer>();
        for(var i=0;i<words.size();i++){
            indexMapping.put(words.get(i), i);
        }

        var result = new ArrayList<List<Integer>>();
        for(var i=0;i<words.size();i++){
            String word = words.get(i);
            for(var j=0;j<word.length();j++){
                var prefix = word.substring(0, j);
                var suffix = word.substring(j);
                var reversedPrefix = reverse(prefix);
                var reversedSuffix = reverse(suffix);

                if(isPalindrome(prefix) && indexMapping.containsKey(reversedSuffix)){
                    var index = indexMapping.get(reversedSuffix);
                    if(index!=i){
                        result.add(List.of(i, index));
                    }
                }

                if(isPalindrome(suffix) && indexMapping.containsKey(reversedPrefix)){
                    var index = indexMapping.get(reversedPrefix);
                    if(index!=i){
                        result.add(List.of(i, index));
                    }
                }
            }
        }
        return result;
    }



    public static void main(String... args){
        var wordsList = Arrays.asList("code", "edoc", "da", "d");
        System.out.println(solve(wordsList));
        System.out.println(solveOptimized(wordsList));
    }

}
