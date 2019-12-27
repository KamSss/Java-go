import java.util.Random;

/**
 * @author ZHZ
 * 被适配类，是旧的接口
 */
public class Adapted {
    public int adaptedRequest(){
        Random r = new Random();
        return r.nextInt(10);
    }
}
