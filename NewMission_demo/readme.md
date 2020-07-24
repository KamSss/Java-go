创建：
选择Spring Initializr项目
选择依赖：
1.JPA 是Java Persistence API, 也就是Java持久层API, 
    它的本质是一套将Java的对象映射到数据库中的关系表的标准, 
    而Spring-Boot的JPA依赖包含一个重要子依赖, 
    你一定听过它的名字: Hibernate. 它是JPA的具体实现, 
    也是Spring Boot的默认JPA实现
2.MySQL、oracle 是用来实现从Java到MySQL、oracle连接的一个中间件.   
3.web：springboot重要组件 包含tomcat、springMVC等核心组件 

配置application.properties文件
spring.datasource.username=niudai
spring.datasource.password=niudai
spring.datasource.url=jdbc:mysql://localhost:3306/springdb
spring.jpa.hibernate.ddl-auto=create

其中create表示开发模式，每次启动都会重新创建一个新表，清除原有的表。开发结束之后可以设置为none
声明了这些之后，启动应用spring就可以自动连接该数据库
注解：
user.java
@Entity
public class user {
    @Id
    @GeneratedValue(strategy = GenerationType)
    private Integer id;
    private String name;
    private String phone;
    private String password;

加了@Entity注解, Spring框架会得知这个类是一个实体类，对应数据库中的表名 
Hibernate会把这个类映射到数据库中的关系表, 这个关系表的列与User的所有属性一一对应

UserRepository.java
CrudRepository
public interface UserRepository extends CrudRepository<User,Interger> {
    List<User> findByPhone(String phone);
    void deleteByPhone(String phone);
}

这只是一个接口，没有具体实现，如何完成对user信息的存储repository呢：spring会帮你自动实现
该类继承自CrudRepository，在别的地方调用继承自他的方法（方法名遵守一定的规范），spring会自动把类似于findByPhone()替换成SQL语句