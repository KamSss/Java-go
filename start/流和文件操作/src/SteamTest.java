import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;

/**
 * @author ZHZ
 */
class FileTest{
    private static void getInputSteam() {
        //获取控制台输入流
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = br.readLine();
            System.out.println(str);
        }catch(IOException e){
            System.out.println("异常捕获：控制台输入流获取失败！");
        }
    }
    private static void dirCreateAndDelete(){
        //1.文件夹创建删除
        String path = "F:\\test";
        File f = new File(path);
        if(!f.exists()){
            f.mkdir();
            //f.delete();
        }
    }
    private static void fileCreateAndDelete() {
        //2.文件创建删除
        String path = "F:\\test.txt";
        String fileName = "test.txt";
        File f = new File(path);
        try {
            boolean c = f.createNewFile();
            //boolean d = f.delete();
        }catch (IOException e){
            System.out.println("异常捕获：文件创建失败!");
        }
    }
    private static void getFileByBite() {
        //1.按字节读取文件，常用于二进制文件，如图片声音
        String path = "F:\\test.txt";
        File f = new File(path);
        try {
            InputStream ips = new FileInputStream(f);
            int a = ips.read();
            System.out.println(a);
//        //2.按多个字节读取文件
//        byte[] temp = new byte[100];
//        ips.read(temp));
        }catch (IOException e){
            System.out.println("异常捕获：按字节读取文件失败！");
        }
    }
    private static void getFileByChar(){
        //2.以单字符为单位读取文件
        String path = "F:\\test.txt";
        File f = new File(path);
        try {
            Reader r = new InputStreamReader(new FileInputStream(f));
            int tmp;
            while ((tmp = r.read()) != -1) {
                if (((char) tmp) != '\r') {
                    System.out.println((char) tmp);
                }
            }
        }catch (IOException e){
            System.out.println("异常捕获：按字符获取文件失败！");
        }
    }
    private static void getFileByString(){
        //按字符串读取文件
        String path = "F:\\test.txt";
        File f = new File(path);
        try {
            Reader r = new InputStreamReader(new FileInputStream(f));
            char[] temp = new char[30];
            r.read(temp);
            System.out.println(temp);
        }catch (IOException e){
            System.out.println("异常捕获：按字符串获取文件失败！");
        }
    }
    private static void getFileByLine(){
        //3.按行读取数据
        String path = "F:\\test.txt";
        File f = new File(path);
        try {
            //下面这行无法读取中文字符，下面第二行使用GBK编码格式可以读取中文
            //BufferedReader r = new BufferedReader(new FileReader(f));
            BufferedReader r = new BufferedReader(new InputStreamReader
                    (new FileInputStream(f),"GBK"));
            String tmp;
            while((tmp = r.readLine()) != null){
                System.out.println(tmp);
            }
        }catch (IOException e){
            System.out.println("异常捕获：按行获取文件失败！");
        }
    }
    private static void writeToFile() throws IOException {
        long skip = 20;
        String str = "王五|男性|20\n王五|男性|20";
        String fileName = "F:\\tmp.txt";
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "rw");
            if (skip < 0 || skip > randomAccessFile.length()) {
                return;
            }
            byte[] b = str.getBytes();
            System.out.println(b.length);
            System.out.println(randomAccessFile.length());
            randomAccessFile.setLength(randomAccessFile.length() + b.length);
            //把后面的内容往后面挪
            for (long i = randomAccessFile.length() - 1; i > b.length + skip - 1; i--) {
                randomAccessFile.seek(i - b.length);
                byte temp = randomAccessFile.readByte();
                randomAccessFile.seek(i);
                randomAccessFile.writeByte(temp);
            }
            randomAccessFile.seek(skip);
            randomAccessFile.write(b);
            randomAccessFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException {
//        getInputSteam();
//        dirCreateAndDelete();
//        fileCreateAndDelete();
//        getFileByBite();
//        getFileByChar();
//        getFileByString();
//        getFileByLine();
        writeToFile();
    }
}
