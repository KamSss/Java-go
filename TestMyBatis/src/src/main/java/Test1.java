import dao.StudentDao;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.io.Resources;
import student.Student;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

/**
 * @author ZHZ
 */
public class Test1 {
    static void wayOne(SqlSession session){
     // 方法一：session直接去Mapper.xml找sql语句
     //缺点：复杂项目命名空间名称很长，传的这个方法名前面就会带上一长串的命名空间，非常复杂不美观，而且传参错了不容易被发现
     Student a = session.selectOne("mySelectOne",1);
     a.showStudent();
     session.close();
    }
    static void wayTwo(SqlSession session){
     //方法二：session.getMapper方法去调一个代理接口，跟映射文件的交互全部通过这个接口负责
     //优势：比起方法一的selectXXX，避免了命名空间过于复杂导致的参数名字过长且易错的问题
     StudentDao sd = session.getMapper(StudentDao.class);
     Student b = sd.InterfaceSelectOne(2);
     b.showStudent();
     session.close();
    }
    static void selectByAnnotation(SqlSession session){
        //方法三:在接口中基于注释写sql
        StudentDao sd = session.getMapper(StudentDao.class);
        Scanner sn = new Scanner(System.in);
        int input = 0;
        List<Student> studentList;
        do {
            System.out.println("请输入查询条件：1-全查找 2-名字查找 3-年龄查找 4-id查找");
            input = sn.nextInt();
            switch (input) {
                case 1:
                    studentList = sd.annotationSelectAll();
                    for (Student s : studentList) {
                        s.showStudent();
                    }
                    break;
                case 2:
                    String name = sn.nextLine();
                    name = sn.nextLine();
                    studentList = sd.annotationSelectByName(name);
                    for(Student s : studentList){
                        s.showStudent();
                    }
                    break;
                case 3:
                    int age = sn.nextInt();
                    studentList = sd.annotationSelectByAge(age);
                    for(Student s : studentList){
                        s.showStudent();
                    }
                    break;
                case 4:
                    int id = sn.nextInt();
                    Student c = sd.annotationSelectById(id);
                    c.showStudent();
                    break;
                default:
                    System.out.println("输入错误，请重新输入");
            }
        }while(input != 0);
        session.close();
    }
    static void insertByAnnotation(SqlSession session){
     Student c = new Student();
     c.setId(5);
     c.setName("小五");
     c.setAge(15);
     StudentDao sd = session.getMapper(StudentDao.class);
     sd.annotationInsert(c);
     session.commit();//提交到数据库
     session.close();
    }
    static void deleteByAnnotation(SqlSession session){
     StudentDao sd = session.getMapper(StudentDao.class);
     sd.annotationDelete(5);
     session.commit();
     session.close();
    }
    static void updateByAnnotation(SqlSession session){
     Student c = new Student();
     c.setId(4);
     c.setName("小五");
     c.setAge(24);
     StudentDao sd = session.getMapper(StudentDao.class);
     sd.annotationUpdate(c);
     session.commit();
     session.close();
    }
    public static void main(String[] args) throws IOException {
        //Mybatis中的工具类Resources可以读取指定配置文件(以及映射文件)
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-configs.xml");
        // 创建sqlSession的工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 通过工厂创建sqlSession
        SqlSession session = sqlSessionFactory.openSession();

//        wayOne(session);
//        wayTwo(session);
//
        selectByAnnotation(session);
//        insertByAnnotation(session);
//        deleteByAnnotation(session);
//        updateByAnnotation(session);
    }
}
