package decorator;

/**
 * @author ZHZ
 */
public class Apple extends Condiment{
    IceCream iceCream;
    String addWeight;

    public Apple(IceCream iceCream){
        //apple会保存上一个引用自己的对象
        this.iceCream = iceCream;
    }
    @Override
    public String getDescription(){
        return iceCream.getDescription() + "，加苹果";
    }

    @Override
    public double cost() {

        return 2 + iceCream.cost();
    }

}
