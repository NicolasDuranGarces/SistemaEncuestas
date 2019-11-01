/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import conexion.FabricaConexion;
import definiciones.IDAOLogIn;
import excepciones.ConexionException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Login;

/**
 *
 * @author jose
 */
public class DAOLogIn implements IDAOLogIn{
    @Override
    public boolean agregar(Login login) throws ConexionException {
        try (Connection con = FabricaConexion.getConexion()) {
            PreparedStatement pstm
                    = con.prepareStatement("insert into login (username, password,"
                            + " rol, dni) values (?, ?, ?, ?)");
            
            pstm.setString(1, login.getUsername());
            pstm.setString(2, login.getPassword());
            pstm.setString(3, login.getRol());
            pstm.setLong(4, login.getDni());
            

            pstm.executeQuery();

            return true;

        } catch (SQLException ex) {
//            System.out.println("Error en la conexión");
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            throw new ConexionException();
        }
    }
    
    
    @Override
    public Login buscar(String username) throws ConexionException {
        try (Connection con = FabricaConexion.getConexion()) {
            PreparedStatement pstm
                    = con.prepareStatement("SELECT username, password,"
                            + " rol, dni from login WHERE username = ?");
            pstm.setString(1, username);

            ResultSet res = pstm.executeQuery();

            String password;
            String rol;
            Long dni;

            Login login = null;

            while (res.next()) {

                password = res.getString(2);
                rol = res.getString(3);
                dni = res.getLong(4);
                
                login = new Login(username, password, rol, dni);
            }

            return login;

        } catch (SQLException ex) {
            System.out.println("Error en la conexión");
            ex.printStackTrace();
            throw new ConexionException();
        }
    }
}
