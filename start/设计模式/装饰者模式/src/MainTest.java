import decorator.Apple;
import decorator.BananaIcecream;
import decorator.IceCream;
import decorator.Milk;

/**
 * @author ZHZ
 */
public class MainTest {
    public static void main(String[] args){
        IceCream iceCream = new BananaIcecream();
        iceCream = new Apple(iceCream);
        iceCream = new Milk(iceCream);
        System.out.println(iceCream.getDescription() + " 价格：" + iceCream.cost());
    }
}
