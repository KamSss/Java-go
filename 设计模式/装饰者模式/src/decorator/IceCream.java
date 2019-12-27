package decorator;

/**
 * @author ZHZ
 */
public abstract class IceCream {
    String description = "unKnown icecream";

    public String getDescription(){
        return description;
    }
    public abstract double cost();
}
