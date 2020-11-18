package practice;

import java.util.*;

public class DayThirtyThree {

    private static class Node<T>{
        T data;
        Node<T> left;
        Node<T> right;

        Node(T data){
            this.data = data;
        }
    }

    public Node<Integer> insert(Node<Integer> root, int value){
        if(root == null){
            return new Node<>(value);
        }
        if(root.data < value){
            root.right = insert(root.right, value);
            return root;
        }
        root.left = insert(root.left, value);
        return root;
    }

    public Node<Integer> search(Node<Integer> root, int value){
        if(root == null){
            return null;
        }
        if(root.data == value){
            return root;
        }
        if(root.data<value){
            return search(root.right, value);
        }
        return search(root.left, value);
    }

    public ArrayList<Node<Integer>> findSum(Node<Integer> root, Node<Integer> node, int sum){
        if(node == null){
            return new ArrayList<>();
        }
        if(node.data<= sum){
            var a = search(root, sum-node.data);
            if(a!=null && a!=node){
                var temp = new ArrayList<Node<Integer>>();
                temp.add(a);temp.add(node);
                return temp;
            }
        }
        var a = findSum(root, node.left, sum);
        if(a.isEmpty()){
           return findSum(root, node.right, sum);
        }
        return a;
    }

    public ArrayList<Node<Integer>> findSum(Node<Integer> node, int sum, HashMap<Integer,Node<Integer>> alreadyVisited){
        if(node==null){
            return new ArrayList<>();
        }
        if(node.data < sum && alreadyVisited.containsKey(sum-node.data)){
            var temp = new ArrayList<Node<Integer>>();
            temp.add(node); temp.add(alreadyVisited.get(sum-node.data));
            return temp;
        }
        alreadyVisited.put(node.data, node);
        var temp = findSum(node.left, sum, alreadyVisited);
        if(temp.isEmpty()){
            return findSum(node.right, sum, alreadyVisited);
        }
        return temp;
    }



    public static void main(String... args){
        DayThirtyThree dayThirtyThree = new DayThirtyThree();
        var root= dayThirtyThree.insert(null, 10);
        dayThirtyThree.insert(root, 5);
        dayThirtyThree.insert(root, 15);
        dayThirtyThree.insert(root, 11);
        dayThirtyThree.insert(root, 15);

        //System.out.println(dayThirtyThree.search(root, 15));

        var sum = dayThirtyThree.findSum(root,root, 20);

        System.out.println(sum.get(0));
        System.out.println(sum.get(1));

        System.out.println(sum.get(0).data);
        System.out.println(sum.get(1).data);



        var sum1 = dayThirtyThree.findSum(root, 26, new HashMap<>());

        if(!sum1.isEmpty()){
            System.out.println(sum1.get(0));
            System.out.println(sum1.get(1));

            System.out.println(sum1.get(0).data);
            System.out.println(sum1.get(1).data);
        }


    }

}
