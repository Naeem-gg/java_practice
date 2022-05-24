import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.text.JTextComponent;
public class project extends JFrame implements ActionListener
{
static JTextField t1;
JTextField t2;
JTextField t3;
JTextField t4;
JTextField tf1;
JTextField tf2;
JTextField tf3;
JTextField tf4;
JTextField tf;
JLabel l1,l2,l3,l4,lb,lb1,lb2,lb3,lb4,lb5;
JButton b1,b2,btn;
JFrame jf;
project(JTextField obj)
{
jf=new JFrame();
l1=new JLabel("Project ID"); jf.add(l1);
t1=new JTextField(10); jf.add(t1);
l2=new JLabel("Project Name");
jf.add(l2);
t2=new JTextField(10);
jf.add(t2);
l3=new JLabel("Project Description");
t3=new JTextField(10);
l4=new JLabel("Project Status");
t4=new JTextField(10);
b1=new JButton("Insert");
jf.add(l3);
jf.add(t3);
jf.add(l4);
jf.add(t4);
jf.add(b1);
b1.addActionListener(this);
b2=new JButton("Display");
b2.addActionListener(this);
jf.add(b2);lb5 = new JLabel("Enter Project Name to be search:");
obj = new JTextField(20);
jf.add(obj);
lb1 = new JLabel("Peoject Id:");
jf.add(lb1);
tf1 = new JTextField(50);
lb2 = new JLabel("Project Name:");
tf2 = new JTextField(100);
jf.add(tf1);
jf.add(lb2);
jf.add(tf2);
lb3 = new JLabel("Peoject Description:");
tf3 = new JTextField(50);
jf.add(lb3);
jf.add(tf3);
lb4 = new JLabel("Project Status :"); jf.add(lb4);
tf4 = new JTextField(50);
jf.add(tf4);
tf1.setEditable(false);
tf2.setEditable(false);
tf3.setEditable(false);
tf4.setEditable(false);
jf.setLayout(new GridLayout(10, 2, 5, 5));
jf.setSize(500, 500);
jf.setVisible(true);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
try
{
    Class.forName("org.postgresq|.Driver");
}
catch(Exception e)
{
System.out.println("Error"+e.getMessage());
}
}
public void actionPerformed(ActionEvent e2, JTextComponent obj)
{
if(e2.getSource()==b1)
{
try
{
int pid=Integer.parseInt(t1 .getText());
String pnm=t2.getText();
jf.add(lb5);String pdc=t3.getText();
String pst=t4.getText();
Connection conn =
DriverManager.getConnection("jdbc:postgresq|://localhost/ASG","msgcs","msgcs");
PreparedStatement st=conn.prepareStatement("insert into project values(?,?,?,?)");
st.setInt(1, pid);
st.setString(2,pnm);
st.setString(3,pdc);
st.setString(4,pst);
st.executeUpdate();
st.close();
JOptionPane.showMessageDialog(this,"Record Inserted Successfully");
}
catch(Exception e)
{
System.out.println("Error...."+e.getMessage());
}
}
if(e2.getSource()==b2)
{
try
{
String str = obj.getText();
Connection con =
DriverManager.getConnection("jdbc:postgresq]://localhost/ASG","msgcs","msgcs");
PreparedStatement st = con.prepareStatement("select * from project where pnm=?");
st.setString(1, str);
ResultSet rs = st.executeQuery();
if (rs.next())
{
String s = rs.getString(1);
String s1 = rs.getString(2);
String s2 = rs.getString(3);
String s3 = rs.getString(4);
tf1.setText(s);
tf2.setText(s1 );
tf3.setText(s2);
tf4.setText(s3);
}
else
{
JOptionPane.showMessageDialog(null, "Name not Found..");
}}
catch (Exception ex)
{
System.out.println(ex);
}
}
}
public static void main(String[] args)
{
new project(t1);
}
@Override
public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
    
}
}