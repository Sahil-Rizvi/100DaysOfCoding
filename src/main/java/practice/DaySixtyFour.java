package practice;

public class DaySixtyFour {

    private static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }

    private static int lengthRec(Node head){
        return head==null ? 0 : 1 + lengthRec(head.next);
    }

    private static int length(Node head){
        Node temp = head;
        var count = 0;
        while(temp!=null){
            temp = temp.next;
            count++;
        }
        return count;
    }

    private static Node solve(Node head1, Node head2){
        var length1 = length(head1);
        var length2 = length(head2);
        var p1 = head1;
        var p2 = head2;
        if( length1 > length2){
            var diff = length1-length2;
            while(diff-->0){
                p1 = p1.next;
            }
        } else{
            var diff = length2-length1;
            while(diff-->0){
                p2 = p2.next;
            }
        }

        while(p1!=p2){
            p1 = p1.next;
            p2 = p2.next;
            if(p1 ==null || p2 == null){
                break;
            }
        }
        return p1;
    }

    private static void printList(Node head){
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
        var node1 = new Node(3);
        var node2 = new Node(7);
        var node3 = new Node(8);
        var node4 = new Node(10);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        var node5 = new Node(99);
        var node6 = new Node(1);
        node5.next = node6;
        node6.next = node3;

        System.out.println(solve(node1, node5).data);

    }

}
