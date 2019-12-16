/**
 * @author ZHZ
 */
public class DesignTest {
    public static void main(String[] args){
        String s = "Dog";
        Animal a = SimpleFactory.createProduct(s);
        a.bark();
    }
}
