������
ѡ��Spring Initializr��Ŀ
ѡ��������
1.JPA ��Java Persistence API, Ҳ����Java�־ò�API, 
    ���ı�����һ�׽�Java�Ķ���ӳ�䵽���ݿ��еĹ�ϵ��ı�׼, 
    ��Spring-Boot��JPA��������һ����Ҫ������, 
    ��һ��������������: Hibernate. ����JPA�ľ���ʵ��, 
    Ҳ��Spring Boot��Ĭ��JPAʵ��
2.MySQL��oracle ������ʵ�ִ�Java��MySQL��oracle���ӵ�һ���м��.   
3.web��springboot��Ҫ��� ����tomcat��springMVC�Ⱥ������ 

����application.properties�ļ�
spring.datasource.username=niudai
spring.datasource.password=niudai
spring.datasource.url=jdbc:mysql://localhost:3306/springdb
spring.jpa.hibernate.ddl-auto=create

����create��ʾ����ģʽ��ÿ�������������´���һ���±����ԭ�еı���������֮���������Ϊnone
��������Щ֮������Ӧ��spring�Ϳ����Զ����Ӹ����ݿ�
ע�⣺
user.java
@Entity
public class user {
    @Id
    @GeneratedValue(strategy = GenerationType)
    private Integer id;
    private String name;
    private String phone;
    private String password;

����@Entityע��, Spring��ܻ��֪�������һ��ʵ���࣬��Ӧ���ݿ��еı��� 
Hibernate��������ӳ�䵽���ݿ��еĹ�ϵ��, �����ϵ�������User����������һһ��Ӧ

UserRepository.java
CrudRepository
public interface UserRepository extends CrudRepository<User,Interger> {
    List<User> findByPhone(String phone);
    void deleteByPhone(String phone);
}

��ֻ��һ���ӿڣ�û�о���ʵ�֣������ɶ�user��Ϣ�Ĵ洢repository�أ�spring������Զ�ʵ��
����̳���CrudRepository���ڱ�ĵط����ü̳������ķ���������������һ���Ĺ淶����spring���Զ���������findByPhone()�滻��SQL���