import Factory.HuaweiFactory;
import Factory.PhoneFactory;

public class FactoryMethod {
    public static void main(String[] args){
        PhoneFactory pf = new HuaweiFactory();
        pf.makePhone("非智能机").open();
    }
}
