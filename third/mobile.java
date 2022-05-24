import java.sql.*;
import java.io.*;

public class mobile {
    public static void main(String args[]) {
        Connection con;
        ResultSet rs;
        PreparedStatement p;
        int ch;
        try {
            Class.forName("org.postgresq|.Driver");
            System.out.println("Driver Loaded");
            con = DriverManager.getConnection("jdbc:postgresq|://localhost/ASG", "msgcs", "msgcs");
            do {
                System.out.println("\n");
                System.out.println("Menu:");
                System.out.println("1.Insert Record ");
                System.out.println("2.Update an Existing Record.");
                System.out.println("3.Display Records");
                System.out.println("4.Search Record.");
                System.out.println("5.Exit");
                System.out.println("Enter your choice: ");
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                ch = Integer.parseInt(br.readLine());
                switch (ch) {
                    case 1:
                        System.out.println("Enter Model Number: ");
                        int no = Integer.parseInt(br.readLine());
                        System.out.println("Enter Model Name: ");
                        String name = br.readLine();
                        System.out.println("Enter Model Color: ");
                        String clr = br.readLine();
                        System.out.println("Enter Network Type: ");
                        String nt = br.readLine();
                        System.out.println("Enter Battery Capacity: ");
                        int bcap = Integer.parseInt(br.readLine());
                        System.out.println("Enter Internal Storage: ");
                        int st = Integer.parseInt(br.readLine());
                        System.out.println("Enter RAM: ");
                        int rm = Integer.parseInt(br.readLine());
                        System.out.println("Enter ProcessorType: ");
                        int pro = Integer.parseInt(br.readLine());
                        String sql = "insert into Mobile values(?,?,?,?,?,?,?,?)";
                        p = con.prepareStatement(sql);
                        p.setInt(1, no);
                        p.setString(2, name);
                        p.setString(3, clr);
                        p.setString(4, nt);
                        p.setInt(5, bcap);
                        p.setInt(6, st);
                        p.setInt(7, rm);
                        p.setInt(8, pro);
                        p.executeUpdate();
                        System.out.println("Record Added");
                        break;
                    case 2:
                        Statement smt = con.createStatement();
                        System.out.println("Enter Mobile Number for the record you wish to Update: ");
                        no = Integer.parseInt(br.readLine());
                        try {
                            System.out.println("Enter Mobile Name: ");
                            name = br.readLine();
                            System.out.println("Enter new storage: ");
                            st = Integer.parseInt(br.readLine());
                            String q = "UPDATE mno=mobile SET mnm=" + name + ",st=" + st + " WHERE mno=" + no + "";
                            ResultSet res = smt.executeQuery(q);
                            smt = con.createStatement();
                            if (res.next()) {
                                System.out.println("Record Updated...");
                            }
                        } catch (Exception e) {
                            System.out.println("Record Not Updated..." + e);
                        }
                        break;
                    case 3:
                        Statement state = con.createStatement();
                        sql = "select * from mobile";
                        rs = state.executeQuery(sql);
                        while (rs.next()) {
                            System.out.println("\n");
                            System.out.print("\t" + rs.getInt(1));
                            System.out.print("\t" + rs.getString(2));
                            System.out.print("\t" + rs.getString(3));
                            System.out.print("\t" + rs.getString(4));
                            System.out.print("\t" + rs.getInt(5));
                            System.out.print("\t" + rs.getInt(6));
                            System.out.print("\t" + rs.getInt(7));
                            System.out.print("\t" + rs.getInt(8));
                            break;
                        }
                    case 4:
                        try {

                            Statement stmt = con.createStatement();
                            System.out.println("Enter Mobile Number to search: ");
                            no = Integer.parseInt(br.readLine());
                            String q = "Select * from mobile where mno=" + no + "";
                            ResultSet res = stmt.executeQuery(q);
                            if (res.next()) {
                                do {
                                    System.out.println(res.getInt(1) + "\t" + res.getString(2) + "\t" + res.getString(3)
                                            + "," + res.getString(
                                                    4)
                                            + "," + res.getInt(5) + "," + res.getInt(6) + "," + res.getInt(7) + ","
                                            + res.getInt(8));
                                } while (res.next());
                            } else {
                                System.out.println("Record Not Found...");
                            }
                        }

                        catch (Exception e) {
                            System.out.println(e);
                        }
                        break;
                    case 5:
                        System.exit(0);
                    default:
                        System.out.println("Invalid Choice");
                        break;
                }
            } while (ch != 5);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}