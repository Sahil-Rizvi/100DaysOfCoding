package practice;

import org.junit.Assert;
import org.junit.Test;

public class DayThirtyTwo {

    private static class Node<T>{
        T data;
        Node<T> left;
        Node<T> right;
        Node(T data){
            this.data = data;
        }
    }

    private static boolean isBST(Node<Integer> root){
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static <T> boolean  isBSTUtil(Node<Integer> root, Integer minValue,Integer maxValue){
        if(null == root){
            return true;
        }
        if(root.data >= minValue && root.data <= maxValue){
            return isBSTUtil(root.left, minValue, root.data) && isBSTUtil(root.right, root.data, maxValue);
        }
        return false;
    }

    @Test
    public void test(){
        var node1 = new Node<Integer>(4);
        var node2 = new Node<Integer>(2);
        var node3 = new Node<Integer>(5);
        var node4 = new Node<Integer>(1);
        var node5 = new Node<Integer>(3);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        Assert.assertTrue(isBST(node1));
    }
}
