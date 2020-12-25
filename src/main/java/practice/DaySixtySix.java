package practice;

import org.junit.Assert;
import org.junit.Test;

public class DaySixtySix {

    private static class Node{
        int data;
        Node prev;
        Node next;
        Node(int data){
            this.data = data;
        }
    }

    private static class SinglyLinkedList{
        private Node head;

        public void add(int a){
            if(head==null){
                head = new Node(a);
            } else {
                var temp = head;
                while(temp.next!=null){
                    temp = temp.next;
                }
                temp.next = new Node(a);
            }
        }

        public Node nodeAtIndex(int index){
            var temp = head;
            var indexCounter = 1;
            while(temp!=null && indexCounter<index){
                temp = temp.next;
                indexCounter++;
            }
            return temp;
        }

        private int size(){
            var temp = head;
            var count = 0;
            while(temp!=null){
                temp=temp.next;
                count++;
            }
            return count;
        }

        public boolean isPalindrome(){
            var size = size();
            var p1 = head;
            Node p2;
            while(p1!=(p2 = nodeAtIndex(size))){
                if(p1.data!=p2.data){
                    return false;
                } else{
                    p1 = p1.next;
                    size--;
                }
            }
            return true;
        }

        public void print(){
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
    }

    private static class DoublyLinkedList{
        private Node head;
        private Node tail;

        public void add(int data){
            if(head==null){
                head = new Node(data);
                tail = head;
            } else{
                tail.next = new Node(data);
                tail.next.prev = tail;
                tail = tail.next;
            }
        }

        public void print(){
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

        public void printReverse(){
            var temp = tail;
            while(temp!=null){
                System.out.print(temp.data);
                if(temp.prev!=null){
                    System.out.print("->");
                }
                temp = temp.prev;
            }
            System.out.println();
        }

        public boolean isPalindrome(){
            var p1 = head;
            var p2 = tail;
            while(p1!=p2){
                if(p1.data == p2.data){
                   p1 = p1.next;
                   p2 = p2.prev;
                } else{
                    return false;
                }
            }
            return true;
        }
    }

    @Test
    public void testDLL(){
        var doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.add(1);
        doublyLinkedList.add(4);
        doublyLinkedList.add(3);
        doublyLinkedList.add(4);
        doublyLinkedList.add(1);
        Assert.assertTrue(doublyLinkedList.isPalindrome());

        doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.add(1);
        doublyLinkedList.add(4);
        Assert.assertFalse(doublyLinkedList.isPalindrome());
    }

    @Test
    public void testSLL(){
        var singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.add(1);
        singlyLinkedList.add(4);
        singlyLinkedList.add(3);
        singlyLinkedList.add(4);
        singlyLinkedList.add(1);
        Assert.assertTrue(singlyLinkedList.isPalindrome());

        singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.add(1);
        singlyLinkedList.add(4);
        Assert.assertFalse(singlyLinkedList.isPalindrome());
    }

}
