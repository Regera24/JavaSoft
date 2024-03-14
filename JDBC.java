/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collection_practice;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.sql.Date;
import java.util.Scanner;
/**
 *
 * @author h
 */
public class JDBC {
    private String url = "jdbc:mysql://localhost:3306/car_schema?autoReconnect=true&useSSL=false";
    private String username = "root";
    private String password = "2412004aA@";

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return (Connection) DriverManager.getConnection(url, username, password);
    }
    
    public ArrayList<Car> getData(){
        ArrayList<Car> arr = new ArrayList<>();
        try {
            Connection con = getConnection();
            if (con != null) {
                PreparedStatement st = con.prepareStatement("select * from car_table");
                ResultSet rs = st.executeQuery();
                while(rs.next()){
                    String id = rs.getString(1);
                    String brand = rs.getString(2);
                    String name = rs.getString(3);
                    String version = rs.getString(4);
                    double price = rs.getDouble(5);
                    String color = rs.getString(6);
                    String date = rs.getString(7);
                    String engine = rs.getString(8);
                    int sales = rs.getInt(9);
                    int inventory = rs.getInt(10);
                    Car x = new Car(id,brand,name,version,price,color,date,engine,sales,inventory);
                    arr.add(x);
                }

            }
        } catch (Exception a) {
            System.out.println(a);
        }
        return arr;
    }
    
    public void deleteData(String id){
        try {
            Connection con = getConnection();
            if (con != null) {
                PreparedStatement st = con.prepareStatement("delete from car_table where id = ?");
                st.setString(1, id);
                st.executeUpdate();
            }
        } catch (Exception a) {
            System.out.println(a);
        }
    }
    
    public void sell(String id,String cusID,String cusName,String cusNum){
        try {
            Connection con = getConnection();
            if (con != null) {
                PreparedStatement st1 = con.prepareStatement("select * from car_table where id = ?");
                st1.setString(1, id);;
                ResultSet rs = st1.executeQuery();
                PreparedStatement st = con.prepareStatement("update car_table set sales = ?, inventory = ? where id = ?");
                PreparedStatement st2 = con.prepareStatement("insert into sales_table values (?,?,?,?,?,?,?)");
                while(rs.next()){
                  st.setInt(1, rs.getInt(9)+1);
                  st.setInt(2, rs.getInt(10)-1);
                  st.setString(3, id);
                  st.executeUpdate();
                  st2.setString(2, rs.getString(1));
                  st2.setString(3, rs.getString(2));
                  Date date = new Date(System.currentTimeMillis());
                  st2.setDate(1,date);
                  st2.setDouble(4, rs.getDouble(5));
                  st2.setString(5, cusID);
                  st2.setString(6, cusName);
                  st2.setString(7, cusNum);
                  st2.executeUpdate();
                }
            }
        } catch (Exception a) {
            System.out.println(a);
        }
    }
}
