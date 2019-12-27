package Factory;

import Product.*;

public class HuaweiFactory implements PhoneFactory{
    @Override
    public Phone makePhone(String name) {
        Phone p = null;
        switch (name){
            case "智能机":
                p = new HuaweiSmartPhone();
                break;
            case "非智能机":
                p = new HuaweiUnSmartPhone();
                break;
            default:
                return null;
        }
        return p;
    }
}

