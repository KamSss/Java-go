package decorator;

/**
 * @author ZHZ
 */
public class Milk extends Condiment{
    IceCream iceCream;

    public Milk(IceCream iceCream){
        this.iceCream = iceCream;
    }
    @Override
    public String getDescription() {
        return iceCream.getDescription() + ",加牛奶";
    }

    @Override
    public double cost() {
        return 6 + iceCream.cost();
    }
}
