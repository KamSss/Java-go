import java.sql.*;

/**
 * @author ZHZ
 */
public class MyTest {
    public static void main(String[] args){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection
                    ("jdbc:mysql://127.0.0.1:3306/test1?serverTimezone=GMT%2B8", "root", "980120");
            Statement statement = conn.createStatement();
            String select = "select * from table1;";
            String insert = "insert into table1 value(3,\"小李\");";
            //statement.executeUpdate(select);
            statement.execute(select);
            ResultSet result = statement.executeQuery(select);
            while(result.next()){
                int id = result.getInt("id");
                String name = result.getString("name");
                System.out.println("id:" + id + " 姓名:" + name);
            }
        }catch (ClassNotFoundException | SQLException c){
            c.printStackTrace();
        }
    }
}
