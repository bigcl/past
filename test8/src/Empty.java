import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Empty implements ActionListener {
    Teacher teacher2;
    JLabel jLabel,label2;
    JTextField jTextField;
    Commandlistener commandlistener;
    JButton jButton;
    public void getA(JLabel jLabel){
        this.jLabel=jLabel;
    }
    public void getText(JTextField jTextField){
        this.jTextField=jTextField;
    }
    public void getL(JLabel jLabel){
        label2=jLabel;
    }
    public void getT(Teacher teacher){
        teacher2=teacher;
    }
    public void getB(JButton jButton){
        this.jButton=jButton;
    }
    public void actionPerformed(ActionEvent e) {
        teacher2.reset();
        jLabel.setText(teacher2.givequestion());
        jTextField.setText("");
        label2.setText("");
    }
}
