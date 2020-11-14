package practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DayTwentyFour {

    public static List<Integer> solve(List<List<Integer>> intervals){
        intervals.sort(Comparator.comparing(l->l.get(0)));

        var result = new ArrayList<Integer>();
        var i = 0;
        while(i<intervals.size()){
            var interval = intervals.get(i);
            while(i<intervals.size() && intersecting(interval, intervals.get(i))){
                var intervalTemp = new ArrayList<Integer>(2);
                intervalTemp.add(Math.max(intervals.get(i).get(0), interval.get(0)));
                intervalTemp.add(Math.min(intervals.get(i).get(1), interval.get(1)));
                interval = intervalTemp;
                i++;
            }
            result.add(interval.get(1));
        }
        return result;
    }

    public static boolean intersecting(List<Integer> x, List<Integer> y){
        return !(y.get(1) < x.get(0) || y.get(0) > x.get(1));
    }




    public static void main(String... args){
//         var intervals = new ArrayList<List<Integer>>();
//         var interval1 = new ArrayList<Integer>();
//         interval1.add(10);
//         interval1.add(20);
//         intervals.add(interval1);
//
//         interval1 = new ArrayList<Integer>();
//         interval1.add(1);
//         interval1.add(6);
//         intervals.add(interval1);
//
//         interval1 = new ArrayList<Integer>();
//         interval1.add(3);
//         interval1.add(8);
//         intervals.add(interval1);
//
//         interval1 = new ArrayList<Integer>();
//         interval1.add(7);
//         interval1.add(12);
//         intervals.add(interval1);

        var intervals = new ArrayList<List<Integer>>();
        var interval1 = new ArrayList<Integer>();
        interval1.add(0);
        interval1.add(3);
        intervals.add(interval1);

        interval1 = new ArrayList<Integer>();
        interval1.add(2);
        interval1.add(6);
        intervals.add(interval1);

        interval1 = new ArrayList<Integer>();
        interval1.add(3);
        interval1.add(4);
        intervals.add(interval1);

        interval1 = new ArrayList<Integer>();
        interval1.add(6);
        interval1.add(9);
        intervals.add(interval1);

        System.out.println(solve(intervals));


    }
}
