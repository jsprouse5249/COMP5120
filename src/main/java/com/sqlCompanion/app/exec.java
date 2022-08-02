package com.sqlCompanion.app;//packagesqlSample;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class exec {
    public static void main(String[]args) {
        try{
            // The newInstance() call is a work around for some
            // broken Java implementations
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            String dbName="final_project";
            String port="3306";
            String pwd="root";
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:"+port+"/"+dbName+"?"+ "user=root&password="+pwd);

            Statement stmt=conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM book");
            while(rs.next()) {
                int id = rs.getInt("BookID");
                String name = rs.getString("BookName");
                System.out.println(id+"---"+name);
            }
        } catch(SQLException ex) {
            System.out.println("SQLException: "+ ex.getMessage());
            System.out.println("SQLState: "+ ex.getSQLState());
            System.out.println("VendorError: "+ ex.getErrorCode());
    } catch(Exception e) {
            System.out.println("Unkown Error:"+ e.getMessage());
        }
    }
}