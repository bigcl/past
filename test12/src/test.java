import javax.swing.*;
import java.sql.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class test {
    public static void main(String args[]) {
        getWin();
    }
    public static void getWin(){
        JFrame frame=new JFrame("登录");
        frame.setBounds(600,244,250, 250);
        frame.setVisible(true);//设置窗口可见
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);    //设置当窗口关闭时对Java程序进行的操作。
        JLabel pic=new JLabel();
        //将图片标签组件放置在JPanel面板上面，以便调整位置。
        JPanel pan=new JPanel();
        pan.add(pic,JPanel.CENTER_ALIGNMENT);
        frame.add(pan,BorderLayout.PAGE_START);

        //创建账号密码的输入文本框。
        JLabel lab1=new  JLabel("账号：");
        JTextField text1=new JTextField (15);
        JLabel lab2=new  JLabel("密码：");
        JPasswordField text2=new JPasswordField (15);

        //再次创建JPanel面板，将这些组件放进去。
        JPanel pan1=new JPanel();
        pan1.add(lab1);
        pan1.add(text1);
        pan1.add(lab2);
        pan1.add(text2);

        frame.add(pan1,BorderLayout.CENTER);
        JButton button1=new JButton("注册");
        JButton button2=new JButton("登录");
        button1.addActionListener(new ActionListener () {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

                //建立注册窗体
                JFrame f1=new JFrame("csdn注册");
                f1.setVisible(true);
                f1.setDefaultCloseOperation(frame.HIDE_ON_CLOSE);
                f1.setBounds(600,240,250, 250);

                JLabel l1=new  JLabel("注册账号：");
                JTextField t1=new JTextField (15);
                JLabel l2=new  JLabel("注册密码：");
                JPasswordField t2=new JPasswordField (15);
                JButton b=new JButton("保存");
                JPanel p=new JPanel();
                p.add(l1);
                p.add(t1);
                p.add(l2);
                p.add(t2);
                p.add(b);
                f1.add(p,BorderLayout.CENTER);
                //给保存按钮注册监听器
                b.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // TODO Auto-generated method stub

                        String acc1=t1.getText();
                        String acc2=new String(t2.getPassword());
                        System.out.println(acc2);
                        t1.setText("");
                        t2.setText("");
                        if((acc1!=null && acc1.length()!=0)&&(acc2!=null && acc2.length()!=0)) {
                            //保存到数据库。
                            dbcon.keepinfo(acc1, acc2);

                            JDialog dia=new JDialog(f1,"提示 ",true);
                            dia.setBounds(630,300,200, 150);
                            dia.setDefaultCloseOperation(dia.HIDE_ON_CLOSE);

                            JLabel l=new JLabel("保存成功！");
                            Font f=new Font("宋体",Font.BOLD,20);
                            l.setFont(f);
                            JPanel p=new JPanel();
                            p.add(l);
                            dia.add(p,BorderLayout.NORTH);
                            dia.setVisible(true);

                        }
                        else {
                            //判断账号、密码文本框中内容是否为空。如果是，弹出对话框。
                            JDialog dia=new JDialog(f1,"提示 ",true);
                            dia.setBounds(630,300,200, 150);
                            dia.setDefaultCloseOperation(dia.HIDE_ON_CLOSE);

                            JLabel l=new JLabel("输入内容不能为空");
                            Font f=new Font("宋体",Font.BOLD,20);
                            l.setFont(f);
                            JPanel p=new JPanel();
                            p.add(l);
                            dia.add(p,BorderLayout.NORTH);
                            dia.setVisible(true);}
                                              }
                                          });
                                      }
                                  }
        );

        //给button2登录 注册监听器
        button2.addActionListener(new ActionListener () {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String acc1=text1.getText();
                String acc2=new String(text2.getPassword());
                text1.setText("");
                text2.setText("");
                if((acc1!=null && acc1.length()!=0)&&(acc2!=null && acc2.length()!=0)) {


                    if(dbcon.compword(acc1, acc2)) {
                        //建立登录窗体
                        JFrame f2=new JFrame("csdn博客");

                        f2.setDefaultCloseOperation(frame.HIDE_ON_CLOSE);
                        f2.setBounds(600,240,290, 580);
                        JLabel la=new JLabel();
                        f2.add(la);
                        f2.setVisible(true);
                    }else //如果账号密码不匹配，则弹出提示对话框。
                    {
                        JDialog dia=new JDialog(frame,"提示 ",true);
                        dia.setBounds(630,300,220, 150);
                        dia.setDefaultCloseOperation(dia.HIDE_ON_CLOSE);

                        JLabel l=new JLabel("账号或者密码错误，请重试");
                        Font f=new Font("宋体",Font.BOLD,20);
                        l.setFont(f);
                        JPanel p=new JPanel();
                        p.setLayout(new BorderLayout());
                        p.add(l,BorderLayout.CENTER);
                        dia.add(p,BorderLayout.NORTH);
                        dia.setVisible(true);
                    }

                }


                else {

                    //判断账号、密码文本框中内容是否为空。如果是，弹出对话框。
                    JDialog dia=new JDialog(frame,"提示 ",true);
                    dia.setBounds(630,300,200, 150);
                    dia.setDefaultCloseOperation(dia.HIDE_ON_CLOSE);

                    JLabel l=new JLabel("输入内容不能为空");
                    Font f=new Font("宋体",Font.BOLD,20);
                    l.setFont(f);
                    JPanel p=new JPanel();
                    p.add(l);
                    dia.add(p,BorderLayout.NORTH);
                    dia.setVisible(true);}

            }
        });

        JPanel pan2=new JPanel();
        pan2.add(button1);
        pan2.add(button2);
        frame.add(pan2,BorderLayout.PAGE_END);
    }

}
//编写一个连接数据库类

class dbcon {


    public static void keepinfo(String a,String b) { //用于保存账号密码信息的方法

        try {
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection con = null;
        PreparedStatement pre= null;
        //2.建立连接并插入数据到表
        try{
            String url = "jdbc:mysql://192.168.177.132:3306/jokerdb";
            String username = "root";
            String password = "123456";
            con =DriverManager.getConnection(url, username, password);
            pre=con.prepareStatement("insert intovalues(?,?)");
            pre.setString(1,a);
            pre.setString(2,b);
            int get=pre.executeUpdate();
            System.out.println("被影响的行数"+get);
        }catch(Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                if(pre!=null)
                    pre.close();
                if(con!=null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean compword(String a,String b) { //完成登录时的数据匹配方法即可
        try {
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        boolean istrue=false;
        Connection con = null;
        PreparedStatement pre= null;
        //2.建立连接并查询数据，以此来匹配传入的账号密码是否正确。
        try{
            String url = "jdbc:mysql://192.168.177.132:3306/jokerdb";
            String username = "root";
            String password = "123456";
            con =DriverManager.getConnection(url, username, password);
            pre=con.prepareStatement("select *from user where username=?and password=?");
            pre.setString(1, a);
            pre.setString(2, b);
            ResultSet res=pre.executeQuery();
            while(res.next()) {
                String id=res.getString(1);
                String psword=res.getString(2);
                if(id.equalsIgnoreCase(a)&&psword.equalsIgnoreCase(b)){
                    istrue=true;
                    break;}
                else{
                    istrue= false;
                    break;}
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return istrue;
    }
}
