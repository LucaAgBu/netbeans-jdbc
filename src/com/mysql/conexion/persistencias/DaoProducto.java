/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysql.conexion.persistencias;

import com.mysql.conexion.entidades.Producto;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Pc-Casa
 */
public class DaoProducto {
    
        public ArrayList<Producto> ProductosLista(Connection conectar){

        
        ArrayList<Producto> lista = new ArrayList();
        Producto producto;
        try {
            Statement stmt = conectar.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT codigo,nombre,precio,codigo_fabricante FROM tienda.producto;");
            while (rs.next()) {   
                producto = new Producto();
                producto.setCodigo(rs.getInt("codigo"));
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setCodigoFabricante(rs.getInt("codigo_fabricante"));
                lista.add(producto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return lista;
    }
        
        public ArrayList<Producto> ProductosPortatiles(Connection conectar){

        
        ArrayList<Producto> lista = new ArrayList();
        Producto producto;
        try {
            Statement stmt = conectar.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT codigo,nombre,precio,codigo_fabricante FROM tienda.producto where nombre like \"%Portatíl%\";");
            while (rs.next()) {   
                producto = new Producto();
                producto.setCodigo(rs.getInt("codigo"));
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setCodigoFabricante(rs.getInt("codigo_fabricante"));
                lista.add(producto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return lista;
    }
    
        public double MenorPrecio(Connection conectar){

        try {
            Statement stmt = conectar.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT MIN(precio) FROM tienda.producto;");
            while (rs.next()) {   
                return rs.getDouble("MIN(precio)");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return 0;
    }
        
        public void insertarProducto(String nombre, double precio, int codigoFabricante, Connection conectar){
            
            try {
                PreparedStatement stmt = conectar.prepareStatement("INSERT INTO tienda.producto(nombre, precio, codigo_fabricante) VALUES (?,?,?)");
                stmt.setString(1, nombre);
                stmt.setDouble(2, precio);
                stmt.setInt(3, codigoFabricante);
                stmt.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        
}
