package entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * @author ZHZ
 */
@TableName(value = "table1")
public class Student {
    @TableId(value = "id",type = IdType.AUTO)
    private int id;
    private String name;
    private int age;
    private int class_id;
    private String className;

    public void setClassName(String className){
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    private StudentClass studentClass;

    public Student(){
        super();
    }

    public Student(int id,String name,int age) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setClass_id(int class_id){
        this.class_id = class_id;
    }

    public int getClass_id(){
        return class_id;
    }



    public void showStudent() {
        System.out.println
                ("查询结果：" + "[id=" + this.id + ", name=" +
                        this.name + ", age=" + this.age + ", className=" + this.className + ", class_id=" +
                        this.class_id + "]" + "\n");
    }
}