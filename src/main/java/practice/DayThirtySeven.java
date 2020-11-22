package practice;

import java.util.HashMap;
import java.util.Map;

public class DayThirtySeven {
    private Map<Integer,Integer> sparseArray = new HashMap<>();

    public void init(int[] arr, int size){
        for(var i=0;i<size;i++){
            if(arr[i]!=0){
                sparseArray.put(i, arr[i]);
            }
        }
    }

    public void set(int i, int val){
        if(0==val){
            sparseArray.remove(i);
        } else{
            sparseArray.put(i,val);
        }
    }

    public Integer get(int i){
        return sparseArray.getOrDefault(i, null);
    }


    public static void main(String... args){
        var arr = new int[]{1, 0, 0, 0, 3, 0, 2};
        var object = new DayThirtySeven();
        object.init(arr, arr.length);
        System.out.println(object.sparseArray);

        object.set(2,4);
        System.out.println(object.sparseArray);

        object.set(2,0);
        System.out.println(object.sparseArray);

        object.set(10,0);
        System.out.println(object.sparseArray);

        object.set(100,1);
        System.out.println(object.sparseArray);

        System.out.println(object.get(4));
        System.out.println(object.get(5));
    }
}
