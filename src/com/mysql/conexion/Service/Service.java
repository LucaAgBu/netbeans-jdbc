/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysql.conexion.Service;

import com.mysql.conexion.entidades.Producto;
import com.mysql.conexion.persistencias.Dao;
import com.mysql.conexion.persistencias.DaoProducto;
import com.mysql.jdbc.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Pc-Casa
 */
public class Service {
    
public static void main(String[] args) throws SQLException {
    
    Connection connection;
    
    Scanner leer = new Scanner(System.in);
    
    Dao dao = new Dao();
    DaoProducto daop = new DaoProducto();
        
    ArrayList<Producto>lista = new ArrayList();
        
    System.out.println("Menu\n"
            + "1) Lista el nombre de todos los productos que hay en la tabla producto.\n" +
"2) Lista los nombres y los precios de todos los productos de la tabla producto.\n" +
"3) Listar aquellos productos que su precio esté entre 120 y 202.\n" +
"4) Buscar y listar todos los Portátiles de la tabla producto.\n" +
"5) Listar el nombre y el precio del producto más barato.\n" +
"6) Ingresar un producto a la base de datos.\n" +
"7) Ingresar un fabricante a la base de datos\n" +
"8) Editar un producto con datos a elección.");
    int x=leer.nextInt();
    
    switch (x) {
        case 1:
            lista.clear();
            connection = dao.Conectar();
        
            lista=daop.ProductosLista(connection);
        
            for (int i = 0; i < lista.size(); i++) {
                  System.out.println(lista.get(i).getNombre());
             }
        
             dao.Desconectar();
            break;
        case 2:
            lista.clear();
            connection = dao.Conectar();
        
            lista=daop.ProductosLista(connection);
        
            for (int i = 0; i < lista.size(); i++) {
                  System.out.println(lista.get(i).getNombre() +" precio: "+ lista.get(i).getPrecio());
             }
        
             dao.Desconectar();
            break;
        case 3:
            lista.clear();
            connection = dao.Conectar();
        
            lista=daop.ProductosLista(connection);
        
            for (int i = 0; i < lista.size(); i++) {
                if(lista.get(i).getPrecio()<120 && lista.get(i).getPrecio()>200){
                    System.out.println(lista.get(i).getNombre());
                }
             }
        
             dao.Desconectar();
            break;
        case 4:
            lista.clear();
            connection = dao.Conectar();
        
            lista=daop.ProductosPortatiles(connection);
        
            for (int i = 0; i < lista.size(); i++) {
                if(lista.get(i).getPrecio()<120 && lista.get(i).getPrecio()>200){
                    System.out.println(lista.get(i).getNombre());
                }   
             }
        
             dao.Desconectar();
            break;
        case 5:
            lista.clear();
            connection = dao.Conectar();
        
            lista=daop.ProductosLista(connection);
        
            for (int i = 0; i < lista.size(); i++) {
                if(lista.get(i).getPrecio()==daop.MenorPrecio(connection)){
                    System.out.println(lista.get(i).getNombre() +" precio: "+ lista.get(i).getPrecio());                }
             }
        
             dao.Desconectar();
            break;
        case 6:
            connection = dao.Conectar();
            
            System.out.println("ingrese el nombre del producot");
            String nombre = leer.next();
            System.out.println("ingrese el precio del producto");
            Double precio = leer.nextDouble();
            System.out.println("Seleccione el fabricante");
            int fab= leer.nextInt();
        
            daop.insertarProducto(nombre, x, x, connection);
        
            
        
             dao.Desconectar();
            break;
        case 7:
            break;
        case 8:
            break;
        case 9:
            break;
        default:
            throw new AssertionError();
    }
        
    
        
        
    }
    
    
}
