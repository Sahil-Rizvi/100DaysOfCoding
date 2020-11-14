package practice;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class DayTwenty {


    // time complexity : O(2^n)
    public static ArrayList<Integer> solve(ArrayList<Integer> answer, ArrayList<Integer> array, int index){
        if(index == array.size()){
            return answer;
        }
        if(answer.size()==0){
            answer.add(array.get(index));
            return solve(answer, array, index+1);
        }
        if(array.get(index) % answer.get(answer.size()-1) == 0 || answer.get(answer.size()-1) % array.get(index)==0){
            answer.add(array.get(index));
            return solve(answer, array, index+1);
        }
        var first = solve(new ArrayList<Integer>(), array,index);
        var second = solve(answer, array,index+1);
        return first.size()>second.size()?first:second;
    }


    public static ArrayList<Integer> solveDp(ArrayList<Integer> array){
        array.sort(Integer::compareTo);
        var noOfDivisors = new ArrayList<Integer>(array.size());
        var prevDivisorIndex = new ArrayList<Integer>(array.size());

        for(var i=0;i<array.size();i++){
            noOfDivisors.add(1);
            prevDivisorIndex.add(-1);
        }

        var maxIndex = 0;
        for(var i=0;i<array.size();i++){
            for(var j=0;j<i;j++){
                if(array.get(i) % array.get(j) == 0 && noOfDivisors.get(j)+1 > noOfDivisors.get(i)){
                    noOfDivisors.set(i, noOfDivisors.get(j)+1);
                    prevDivisorIndex.set(i,j);
                }
            }
            if(noOfDivisors.get(maxIndex) < noOfDivisors.get(i)){
                maxIndex = i;
            }
        }

        var result = new ArrayList<Integer>();
        var i = maxIndex;
        while(i>=0){
            result.add(array.get(i));
            i = prevDivisorIndex.get(i);
        }

        var reverse = new ArrayList<Integer>();
        result.stream().collect(Collectors.toCollection(LinkedList::new)).descendingIterator().forEachRemaining(reverse::add);
        return reverse;
    }


    @Test
    public void test(){
        var test = new ArrayList<>(Arrays.asList(1, 3, 6, 24));
        var ans = new ArrayList<Integer>();
        Assert.assertEquals(Arrays.asList(1, 3, 6, 24), solve(ans, test, 0));
        Assert.assertEquals(Arrays.asList(1, 3, 6, 24), solveDp(test));

        test = new ArrayList<>(Arrays.asList(3, 5, 10, 20, 21));
        ans = new ArrayList<Integer>();
        Assert.assertEquals(Arrays.asList(5,10,20), solve(ans, test, 0));
        Assert.assertEquals(Arrays.asList(5,10,20), solveDp(test));
    }

}
