package practice;

import java.util.concurrent.*;

public class DayFiftyOne {

    private ConcurrentHashMap<String, ScheduledFuture<?>> callableConcurrentHashMap = new ConcurrentHashMap<>();
    private final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

    public void debounce(Callable<Integer> c, String k, long delay){
        if(callableConcurrentHashMap.containsKey(k)){
            System.out.println("already contains "+k+" so remove and put new");
            callableConcurrentHashMap.remove(k).cancel(true);
            return;
        }

        ScheduledFuture<?> scheduledFuture = scheduledExecutorService.schedule(c, delay,TimeUnit.MILLISECONDS);
        callableConcurrentHashMap.put(k, scheduledFuture);
        while(!scheduledFuture.isDone()){
            try {
                Thread.sleep(1000);
                System.out.println("running "+k);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            System.out.println(scheduledFuture.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        callableConcurrentHashMap.remove(k);
    }

    public static void main(String... args){
        Callable<Integer> c = () -> {
            Thread.sleep(1000);
            System.out.println("calculating........");
            return 1;
        };
        var d = new DayFiftyOne();
        d.debounce(c, "a", 10);

        d.debounce(c, "b", 10);

        d.debounce(c, "a", 10);

        d.scheduledExecutorService.shutdown();
    }

}
