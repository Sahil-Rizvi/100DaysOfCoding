package practice;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DayFiftyNine {

    private static final int MAX_PARTS = 4;

    public static List<String> solve(String str, int index, List<String> parts){
        var resultList = new ArrayList<String>();
        if(!parts.isEmpty()){
            String lastPart = parts.get(parts.size()-1);
            if(lastPart.length()>1 && lastPart.startsWith("0")){
                return resultList;
            }
            if(lastPart.length()>2 && Integer.parseInt(lastPart) > 255){
                return resultList;
            }
        }

        if(index==str.length()){
            if(parts.size()==MAX_PARTS){
                resultList.add(String.join(".", parts));
            }
            return resultList;
        }

        for(var k=1;k<=MAX_PARTS-1 && k+index<=str.length();k++){
            parts.add(str.substring(index, index+k));
            var temp = solve(str, index+k, parts);
            resultList.addAll(temp);
            parts.remove(parts.size()-1);
        }
        return resultList;
    }


    public static List<String> solve1(String string,int index, List<String> parts){
        if(index == string.length()){
            if(parts.size() == MAX_PARTS){
                return Collections.singletonList(String.join(".", parts));
            }
            return new ArrayList<>();
        }

        parts.add(string.substring(index, index+1));
        var result = new ArrayList<>(solve1(string,index + 1, parts));
        parts.remove(parts.size()-1);

        if(index+2 <= string.length() && string.charAt(index)!='0'){
            parts.add(string.substring(index, index+2));
            result.addAll(solve1(string, index + 2, parts));
            parts.remove(parts.size()-1);
        }

        if(index+3 <= string.length() && Integer.parseInt(string.substring(index, index+3)) <= 255){
            parts.add(string.substring(index, index+3));
            result.addAll(solve1(string, index + 3, parts));
            parts.remove(parts.size()-1);
        }

        return result;

    }

    @Test
    public void test(){
        System.out.println(solve("25525511135",0, new ArrayList<>()));
        System.out.println(solve1("25525511135",0, new ArrayList<>()));
    }

}
