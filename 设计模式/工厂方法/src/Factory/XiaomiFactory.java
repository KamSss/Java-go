package Factory;

import Product.Phone;
import Product.XiaomiSmartPhone;
import Product.XiaomiUnSmartPhone;

public class XiaomiFactory implements PhoneFactory{
    @Override
    public Phone makePhone(String name) {
        Phone p = null;
        switch (name){
            case "智能机":
                p = new XiaomiSmartPhone();
                break;
            case "非智能机":
                p = new XiaomiUnSmartPhone();
                break;
            default:
                return null;
        }
        return p;
    }
}