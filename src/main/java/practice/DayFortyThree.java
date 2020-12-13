package practice;

public class DayFortyThree {

    public static int coins(int n){
        return (int) Math.ceil(Math.log(n)/Math.log(2));
    }

    public static void main(String ...args){
        System.out.println(coins(100));
    }
}
