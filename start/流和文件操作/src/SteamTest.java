import java.io.*;

/**
 * @author ZHZ
 */
//控制台输入
//public class SteamTest {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = "aaa";
//        do{
//            str = br.readLine();
//            System.out.println(str);
//        }while(!str.equals("abc"));
//    }
//}

class FileTest{
    private static void fielMkdirAndDelete(){
                //1.文件夹创建删除
        String path = "F:\\test";
        File f = new File(path);
        if(f.exists()){
            f.mkdir();
            f.delete();
        }
    }
    "aa|ss|1"
    public static void main(String[] args) throws IOException {
        out();
        inBefore();
        in();
        save();

//        fielMkdirAndDelete();

        //2.文件创建删除
        String path = "F:\\test.txt";
        String fileName = "test.txt";
        File f = new File(path);
        f.createNewFile();
        //f.delete();
//
//        //1.按字节读取文件，常用于二进制文件，如图片声音
//        String path = "F:\\test.txt";
//        File f = new File(path);
//        InputStream ips = new FileInputStream(f);
//        int a = ips.read();
//        System.out.println(a);
//        //2.按多个字节读取文件
//        byte[] temp = new byte[100];
//        ips.read(temp));
//
//        //2.以单字符为单位读取文件
//        String path = "F:\\test.txt";
//        File f = new File(path);
//        Reader r = new InputStreamReader(new FileInputStream(f));
//        int tmp;
//        while((tmp = r.read()) != -1){
//            if(((char)tmp) != '\r'){
//                System.out.println((char)tmp);
//            }
//        }
//        //按字符串读取文件
//        char[] temp = new char[30];
//        r.read(temp);
//
//        //3.按行读取数据
//        BufferedReader r = new BufferedReader(new FileReader(f));
//        r.readLine();
    }
}
