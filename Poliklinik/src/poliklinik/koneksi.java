/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poliklinik;

/**
 *
 * @author asus
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author phantom
 */
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class koneksi{

    private static Connection mysqlkonek;
 public static Connection koneksiDB() throws SQLException{
        if(mysqlkonek==null){
 try {
 String url="jdbc:mysql://localhost:3306/pemrograman3_uts";
 String user="root";
 String pass="";
 
 DriverManager.registerDriver(new com.mysql.jdbc.Driver());
 mysqlkonek = (Connection) DriverManager.getConnection(url,user,pass);
 
 
 } catch (Exception e) {
 JOptionPane.showMessageDialog(null,"gagal koneksi");
 }
 
 }
 
 return mysqlkonek;
 
 }
 public static void main (String args[]){
 
 }
 
}
