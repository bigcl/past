import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class test {
    public static void main(String args[]){
        Window win = new Window();
        win.setTitle("梯形");
        win.setBounds(100,100,420,260);
    }
}
class Window extends JFrame implements ActionListener {
    Lader lader;
    JTextField textAbove,textBottom,textHeight;
    JTextArea showArea;
    JButton controlButton;
    Window() {
        init();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    void init() {
        lader = new Lader();
        textAbove = new JTextField(5);
        textBottom = new JTextField(5);
        textHeight = new JTextField(5);
        showArea = new JTextArea();
        controlButton=new JButton("计算面积");
        JPanel jPanel=new JPanel();
        setLayout(new BorderLayout());
        jPanel.add(new JLabel("上底:"));
        jPanel.add(textAbove);
        jPanel.add(new JLabel("下底:"));
        jPanel.add(textBottom);
        jPanel.add(new JLabel("高:"));
        jPanel.add(textHeight);
        jPanel.add(controlButton);
        controlButton.addActionListener(this);
        add(jPanel,BorderLayout.NORTH);
        add(new JScrollPane(showArea),BorderLayout.CENTER);
    }
    public void actionPerformed(ActionEvent e) {
            double above = Double.parseDouble(textAbove.getText());
            double bottom = Double.parseDouble(textBottom.getText());
            double height = Double.parseDouble(textHeight.getText());
            lader.setAbove(above);
            lader.setBottom(bottom);
            lader.setHeight(height);
            double area = lader.getArea();
            showArea.append("上底:"+above+"下底:"+bottom+"高:"+height+"面积:"+area+"\n");
    }
}
class Lader {
    double above,bottom,height;
    public double getArea() {
        double area = (above+bottom)*height/2.0;
        return area;
    }
    public void setAbove(double a) {
        above = a;
    }
    public void setBottom(double b) {
        bottom = b;
    }
    public void setHeight(double c) {
        height = c;
    }
}

