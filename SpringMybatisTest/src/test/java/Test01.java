import mappera.StudentDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import student.Student;

public class Test01 {
    @Test
    public void test01() {
        //获取applicationContext文件并加载
        ApplicationContext ac = new ClassPathXmlApplicationContext("springApplicationContext.xml");
        //获取StudentDao的bean
        StudentDao sd = (StudentDao)ac.getBean("studentDao");
        Student s = sd.interfaceSelectOne(1);
        s.showStudent();
    }
}