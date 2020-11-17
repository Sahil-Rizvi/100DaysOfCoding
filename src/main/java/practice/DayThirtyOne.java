package practice;

import java.util.HashMap;

public class DayThirtyOne {

    private static class Node{
        int data;
        Node next;
        Node random;

        public Node(int data) {
            this.data = data;
        }
    }


    public static Node createCloneUsingO1(Node head){
        var temp = head;
        while(temp!=null){
            var newNode = new Node(temp.data);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = newNode.next;
        }

        temp = head;
        while(temp!=null){
            temp.next.random = (temp.random!=null)?temp.random.next:temp.random;
            temp = (temp.next!=null)?temp.next.next:temp.next;
        }

        temp = head;
        var newHead = temp.next;
        var cloneTemp = newHead;
        while(temp.next!=null && cloneTemp.next!=null){
            temp.next = temp.next.next;
            cloneTemp.next = cloneTemp.next.next;
            temp = temp.next;
            cloneTemp = cloneTemp.next;
        }

        return newHead;
    }

    public static Node createClone(Node head){
        var curNode = head;
        var mapping = new HashMap<Node,Node>();
        while(curNode!=null){
            mapping.put(curNode, new Node(curNode.data));
            curNode = curNode.next;
        }

        curNode = head;
        while(curNode!=null){
            var cloneNode = mapping.get(curNode);
            cloneNode.next = mapping.get(curNode.next);
            cloneNode.random = mapping.get(curNode.random);
            curNode = curNode.next;
        }
        return mapping.get(head);
    }


    private static void traverse(Node head){
        var temp = head;
        while(temp!=null){
            System.out.print(temp.data + "("+temp+")" + "("+temp.random.data+")");
            if(temp.next!=null){
                System.out.println(" -> ");
            }
            temp = temp.next;
        }
        System.out.println();
    }


    public static void main(String... args){
        var node1 = new Node(1);
        var node2 = new Node(2);
        var node3 = new Node(3);
        var node4 = new Node(4);
        var node5 = new Node(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node1.random = node3;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node2;

        traverse(node1);

//        traverse(createClone(node1));

        traverse(createCloneUsingO1(node1));
    }
}
