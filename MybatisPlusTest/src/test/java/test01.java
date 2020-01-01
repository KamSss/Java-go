import entity.StudentClass;
import entity.StudentVO;
import mapperdao.StudentClassDao;
import mapperdao.StudentDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import entity.Student;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:springApplicationContext.xml"})
public class test01 {
    @Resource
    private StudentDao studentDao;
    private StudentClassDao studentClassDao;

    private Student student = new Student();
    private StudentClass studentClass = new StudentClass();
    private List<StudentVO> studentVOList;

    @Before
    public void ty() {

        student.setId(5);
        student.setName("小刘");
        student.setAge(38);
        student.setClass_id(1);
    }
    @Test
    public void testInsert(){
        studentDao.insert(student);
        //mybatisPlus会自动把当前插入对象在数据库中的id写回到该实体中
        student.showStudent();
    }
    @Test
    public void testSelectOne(){
        student.setId(1);
        student = studentDao.selectById(student.getId());
        student.showStudent();
    }
    @Test
    public void testSelectAll(){
        Map<String,Object> studentMap = new HashMap<String, Object>();
        //studentMap.put("id",1);
        studentMap.put("name","小明");
        studentMap.put("age",21);
        List<Student> studentList = studentDao.selectByMap(studentMap);
        System.out.println(studentList.size());
    }
    @Test
    public void testDelete(){
        //1.根据id删除
        studentDao.deleteById(1);
        //2.根据条件删除
        Map<String,Object> studentMap = new HashMap<String, Object>();
        studentMap.put("name",1);
        studentMap.put("age",80);
        studentDao.deleteByMap(studentMap);
    }

    @Test
    public void tablesSelect(){
//        studentVOList = studentClassDao.getStudentVO(student,studentClass);
        Student student = studentDao.query2("1");
        student.showStudent();
    }
}

