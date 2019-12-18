package handle;

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
}
