import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.*;

public class Monitor implements Commandlistenner{
    JTextField inputuser,inputpwd;
    JLabel jLabel;
    public void setPsd(JTextField jTextField) {
        inputpwd=jTextField;
    }

    @Override
    public void setUser(JTextField jTextField) {
        inputuser=jTextField;
    }

    @Override
    public void setInformation(JLabel jLabel) {
        this.jLabel=jLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s1=inputuser.getText();
        String s2=inputpwd.getText();
        Connection con = null;
        Statement sql;
        ResultSet rs;
        String rightpw=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception ei) {
            System.out.println(e.toString());
        }
        String uri = "jdbc:mysql://192.168.177.132/jokerdb";
        String user = "root";
        String password = "123456";
        try {
            con = DriverManager.getConnection(uri, user, password);
        } catch (SQLException s) {
            System.out.println("SQL Error: " + s.toString() + " " + s.getErrorCode() + " " + s.getSQLState());
        }
        try {
            sql=con.createStatement();
            rs=sql.executeQuery("select password from user where username="+s1);
            while(rs.next()) {
                rightpw=rs.getString("password");
            }
        }
        catch(SQLException ei) {
            System.out.println(ei);
        }

        if(s2.equals(rightpw)){
            jLabel.setText("登录成功");
        }
        else jLabel.setText("登陆失败");
    }
}
