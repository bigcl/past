import javax.swing.*;
import java.awt.*;

public class Login  extends JFrame {
    JTextField jTextFieldUser,jTextFieldPwd;
    JLabel user,password,logininformation;
    JButton jButton;
    Commandlistenner listenner;
    JPanel jPanel;
    Login(){
        setTitle("登陆系统");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(400,500);
        setLocation(300,200);
        init();
    }
    public void init() {
        user = new JLabel("用户名");
        password = new JLabel("密码");
        jButton = new JButton("登录");
        jTextFieldUser = new JTextField();
        jTextFieldPwd = new JTextField();
        user.setBounds(100,150,60,30);
        add(user);
        jTextFieldUser.setBounds(170,150,100,30);
        add(jTextFieldUser);
        password.setBounds(100,200,60,30);
        add(password);
        jTextFieldPwd.setBounds(170,200,100,30);
        add(jTextFieldPwd);
        jButton.setBounds(180,250,60,30);
        add(jButton);
        logininformation=new JLabel();
        logininformation.setBounds(180,300,200,30);
        add(logininformation);
        listenner=new Monitor();
        listenner.setUser(jTextFieldUser);
        listenner.setPsd(jTextFieldPwd);
        listenner.setInformation(logininformation);
        jButton.addActionListener(listenner);
        System.out.println(jTextFieldUser.getText());
        setVisible(true);
    }
}
