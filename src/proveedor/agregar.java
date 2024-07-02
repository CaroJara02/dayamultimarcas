/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proveedor;

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
        String nombre_empresa= "Angeluz";
        String nit = "9005647";
        String nombre_rlegal = "Antonio Diaz";
        String correoelectronico = "angeluz0221@gmail.com";
        
        
        //Instruccion SQL
        String sql = "INSERT INTO proveedor (nombre_empresa, nit, nombre_rlegal, correoelectronico) values ('"+nombre_empresa+"','"+nit+"','"+nombre_rlegal+"','"+correoelectronico+"')";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(agregar.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        try {
            cn = con.getConection();
            st = cn.createStatement();
            st.executeUpdate(sql); //Agregar datos
            rs = st.executeQuery("SELECT * FROM proveedor"); //Traer datos de la tabla de cursos
            rs.next();
            
            //Imprimir en concola los datos de la tabla curso
            do {
                System.out.println(rs.getInt("id_proveedor") + ": " + rs.getString("nombre_empresa")+" - "+rs.getString("nit")+" -"+rs.getString("nombre_rlegal")+" - "+rs.getString("correoelectronico"));
            } while (rs.next());
            
        } catch (SQLException ex) {
            Logger.getLogger(agregar.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
}
