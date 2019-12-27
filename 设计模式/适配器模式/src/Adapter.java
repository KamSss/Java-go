/**
 * @author ZHZ
 * 1.类适配器（同时继承两者）
 * 2.对象适配器（只继承一者，把另一者声明成自己的成员对象）
 */
//public class Adapter extends Adapted implements Target {
//    @Override
//    public void request() {
//        int i =  super.adaptedRequest();
//        System.out.println(i);
//    }
//}
public class Adapter implements Target {
    private Adapted adapted = new Adapted();
    @Override
    public void request() {
        int i = adapted.adaptedRequest();
        System.out.println(i);
    }
}
