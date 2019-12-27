package handle;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author ZHZ
 */
public class MyFile {
    public List<Person> getAndAdd(){
        List<Person> personList = new ArrayList<>();
        String path = "F:\\test.txt";
        File f = new File(path);
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader
                    (new FileInputStream(f), StandardCharsets.UTF_8));
            String thisLine;
            while(((thisLine = br.readLine()) != null)){
                int i = 1;
                Person thisPerson = new Person();
                //把thisLine根据“|”分隔开并放入String[]
                String[] split = thisLine.split("\\|");
                thisPerson.setName(split[0]);
                thisPerson.setSex(split[1]);
                thisPerson.setYear(split[2]);
                personList.add(thisPerson);
            }
            br.close();
        }catch (IOException e){
            System.out.println("异常捕获：按行获取文件失败！");
        }
        return personList;
    }

    public void showPerson(List<Person> personList){
        for(Person person : personList){
            System.out.print(person.getName() + "|");
            System.out.print(person.getSex() + "|");
            System.out.println(person.getYear());
        }
    }

    public void chooseAndChange(List<Person> personList,int line){
        Person thisPerson = personList.get(line);
        Scanner s = new Scanner(System.in);
        //1.展示thisPerson
        System.out.println("第" + line + "行信息如下：");
        thisPerson.show();
        //2.修改thisPerson
        System.out.println("请输入修改姓名：（例如：张三）");
        thisPerson.setName(s.nextLine());
        System.out.println("请输入修改性别：（例如：男性）");
        thisPerson.setSex(s.nextLine());
        System.out.println("请输入修改年龄：（例如：20）");
        thisPerson.setYear(s.nextLine());
    }

    public void writeToFile(List<Person> personList){
        File f = new File("F:\\test.txt");
        try(Writer out = new FileWriter(f)){
            for (Person p : personList) {
                out.write(p.getName() + "|");
                out.write(p.getSex() + "|");
                out.write(p.getYear() + "\r");
            }
        }catch (IOException e){
            System.out.println("异常捕获：写入文件失败");
        }
    }
}
