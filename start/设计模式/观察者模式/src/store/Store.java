package store;

import observer.Observer;
import observer.Subject;

import java.util.ArrayList;

/**
 * @author ZHZ
 */
public class Store implements Subject {
    private ArrayList<Observer> observers;
    private String isOpen;
    private String saleDay;
    private boolean changed = false;

    public Store(){
        observers = new ArrayList();
    }
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if(i >= 0){
            observers.remove(i);
        }
    }

    public void setChanged(){
        changed = true;
    }

    @Override
    public void notifyObserver() {
        if(changed) {
            for (Observer ob : observers) {
                ob.update(isOpen, saleDay);
            }
        }
        changed = false;
    }

    public void setMessage(String isOpen,String saleDay){
        this.isOpen = isOpen;
        this.saleDay = saleDay;
        notifyObserver();
    }


}
