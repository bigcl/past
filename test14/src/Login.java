import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Login extends JFrame implements ActionListener {
    private JPanel pan = new JPanel();
    private JLabel namelab = new JLabel("用户名");
    private JLabel passlab = new JLabel("密码");
    private JTextField nametext = new JTextField();
    private JPasswordField passtext = new JPasswordField();


    public JButton denglu = new JButton("登录");
    public JButton zhuce = new JButton("插入");
    public JButton updatepass = new JButton("修改");
    public JButton deleteuser = new JButton("删除");


    public Login() {
        Font font = new Font("宋体", Font.BOLD, 12);
        super.setTitle("登录系统");
        pan.setLayout(null);
        namelab.setBounds(20, 20, 60, 30);
        nametext.setBounds(90, 20, 140, 30);
        passlab.setBounds(20, 60, 60, 30);
        passtext.setBounds(90, 60, 140, 30);
        denglu.setBounds(30, 120, 90, 20);
        zhuce.setBounds(140, 120, 90, 20);
        updatepass.setBounds(100, 150, 90, 20);
        deleteuser.setBounds(140, 150, 90, 20);

        pan.add(namelab);
        pan.add(nametext);
        pan.add(passlab);
        pan.add(passtext);
        pan.add(denglu);
        pan.add(zhuce);
        pan.add(updatepass);

        passtext.setFont(font);
        zhuce.setFont(font);
        updatepass.setFont(font);
        deleteuser.setFont(font);

        denglu.addActionListener(this);
        zhuce.addActionListener(this);
        updatepass.addActionListener(this);
        deleteuser.addActionListener(this);

        add(pan);
        setSize(300, 250);
        setVisible(true);
        setResizable(false);
    }

    public static void main(String[] args) {

        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        if (arg0.getSource() == denglu) {
            denglu();
        } else if (arg0.getSource() == zhuce) {
            zhuce();
        } else if (arg0.getSource() == updatepass) {
            updatepass();
        }

    }

    public void denglu() {
        Jdbcs d = new Jdbcs();
        String username = nametext.getText();
        String password = passtext.getText();
        if (d.compare(username, password)) {
            JOptionPane.showMessageDialog(null, "登录成功！");
            super.setVisible(false);
        }
    }

    //注册
    public void zhuce() {
        Jdbcs d = new Jdbcs();
        String username = nametext.getText();
        String password = passtext.getText();
        d.insert(username, password);
    }

    public void updatepass() {
        pan.setEnabled(false);
        JFrame frame1 = new JFrame("密码修改");
        frame1.setSize(250, 200);
        JPanel updatepass = new JPanel();
        JLabel namelab1 = new JLabel("用户名");
        JLabel passlab1 = new JLabel("旧密码");
        JLabel newpasslab = new JLabel("新密码");
        JTextField nametext1 = new JTextField("" + nametext.getText());
        JPasswordField passtext1 = new JPasswordField();
        JPasswordField newpasstext = new JPasswordField();
        JButton ok = new JButton("修改");

        updatepass.setLayout(null);

        namelab1.setBounds(5, 5, 70, 20);
        nametext1.setBounds(80, 5, 120, 20);
        passlab1.setBounds(5, 30, 70, 20);
        passtext1.setBounds(80, 30, 120, 20);
        newpasslab.setBounds(5, 60, 70, 20);
        newpasstext.setBounds(80, 60, 120, 20);
        ok.setBounds(10, 110, 60, 20);

        updatepass.add(namelab1);
        updatepass.add(nametext1);
        updatepass.add(passlab1);
        updatepass.add(passtext1);
        updatepass.add(newpasslab);
        updatepass.add(newpasstext);
        updatepass.add(ok);

        frame1.add(updatepass);
        frame1.setVisible(true);

        ok.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                Jdbcs d = new Jdbcs();
                String username = nametext1.getText();
                String password1 = passtext1.getText();
                String newpassword = newpasstext.getText();
                if (d.update(username, password1, newpassword)) {
                    frame1.setVisible(false);
                }
            }
        });

    }

}