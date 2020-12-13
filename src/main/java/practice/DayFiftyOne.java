package practice;

import java.util.concurrent.*;

public class DayFiftyOne {

    private ConcurrentHashMap<String, ScheduledFuture<?>> callableConcurrentHashMap = new ConcurrentHashMap<>();
    private final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

    public void debounce(Callable<Integer> c, String k, long delay){

        System.out.println("keyset"+callableConcurrentHashMap.keySet());
        System.out.println("values"+callableConcurrentHashMap.values());
        if(callableConcurrentHashMap.containsKey(k)){
            System.out.println("already contains "+k+" so remove and put new");
            //callableConcurrentHashMap.remove(k).cancel(true);
            var s = callableConcurrentHashMap.get(k);
            if(s.isDone()){
                System.out.println("removing "+k+" hash" +s.hashCode());
                callableConcurrentHashMap.remove(k);
            }
            return;
        }

        ScheduledFuture<?> scheduledFuture = scheduledExecutorService.schedule(c, delay,TimeUnit.MILLISECONDS);
        callableConcurrentHashMap.put(k, scheduledFuture);
//        while(!scheduledFuture.isDone()){
//            try {
//                Thread.sleep(1000);
//                System.out.println("running "+scheduledFuture.hashCode());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        try {
//            System.out.println(scheduledFuture.get());
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }
//        while(!scheduledFuture.isDone());
//        System.out.println("removing "+scheduledFuture.hashCode());
//        callableConcurrentHashMap.remove(k);
    }

    public static void main(String... args) throws InterruptedException {
        Callable<Integer> c = () -> {
            Thread.sleep(100);
            System.out.println("calculating........");
            return 1;
        };
        var d = new DayFiftyOne();

        var start = System.currentTimeMillis();
        while(System.currentTimeMillis() - start<=500){
            d.debounce(c, "a", 1);
            Thread.sleep(99);
        }
        d.scheduledExecutorService.shutdown();
    }

}
