package practice;

public class DayTwentyEight {

    private static final double ERROR = 0.00001;
    public static double squareRootUsingGuess(double n){
        var guess = 1.0;
        while( Math.abs(Math.pow(guess,2) - n) >= ERROR){
            guess = (guess + n/guess)/2.0;
        }
        return guess;
    }

    public static double squareRootUsingBinarySearch(double n){
        var low = 0.0;
        var high = n;
        var guess = low+(high-low)/2.0;

        while(Math.abs(Math.pow(guess,2) - n) >= ERROR){
            if (Math.pow(guess,2) > n){
                high = guess;
            } else{
                low = guess;
            }
            guess = low+(high-low)/2.0;
        }

        return guess;
    }

    public static void main(String... args){
        System.out.println(squareRootUsingGuess(9));
        System.out.println(squareRootUsingBinarySearch(9));
    }
}
