// 
// Decompiled by Procyon v0.5.36
// 

package Encryption;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

public class AccessCredentials
{
    Connection con;
    Statement stmt;
    ResultSet rs;
    String URL;
    String dbusername;
    String dbpassword;
    int flag;
    
    public AccessCredentials() {
        this.URL = "jdbc:mysql://localhost/attendanceregister_cs_attendance";
        this.dbusername = "root";
        this.dbpassword = "root";
    }
    
    public int returnPassword(final String name, final String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("registered driver");
            this.con = DriverManager.getConnection(this.URL, this.dbusername, this.dbpassword);
            System.out.println("connection established");
            System.out.println("creating statements");
            this.stmt = this.con.createStatement();
            final String query1 = "select password from teachers_passwords where username ='" + name + "'";
            System.out.println("executing queries...");
            this.rs = this.stmt.executeQuery(query1);
            while (this.rs.next()) {
                final String dbpassword = this.rs.getString("password");
                System.out.println("pass=" + dbpassword);
                if (password.equals(dbpassword)) {
                    this.flag = 1;
                }
                else {
                    this.flag = 0;
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        }
        return this.flag;
    }
    
    public static void main(final String[] args) {
        final AccessCredentials ac = new AccessCredentials();
        final int i = ac.returnPassword("Vasugi", "12356");
        System.out.println(i);
    }
}
