package mapperdao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ZHZ
 */
public interface StudentDao extends BaseMapper<Student> {

    public Student query(@Param("str") String str);

    public Student query2(@Param("str") String str);

}