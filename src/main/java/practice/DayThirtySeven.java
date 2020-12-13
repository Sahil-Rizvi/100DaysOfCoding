package practice;

import java.util.HashMap;
import java.util.Map;

public class DayThirtySeven {

    private int size;
    private Map<Integer, Integer> sparseArray = new HashMap<>();

    public void init(int[] arr, int size){
        this.size = size;
        for(var i=0;i<arr.length;i++){
            if(arr[i]!=0){
                this.sparseArray.put(i, arr[i]);
            }
        }
    }

    public void set(int index, int value){
        checkBounds(index);
        if(value==0){
            sparseArray.remove(index);
        } else{
            sparseArray.put(index, value);
        }
    }

    public int get(int index){
        checkBounds(index);
        return sparseArray.get(index);
    }

    private void checkBounds(int index){
        if(index < 0 || index > this.size){
            throw new IndexOutOfBoundsException();
        }
    }

    public static void main(String... args){
        var arr = new int[]{1, 0, 0, 0, 3, 0, 0};
        var object = new DayThirtySeven();
        object.init(arr, 4);
        System.out.println(object.sparseArray);

        object.set(2,4);
        System.out.println(object.sparseArray);
        object.set(2,0);
        System.out.println(object.sparseArray);


        object.set(2,4);
        System.out.println(object.sparseArray);

        object.set(3,4);
        System.out.println(object.sparseArray);
        object.set(4,4);
        System.out.println(object.sparseArray);
        object.set(10,0);
        System.out.println(object.sparseArray);

        object.set(100,1);
        System.out.println(object.sparseArray);

        System.out.println(object.get(0));
        System.out.println(object.get(3));
        System.out.println(object.get(5));
    }
}
