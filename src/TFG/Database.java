/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TFG;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author javier
 */
public class Database {
       Connection conn=null;
       public Connection conexion(){
       String username="root";
       String password="";
       String url="jdbc:mysql://localhost:3306/panaderia?zeroDateTimeBehavior=convertToNull";
       try{
           Class.forName("com.mysql.jdbc.Driver");
           conn=(Connection)DriverManager.getConnection(url,username,password);
           System.out.print("Conexion correcta");
       }catch(Exception e){
       System.out.println(e);
       }
       return conn;
       }
        public static Connection conexion =null;
    public static Connection conectar() throws ClassNotFoundException, SQLException{
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection conexion =(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/panaderia","root","");
        return conexion;
        
        
         
    }
}
