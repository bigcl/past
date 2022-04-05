import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Teacher implements Commandlistener{
    int number1,number2,value;
    int key;
    char symbol;
    String s;
    JTextField jTextField;
    JLabel jLabel;
    Teacher(){
        Random random = new Random();
        number1 = random.nextInt(100);
        number2 = random.nextInt(100);
        int i = random.nextInt(4);
        if (i==0) symbol = '+';
        if (i==1) symbol = '-';
        if (i==2) symbol = '*';
        if (i==3) symbol = '/';
        if(symbol=='+') key=number1+number2;
        if(symbol=='-') key=number1-number2;
        if(symbol=='*') key=number1*number2;
        if(symbol=='/') key=number1/number2;
    }
    public String givequestion(){
        return String.valueOf(number1)+"    "+symbol+"    "+String.valueOf(number2);
    }
    public void reset(){
        Random random = new Random();
        number1 = random.nextInt(100);
        number2 = random.nextInt(100);
        int i = random.nextInt(4);
        if (i==0) symbol = '+';
        if (i==1) symbol = '-';
        if (i==2) symbol = '*';
        if (i==3) symbol = '/';
        if(symbol=='+') key=number1+number2;
        if(symbol=='-') key=number1-number2;
        if(symbol=='*') key=number1*number2;
        if(symbol=='/') key=number1/number2;
    }
    public void getanswer(JTextField jTextField){
        this.jTextField=jTextField;
    }
    public void getinformation(JLabel jLabel){
        this.jLabel=jLabel;
    }
    public void actionPerformed(ActionEvent e){
        value=Integer.parseInt(jTextField.getText());
        if(value==key) jLabel.setText("答案正确！");
        else jLabel.setText("答案错误！正确答案"+key);
        System.out.println(number1);
    }
}


