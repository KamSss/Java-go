package singleton;

/**
 * @author ZHZ
 */
public class UnSafeLazySingleton {
    private static UnSafeLazySingleton instance;

    private UnSafeLazySingleton(){}

    public static UnSafeLazySingleton getInstance(){
        if(instance == null){
            instance = new UnSafeLazySingleton();
        }
        return instance;
    }
}
