package practice;

import org.junit.Test;

import java.util.*;

public class DayFortySeven {

    public static int solve(List<Integer> numbers, List<Double> probabilities, double p){
        var sum = 0.0;
        var r = p;
        for(var i=0;i<probabilities.size();i++){
            sum+=probabilities.get(i);
            if(sum>=r){
                return numbers.get(i);
            }
        }
        return -1;
    }


    private int binarySearch(List<Double> list, double val){

        if(val < list.get(0)){
            return 0;
        }

        if(val > list.get(list.size()-1)){
            return -1;
        }

        var low = 0;
        var high = list.size()-1;
        while(high - low > 0){
            var mid = low+(high-low)/2;
            if(list.get(mid) == val){
                return mid;
            } else if(list.get(mid) < val){
                low = mid+1;
            } else{
                high = mid;
            }
        }
        return low;
    }

    public int solve_(List<Integer> numbers, List<Double> probabilities, double p){
        var cumulativeProbabilities = new ArrayList<Double>(probabilities.size());
        var currentValue = 0.0;
        for(var prob:probabilities){
            currentValue+=prob;
            cumulativeProbabilities.add(currentValue);
        }

        //var p = Math.random();
        var ans = binarySearch(cumulativeProbabilities, p);

        if(ans !=-1){
            return ans+1;
        }
        return ans;


    }

    @Test
    public void test(){
        var numbers = Arrays.asList(1, 2, 3, 4);
        var probabilities = Arrays.asList(0.1,0.5,0.2,0.2);
        var p = Math.random();
        System.out.println(p);
        System.out.println(solve(numbers,probabilities, p));
        System.out.println(solve_(numbers,probabilities, p));
        //System.out.println(binarySearch(Arrays.asList(0.1,0.6,0.8,1.0),0.7876));
    }
}
