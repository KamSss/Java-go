import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZHZ
 */
//泛型方法
public class GenericsTest {

    private static void ss() {
        try {
            List<String> list = new ArrayList<>();
            list.get(0).equals("s");
        } catch ( NullPointerException e){
            System.out.println(e);
            throw
        }

    };

    public static < E > void printArray(E[] arr ){
        for(E output:arr){
            System.out.print(output + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        ss();
        Integer[] i = {1,2,3,4};
        printArray(i);
        Double[] d = {1.1,2.2,3.3};
        printArray(d);
    }
}

//泛型类
class GetCont<T>{
    private T t;
    T getContent(T t){
        this.t = t;
        return t;
    }
}

class GenericsTest{
    public static void main(String[] args){
        String str = "abc";
        int a = 5;
        GetCont g = new GetCont();
        GetCont t = new GetCont();
        System.out.println(g.getContent(str));
        System.out.println(g.getContent(a));
    }
}

class Dog{
    String name;
    int years;
}

public class GenericsTest {
    public static void main(String[] args){
        Dog d = new Dog();
        d.name = "jack";
        d.years = 2;
        try{
            FileOutputStream f = new FileOutputStream("F:\\Dog.ser");
            ObjectOutputStream out = new ObjectOutputStream(f);
            //OOS类的writeObject方法用来序列化一个对象
            out.writeObject(d);
            out.close();
            f.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}



