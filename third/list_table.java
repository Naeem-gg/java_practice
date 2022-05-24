import java.sql.*;
import java.io.*;
public class list_table
{
public static void main(String[] args) throws Exception
{
ResultSet rs = null;
Statement st = null;
ResultSetMetaData rsmd = null;
int columnCount = 0;
Class.forName("org.postgresq|.Driver");
Connection con =
DriverManager.getConnection("jdbc:postgresq]://localhost/ASG","msgcs","msgcs");
DatabaseMetaData dbmd = con.getMetaData();
System.out.println("Database Product name =" + dbmd.getDatabaseProductName());
System.out.println("User name = " + dbmd.getUserName());
System.out.println("Database driver name= " + dbmd.getDriverName());
System.out.println("Database driver version = "+ dbmd.getDriverVersion());
System.out.println("Database product name = " + dbmd.getDatabaseProductName());
System.out.println("Database Version = " + dbmd.getDriverMajorVersion()+"\n");
rs = dbmd.getTables(null,null,null, new String[]{"TABLE"});
System.out.println("List of tables...");
while(rs.next())
{
String tbIName = rs.getString("TABLE_NAME");
System.out.println("Table : "+ tbIName);
}
if(con != null)
st = con.createStatement();if(st != null)
rs = st.executeQuery("SELECT * FROM project");
if(rs!= null)
rsmd = rs.getMetaData();
if(rsmd != null)
columnCount = rsmd.getColumnCount();
System.out.println("\nColumn Names");
if(rsmd != null)
{
for(int i=1; i<=columnCount; i++)
System.out.print(rsmd.getColumnLabel(i)+" ");
}
con.close();
}
}
