/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TFG;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author javier
 */
public class Metodos {
    Database database=new Database();
    Connection conn=null;
    ResultSet rs=null;
    ResultSet rs1=null;
    Statement stmt=null;
    ResultSet rs2=null;
    
    public void anyadirProducto(String nombre,String precio,String ingredientes){
    String nomb=nombre;
    String prec=precio;
    String ingre=ingredientes;
    
    try{
    conn=database.conexion();
    stmt=conn.createStatement();
    PreparedStatement p=conn.prepareStatement("INSERT INTO `productos` (`id`,`nombre`,`precio`,`ingredientes`) VALUES (NULL, ?, ?, ?)",Statement.RETURN_GENERATED_KEYS);
    
    p.setString(1,nomb);
    p.setString(2,prec);
    p.setString(3,ingre);
    
    p.executeUpdate();
    
    JOptionPane.showMessageDialog(null,"Registro insertado correctamente");
    }catch(SQLException e){
    JOptionPane.showMessageDialog(null,"Error al insertar los datos"+e.getMessage());
    }
    }
    public void anyadirCliente(String nombre,String direccion,Integer telefono){
    String nomb=nombre;
    String dir=direccion;
    Integer tlf=telefono;
    
    try{
    conn=database.conexion();
    stmt=conn.createStatement();
    PreparedStatement p=conn.prepareStatement("INSERT INTO `clientes` (`id`,`nombre`,`direccion`,`telefono`) VALUES (NULL, ?, ?, ?)",Statement.RETURN_GENERATED_KEYS);
    
    p.setString(1,nomb);
    p.setString(2,dir);
    p.setInt(3,tlf);
    p.executeUpdate();
    
    JOptionPane.showMessageDialog(null,"Registro insertado correctamente");
    }catch(SQLException e){
    JOptionPane.showMessageDialog(null,"Error al insertar los datos"+e.getMessage());
    }
    }
    public void anyadirPedido(String nombre,String producto,Integer cantidad,String fecha){
    String nomb=nombre;
    String prod=producto;
    Integer cant=cantidad;
    String date=fecha;
    Integer idNomb = 0;
    Integer idProd = 0;
    try{
   conn = database.conexion();
stmt = conn.createStatement();

PreparedStatement idNombre = conn.prepareStatement("SELECT id FROM clientes WHERE nombre = ?");
idNombre.setString(1, nomb);
ResultSet rsNombre = idNombre.executeQuery();

while (rsNombre.next()) {
    idNomb = rsNombre.getInt("id");
}

PreparedStatement idProducto = conn.prepareStatement("SELECT id FROM productos WHERE nombre = ?");
idProducto.setString(1, prod);
ResultSet rsProducto = idProducto.executeQuery();

while (rsProducto.next()) {
    idProd = rsProducto.getInt("id");
}


    PreparedStatement p=conn.prepareStatement("INSERT INTO `pedidos` (`id`,`cliente_id`,`producto_id`,`cantidad`,`fecha`) VALUES (NULL, ?, ?, ?, ?)",Statement.RETURN_GENERATED_KEYS);
    
    p.setInt(1,idNomb);
    p.setInt(2,idProd);
    p.setInt(3,cant);
    p.setString(4,date);
    p.executeUpdate();
    
    JOptionPane.showMessageDialog(null,"Registro insertado correctamente");
    }catch(SQLException e){
    JOptionPane.showMessageDialog(null,"Error al insertar los datos"+e.getMessage());
    }
    }
  
        public void modificarClientes(String nombreMod,String direccionMod,Integer telefonoMod,Integer id){
    String nombreM=nombreMod;
    String direccionM=direccionMod;
    Integer telefonoM=telefonoMod;
    Integer ID=id;
    try{
    conn=database.conexion();
    stmt=conn.createStatement();
    PreparedStatement p=conn.prepareStatement("UPDATE clientes SET nombre=?,direccion=?,telefono=? WHERE id=?",Statement.RETURN_GENERATED_KEYS);
    
    p.setString(1,nombreM);
    p.setString(2,direccionM);
    p.setInt(3,telefonoM);
    p.setInt(4,ID);
    p.executeUpdate();
    
    JOptionPane.showMessageDialog(null,"Registro modificado correctamente");
    }catch(SQLException e){
    JOptionPane.showMessageDialog(null,"Error al insertar los datos"+e.getMessage());
    }
    }
        
        public void modificarProductos(String prod,String prec,String ingre,Integer id){
    String nombre=prod;
    String precio=prec;
    String ingredientes=ingre;
    Integer ID=id;
    try{
    conn=database.conexion();
    stmt=conn.createStatement();
    PreparedStatement p=conn.prepareStatement("UPDATE productos SET nombre=?,precio=?,ingredientes=? WHERE ID=?",Statement.RETURN_GENERATED_KEYS);
    
    p.setString(1,nombre);
    p.setString(2,precio);
    p.setString(3,ingredientes);
    p.setInt(4,ID);
    p.executeUpdate();
    
    JOptionPane.showMessageDialog(null,"Registro modificado correctamente");
    }catch(SQLException e){
    JOptionPane.showMessageDialog(null,"Error al insertar los datos"+e.getMessage());
    }
    }
        
        
        public void modificarPedidos(Integer id,String nombreCliente,String nombreProducto,Integer cantidad,String fecha){
    Integer ID=id;
    String nombCli=nombreCliente;
    String nombProd=nombreProducto;
    Integer cant=cantidad;
    String date=fecha;
     Integer idNomb = 0;
    Integer idProd = 0;
    
    try{
        conn = database.conexion();
        stmt = conn.createStatement();

        PreparedStatement idNombre = conn.prepareStatement("SELECT id FROM clientes WHERE nombre = ?");
        idNombre.setString(1, nombCli);
        ResultSet rsNombre = idNombre.executeQuery();

            while (rsNombre.next()) {
            idNomb = rsNombre.getInt("id");
             }

        PreparedStatement idProducto = conn.prepareStatement("SELECT id FROM productos WHERE nombre = ?");
        idProducto.setString(1, nombProd);
        ResultSet rsProducto = idProducto.executeQuery();

            while (rsProducto.next()) {
            idProd = rsProducto.getInt("id");
            }


    PreparedStatement p0=conn.prepareStatement("UPDATE pedidos SET cliente_id = ?, producto_id = ?, cantidad = ?, fecha = ? WHERE id = ?",Statement.RETURN_GENERATED_KEYS);
    
    p0.setInt(1,idNomb);
    p0.setInt(2,idProd);
    p0.setInt(3,cant);
    p0.setString(4,date);
    p0.setInt(5,id);
    p0.executeUpdate();
    
    
    
    JOptionPane.showMessageDialog(null,"Registro modificado correctamente");
    }catch(SQLException e){
    JOptionPane.showMessageDialog(null,"Error al insertar los datos"+e.getMessage());
    }
    }
        
}
