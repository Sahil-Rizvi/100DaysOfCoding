package practice;

import java.io.Serializable;

public class EagerInitializedSingleton {

    private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();

    private EagerInitializedSingleton(){
    }

    public static EagerInitializedSingleton getInstance(){
        return instance;
    }
}

class StaticBlockSingleton{
    private static StaticBlockSingleton instance;

    static {
        try{
            instance = new StaticBlockSingleton();
        }catch (Exception e){
            throw new RuntimeException("Exception occured in creating singleton instance");
        }
    }

    private StaticBlockSingleton(){

    }

    public static StaticBlockSingleton getInstance(){
        return instance;
    }
}

class LazyInitializedSingleton{
    private static LazyInitializedSingleton instance;

    private LazyInitializedSingleton(){

    }

    public static LazyInitializedSingleton getInstance(){
        if(instance==null){
            instance = new LazyInitializedSingleton();
        }
        return instance;
    }
}

class ThreadSafeSingleton{
    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton(){
    }

    public static synchronized ThreadSafeSingleton getInstance(){
        if(instance==null){
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }

    public static ThreadSafeSingleton getInstanceUsingDoubleLocking(){
        if(instance==null){
            synchronized (ThreadSafeSingleton.class){
                if(instance==null){
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }
}



class BillPughSingleton{
    private BillPughSingleton(){

    }

    private static class SingletonHelper{
        private static final BillPughSingleton instance = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance(){
        return SingletonHelper.instance;
    }
}

enum EnumSingleton{
    INSTANCE;
}

class SerializedSingleton implements Serializable{

    private static final long serialVersionUID = -7604766932017737115L;

    private SerializedSingleton(){
    }

    private static class SingletonHelper{
        private static final SerializedSingleton INSTANCE = new SerializedSingleton();
    }

    public static SerializedSingleton getInstance(){
        return SingletonHelper.INSTANCE;
    }

    protected Object readResolve(){
        return getInstance();
    }
}