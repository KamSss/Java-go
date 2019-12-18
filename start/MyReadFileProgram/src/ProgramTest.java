import handle.MyFile;
import handle.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZHZ
 */
public class ProgramTest {
    public static int getLine(){
        int input = 0;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = br.readLine();
            input = Integer.parseInt(str);
            //br.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return input;
    }
    public static void menu(){
        System.out.println("\r———员工信息管理系统————");
        System.out.println("—————————————————————");
        System.out.println("———1.查看员工信息—————");
        System.out.println("———2.修改员工信息—————");
        System.out.println("———3.添加员工信息—————");
        System.out.println("———4.删除员工信息—————");
        System.out.println("———————0.exit————————");
        System.out.println("—————————————————————");
        System.out.println("输入0~4选择功能>> ");
    }
        public static void main(String[] args){
            List<Person> personMessage = new ArrayList<>();
            MyFile mf = new MyFile();
            //业务逻辑
            int input = 0;
            do{
                menu();
                input = getLine();
                switch(input){
                    case 1:
                        System.out.println("查看所有信息：");
                        mf.getAndShow(personMessage);
                        personMessage.clear();
                        break;
                    case 2:
                        System.out.println("\n要改动第__行：");
                        mf.getAndShow(personMessage);
                        mf.chooseAndChange(personMessage);
                        mf.saveAndShow(personMessage);
                        mf.getAndShow(personMessage);
                        break;
                    case 3:
                        System.out.println("添加");
                        break;
                    case 4:
                        System.out.println("删除");
                        break;
                    case 0:
                        System.out.println("系统退出");
                        break;
                    default:
                        System.out.println("输入错误，请重新输入");
                }
            }while(input != 0);
        }
}
