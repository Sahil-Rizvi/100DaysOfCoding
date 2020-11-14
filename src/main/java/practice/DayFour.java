package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class DayFour {


    private static List<Integer> swap(List<Integer> row, int i, ArrayList<Integer> positions) {
        var partner = -1;
        if(row.get(i)%2 == 0){
            partner = positions.get(row.get(i)/2*2+1);
        }
        else{
            partner = positions.get(row.get(i)/2*2);
        }

        var temp = row.get(1-i);
        row.set(1-i, row.get(partner));
        row.set(partner, temp);
        return row;
    }


    private static int minSwapsUtil(List<Integer> row, ArrayList<Integer> positions) {
        if(row.size()==0){
            return 0;
        }
        if(row.get(0)/2 == row.get(1)/2){
            return minSwapsUtil(row.subList(2, row.size()), positions);
        }
        else{
            var first = swap(row, 0, positions);
            var second = swap(row, 1, positions);
//            for(var i =0;i<positions.size();i++){
//                positions.set(i, positions.get(i)-2);
//            }
            return 1 + Math.min(minSwapsUtil(first.subList(2, first.size()), positions), minSwapsUtil(second.subList(2, second.size()), positions));
        }
    }


    public static int minSwaps(List<Integer> row){
        var positions = new ArrayList<Integer>(row.size());
        for(var i=0 ; i <row.size(); i++){
            positions.add(-1);
        }
        for(var i=0 ; i <row.size(); i++){
            positions.set(row.get(i),i);
        }
        return minSwapsUtil(row,positions);
    }

    public static int maxDistinct(Integer[] arr){
        var ans = 0;
        var indexMap = new HashMap<Integer, Integer>();
        var j = 0;
        for(var i=0;i<arr.length;i++){
            j = Math.max(indexMap.getOrDefault(arr[i], -1),j);
            ans = Math.max(ans, i - j);
            indexMap.put(arr[i], i);
        }
        return ans;
    }

    public static void main(String... args){
        System.out.println(maxDistinct(new Integer[]{5, 1, 3, 5, 2, 3, 4, 1}));
    }
}
