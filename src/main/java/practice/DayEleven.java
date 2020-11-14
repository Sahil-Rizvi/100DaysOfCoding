package practice;

public class DayEleven {
    private static class Node<T>{
        T data;
        Node next;
        Node(T data){
            this.data = data;
            next = null;
        }
    }

    public static void print(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data);
            temp = temp.next;
            if(temp!=null){
                System.out.print("->");
            }
        }
        System.out.println();
    }

    public static Node swap(Node head){
        var p1 = head;
        Node newHead = null;
        Node prev = null;
        while(p1!=null && p1.next!=null){
            var p2 = p1.next;
            var temp = p2.next;
            p2.next = p1;
            p1.next = temp;
            if (newHead == null){
                newHead = p2;
            }
            if (prev!=null){
                prev.next = p2;
            }
            prev = p1;
            p1 = p1.next;
        }
        return newHead;
    }

    public static void main(String... args){
        var a = new Node<Integer>(1);
        var b = new Node<Integer>(2);
        var c = new Node<Integer>(3);
        var d = new Node<Integer>(4);
        a.next = b;
        b.next = c;
        c.next = d;
        var head = a;
        print(head);
        head = swapUsingRecursion(head);
        print(head);
        head = swapUsingRecursion(head);
        print(head);
        head = swapUsingRecursion(head);
        print(head);
    }

    private static Node swapUsingRecursion(Node head){
        if(head == null || head.next ==null){
            return head;
        }
        var temp = head.next;
        head.next = swapUsingRecursion(head.next.next);
        temp.next = head;
        return temp;
    }


}
