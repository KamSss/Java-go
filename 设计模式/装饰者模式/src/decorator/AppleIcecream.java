package decorator;

/**
 * @author ZHZ
 */
public class AppleIcecream extends IceCream{
    public AppleIcecream(){
        description = "苹果冰淇淋";
    }

    @Override
    public double cost() {
        return 30;
    }
}
