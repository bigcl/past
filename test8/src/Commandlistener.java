import javax.swing.*;
import java.awt.event.ActionListener;

interface Commandlistener extends ActionListener {
    public void getanswer(JTextField jTextField);
    public void getinformation(JLabel jLabel);
}
