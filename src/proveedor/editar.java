/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proveedor;

import conexion.conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class editar {

    public static void main(String[] args) {
        // CONEXION
        conexion con = new conexion();
        Connection cn;
        Statement st;
        ResultSet rs;

        // DATOS A EDITAR
        int id_editar = 1;
        String nombre_empresa= "Angeluz";
        String nit = "9005647";
        String nombre_rlegal = "Antonio Diaz";
        String correoelectronico = "angeluz0221@gmail.com";

        //ONSTRUCCION SQL
        String sql = "UPDATE proveedor set nombre_empresa='" + nombre_empresa + "', nit='" + nit + "', nombre_rlegal='" + nombre_rlegal + "', correoelectronico='" + correoelectronico +"' where id_proveedor=" + id_editar;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(agregar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            cn = con.getConection();
            st = cn.createStatement();
            st.executeUpdate(sql); // EDITAR DATOS
            rs = st.executeQuery("SELECT * FROM proveedor"); // TRAER DATOS DE LA TABLA PERSONA
            rs.next();

            // IMPRIMIR EN CONSOLA LOS DATOS DE LA TABLA PERSONA
            do {
                System.out.println(rs.getInt("id_proveedor") + ": " + rs.getString("nombre_empresa")+" - "+rs.getString("nit")+" -"+rs.getString("nombre_rlegal")+" - "+rs.getString("correoelectronico"));
            } while (rs.next());

        } catch (SQLException ex) {
            Logger.getLogger(editar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

