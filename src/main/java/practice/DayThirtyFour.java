package practice;

import org.junit.Test;

public class DayThirtyFour {

    private static class Node<T>{
        T data;
        Node<T> next;

        Node(T data){
            this.data = data;
        }
    }

    public static Node<Integer> rotateListByK(Node<Integer> head, int k){
        if(null == head || null == head.next){
            return head;
        }

        var p2 = head;

        var i = 0;
        while(i<k && p2.next!=null){
            p2 = p2.next;
            i++;
        }

        var p1 = head;
        while(p2.next!=null){
            p1 = p1.next;
            p2 = p2.next;
        }

        var newHead = p1.next;
        p1.next = null;
        p2.next = head;
        return newHead;
    }

    public static void traverse(Node<Integer> head){
        var temp = head;
        while(temp!=null){
            System.out.print(temp.data);
            if(temp.next!=null){
                System.out.print("->");
            }
            temp = temp.next;
        }
        System.out.println();
    }

    @Test
    public void test(){
        var node1 = new Node<Integer>(7);
        var node2 = new Node<Integer>(7);
        var node3 = new Node<Integer>(3);
        var node4 = new Node<Integer>(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        traverse(node1);
        traverse(rotateListByK(node1,2));

        node1 = new Node<Integer>(1);
        node2 = new Node<Integer>(2);
        node3 = new Node<Integer>(3);
        node4 = new Node<Integer>(4);
        var node5 = new Node<Integer>(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        traverse(node1);
        traverse(rotateListByK(node1,3));

        node1 = new Node<Integer>(1);
        node2 = new Node<Integer>(2);
        node1.next = node2;

        traverse(node1);
        traverse(rotateListByK(node1,3));

    }

}
