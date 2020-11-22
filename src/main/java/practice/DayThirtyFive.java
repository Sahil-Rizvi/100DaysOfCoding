package practice;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

// eager initialization
public class DayThirtyFive {

    private static volatile DayThirtyFive instance = new DayThirtyFive();

    private DayThirtyFive(){
    }

    public static DayThirtyFive getInstance(){
        return instance;
    }
}

// LazyInitialization but not thread-safe
class LazyInitialization implements Serializable, Cloneable{

    private static volatile LazyInitialization oddInstance;
    private static volatile LazyInitialization evenInstance;

    private static Integer count = 0;

    private LazyInitialization(){
//        if(oddInstance !=null){
//            throw new RuntimeException("Use getInstance() to get the single instance of this class");
//        }
    }

    public static synchronized LazyInitialization getInstance(){
        LazyInitialization result = null;
        System.out.println("here");
//        if(null==instance){
//            synchronized(LazyInitialization.class){
//                 if(null == instance){
//                     instance = new LazyInitialization();
//                     result = instance;
//                 }
//            }
//        }


        if((count&1)!=0) {
            if (oddInstance == null) {
                //synchronized (LazyInitialization.class) {
                    if (oddInstance == null && (count&1)!=0) {
                        oddInstance = new LazyInitialization();
                        result = oddInstance;
                    }
                //}
            }
        } else{
            if (evenInstance == null) {
                //synchronized (LazyInitialization.class) {
                    if (evenInstance == null && (count&1)==0) {
                        evenInstance = new LazyInitialization();
                        result = evenInstance;
                    }
                //}
            }
        }

        System.out.println(result.hashCode() + "count:"+ count);
        count++;
        return result;
    }

    protected Object readResolve(){
        return count%2==0? evenInstance:oddInstance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        throw new CloneNotSupportedException();
    }
}


class Test{
    public static void main(String... args) throws InterruptedException, TimeoutException, ExecutionException {
//        System.out.println(LazyInitialization.getInstance().hashCode());
//        System.out.println(LazyInitialization.getInstance().hashCode());
        // object creation using reflection

//        LazyInitialization instance1 = LazyInitialization.getInstance();
//
//        LazyInitialization instance2 = null;
//
//        Class<LazyInitialization> lazyInitialization = LazyInitialization.class;
//        try {
//            Constructor<LazyInitialization> constructor = lazyInitialization.getDeclaredConstructor();
//            constructor.setAccessible(true);
//            instance2 = constructor.newInstance();
//        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(instance1.hashCode());
//        System.out.println(instance2.hashCode());

//        Thread t1 = new Thread(() -> {
//            LazyInitialization lazyInitialization = LazyInitialization.getInstance();
//            System.out.println(lazyInitialization.hashCode());
//        });
//
//        Thread t2 = new Thread(() -> {
//            LazyInitialization lazyInitialization = LazyInitialization.getInstance();
//            System.out.println(lazyInitialization.hashCode());
//        });
//
//        t1.start();
//        t2.start();

//        try {
//            LazyInitialization lazyInitialization1 = LazyInitialization.getInstance();
//            ObjectOutput objectOutput = null;
//
//            objectOutput = new ObjectOutputStream(new FileOutputStream("instance.ser"));
//            objectOutput.writeObject(lazyInitialization1);
//            objectOutput.close();
//
//            ObjectInput objectInput = new ObjectInputStream(new FileInputStream("instance.ser"));
//            LazyInitialization lazyInitialization2 = (LazyInitialization) objectInput.readObject();
//            objectOutput.close();
//
//            System.out.println(lazyInitialization1.hashCode());
//            System.out.println(lazyInitialization2.hashCode());
//
//            System.out.println(lazyInitialization1.clone().hashCode());
//        } catch (IOException | ClassNotFoundException | CloneNotSupportedException e) {
//            e.printStackTrace();
//        }

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        var results = new ArrayList<Future<String>>();
        for(var i=0;i<10;i++){
            int finalI = i;
            results.add(executorService.submit(() -> {
                var l = LazyInitialization.getInstance();
                //System.out.println(l.hashCode());
                return finalI +""+l.hashCode();
            }));
        }


        for(var result:results){
            System.out.println(result.get(1000, TimeUnit.MILLISECONDS));
            System.out.println(result.isDone());
            System.out.println(result.isCancelled());
        }
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(2000, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }    }
}
