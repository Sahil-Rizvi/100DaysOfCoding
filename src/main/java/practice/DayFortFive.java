package practice;

import java.util.LinkedList;
import java.util.Queue;

public class DayFortFive {

    private static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }

    public static void printLevelWise(Node root){
        if(root==null){
            return;
        }

        var queue = new LinkedList<Node>();
        queue.add(root);

        while(!queue.isEmpty()){
            var node = queue.poll();
            System.out.println(node.data);
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
        }

    }

    public static void main(String... args){
        var node1 = new Node(1);
        var node2 = new Node(2);
        var node3 = new Node(3);
        var node4 = new Node(4);
        var node5 = new Node(5);

        node1.left = node2;
        node1.right = node3;

        node3.left = node4;
        node3.right = node5;

        printLevelWise(node1);
    }

}
