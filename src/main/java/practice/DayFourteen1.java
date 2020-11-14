package practice;

import java.util.PriorityQueue;

public class DayFourteen1 {
    private static class Item{
        int data;
        int timestamp;
        Item(int data, int timestamp){
            this.data = data;
            this.timestamp = timestamp;
        }
    }
    private static PriorityQueue<Item> priorityQueue = new PriorityQueue<>(4,(a,b)-> (int) (b.timestamp - a.timestamp));

    public static void push(int data){
        int time = (int)System.currentTimeMillis();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("adding "+data+" with "+time);
        priorityQueue.add(new Item(data,time));
    }

    public static int pop() throws Exception {
        Item item = priorityQueue.poll();
        if(item == null){
            throw new Exception("empty stack");
        }
        return item.data;
    }

    public static void main(String... args){
        for(var i=0;i<4;i++){
            push(i);
        }
        for(var i=0;i<4;i++){
            try {
                System.out.println(pop());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
