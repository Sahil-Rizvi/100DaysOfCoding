package practice;

import java.util.ArrayList;
import java.util.List;

public class DayTwentyNine {

    private static List<Integer> grayCode(int n){
        if(n==0){
            return new ArrayList<>();
        }
        if(n==1){
            return new ArrayList<>(){
                {
                    add(0);
                    add(1);
                }
            };
        }
        var prevAns = grayCode(n-1);
        var result = new ArrayList<Integer>();
        result.addAll(prevAns);

        for(var j = prevAns.size()-1;j>=0;j--){
            result.add((1<<(n-1)) | prevAns.get(j));
        }
        return result;
    }

    public static void main(String... args){
        var n = 4;
        System.out.println(grayCode(n));
    }
}
