package practice;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class DayFortySix {

    public static Integer nearest(List<Integer> list, int index){
        for(var j = 1;j<list.size();j++){
            var low = index - j;
            var high = index + j;

            if(low >= 0 && list.get(low) > list.get(index)){
                return low;
            } else if(high < list.size() && list.get(high) > list.get(index)){
                return high;
            }
        }
        return null;
    }

    public static List<Integer> preProcess(List<Integer> list){
        var distances = new ArrayList<Integer>(list.size());
        IntStream.range(0,list.size()).forEach( e -> distances.add(null));
        for(var i=0;i<list.size()-1;i++){
            if(list.get(i+1) > list.get(i)){
                distances.set(i, i+1);
            } else if(list.get(i+1) < list.get(i)){
                distances.set(i+1, i);
            }
        }

        for(var i=0;i<distances.size();i++){
            if(distances.get(i) == null){
                distances.set(i, nearest(list,i));
            }
        }
        return distances;
    }


    public static Integer nearest_(List<Integer> list, int index){
        var cache_ = preProcess(list);
        return cache_.get(index);
    }


    @Test
    public void test(){
        var list = Arrays.asList(4, 1, 3, 5, 6);
        System.out.println(nearest(list, 0));
        System.out.println(nearest_(list, 0));
    }
}
