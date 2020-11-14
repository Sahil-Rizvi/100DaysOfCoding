package practice;

import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class DayNineteen {
    private static class Node<V>{
        V data;
        Node<V> left;
        Node<V> right;
        Node(V data){
            this.data = data;
        }
    }

    private static void maxLevelSumUtil(Node<Integer> root, int level, HashMap<Integer,Integer> levelSum, AtomicInteger levelWithMaxSum){
        if(root!=null){
            levelSum.put(level, levelSum.getOrDefault(level, 0)+root.data);
            if(levelSum.get(level) > levelSum.get(levelWithMaxSum.get())){
                levelWithMaxSum.set(level);
            }
            maxLevelSumUtil(root.left,level+1,levelSum,levelWithMaxSum);
            maxLevelSumUtil(root.right,level+1,levelSum,levelWithMaxSum);
        }
    }

    public static int maxLevelSum(Node<Integer> root){
        AtomicInteger atomicInteger = new AtomicInteger(1);
        var hashMap = new HashMap<Integer,Integer>();
        maxLevelSumUtil(root,1, hashMap,atomicInteger);
        return atomicInteger.get();
    }

    private static void minLevelSumUtil(Node<Integer> root, int level, HashMap<Integer,Integer> levelSum, AtomicInteger levelWithMinSum){
        if(root!=null){
            levelSum.put(level, levelSum.getOrDefault(level, 0)+root.data);
            if(levelSum.get(level) < levelSum.get(levelWithMinSum.get())){
                levelWithMinSum.set(level);
            }
            minLevelSumUtil(root.left,level+1,levelSum,levelWithMinSum);
            minLevelSumUtil(root.right,level+1,levelSum,levelWithMinSum);
        }
    }

    public static int minLevelSum(Node<Integer> root){
        AtomicInteger atomicInteger = new AtomicInteger(1);
        var hashMap = new HashMap<Integer,Integer>();
        minLevelSumUtil(root,1, hashMap,atomicInteger);
        return atomicInteger.get();
    }

    private static int minLevel(Node<Integer> root){
        var queue = new LinkedList<Node<Integer>>();
        queue.add(root);
        var minLevel = -1;
        var minSum = Integer.MAX_VALUE;
        var level = 1;
        while(!queue.isEmpty()){
            var noOfNodes = queue.size();
            var curSum = 0;
            while(noOfNodes-->0){
                var top = queue.pop();
                curSum+=top.data;
                if(top.left!=null){
                    queue.add(top.left);
                }
                if(top.right!=null){
                    queue.add(top.right);
                }
            }
            if(curSum < minSum){
                minSum = curSum;
                minLevel = level;
            }
            level++;
        }
        return minLevel;
    }

    @Test
    public void test(){
        var node1 = new Node(4);
        var node2 = new Node(2);
        var node3 = new Node(-5);
        var node4 = new Node(-1);
        var node5 = new Node(3);
        var node6 = new Node(-2);
        var node7 = new Node(6);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        Assert.assertEquals(2,DayNineteen.minLevelSum(node1));
        Assert.assertEquals(2,DayNineteen.minLevel(node1));


    }

}
