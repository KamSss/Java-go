package mappera;

import org.apache.ibatis.annotations.Param;
import student.Student;

public interface StudentDao {
    /**
     * 查询单个数据
     * 接口映射mapper中的sql
     * @param id
     * @return Student
     */
    Student interfaceSelectOne(@Param("id")int id);
}