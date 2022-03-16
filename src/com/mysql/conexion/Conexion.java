/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysql.conexion;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Pc-Casa
 */
public class Conexion {
    
    private static String Driver="com.mysql.jdbc.Driver";
    private static String Usuario="root";
    private static String Password="root";
    private static String URL="jdbc:mysql://localhost:3306/tienda";
    
    static {
        try {
            Class.forName(Driver);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Erro en el driver: "+e);
        }
    }
    
    public Connection getConextion(){
        Connection con = null;
        try {
            con=(Connection) DriverManager.getConnection(URL,Usuario,Password);
            JOptionPane.showMessageDialog(null, "Conexion exitosa");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erorr en la conexion"+e);
        }
        return con;
    }
    
}
