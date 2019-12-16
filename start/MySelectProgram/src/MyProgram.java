import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

class SelectMessage{

    Person getMessage(String messageOfThisLine,int line) throws IOException {
        //1.把string拆分成对象的各个属性,并且做修改
        System.out.println(messageOfThisLine);

        //2.把属性写入本行
        try {
            File tmp = File.createTempFile("temp", null);
            //在虚拟机终止时，删除这个临时缓存文件
            tmp.deleteOnExit();
            FileOutputStream fos = new FileOutputStream(tmp);
            RandomAccessFile raf = new RandomAccessFile("F:\\test.txt", "rw");

            //1.写入临时文件
            //每两个字节跳过一个汉字
            int pos = 15;
            raf.seek(pos);
            byte[] buffer = new byte[4];
            int num = 0;
            while ((num = raf.read(buffer)) != -1) {
                fos.write(buffer, 0, num);
            }

            //2.回到目标位置插入数据
            raf.seek(pos);
            raf.write("aaa".getBytes());

            //3.把之前缓存的内容重新填充到后面
            FileInputStream fis = new FileInputStream(tmp);
            while (-1 != (num = fis.read(buffer))) {
                raf.write(buffer, 0, num);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/**
 * @author ZHZ
 */
public class MyProgram {
    private static List<Person> getFileByLine(){
        //按行读取数据
        String path = "F:\\test.txt";
        File f = new File(path);
        try {
            BufferedReader r = new BufferedReader(new InputStreamReader
                    (new FileInputStream(f), StandardCharsets.UTF_8));
            String tmp1;
            List<Person> list = new ArrayList<>();
            while(((tmp1 = r.readLine()) != null)){
                int i = 1;
                Person person = new Person();
                for (String tmp: tmp1.split("\\|")){
                    if(i == 1){
                        i++;
                        System.out.println("请输入修改姓名：（例如：张三）");
                        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                        person.setName(br.readLine() + "|");
                    }
                    else if(i == 2){
                        i++;
                        System.out.println("请输入修改性别：（例如：男性）");
                        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                        this.sex = br.readLine() + "|";
                    }
                    else if(i == 3){
                        System.out.println("请输入修改年龄：（例如：20）");
                        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                        this.year = br.readLine();
                    }
                }
                list.add(person);
            }
        }catch (IOException e){
            System.out.println("异常捕获：按行获取文件失败！");
        }
    }
    private static void chooseTheLine(List<Person> list){
        System.out.print("\n要改动第__行：");
        try {
            //获取要改动行数
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = br.readLine();
            //将str转成int传给修改函数
            int line = Integer.parseInt(str);
            Person person = list.get(line);
            changeTheLine(person);
        }catch(IOException e){
            System.out.println("异常捕获：控制台输入流获取失败！");
        }
    }
    private static void changeTheLine(Person person){

        person.setName("ss");
        String path = "F:\\test.txt";
        File f = new File(path);
        try {
            BufferedReader r = new BufferedReader(new InputStreamReader
                    (new FileInputStream(f),"UTF-8"));
            String tmp;
            while(((tmp = r.readLine()) != null) && line > 0){
                line--;
            }
            SelectMessage sm = new SelectMessage();
            //把tmp各个属性拆开到对象里
            Person person = sm.getMessage(tmp, line);
        }catch (IOException e){
            System.out.println("异常捕获：修改当前行失败！");
        }
    }
    private static void entrance(){
        System.out.println("————————————————\n");
        //1.读取、显示数据
        List<Person> fileByLine = getFileByLine();
        chooseTheLine(fileByLine);
    }
    public static void main(String[] args){
        entrance();
    }
}
