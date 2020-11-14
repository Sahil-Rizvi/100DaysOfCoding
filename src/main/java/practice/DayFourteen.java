package practice;

import java.util.AbstractMap;
import java.util.PriorityQueue;

public class DayFourteen {
    static private class Stack {
        private int counter;
        private PriorityQueue<AbstractMap.SimpleEntry<Long,Integer>> priorityQueue = new PriorityQueue<>((e1,e2)-> (int) (e2.getKey()-e1.getKey()));
        
        public void push(int value){
            priorityQueue.add(new AbstractMap.SimpleEntry<>(System.nanoTime(), value));
        }

        public int pop(){
            if(priorityQueue.isEmpty()){
                return Integer.MIN_VALUE;
            }
            counter--;
            return priorityQueue.poll().getValue();
        }

        public int peek(){
            return priorityQueue.peek().getValue();
        }

    }

    public static void main(String... args){
        Stack st = new Stack();
        st.push(10);
        st.push(20);
        st.push(30);

        System.out.println(st.pop());
        System.out.println(st.pop());



    }
}
