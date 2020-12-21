package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DayFiftySix {

    public static ArrayList<List<Integer>> solve(List<List<Integer>> list){
        var result = new ArrayList<List<Integer>>();

        list.sort(Comparator.comparingInt(e-> e.get(0)));

        var previous = list.get(0);
        result.add(previous);
        for(var i=1;i<list.size();i++){
            if(list.get(i).get(0) < previous.get(1) ){
                var mergedInterval = new ArrayList<Integer>();
                mergedInterval.add(Math.min(list.get(i).get(0), previous.get(0)));
                mergedInterval.add(Math.max(list.get(i).get(1), previous.get(1)));
                result.set(result.size()-1, mergedInterval);
            } else{
                result.add(list.get(i));
            }
            previous = result.get(result.size()-1);
        }
        return result;
    }

    public static void main(String... args){
        var list = new ArrayList<List<Integer>>();
        list.add(Arrays.asList(6,8));
        list.add(Arrays.asList(1,9));
        list.add(Arrays.asList(2,4));
        list.add(Arrays.asList(4,7));

        System.out.println(solve(list));

        var list1 = new ArrayList<List<Integer>>();
        list1.add(Arrays.asList(1,3));
        list1.add(Arrays.asList(5,8));
        list1.add(Arrays.asList(4,10));
        list1.add(Arrays.asList(20,25));

        System.out.println(solve(list1));

    }

}
