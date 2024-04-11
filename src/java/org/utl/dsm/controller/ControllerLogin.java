package org.utl.dsm.controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.codec.digest.DigestUtils;
import org.utl.dsm.conexion.conexionBD;
import org.utl.dsm.model.Usuario;

public class ControllerLogin {
    public Usuario log(Usuario user) throws SQLException{
        
        String sql = "SELECT * FROM usuario WHERE email = ? AND password = ?";
        
        Usuario usuarioResultante = null;
        
        conexionBD con = new conexionBD();
        // Abrimos la conexión con la Base de Datos:
        Connection conn = con.open();
        
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setString(1, user.getEmail());
            stmt.setString(2, DigestUtils.sha512_256Hex(user.getPassword()));
        
            System.out.println(stmt);
        
            ResultSet rs = stmt.executeQuery();
            
            // Verificar si se encontró un usuario
            if (rs.next()) {
                String token = null;
                String tokenizer = null;
                // Hacemos una instancia 
                Date myDate = new Date();
                // Ahora le seteamos el formato de la fecha
                String fecha = new SimpleDateFormat("dd-MM-yyyy").format(myDate);
                // Seteamos el formato del token
                token = "CC" + "." + fecha;
                // Lo ciframos 
                tokenizer = DigestUtils.sha512_256Hex(token);
                
                String sqlToken = "UPDATE usuario SET lastToken = ? WHERE idUsuario = ?";
                CallableStatement stmtT = conn.prepareCall(sqlToken);
                
                System.out.println(tokenizer);
                
                stmtT.setString(1, tokenizer);
                stmtT.setInt(2, rs.getInt("idUsuario"));
                
                stmtT.execute();
                
                usuarioResultante = fill(rs);
            }
        }
        System.out.println("este es el usuario resultante " + usuarioResultante.toString());
        return usuarioResultante;
    }
    public static int insert(Usuario u) throws SQLException{
        System.out.println(u + "prueba");
        int idGenerado = -1;
        final String sql = "INSERT INTO usuario (email, password, nombre, tipo)"
                    + "VALUES (?, ?, ?, ?)";

        
        // Con este objeto nos vamos a conectar a la Base de Datos:
        conexionBD connMySQL = new conexionBD();
        // Abrimos la conexión con la Base de Datos:
        Connection conn = connMySQL.open();
        // Seteamos el ejecutable de sql
        PreparedStatement pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        
        pstmt.setString(1, u.getEmail());
        pstmt.setString(2, DigestUtils.sha512_256Hex(u.getPassword()));
        pstmt.setString(3, u.getNombre());
        pstmt.setInt(4, u.getTipo());
                
        System.out.println(pstmt);
        
        pstmt.execute();
        
        // Obtener las claves generadas (en este caso, solo debería ser una clave)
        ResultSet generatedKeys = pstmt.getGeneratedKeys();
        if (generatedKeys.next()) {
            idGenerado = generatedKeys.getInt(1);
            System.out.println("Se ha insertado el registro con ID: " + idGenerado);
        } else {
            // No se generaron claves, manejar la situación según sea necesario
            throw new SQLException("No se pudo obtener el ID del registro insertado.");
        }
        return idGenerado;
    };
    
    public static int update(Usuario u) throws SQLException {
        final String sql = "UPDATE productos SET nombre=?, password=?, nombre=?";
        
        int rowsAffected = -1;
        
        // Con este objeto nos vamos a conectar a la Base de Datos:
        conexionBD connMySQL = new conexionBD();
        // Abrimos la conexión con la Base de Datos:
        Connection conn = connMySQL.open();
        // Seteamos el ejecutable de sql
        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, u.getEmail());
        pstmt.setString(2, DigestUtils.sha512_256Hex(u.getPassword()));
        pstmt.setString(3, u.getNombre());

        rowsAffected = pstmt.executeUpdate();
        if (rowsAffected == 0) {
            throw new SQLException("No se actualizó ningún registro.");
        } else {
            System.out.println("Se ha actualizado el registro con ID: " + u.getIdUsuario());
        }
        
        return rowsAffected;
    }
    
    public List<Usuario> getAll() throws SQLException{
        String sql = "SELECT * FROM usuario";
        
        System.out.println(sql);
        
        // Con este objeto nos vamos a conectar a la Base de Datos:
        conexionBD connMySQL = new conexionBD();
        // Abrimos la conexión con la Base de Datos:
        Connection conn = connMySQL.open();
        // Seteamos el ejecutable de sql
        PreparedStatement pstmt = conn.prepareStatement(sql);
        // Aquí guardaremos los resultados de la consulta:
        ResultSet rs = pstmt.executeQuery();
        
        List<Usuario> usuarios = new ArrayList<>();
        
        while(rs.next()){
            usuarios.add(fill(rs));
        }
        rs.close();
        pstmt.close();
        connMySQL.close();
        return usuarios;
    }
    
    private static Usuario fill(ResultSet rs) throws SQLException{
        Usuario user = new Usuario();
        user.setIdUsuario(rs.getInt("idUsuario"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setNombre(rs.getString("nombre"));
        return user;
    }
}
