package org.utl.dsm.controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import org.utl.dsm.conexion.conexionBD;
import org.utl.dsm.model.Usuario;

/**
 *
 * @author PC
 */
public class Logout {
    public static void logout(int id) throws SQLException{
        String sql = "UPDATE usuario SET lastToken = NULL WHERE idUsuario = ?";
        conexionBD con = new conexionBD();
        // Abrimos la conexión con la Base de Datos:
        Connection conn = con.open();
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, id);
            System.out.println(stmt);
            stmt.execute();
        }
    }

    public void logout(String email) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
            
}
