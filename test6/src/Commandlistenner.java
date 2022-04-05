import javax.swing.*;
import java.awt.event.ActionListener;

interface Commandlistenner extends ActionListener {
    public void setUser(JTextField jTextField);
    public void setPsd(JTextField jTextField);
    public void setInformation(JLabel jLabel);
}
