package decorator;

/**
 * @author ZHZ
 */
public class BananaIcecream extends IceCream{
    public BananaIcecream(){
        description = "香蕉冰淇淋";
    }
    @Override
    public double cost() {
        return 20;
    }
}
