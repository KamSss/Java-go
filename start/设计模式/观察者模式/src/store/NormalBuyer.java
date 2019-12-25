package store;

import observer.DisplayElement;
import observer.Observer;
import observer.Subject;

/**
 * @author ZHZ
 */
public class NormalBuyer implements Observer, DisplayElement {
    private String isOpen;
    private String saleDay;
    private Subject store;

    public NormalBuyer(Subject store){
        this.store = store;
        store.registerObserver(this);
    }

    @Override
    public void update(String isOpen, String saleDay) {
        this.isOpen = isOpen;
        this.saleDay = saleDay;
        display();
    }
    @Override
    public void display() {
        System.out.println("普通买家收到信息：" + isOpen + saleDay);
    }
}
