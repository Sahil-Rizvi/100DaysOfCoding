package practice;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class DayTwentyTwo {

    public static int findSmallestDistance(String sentence, String word1, String word2){
        var words = Arrays.stream(sentence.split(" ")).collect(Collectors.toList());
        var word1Indices = new ArrayList<Integer>();
        var word2Indices = new ArrayList<Integer>();
        var minDistance = Integer.MAX_VALUE;
        for(var i=0;i<words.size();i++){
            if(words.get(i).equals(word1)){
                word1Indices.add(i);
            } else if(words.get(i).equals(word2)){
                word2Indices.add(i);
            }
        }
        if(word1Indices.isEmpty() || word2Indices.isEmpty()){
            return minDistance;
        }
        var i = 0;
        var j = 0;

        while(i < word1Indices.size() && j < word2Indices.size()){
            var currentDistance = Math.abs(word1Indices.get(i) - word2Indices.get(j));
            if(currentDistance < minDistance){
                minDistance = currentDistance;
            }
            if(word1Indices.get(i) < word2Indices.get(j)){
                i++;
            } else{
                j++;
            }
        }
        return minDistance - 1;
    }

    @Test
    public void test(){
        System.out.println(findSmallestDistance("dog cat hello cat dog dog hello cat world", "hello", "world"));
    }
}
