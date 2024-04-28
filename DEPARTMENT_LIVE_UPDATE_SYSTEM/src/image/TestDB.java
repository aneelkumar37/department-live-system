/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Dell
 */
import java.sql.*;
public class TestDB {
 
    public static void main(String arg[])throws ClassNotFoundException{
   
        Connection conn = null;
 try {
        Class.forName("com.mysql.cj.jdbc.Driver");
            String dbURL = "jdbc:mysql://localhost:3306/POS";
            String username = "root";
            String password = "";
            conn = DriverManager.getConnection(dbURL, username, password);

            // Perform some operations on the database
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM Login ");

                while (rs.next()) {
                    System.out.println(rs.getString("user_name"));
                    System.out.println(rs.getInt("user_id"));
                    System.out.println(rs.getString("user_pass"));
                    System.out.println(rs.getString("user_email"));
            }
        } //catch (ClassNotFoundException e) {
            //e.printStackTrace();
//        } 
catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the connection when done
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
    
 }
 }
}
    
    


