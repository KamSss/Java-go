import sql.Sql;

import java.util.Scanner;

/**
 * @author ZHZ
 */
public class MyTest {
    public static final String R = "\n\n\n";
    public static int getLine(){
        return new Scanner(System.in).nextInt();
    }
    public static void menu(){
        System.out.println(R + "———MySQL数据库管理————");
        System.out.println("—————————————————————");
        System.out.println("———1.查看员工信息—————");
        System.out.println("———2.搜索具体员工—————");
        System.out.println("———3.添加员工信息—————");
        System.out.println("———4.修改员工信息—————");
        System.out.println("———5.删除员工信息—————");
        System.out.println("———————0.exit————————");
        System.out.println("—————————————————————");
        System.out.println("输入0~4选择功能>> ");
    }
    public static void main(String[] args){
        Sql mysql = new Sql();
        mysql.init();
        //业务逻辑
        int input;
        do{
            menu();
            input = getLine();
            switch(input){
                case 1:
                    System.out.println(R + "查看所有信息：");
                    mysql.selectAll();
                    break;
                case 2:
                    System.out.println(R + "搜索具体员工信息");
                    mysql.selectSolo();
                    break;
                case 3:
                    System.out.println(R + "添加新员工：");
                    mysql.insert();
                    break;
                case 4:
                    System.out.println(R + "改动员工信息：");
                    mysql.selectAll();
                    mysql.change();
                    break;
                case 5:
                    System.out.println(R + "删除员工：");
                    mysql.delete();
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
