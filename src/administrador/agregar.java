/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administrador;

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
        String nombre = "Carolina";
        String apellido = "Jaramillo";
        String correoelectronico = "cfmckmdk@gmail.com";
        String contrasena = "2542";
        
        //Instruccion SQL
        String sql = "INSERT INTO administrador (nombre, apellido, correoelectronico, contrasena) values ('"+nombre+"','"+apellido+"','"+correoelectronico+"','"+contrasena+"')";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(agregar.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        try {
            cn = con.getConection();
            st = cn.createStatement();
            st.executeUpdate(sql); //Agregar datos
            rs = st.executeQuery("SELECT * FROM administrador"); //Traer datos de la tabla de cursos
            rs.next();
            
            //Imprimir en concola los datos de la tabla curso
            do {
                System.out.println(rs.getInt("id_administrador") + ": " + rs.getString("nombre")+" - "+rs.getString("apellido")+" - "+rs.getString("correoelectronico")+" - "+rs.getString("contrasena"));
            } while (rs.next());
            
        } catch (SQLException ex) {
            Logger.getLogger(agregar.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
}

