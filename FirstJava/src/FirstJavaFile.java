import com.sun.org.apache.bcel.internal.generic.ANEWARRAY;

import java.util.ArrayList;

/**
 * @author ZHZ
 */
//public class FirstJavaFile {
//    public static void main(String[] args) {
//        String[] wordList = {"小米","华为","魅族"};
//        int len = wordList.length;
//        int tmp = (int)(Math.random() * len);
//        int tmp2 = (int)(Math.random() * len);
//        String wordAndWord = wordList[tmp] + " and " +  wordList[tmp2];
//        System.out.print("wtf is " + wordAndWord);
//    }
//}
//class Count{
//    String name = "空白name";
//    int money = 0;
//    void showIt(){
//        System.out.println(name + " 账户余额为：" + money);
//    }
//}
//class TestGetCount{
//    public static void main(String[] args){
//        Count a = new Count();
//        a.name = "张三";
//        a.money = 100;
//        while(a.money != 0){
//            a.showIt();
//            a.money -= 20;
//        }
//    }
//}
//class TestSuperFor{
//    public static void main(String[] args){
//        int[] array = new int[3];
//        array[0] = 3;
//        array[1] = 2;
//        array[2] = 1;
//        for(int i : array){
//            System.out.println(i);
//        }
//    }
//}
class Dog{
    String name;
    void bark(){
        System.out.println("wow wow im " + name);
    }
}
class TestArrayList{
    public static void main(String[] args){
        ArrayList<Dog> arr = new ArrayList<Dog>();
        Dog a = new Dog();
        Dog b = new Dog();
        a.name = "bary allen";
        b.name = "steve";
        arr.add(a);
        arr.add(b);
        for(Dog i : arr){
            i.bark();
        }
    }
}
