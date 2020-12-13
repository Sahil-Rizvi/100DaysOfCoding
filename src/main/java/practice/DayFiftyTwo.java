package practice;

public class DayFiftyTwo {

    public static boolean isPerfect(int n){
        var sum =0;
        while(n>0){
            sum+=n%10;
            n/=10;
        }
        return sum==10;
    }

    public static int nPerfectNumber(int n){
        var count = 0;
        for(var i=0;i<Integer.MAX_VALUE;i++){
            if(isPerfect(i)){
                count++;
            }
            if(count==n){
                return i;
            }
        }
        return -1;
    }


    public static void main(String... args){
        System.out.println(isPerfect(19));
        System.out.println(nPerfectNumber(4));
    }
}
