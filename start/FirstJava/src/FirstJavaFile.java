import java.util.ArrayList;
import java.util.Stack;

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

//class Dog{
//    static final int BIG_DOG_LENGTH = 40;
//    String name;
//    int size;
//    void bark(){
//        if(size > BIG_DOG_LENGTH){
//            System.out.println("我又不咬人.jpg " + name);
//        }
//        else{
//            System.out.println("恶龙咆哮！嗷呜！" + name);
//        }
//    }
//}
//
//class TestArrayList {
//    public static void main(String[] args){
//        ArrayList<Dog> dogList = new ArrayList<Dog>();
//        Dog a = new Dog();
//        Dog b = new Dog();
//        Dog c = new Dog();
//        a.name = "Trump";
//        b.name = "piao";
//        c.name = "anbei";
//        a.size = 50;
//        b.size = 30;
//        c.size = 40;
//        dogList.add(a);
//        dogList.add(b);
//        dogList.add(c);
//        System.out.println(dogList.contains(a));
//        System.out.println(dogList.indexOf(c));
//        dogList.remove(b);
//        for(Dog i : dogList){
//            i.bark();
//        }
//        dogList.get(0).bark();
//    }
//}


class ExceptionTest{
    public static void main(String[] args){
        try{
            //保护代码，出现异常之前的每一条代码都会执行
            int[] a = new int[2];

            if (true){
                throw new MyRuntimeException("MSG1");
            }
            System.out.println("尝试越界访问数组");
            //出现异常之后跳转到catch模块尝试捕捉并执行自定制操作
            System.out.println("尝试越界访问数组" + a[3]);
        } catch (MyRuntimeException e){
            e.getMsg();
            System.out.println(e.getMessage());
        } catch(ArrayIndexOutOfBoundsException e){
            System.out.println("捕捉到异常：" + e);
        } catch (Exception e){

        } finally {

        }
        System.out.println("TryCatch结束");
    }
}

