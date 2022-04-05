import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class test {
    public static void main(String args[]) {
        Connection con = null;
        Statement sql;
        ResultSet rs;
        String rightpw;
        try {
            Class.forName("com.mysql.jdbc.Driver"); //加载JDBC_MySQL驱动
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        String uri = "jdbc:mysql://192.168.177.132/jokerdb";
        String user = "root";
        String password = "730121";
        try {
            con = DriverManager.getConnection(uri, user, password); //连接代码
        } catch (SQLException s) {
            System.out.println("SQL Error: " + s.toString() + " " + s.getErrorCode() + " " + s.getSQLState());
        }
        try {
            sql=con.createStatement();
            rs=sql.executeQuery("select password from user where username='1234567890'");
            while(rs.next()) {
                String number=rs.getString("password");
                //String name=rs.getString(3);
                System.out.printf("%s\t",number);
                //System.out.printf("%s\t",name);
                System.out.println();

            }
            con.close();
        }
        catch(SQLException ei) {
            System.out.println(ei);
        }
    }
}