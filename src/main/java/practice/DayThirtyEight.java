package practice;

import java.util.*;

import static java.util.Collections.swap;

public class DayThirtyEight {

    private ArrayList<Integer> getNextPermutationUtil(ArrayList<Integer> l){
        var i = l.size()-1;
        while(i>=1 && l.get(i-1)>l.get(i)){
            i--;
        }

        var boundary = i - 1;
        if(boundary==-1){
            return null;
        }
        i = l.size()-1;

        while(i>=0 && l.get(boundary)>l.get(i)){
            i--;
        }
        Collections.swap(l, i, boundary);
        Collections.reverse(l.subList(boundary+1, l.size()));
        return l;
    }

    public ArrayList<ArrayList<Integer>> getNextPermutation(ArrayList<Integer> l){
         l.sort((Comparator.comparingInt(l1 -> l1))); // O(nlogn)
         var temp = new ArrayList<>(l);
         var res = new ArrayList<ArrayList<Integer>>();
         res.add(temp);
         while((temp = getNextPermutationUtil(l))!=null){ // 0(n!)
             res.add(new ArrayList<>(temp));
         }
         return res;
    }


    public ArrayList<List<Integer>> getPermutations(List<Integer> list){
        return getPermutationsUtil(list, 0);
    }

    private ArrayList<List<Integer>> getPermutationsUtil(List<Integer> list, int index) {
        if(index==list.size()-1){
            var t = new ArrayList<List<Integer>>();
            t.add(list);
            return t;
        }

        var result = new ArrayList<List<Integer>>();
        for(var i=index;i<list.size();i++){
            swap(list, index, i);
            getPermutationsUtil(list,index+1).forEach(e -> result.add(new ArrayList<>(e)));
            swap(list, index, i);
        }
        return result;
    }

    public static void main(String... args){
        var test = new ArrayList<>(Arrays.asList(1,2,3));
        System.out.println(new DayThirtyEight().getPermutations(test));
        System.out.println(new DayThirtyEight().getNextPermutation(test));

    }



}
