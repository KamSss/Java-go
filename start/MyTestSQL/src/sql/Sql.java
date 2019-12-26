package sql;

import java.sql.*;
import java.util.Scanner;

/**
 * @author ZHZ
 */
public class Sql {
    Connection conn;
    Statement statement;

    public void init() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection
                    ("jdbc:mysql://127.0.0.1:3306/test1?serverTimezone=GMT%2B8", "root", "980120");
            statement = conn.createStatement();
            System.out.println("初始化成功");
        } catch (ClassNotFoundException | SQLException c) {
            c.printStackTrace();
        }
    }
    private void sqlUpdate(String sql,String operator){
        try {
            statement.executeUpdate(sql);
        }catch (SQLException se){
            se.printStackTrace();
        }
    }
    public void selectAll(){
        String sql = "select * from table1;";
        try {
            statement.execute(sql);
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                int age = result.getInt("age");
                System.out.println("id:" + id + " 姓名:" + name + " 年龄：" + age);
            }
        }catch (SQLException s){
            s.printStackTrace();
        }
    }
    public void selectSolo(){
        Scanner s = new Scanner(System.in);
        System.out.println("根据id号还是姓名查找：（输入1是按照id，输入2是姓名,输入3是年龄）");
        int input = s.nextInt();
        String sql = "select * from table1 where ";
        if(input == 1){
            System.out.println("请输入要查询成员的id号：");
            int id = s.nextInt();
            sql += "id=" + id + ";";
        }else if(input == 2){
            System.out.println("请输入要查询成员的姓名：");
            String name = s.nextLine();
            name = s.nextLine();
            sql += "name='" + name + "';";
        }else{
            System.out.println("请输入要查询成员的年龄：");
            int age = s.nextInt();
            sql += "age=" + age + ";";
        }

        try {
            statement.execute(sql);
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                int resultId = result.getInt("id");
                String resultName = result.getString("name");
                int resultAge = result.getInt("age");
                System.out.println("id:" + resultId + " 姓名:" + resultName + " 年龄：" + resultAge);
            }
        }catch (SQLException se){
            se.printStackTrace();
        }
    }
    public void insert(){
        Scanner s = new Scanner(System.in);
        System.out.println("请输入新成员年龄：");
        String age = s.nextLine();
        System.out.println("请输入新成员姓名：");
        String name = s.nextLine();
        String sql = "insert into table1 value(0,\"" + name + "\"," + age + ");";
        sqlUpdate(sql,"插入");
    }
    public void delete(){
        Scanner s = new Scanner(System.in);
        System.out.println("根据id号或者姓名、年龄删除：（输入1是按照id，输入2是姓名,输入3是年龄）");
        int input = s.nextInt();
        String sql = "delete from table1 where ";
        if(input == 1){
            System.out.println("请输入要删除成员的id号：");
            int id = s.nextInt();
            sql += "id=" + id + ";";
        }else if(input == 2){
            System.out.println("请输入要删除成员的姓名：");
            String name = s.nextLine();
            name = s.nextLine();
            sql += "name='" + name + "';";
        }else{
            System.out.println("请输入要删除成员的年龄：");
            int age = s.nextInt();
            sql += "age=" + age + ";";
        }
        sqlUpdate(sql,"删除");
    }
    public void change(){
        Scanner s = new Scanner(System.in);
        System.out.println("请输入要修改成员的id号：");
        int id = s.nextInt();
        System.out.println("请输入修改之后成员的姓名：");
        String resultName = s.nextLine();
        resultName = s.nextLine();
        System.out.println("请输入修改之后成员的年龄：");
        int resultAge = s.nextInt();
        String sql = "update table1 set name=\"" + resultName + "\",age=" + resultAge + " where id=" + id + ";";
        sqlUpdate(sql,"修改");
    }
}
