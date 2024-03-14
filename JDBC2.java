/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collection_practice;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author h
 */
public class JDBC2 {
    private String url = "jdbc:mysql://localhost:3306/car_schema?autoReconnect=true&useSSL=false";
    private String username = "root";
    private String password = "2412004aA@";

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return (Connection) DriverManager.getConnection(url, username, password);
    }
    
    public ArrayList<soldCar> getData(){
        ArrayList<soldCar> arr = new ArrayList<>();
        try {
            Connection con = getConnection();
            if (con != null) {
                PreparedStatement st = con.prepareStatement("select * from sales_table");
                ResultSet rs = st.executeQuery();
                while(rs.next()){
                    Date date = rs.getDate(1);
                    String id = rs.getString(2);
                    String name = rs.getString(3);
                    double price = rs.getDouble(4);
                    soldCar x = new soldCar(id,name,price,date);
                    arr.add(x);
                }

            }
        } catch (Exception a) {
            System.out.println(a);
        }
        return arr;
    }
}
