package practice;

import java.util.*;

public class DayEight {
    private Map<Integer, List<Integer>> hashMap = new HashMap<>();

    public void addEdge(int s,int d){
        var list = hashMap.get(s);
        if(list == null){
            list = new ArrayList<>();
            list.add(d);
            hashMap.put(s, list);
        }
        else{
            list.add(d);
        }
    }

    public void traverse(Map<Integer, List<Integer>> hashMap){
        for(var entry:hashMap.entrySet()){
            System.out.print(entry.getKey()+" -> ");
            for(var i=0;i<entry.getValue().size();i++){
                System.out.print(entry.getValue().get(i));
                if(i<entry.getValue().size()-1){
                    System.out.print(",");
                }
            }
            System.out.println();
        }
    }

    public Map<Integer, List<Integer>> getReversedGraph(){
        var transposedGraph = new LinkedHashMap<Integer, List<Integer>>();
        for(var entry:hashMap.entrySet()){
            for(var el:entry.getValue()){
                var list = transposedGraph.get(el);
                if(list==null){
                    list = new ArrayList<>();
                    list.add(entry.getKey());
                    transposedGraph.put(el,list);
                }
                else{
                    list.add(entry.getKey());
                }
            }
        }
        return transposedGraph;
    }

    public static void main(String... args){
        DayEight dayEight = new DayEight();
        dayEight.addEdge(0,2);
        dayEight.addEdge(0,3);
        dayEight.addEdge(1,3);
        dayEight.addEdge(1,4);
        dayEight.addEdge(2,1);
        dayEight.traverse(dayEight.hashMap);
        System.out.println("********************");
        dayEight.traverse(dayEight.getReversedGraph());
    }

}
