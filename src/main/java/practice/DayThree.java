package practice;

import java.util.Arrays;

public class DayThree {

    public static void sieveOfEratosthenes(int n){
        var primes = new boolean[n+1];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;

        for(var i=2;i*i<=n;i++){
            if(primes[i]){
                for(var j=i*i; j<=n; j+=i){
                    primes[j] = false;
                }
            }
        }

        for(var i =0;i<=n ;i++){
            if(primes[i]){
                System.out.print(i+" ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args){
        sieveOfEratosthenes(20);
    }
}
