package singleton;

/**
 * @author ZHZ
 */
public class SafeLazySingleton {
    private static volatile SafeLazySingleton instance;

    private SafeLazySingleton(){}

    public static SafeLazySingleton getInstance(){
        if(instance == null){
            synchronized (SafeLazySingleton.class){
                if(instance == null){
                    instance = new SafeLazySingleton();
                }
            }
        }
        return instance;
    }
}
//public class SafeLazySingleton {
//    private static SafeLazySingleton instance;
//
//    private SafeLazySingleton(){}
//
//    public static synchronized SafeLazySingleton getInstance(){
//        if(instance != null){
//            instance = new SafeLazySingleton();
//        }
//        return instance;
//    }
//}
