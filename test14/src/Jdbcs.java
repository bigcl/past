import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Jdbcs {
    Connection con = null;
    Connection con1 = null;
    Statement statement = null;
    Statement statement1 = null;
    ResultSet res = null;
    ResultSet res1 = null;
    String driver = "com.mysql.cj.jdbc.Driver";
    String uri = "jdbc:mysql://192.168.177.132/jokerdb";
    String user = "root";
    String password = "123456";
    public Jdbcs() {
        try {
            Class.forName(driver).newInstance();
            con = DriverManager.getConnection(uri, user, password);
            con1 = DriverManager.getConnection(uri, user, password);
            statement = con.createStatement();
            statement1 = con1.createStatement();

        } catch (ClassNotFoundException e) {
            System.out.println("对不起，找不到这个Driver");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean update(String username1, String password1, String newpassword) {
        boolean judge = false;
        boolean s = compare(username1, password1);
        if (s) {
            String sql ="update user set password =%s where username=%s".formatted(password1,username1);
            System.out.println(sql);
            try {
                int a = statement1.executeUpdate(sql);
                System.out.println(sql);
                if (a == 1) {
                    JOptionPane.showMessageDialog(null, "密码修改成功！");
                    judge = true;
                }
                con1.close();
                statement1.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "用户不存在！");
                e.printStackTrace();
            }
        }
        return judge;
    }

    public void insert(String username, String password) {
        if (username == null || username.trim().length() <= 0) {
            JOptionPane.showMessageDialog(null, "注册账号为空，请重新输入！");
            return;
        }
        String sql = "insert into user(username,password) values(\"" + username + "\",\"" + password + "\")";
        try {
            int a = statement.executeUpdate(sql);
            con.close();
            statement.close();
            if (a == 1) {
                JOptionPane.showMessageDialog(null, "注册成功！");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "对不起该用户名已经有了！");
            e.printStackTrace();
        }
    }

    public boolean compare(String username, String password) {
        boolean m = false;
        String sql = "select password from user where username=\"" + username + "\"";
        try {
            res = statement.executeQuery(sql);
            if (res.next()) {
                String pa = res.getString(1);
                System.out.println(pa + " " + password);
                if (pa.equals(password)) {
                    m = true;
                } else {
                    JOptionPane.showMessageDialog(null, "密码错误！");
                }
            } else {
                JOptionPane.showMessageDialog(null, "用户名不存在！");
            }
            res.close();
            con.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return m;
    }

}