import com.sun.rowset.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.sql.rowset.*;
public class Main {
public static void main(String[] args) {
JFrame frame = new ResultSetFrame();
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);
}
}
class ResultSetFrame extends JFrame {
private JScrollPane scrollPane;

private ResultSetTableModel model;

private JComboBox tableNames;

        private JButton jb1;

        private JTextField jtf1;

        private JTextField jtf2;

private ResultSet rs;

private Connection conn;

private Statement stat;

private boolean scrolling;


public ResultSetFrame() {
setTitle("ResultSet");
setSize(400, 400);
tableNames = new JComboBox();
tableNames.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent event) {
try {
if (scrollPane != null)
remove(scrollPane);
String tableName = (String) tableNames.getSelectedItem();
if (rs != null)
rs.close();
String query = "SELECT * FROM " + tableName;
rs = stat.executeQuery(query);
if (scrolling)
model = new ResultSetTableModel(rs);
else {
CachedRowSet crs = new CachedRowSetImpl();
crs.populate(rs);
model = new ResultSetTableModel(crs);
}

JTable table = new JTable(model);
scrollPane = new JScrollPane(table);
add(scrollPane, BorderLayout.CENTER);
validate();
} catch (SQLException e) {
e.printStackTrace();
}
}
});
jb1=new JButton("增加");
jb1.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent event) {
test();
}
});
jtf1=new JTextField("ccc");
jtf2=new JTextField("123");
jtf1.setToolTipText("用户名");
jtf2.setToolTipText("密码");
JPanel p = new JPanel();
p.setLayout(new GridLayout(2,3));
p.add(new JLabel());
p.add(tableNames);
p.add(new JLabel());
p.add(jtf1);
p.add(jtf2);
p.add(jb1);
add(p, BorderLayout.NORTH);

try {
conn = getConnection();
DatabaseMetaData meta = conn.getMetaData();
if (meta.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) {
scrolling = true;
stat = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
} else {
stat = conn.createStatement();
scrolling = false;
}
ResultSet tables = meta.getTables(null, null, null, new String[] { "TABLE" });
while (tables.next())
tableNames.addItem(tables.getString(3));
tables.close();
}
catch (IOException e) {
e.printStackTrace();
} catch (SQLException e) {
e.printStackTrace();
}

addWindowListener(new WindowAdapter() {
public void windowClosing(WindowEvent event) {
try {
if (conn != null)
conn.close();
} catch (SQLException e) {
e.printStackTrace();
}
}
});
}

private void test(){
String s1=jtf1.getText();
String s2=jtf2.getText();
String tableName = (String) tableNames.getSelectedItem();
String insert="insert into "+tableName+" values('"+s1+"','"+s2+"')";
System.out.println(insert);
try {
int i=stat.executeUpdate(insert);
JOptionPane.showMessageDialog(null, "添加成功："+i+"条") ;
} catch (SQLException e) {
// TODO Auto-generated catch block
JOptionPane.showMessageDialog(this, "添加失败") ;
e.printStackTrace();
}
}
public static Connection getConnection() throws SQLException, IOException {
Properties props = new Properties();
FileInputStream in = new FileInputStream("database.properties");
props.load(in);
in.close();

String drivers = props.getProperty("jdbc.drivers");
try {
Class.forName(drivers);
} catch (ClassNotFoundException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
String url = props.getProperty("jdbc.url");
String username = props.getProperty("jdbc.username");
String password = props.getProperty("jdbc.password");

return DriverManager.getConnection(url, username, password);
//  return DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=cwb&password=cwb123&useUnicode=true");
}
}


class ResultSetTableModel extends AbstractTableModel {
private ResultSet rs;
private ResultSetMetaData rsmd;
public ResultSetTableModel(ResultSet aResultSet) {
rs = aResultSet;
try {
rsmd = rs.getMetaData();
} catch (SQLException e) {
e.printStackTrace();
}
}

public String getColumnName(int c) {
try {
return rsmd.getColumnName(c + 1);
} catch (SQLException e) {
e.printStackTrace();
return "";
}
}

public int getColumnCount() {
try {
return rsmd.getColumnCount();
} catch (SQLException e) {
e.printStackTrace();
return 0;
}
}

public Object getValueAt(int r, int c) {
try {
rs.absolute(r + 1);
return rs.getObject(c + 1);
} catch (SQLException e) {
e.printStackTrace();
return null;
}
}

public int getRowCount() {
try {
rs.last();
return rs.getRow();
} catch (SQLException e) {
e.printStackTrace();
return 0;
}
}
}