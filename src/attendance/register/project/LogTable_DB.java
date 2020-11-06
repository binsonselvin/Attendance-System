// 
// Decompiled by Procyon v0.5.36
// 

package attendance.register.project;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

public class LogTable_DB
{
    Connection con;
    Statement stmt;
    ResultSet rs;
    String dbName;
    String driver_URL;
    String con_URL;
    String username;
    String password;
    
    public LogTable_DB() {
        this.dbName = "alien";
        this.driver_URL = "com.mysql.jdbc.Driver";
        this.con_URL = "jdbc:mysql://localhost/" + this.dbName;
        this.username = "root";
        this.password = "root";
    }
    
    public void updateAttendance() {
        try {
            Class.forName(this.driver_URL);
            this.con = DriverManager.getConnection(this.con_URL, this.username, this.password);
            System.err.println("Connection Established");
            this.stmt = this.con.createStatement();
            System.err.println("Statement Created");
            final String sql = "select * from alien_table";
            this.rs = this.stmt.executeQuery(sql);
            while (this.rs.next()) {
                final String name = this.rs.getInt(1) + " " + this.rs.getString(2) + " " + this.rs.getString(3) + " " + this.rs.getString(4) + " " + this.rs.getString(5);
                System.out.println(name);
            }
        }
        catch (ClassNotFoundException ce) {
            ce.printStackTrace();
        }
        catch (SQLException ce2) {
            ce2.printStackTrace();
        }
        finally {
            try {
                if (this.con != null) {
                    this.con.close();
                }
            }
            catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (this.stmt != null) {
                    this.stmt.close();
                }
            }
            catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("connection closed");
    }
    
    public static void main(final String[] args) {
        final LogTable_DB lg = new LogTable_DB();
        lg.updateAttendance();
    }
}
