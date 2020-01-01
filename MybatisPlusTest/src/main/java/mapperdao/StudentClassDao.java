package mapperdao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import entity.Student;
import entity.StudentClass;
import entity.StudentVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author ZHZ
 */
public interface StudentClassDao extends BaseMapper<Student> {
    /**
     * 查询
     * @param student
     * @param studentClass
     * @return 查询对象类
     */
    @Select("SELECT table1.id,table1.`name`,table1.age,table2.class_name FROM table1,table2 WHERE table1.class_id = table2.class_id")
    List<StudentVO> getStudentVO(Student student,StudentClass studentClass);
}