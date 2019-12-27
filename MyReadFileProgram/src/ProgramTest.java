import handle.MyFile;
import handle.Person;

import java.util.List;
import java.util.Scanner;

/**
 * @author ZHZ
 */
public class ProgramTest {
    public static final String R = "\n\n\n\n\n\n";
    public static int getLine(){
        return new Scanner(System.in).nextInt();
    }
    public static void menu(){
        System.out.println(R + "———员工信息管理系统————");
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
            MyFile myFile = new MyFile();
            List<Person> personList = myFile.getAndAdd();
            //业务逻辑
            int input;
            do{
                menu();
                input = getLine();
                switch(input){
                    case 1:
                        System.out.println(R + "查看所有信息：");
                        myFile.showPerson(personList);
                        break;
                    case 2:
                        System.out.println(R + "要改动第__行：");
                        personList = myFile.getAndAdd();
                        int line = getLine();
                        myFile.chooseAndChange(personList,line);
                        myFile.writeToFile(personList);
                        myFile.showPerson(personList);
                        break;
                    case 3:
                        System.out.println(R + "添加新员工：");
                        Person person = new Person();
                        person.add();
                        personList.add(person);
                        myFile.writeToFile(personList);
                        System.out.println(R);
                        break;
                    case 4:
                        System.out.println(R + "删除员工：");
                        int delete = getLine();
                        personList.remove(delete);
                        myFile.writeToFile(personList);
                        break;
                    case 0:
                        System.out.println(R + "系统退出");
                        break;
                    default:
                        System.out.println(R + "输入错误，请重新输入");
                }
            }while(input != 0);
        }
}
