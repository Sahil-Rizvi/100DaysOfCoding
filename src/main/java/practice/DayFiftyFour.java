package practice;

public class DayFiftyFour {

    private static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    // in O(1) space and O(n) time
    public static Node solve(Node head, int k){
        Node lessHead = null;
        Node lessTail = null;
        Node greaterHead = null;
        Node greaterTail = null;
        var temp = head;
        Node previous = null;
        while(temp!=null){
            if(temp.data < k){
                if(lessHead == null){
                    lessHead = lessTail = temp;
                    previous = temp;
                    temp = temp.next;
                } else if(previous.data < k){
                    lessTail = lessTail.next;
                    previous = temp;
                    temp = temp.next;
                } else{
                    var t2 = temp.next;
                    var t1 = lessTail.next;
                    lessTail.next = temp;
                    temp.next = t1;
                    lessTail = lessTail.next;
                    previous.next = t2;
                    temp = t2;
                }
            } else{
                if(greaterHead == null){
                    greaterHead = greaterTail = temp;
                    previous = temp;
                    temp = temp.next;
                } else if(previous.data >= k){
                    greaterTail = greaterTail.next;
                    previous = temp;
                    temp = temp.next;
                } else{
                    var t2 = temp.next;
                    var t1 = greaterTail.next;
                    greaterTail.next = temp;
                    temp.next = t1;
                    greaterTail = greaterTail.next;
                    previous.next = t2;
                    temp = t2;
                }
            }
        }
        if(lessHead!=null && greaterHead!=null){
            lessTail.next = greaterHead;
            greaterTail.next = null;
            head = lessHead;
        }
        return head;
    }

    public static void traverse(Node head){
        var temp = head;
        while(temp!=null){
            System.out.print(temp.data);
            if(temp.next!=null){
                System.out.print(" -> ");
            }
            temp = temp.next;
        }
        System.out.println();
    }


    public static void main(String... args){
        var node1 = new Node(10);
        var node2 = new Node(4);
        var node3 = new Node(20);
        var node4 = new Node(10);
        var node5 = new Node(3);
//        var node6 = new Node(2);
//        var node7 = new Node(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
//        node6.next = node7;

        traverse(node1);

        var t = solve(node1, 4);
        traverse(t);

    }

}
