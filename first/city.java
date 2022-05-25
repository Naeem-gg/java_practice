import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class city
extends JFrame implements ActionListener
{
JFrame jf;
JLabel l1,l2,l3;
JTextField t1,t2,t3;
JButton b1,b2,b3;
JTextArea t;
JPanel p1,p2;
Hashtable ts;
city()
{
jf=new JFrame();
ts=new Hashtable();
t1=new JTextField(10);
t2=new JTextField(10);
t3=new JTextField(10);
l1=new JLabel("Enter City Name");
l2=new JLabel("Enter City Code");
l3=new JLabel("Enter City Name to Search");
b1=new JButton("Add");
b2=new JButton("Search");
b3=new JButton("Remove");t=new JTextArea(20,20);
p1=new JPanel();
p1.add(t);
setSize(500,500);
setVisible(true);
add(p1);
p2= new JPanel();
p2.setLayout(new FlowLayout());
p2.add(l1);
p2.add(t1);
p2.add(l2);
p2.add(t2);
p2.add(b1);
p2.add(l3);
p2.add(t3);
p2.add(b2);
p2.add(b3);
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
t.setEditable(false);
add(p1);
add(p2);
setLayout(new FlowLayout());
setSize(400,400);
setVisible(true);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
public void actionPerformed(ActionEvent e)
{
if(b1==e.getSource())
{
String name = t1.getText();
int code = Integer.parseInt(t2.getText());
ts.put(name,code);
Enumeration k=ts.keys();
Enumeration v=ts.elements();
String msg="";
while(k.hasMoreElements())
{
msg=msg+k.nextElement()+" = "+v.nextElement()+"\n";
}
t.setText(msg);
t1.setText("");
t2.setText("");if(ts != null)
JOptionPane.showMessageDialog(null,"Data Inserted ...");
else
JOptionPane.showMessageDialog(null,"Data not inserted ...");
}
else if(b2==e.getSource())
{
String name = t3.getText();
if(ts.containsKey(name))
{
t.setText(ts.get(name).toString());
}
else
JOptionPane.showMessageDialog(null,"Data not found ...");
}
else if(b3==e.getSource())
{
String name = t3.getText();
if(ts.containsKey(name))
{
ts.remove(name);
JOptionPane.showMessageDialog(null,"City Deleted ...");
}
else
JOptionPane.showMessageDialog(null,"City not found ...");
}
}
public static void main(String a[])
{
    city obj=new city();
}
}
