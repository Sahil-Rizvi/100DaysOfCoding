package practice;

import java.util.*;

public class DayFortyOne {
    private static class Graph{
        private Map<Integer, List<Integer>> adjacencyList = new LinkedHashMap<>();

        public void addEdge(int v1, int v2){
            var list = adjacencyList.get(v1);
            if(list ==null){
                list = new ArrayList<>();
            }
            list.add(v2);
            adjacencyList.put(v1, list);

            list = adjacencyList.get(v2);
            if(list ==null){
                list = new ArrayList<>();
            }
            list.add(v1);
            adjacencyList.put(v2, list);
        }

        void print(){
            adjacencyList.forEach((k,v)->{
                System.out.print(k + " -> ");
                v.forEach( val -> System.out.print(val+" , "));
                System.out.println();
            });
        }

    }

    public static boolean isMinimalConnected(Graph g){
        var noOfVertices = g.adjacencyList.size();
        var noOfEdges = 0;
        for(var mapEntry: g.adjacencyList.entrySet()){
            noOfEdges += mapEntry.getValue().size();
        }
        return noOfEdges/2 == noOfVertices-1;
    }



    public static void main(String... args){
        var graph = new Graph();
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(3,4);
        graph.addEdge(4,1);

        graph.print();
        System.out.println(isMinimalConnected(graph));

        graph = new Graph();
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(3,4);

        graph.print();
        System.out.println(isMinimalConnected(graph));

        graph = new Graph();
        graph.addEdge(1,4);
        graph.addEdge(4,3);
        graph.addEdge(3,2);
        graph.addEdge(2,1);

        graph.print();
        System.out.println(isMinimalConnected(graph));

    }
}
