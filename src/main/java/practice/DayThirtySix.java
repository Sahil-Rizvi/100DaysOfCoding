package practice;

import java.util.HashMap;
import java.util.Map;

public class DayThirtySix {

    public static HashMap<Character, Integer> solve(Character startState, Map<Character,Map<Character,Double>> probabilities, int noOfSteps){
        var counts = new HashMap<Character,Integer>();
        var currentState = startState;
        for(var i=0;i<noOfSteps;i++){
            counts.put(currentState, counts.getOrDefault(currentState, 0) + 1);
            var nextState = getNextState(currentState, probabilities);
            currentState = nextState;
        }
        return counts;
    }

    private static Character getNextState(Character currentState, Map<Character,Map<Character,Double>> probabilities){
        var random = Math.random();
        for(var probabilisticStates : probabilities.get(currentState).entrySet()){
            random-= probabilisticStates.getValue();
            if(random<=0){
                return probabilisticStates.getKey();
            }
        }
        return null;
    }

    public static void main(String... args){
        Map<Character, Map<Character,Double>> probabilities = new HashMap<>(){{
            put('a', new HashMap<>(){{
                put('a', 0.9);
                put('b', 0.075);
                put('c', 0.025);
            }});

            put('b', new HashMap<>(){{
                put('a', 0.15);
                put('b', 0.8);
                put('c', 0.05);
            }});

            put('c', new HashMap<>(){{
                put('a', 0.25);
                put('b', 0.25);
                put('c', 0.5);
            }});
        }};

        var ans = solve('a', probabilities, 5000);
        System.out.println(ans);
        System.out.println(ans.values().stream().mapToInt(Integer::intValue).sum());

    }


}
