/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysql.conexion;

import com.mysql.conexion.entidades.Producto;
import com.mysql.conexion.persistencias.Dao;
import com.mysql.conexion.persistencias.DaoProducto;
import com.mysql.jdbc.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Pc-Casa
 */
public class Probadita {
    public static void main(String[] args) throws SQLException {
        
        Dao dao = new Dao();
        DaoProducto daop = new DaoProducto();
        
        ArrayList<Producto>lista = new ArrayList();
        
        Connection connection = dao.Conectar();
        
        
            lista=daop.ProductosLista(connection);
        
            System.out.println(daop.MenorPrecio(connection));
            for (int i = 0; i < lista.size(); i++) {
                if(lista.get(i).getPrecio()==daop.MenorPrecio(connection)){
                    System.out.println(lista.get(i).getNombre());
                }
                
             }
        
             dao.Desconectar();
        
    }
}
