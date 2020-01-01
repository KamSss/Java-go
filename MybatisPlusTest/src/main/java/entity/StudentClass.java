package entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * @author ZHZ
 */
@TableName(value = "table2")
public class StudentClass {
    @TableId(value = "class_id",type = IdType.ID_WORKER)
    private int class_id;
    private String class_name;

    public StudentClass(){
        super();
    }

    public StudentClass(int class_id,String class_name){
        this.class_id = class_id;
        this.class_name = class_name;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }
}
