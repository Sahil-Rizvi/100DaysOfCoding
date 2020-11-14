package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DaySix {

    public static boolean isOverlapping(ArrayList<Integer> list1, ArrayList<Integer> list2){
        if(list1.get(1) > list2.get(0)){
            return true;
        }
        return false;
    }

    public static int solve(ArrayList<ArrayList<Integer>> list){
        list.sort(Comparator.comparing(l -> l.get(0)));
        var ans = 0;
        var i =0;
        var j = i+1;
        while(j<list.size()){
            if(isOverlapping(list.get(i), list.get(j))){
                ans++;
            }
            else{
                i =j;
            }
            j++;
        }
        return ans;
    }

    public static void main(String... args){
        var list = new ArrayList<ArrayList<Integer>>();
        list.add(new ArrayList<>(Arrays.asList(7,9)));
        list.add(new ArrayList<>(Arrays.asList(2,4)));
        list.add(new ArrayList<>(Arrays.asList(5,8)));
        System.out.println(new DaySix().solve(list));
        System.out.println(new DaySix().solveNonOverlapping(list));
    }

    public static int solveNonOverlapping(ArrayList<ArrayList<Integer>> list){
        list.sort(Comparator.comparing(l->l.get(1)));
        var prevEnd = list.get(0).get(1);
        var ans = 0;
        for(var i=1;i<list.size();i++){
            if(prevEnd > list.get(i).get(0)){
                ans++;
                continue;
            }
            prevEnd = list.get(i).get(1);
        }
        return ans;
    }

}
