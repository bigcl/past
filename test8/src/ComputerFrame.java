import javax.swing.*;
import java.awt.event.ActionListener;

public class ComputerFrame extends JFrame {
    JLabel question,answer,getQuestion,information;
    JButton submmit,again;
    JTextField answeri;
    Commandlistener commandlistener;
    ComputerFrame(){
        setLayout(null);
        setTitle("计算题");
        setBounds(300,200,400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        init();
    }
    void init(){
        Teacher teacher=new Teacher();
        commandlistener = teacher;
        question = new JLabel("题目:");
        question.setBounds(100,50,60,50);
        add(question);
        getQuestion = new JLabel();
        getQuestion.setBounds(150,60,200,30);
        getQuestion.setText(teacher.givequestion());
        add(getQuestion);
        answer = new JLabel("答案:");
        answer.setBounds(100,100,60,50);
        add(answer);
        submmit = new JButton("提交答案");
        submmit.setBounds(120,180,90,30);
        add(submmit);
        again = new JButton("再来一题");
        again.setBounds(250,180,90,30);
        add(again);
        answeri = new JTextField();
        answeri.setBounds(150,120,200,30);
        add(answeri);
        information = new JLabel();
        information.setBounds(200,220,200,30);
        add(information);
        commandlistener.getanswer(answeri);
        commandlistener.getinformation(information);
        submmit.addActionListener(commandlistener);
        Empty empty = new Empty();
        empty.getA(getQuestion);
        empty.getText(answeri);
        empty.getL(information);
        empty.getB(submmit);
        empty.getT(teacher);
        again.addActionListener(empty);
        setVisible(true);

    }
}
