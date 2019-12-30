package dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import student.Student;
import student.StudentParam;

import java.util.List;

/**
 * @author ZHZ
 */
public interface StudentDao {
    /**
     * 插入数据
     * @param student
     */
    @Insert("insert into table1 values(#{id},#{name},#{age})")
    void annotationInsert(Student student);
    /**
     * 删除数据
     * @param id
     */
    @Delete("delete from table1 where id=#{v}")
    void annotationDelete(int id);
    /**
     * update数据
     * @param student
     */
    @Update("update table1 set name=#{name},age=#{age}" + " where id=#{id}")
    void annotationUpdate(Student student);
    /**
     * 查询
     * @param name
     * @return Student
     */
    @Select("select * from table1")
    List<Student> annotationSelectAll();
    /**
     * 查询单个数据
     * 接口映射mapper中的sql
     * @param id
     * @return Student
     */
    Student InterfaceSelectOne(int id);
    /**
     * 查询单个数据
     * 基于注释把sql写在接口中
     * @param id
     * @return Student
     */
    @Select("select * from table1 where id=#{v}")
    Student annotationSelectById(int id);
    /**
     * 查询
     * @param name
     * @return Student
     */
    @Select("select * from table1 where name=#{v}")
    List<Student> annotationSelectByName(String name);
    /**
     * 查询
     * @param age
     * @return Student
     */
    @Select("select * from table1 where age=#{v}")
    List<Student> annotationSelectByAge(int age);

    List<Student> query(StudentParam studentParam);

}
