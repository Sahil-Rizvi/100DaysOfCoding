package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DayFiftyFive {
    public static List<Integer> solve(List<Integer> list){
        return list.stream().map(e -> Math.pow(e,2)).map(Double::intValue).sorted().collect(Collectors.toList());
    }

    public static void main(String... args){
        System.out.println(solve(Arrays.asList(-9, -2, 0, 2, 3)));
        System.out.println(solveOptimized(Arrays.asList(-9, -2, -1, 0, 2, 9, 25)));
    }

    public static List<Integer> solveOptimized(List<Integer> list){
        var negativeNumbers = list.stream().filter(e -> e < 0).collect(Collectors.toList());
        var positiveNumbersSquared = list.stream().filter(e -> e >= 0).map(e-> e*e).collect(Collectors.toList());
        Collections.reverse(negativeNumbers);
        var negativeNumbersSquared = negativeNumbers.stream().map(e -> e*e).collect(Collectors.toList());

        var i = 0;
        var j = 0;
        var result = new ArrayList<Integer>();
        while( i < negativeNumbersSquared.size() && j < positiveNumbersSquared.size()){
            if(negativeNumbersSquared.get(i) < positiveNumbersSquared.get(j)){
                result.add(negativeNumbersSquared.get(i));
                i++;
            } else if(negativeNumbersSquared.get(i) > positiveNumbersSquared.get(j)){
                result.add(positiveNumbersSquared.get(j));
                j++;
            } else{
                result.add(negativeNumbersSquared.get(i));
                result.add(positiveNumbersSquared.get(i));
                i++;
                j++;
            }
        }

        while(i < negativeNumbersSquared.size()){
            result.add(negativeNumbersSquared.get(i));
            i++;
        }
        while(j < positiveNumbersSquared.size()){
            result.add(positiveNumbersSquared.get(j));
            j++;
        }
        return result;
    }

}
