package practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DayFiftyFive {
    public static List<Integer> solve(List<Integer> list){
        return list.stream().map(e -> Math.pow(e,2)).map(Double::intValue).sorted().collect(Collectors.toList());
    }

    public static void main(String... args){
        System.out.println(solve(Arrays.asList(-9, -2, 0, 2, 3)));
    }

}
