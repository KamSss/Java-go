abstract class Animal{
    public abstract void bark();
}
class Dog extends Animal{
    @Override
    public void bark() {
        System.out.println("狗叫");
    }
}
class Cat extends Animal{
    @Override
    public void bark() {
        System.out.println("猫叫");
    }
}
/**
 * @author ZHZ
 */
public class SimpleFactory{
    public static Animal createProduct(String type){
        Animal a = null;
        switch (type) {
            case "Dog":
                a = new Dog();
                break;
            case "Cat":
                a = new Cat();
                break;
            default:
                System.out.println("简单工厂创建失败");
        }
        return a;
    }
}
