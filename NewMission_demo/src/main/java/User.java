import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * @author ZHZ
 */
@Entity
public class User {
    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String name;
    private String phone;
    private String password;

    @Override
    public String toString(){
        return "{"+ "id"+getId()+"'"+
                ",name='"+getName()+ "'"+
                ",phone='"+getPhone()+"'"+
                ",password='"+getPassword()+"'"+
                "}";
    }
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password=password;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
