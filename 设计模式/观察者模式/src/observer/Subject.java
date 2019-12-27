package observer;

/**
 * @author ZHZ
 * 注册、移除、通知
 */
public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObserver();
}
