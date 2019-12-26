package student;

/**
 * @author ZHZ
 */
public class Student {
    private int id;
    private String name;
    private int age;

    public Student(){
        super();
    }

    public Student(int id,String name, int age) {
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

    public void showStudent() {
        System.out.println("Student[id=" + this.id + ", name=" + this.name + ", age=" + this.age + "]");
    }
}
