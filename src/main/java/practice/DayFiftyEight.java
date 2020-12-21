package practice;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DayFiftyEight {

    private static class Node<T>{
        T data;
        Node<T> next;

        Node(T data){
            this.data = data;
            this.next = null;
        }
    }

    private static class Result{
        int minIndex;
        boolean isNoOfNullsEqualKMinus1;

        Result(){
            minIndex = -1;
            isNoOfNullsEqualKMinus1 = false;
        }

        Result(int minIndex, boolean isNoOfNullsEqualKMinus1){
            this.minIndex = minIndex;
            this.isNoOfNullsEqualKMinus1 = isNoOfNullsEqualKMinus1;
        }
    }

    private static Result findMinimum(Node<Integer>[] heads){
        int minIndex = -1;
        int noOfNonNulls = 0;

        for(var i=0;i<heads.length;i++){
            if(heads[i]!=null){
                noOfNonNulls++;
                if( minIndex==-1 || heads[i].data < heads[minIndex].data){
                    minIndex = i;
                }
            }
        }

        return new Result(minIndex, noOfNonNulls==1);
    }

    public static Node<Integer> solve(Node<Integer>[] heads){
        Result result = null;
        result = findMinimum(heads);
        Node<Integer> finalList = null;
        Node<Integer> finalListHead = null;

        while(result.minIndex!=-1){
            if(finalList == null){
                finalList = heads[result.minIndex];
                finalListHead = finalList;
            }
            else{
                finalList.next = heads[result.minIndex];
                if(result.isNoOfNullsEqualKMinus1){
                  break;
                }
                finalList = finalList.next;
            }
            heads[result.minIndex] = heads[result.minIndex].next;

            result = findMinimum(heads);
        }
        return finalListHead;
    }

    private static <T> void printList(Node<T> head){
        var temp = head;
        while (temp!=null){
            System.out.print(temp.data);
            if(temp.next!=null){
                System.out.print(" -> ");
            }
            temp = temp.next;
        }
        System.out.println();
    }

    public static Node<Integer> solveUsingHeap(Node<Integer>[] heads){
        Node<Integer> result = null;
        Node<Integer> resultPointer = null;

        var minHeap = new PriorityQueue<Node<Integer>>(heads.length, Comparator.comparingInt(a -> a.data));
        minHeap.addAll(Arrays.asList(heads));
        while(!minHeap.isEmpty()){
            var minimumNode = minHeap.poll();
            if(resultPointer == null){
                resultPointer = minimumNode;
                result = resultPointer;
            } else{
                resultPointer.next = minimumNode;
                resultPointer = resultPointer.next;
            }
            if(minimumNode.next!=null){
                minHeap.add(minimumNode.next);
            }
        }
        return result;
    }


    @Test
    public void test(){
        var head1 = new Node<Integer>(1);
        head1.next = new Node<Integer>(3);
        head1.next.next = new Node<Integer>(5);
        head1.next.next.next = new Node<Integer>(7);


        var head2 = new Node<Integer>(2);
        head2.next = new Node<Integer>(4);
        head2.next.next = new Node<Integer>(6);
        head2.next.next.next = new Node<Integer>(8);

        var head3 = new Node<Integer>(0);
        head3.next = new Node<Integer>(9);
        head3.next.next = new Node<Integer>(10);
        head3.next.next.next = new Node<Integer>(11);

        var list = new Node[3];
        list[0] = head1;
        list[1] = head2;
        list[2] = head3;

        printList(solve(list));

        head1 = new Node<Integer>(1);
        head1.next = new Node<Integer>(3);
        head1.next.next = new Node<Integer>(7);


        head2 = new Node<Integer>(2);
        head2.next = new Node<Integer>(4);
        head2.next.next = new Node<Integer>(8);

        head3 = new Node<Integer>(9);
        head3.next = new Node<Integer>(10);
        head3.next.next = new Node<Integer>(11);

        list = new Node[3];
        list[0] = head1;
        list[1] = head2;
        list[2] = head3;

        printList(solve(list));

        head1 = new Node<Integer>(1);
        head1.next = new Node<Integer>(3);
        head1.next.next = new Node<Integer>(5);
        head1.next.next.next = new Node<Integer>(7);

        head2 = new Node<Integer>(2);

        head3 = new Node<Integer>(0);
        head3.next = new Node<Integer>(11);

        list = new Node[3];
        list[0] = head1;
        list[1] = head2;
        list[2] = head3;


        printList(solveUsingHeap(list));

    }

}
