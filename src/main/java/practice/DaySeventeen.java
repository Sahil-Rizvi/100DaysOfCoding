package practice;

public class DaySeventeen {

    public static int getGCD(int[] arr){
        var gcd = arr[0];
        for(var i=1;i<arr.length;i++){
            gcd = gcdUtil(gcd,arr[i]);
        }
        return gcd;
    }

    private static int gcdUtil(int a, int b) {
        if(a==0){
            return b;
        }
        return gcdUtil(b%a,a);
    }

    private static int gcdUtil1(int a, int b) {
        while(a!=0){
            var temp = a;
            a = b%a;
            b = temp;
        }
        return b;
    }




    public static void main(String... args){
//        var array = new int[]{100,200,180};
//        System.out.println(getGCD(array));
        System.out.println(gcdUtil1(3,7));
        System.out.println(gcdUtil(3,7));
    }
}
