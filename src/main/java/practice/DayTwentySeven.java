package practice;

import java.util.HashMap;

public class DayTwentySeven {

    private static final int NO_OF_BITS = 32;
    private static final int NO_OF_BITS_IN_CACHE = 8;

    public static int reverseBits(int n){
        var result = 0;
        for(var i=0;i<NO_OF_BITS;i++){
            var j = (n>>i)&1;
            result+= j<< (NO_OF_BITS - (i+1));
        }
        return result;
    }

    private static int reverseBitsNaive(int n, int noOfBits){
        var result = 0;
        for(var i=0;i<noOfBits;i++){
            var j = (n>>i)&1;
            result+= j<< (noOfBits - (i+1));
        }
        return result;
    }

    private static int[] preProcess(){
        var cache = new int[(int)Math.pow(2,NO_OF_BITS_IN_CACHE)];
        for(var i=0;i<Math.pow(2,NO_OF_BITS_IN_CACHE);i++){
            cache[i] = reverseBitsNaive(i,NO_OF_BITS_IN_CACHE);
        }
        return cache;
    }

    public static int reverseOptimized(int n){
        var cache = preProcess();
        var mask = (int)Math.pow(2, NO_OF_BITS_IN_CACHE) - 1;
        var result = 0;
        for(var i=0;i<NO_OF_BITS/NO_OF_BITS_IN_CACHE;i++){
            var relevant = (n>>(i*NO_OF_BITS_IN_CACHE)) & mask;
            result += cache[relevant] << (NO_OF_BITS - (i+1)*NO_OF_BITS_IN_CACHE);
        }
        return result;
    }


    public static void main(String ...args){
        var n = 1 ;//-2147483648;
        System.out.println(Integer.toBinaryString(n));
        var res = reverseBitsNaive(n,NO_OF_BITS);
        System.out.println(res);
        System.out.println(Integer.toBinaryString(res));

        res = reverseOptimized(n);
        System.out.println(res);
        System.out.println(Integer.toBinaryString(res));

    }

}
