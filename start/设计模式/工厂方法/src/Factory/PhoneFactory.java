package Factory;

import Product.Phone;

/**
 * @author ZHZ
 */
public interface PhoneFactory{
    Phone makePhone(String name);
}
