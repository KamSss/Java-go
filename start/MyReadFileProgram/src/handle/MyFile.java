package handle;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZHZ
 */
public class MyFile {
    public void getAndShow(List<Person> personMessage){
        System.out.print("————————————————\n");
        String path = "F:\\test.txt";
        File f = new File(path);
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader
                    (new FileInputStream(f), StandardCharsets.UTF_8));
            String thisLine;
            while(((thisLine = br.readLine()) != null)){
                int i = 1;
                Person thisPerson = new Person();
                //把thisLine单行信息分成3个tmp分别存入personMessage的姓名性别年龄。
                for (String tmp: thisLine.split("\\|")){
                    if(i == 1){
                        i++;
                        System.out.print(tmp + "|");
                        thisPerson.setName(tmp);
                    }
                    else if(i == 2){
                        i++;
                        System.out.print(tmp + "|");
                        thisPerson.setSex(tmp);
                    }
                    else if(i == 3){
                        System.out.println(tmp);
                        thisPerson.setYear(tmp);
                    }
                }
                personMessage.add(thisPerson);
            }
            br.close();
        }catch (IOException e){
            System.out.println("异常捕获：按行获取文件失败！");
        }
        System.out.print("————————————————\n");
    }
    public void chooseAndChange(List<Person> personMessage){
        try {
            //获取要改动行数
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = br.readLine();
            //将str转成int传给修改函数
            int line = Integer.parseInt(str);
            Person thisPerson = personMessage.get(line);
            //1.展示thisPerson
            System.out.println("第"+line+"行信息如下：");
            thisPerson.show();
            //2.修改thisPerson
            System.out.println("请输入修改姓名：（例如：张三）");
            thisPerson.setName(br.readLine());
            System.out.println("请输入修改性别：（例如：男性）");
            thisPerson.setSex(br.readLine());
            System.out.println("请输入修改年龄：（例如：20）");
            thisPerson.setYear(br.readLine());
        }catch(IOException e){
            System.out.println("异常捕获：获取控制台输入流失败");
        }
    }
    public void saveAndShow(List<Person> personMessage){
        try{
            File f = new File("F:\\test.txt");
            Writer out = new FileWriter(f);
            for(int i = 0;i < personMessage.size();i++) {
                Person p = personMessage.get(i);
                out.write(p.getName() + "|");
                out.write(p.getSex() + "|");
                out.write(p.getYear() + "\r");
            }
            out.close();
        }catch (IOException e){
            System.out.println("异常捕获：写入文件失败");
        }
    }
}
