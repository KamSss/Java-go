import singleton.HungrySingleton;
import singleton.SafeLazySingleton;
import singleton.UnSafeLazySingleton;

/**
 * @author ZHZ
 */
public class MainTest {
    public static void main(String[] args){
        UnSafeLazySingleton instance = UnSafeLazySingleton.getInstance();
        SafeLazySingleton instance2 = SafeLazySingleton.getInstance();
        HungrySingleton instance3 = HungrySingleton.getInstance();
    }
}
