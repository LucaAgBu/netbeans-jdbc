/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysql.conexion.persistencias;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Pc-Casa
 */
public class Dao {
     
    private static String Driver="com.mysql.jdbc.Driver";
    private static String Usuario="root";
    private static String Password="root";
    private static String URL="jdbc:mysql://localhost:3306/tienda";
    private static Connection con = null;
    

    
    public static Connection Conectar(){
        try {
            Class.forName(Driver);
            con=(Connection) DriverManager.getConnection(URL,Usuario,Password);
            JOptionPane.showMessageDialog(null, "Conexion exitosa");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erorr en la conexion"+e);
        }
        catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Erro en el driver: "+e);
        }
        return con;
    }
    
    public static void Desconectar() throws SQLException{
        if(con!=null){
            con.close();
        }
    }
    
}
