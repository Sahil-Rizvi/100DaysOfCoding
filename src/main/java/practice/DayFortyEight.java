package practice;

import java.util.*;

public class DayFortyEight {

    private static class Node{
        char val;
        List<Set<Node>> edges = new ArrayList<>();
        Node(char val){
            this.val = val;
            for(var i=0;i<4;i++){
                edges.add(new HashSet<>());
            }
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    }

    public static final int N = 0;
    public static final int S = 1;
    public static final int E = 2;
    public static final int W = 3;
    public static final int[] DIRS = {N,S,E,W};

    public static final Map<Character, Integer> charToDir = new HashMap<>();
    static {
        charToDir.put('N', N);
        charToDir.put('S', S);
        charToDir.put('E', E);
        charToDir.put('W', W);
    }

    public static boolean validate(String[] rules){
        var map = new HashMap<Character,Node>();
        for(String line: rules){
            String[] rule = line.split(" ");
            System.out.println("Rule "+rule[0]+" "+rule[1]+" "+rule[2]);
            char fromValue = rule[0].charAt(0);
            char toValue = rule[2].charAt(0);

            if(!map.containsKey(fromValue)){
                var node = new Node(fromValue);
                map.put(fromValue, node);
            }

            if(!map.containsKey(toValue)){
                var node = new Node(toValue);
                map.put(toValue, node);
            }

            var fromNode = map.get(fromValue);
            var toNode = map.get(toValue);

            for(char dirChar :rule[1].toCharArray()){
                int dir = charToDir.get(dirChar);
                if(!isValid(map, fromNode, toNode, dir)){
                    return false;
                }
                addEdges(map, fromNode, toNode, dir);
                System.out.println(fromNode.edges.get(dir));
                System.out.println(toNode.edges.get(opposite(dir)));
            }
        }
        return true;
    }

    private static boolean isValid(Map<Character, Node> map, Node fromNode, Node toNode, int dir) {
        var oppositeDir = opposite(dir);
        if(fromNode.edges.get(oppositeDir).contains(toNode)){
            return false;
        }
        return true;
    }

    private static void addEdges(Map<Character, Node> map, Node fromNode, Node toNode, int newDir) {
        var oppositeDir = opposite(newDir);
        fromNode.edges.get(newDir).add(toNode);
        toNode.edges.get(oppositeDir).add(fromNode);

        for(int dir: DIRS){
            if(dir == newDir){
                continue;
            }

            for(var neighbour: fromNode.edges.get(dir)){
                if(neighbour==toNode){
                    continue;
                }
                neighbour.edges.get(newDir).add(toNode);
                toNode.edges.get(oppositeDir).add(fromNode);
            }
        }
    }

    private static int opposite(int dir){
        return (dir+2)%4;
    }


    private static void test1(){
        var rules = new String[]{"A N B",
                        "C SE B",
                        "C N A"};
        System.out.println(validate(rules));
    }

    private static void test2(){
        var rules = new String[]{"A NW B",
                "A N B"};
        System.out.println(validate(rules));
    }

    private static void test3(){
        var rules = new String[]{"A N B",
                "C N B"};
        System.out.println(validate(rules));
    }

    public static void main(String... args){
        test1();
        test2();
        test3();
    }
}
