/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jose
 */
public class FabricaConexion {

    public static Connection getConexion() throws SQLException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String user = "PROYECTO_4_ENCUESTAS";
            String pass = "admin";
            Connection con = DriverManager.getConnection(url, user, pass);
            return con;
        } catch (SQLException ex) {
            System.out.println("Error al crear la conexion");
        } catch (ClassNotFoundException ex) {
            System.out.println("No se encuentra el driver");
        }
        return null;
    }

}
