/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente;

/**
 *
 * @author kro02
 */
import conexion.conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class agregar {
    
public static void main(String[] args) {
        //Conexion
        conexion con= new conexion();
        Connection cn;
        Statement st;
        ResultSet rs;   
        
        //Datos a agregar
        String nombre = "Daniela";
        String apellido = "Jaramillo";
        String documento = "4698754";
        String correoelectronico = "dani0221@gmail.com";
        String contrasena = "5426";
        
        //Instruccion SQL
        String sql = "INSERT INTO cliente (nombre, apellido, documento, correoelectronico, contrasena) values ('"+nombre+"','"+apellido+"','"+documento+"','"+correoelectronico+"','"+contrasena+"')";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(agregar.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        try {
            cn = con.getConection();
            st = cn.createStatement();
            st.executeUpdate(sql); //Agregar datos
            rs = st.executeQuery("SELECT * FROM cliente"); //Traer datos de la tabla de cursos
            rs.next();
            
            //Imprimir en concola los datos de la tabla curso
            do {
                System.out.println(rs.getInt("id_cliente") + ": " + rs.getString("nombre")+" - "+rs.getString("apellido")+" -"+rs.getString("documento")+" - "+rs.getString("correoelectronico")+" - "+rs.getString("contrasena"));
            } while (rs.next());
            
        } catch (SQLException ex) {
            Logger.getLogger(agregar.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
}

