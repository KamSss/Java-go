package handle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author ZHZ
 */
public class Person {
    String name;
    String sex;
    String year;

    public void show(){ System.out.println(this.name + "|" + this.sex + "|" + this.year); }

    public String getName() {
        return name;
    }

    public String getSex() { return sex; }

    public String getYear() { return year; }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) { this.sex = sex; }

    public void setYear(String year) { this.year = year; }

    public void add() {
        Scanner s = new Scanner(System.in);
        System.out.println("请输入新员工姓名：（例如：张三）");
        this.name = s.nextLine();
        System.out.println("请输入新员工性别：（例如：男性）");
        this.sex = s.nextLine();
        System.out.println("请输入新员工年龄：（例如：20）");
        this.year = s.nextLine();
    }
}
