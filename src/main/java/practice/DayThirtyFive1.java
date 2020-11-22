package practice;

public class DayThirtyFive1 {
    private static DayThirtyFive1 instanceOne = null;
    private static DayThirtyFive1 instanceTwo = null;
    private static int calls = 0;

    private DayThirtyFive1(){
    }

    public static DayThirtyFive1 getInstance(){
        if(instanceOne==null){
            instanceOne = new DayThirtyFive1();
            instanceTwo = new DayThirtyFive1();
        }

        if(calls++ %2==0){
            return instanceOne;
        }
        return instanceTwo;
    }
}
