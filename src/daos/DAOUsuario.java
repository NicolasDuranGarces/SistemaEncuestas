/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import conexion.FabricaConexion;
import definiciones.IDAOUsuario;
import excepciones.ConexionException;
import excepciones.UsuarioNoexisteExcepcion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Usuario;

/**
 *
 * @author jose
 */
public class DAOUsuario implements IDAOUsuario {

    @Override
    public boolean agregar(Usuario usuario) throws ConexionException {
        try (Connection con = FabricaConexion.getConexion()) {
            PreparedStatement pstm
                    = con.prepareStatement("insert into usuarios (dni, nombre,"
                            + " apellido, edad, genero, ocupacion, idciudadresidencia, "
                            + "direccion) values (?, ?, ?, ?, ?, ?, ?, ?)");
            pstm.setLong(1, usuario.getDni());
            pstm.setString(2, usuario.getNombre());
            pstm.setString(3, usuario.getApellido());
            pstm.setInt(4, usuario.getEdad());
            pstm.setString(5, usuario.getGenero());
            pstm.setString(6, usuario.getOcupacion());
            pstm.setInt(7, usuario.getIdCiudadResidencia());
            pstm.setString(8, usuario.getDireccion());

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
    public boolean modificar(Usuario usuario) throws ConexionException {
        try (Connection con = FabricaConexion.getConexion()) {
            PreparedStatement pstm
                    = con.prepareStatement("update usuarios set dni = ?, nombre = ?, "
                            + "apellido = ?, edad = ?, genero = ?, ocupacion = ?, "
                            + "idCiudadResidencia = ?, direccion = ? where dni = ?");
            pstm.setLong(1, usuario.getDni());
            pstm.setString(2, usuario.getNombre());
            pstm.setString(3, usuario.getApellido());
            pstm.setInt(4, usuario.getEdad());
            pstm.setString(5, usuario.getGenero());
            pstm.setString(6, usuario.getOcupacion());
            pstm.setInt(7, usuario.getIdCiudadResidencia());
            pstm.setString(8, usuario.getDireccion());
            pstm.setLong(9, usuario.getDni());

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
    public Usuario buscar(long dni) throws ConexionException {
        try (Connection con = FabricaConexion.getConexion()) {
            PreparedStatement pstm
                    = con.prepareStatement("SELECT dni, nombre,"
                            + " apellido, edad, genero, ocupacion, idCiudadResidencia, "
                            + "direccion from usuarios WHERE dni = ?");
            pstm.setLong(1, dni);

            ResultSet res = pstm.executeQuery();

            String nombre;
            String apellido;
            int edad;
            String genero;
            String ocupacion;
            int idCiudadResidencia;
            String direccion;

            Usuario usuario = null;

            while (res.next()) {

                nombre = res.getString(2);
                apellido = res.getString(3);
                edad = res.getInt(4);
                genero = res.getString(5);
                ocupacion = res.getString(6);
                idCiudadResidencia = res.getInt(7);
                direccion = res.getString(8);
                usuario = new Usuario(dni, nombre, apellido, edad, genero, ocupacion, idCiudadResidencia, direccion);
            }

            return usuario;

        } catch (SQLException ex) {
            System.out.println("Error en la conexión");
            ex.printStackTrace();
            throw new ConexionException();
        }
    }
    
    public boolean eliminar(long dni) throws ConexionException{
        try (Connection con = FabricaConexion.getConexion()) {
            PreparedStatement pstm
                    = con.prepareStatement("delete from usuarios where dni = ? ");
            pstm.setLong(1, dni);
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
    public ArrayList<Usuario> listar() throws ConexionException {
        try (Connection con = FabricaConexion.getConexion()) {
            ArrayList<Usuario> user = new ArrayList<Usuario>();
            PreparedStatement pstm
                    = con.prepareStatement("SELECT dni, nombre,"
                            + " apellido, edad, genero, ocupacion, idCiudadResidencia, "
                            + "direccion from usuarios");
          
            ResultSet res = pstm.executeQuery();

            while (res.next()) {
                Usuario usuario = new Usuario();
                usuario.setDni(res.getLong(1));
                usuario.setNombre(res.getString(2));
                usuario.setApellido(res.getString(3));
                usuario.setEdad(res.getInt(4));
                usuario.setGenero(res.getString(5));
                usuario.setOcupacion(res.getString(6));
                usuario.setIdCiudadResidencia(res.getInt(7));
                usuario.setDireccion(res.getString(8));
                user.add(usuario);
            }
            return user;

        } catch (SQLException ex) {
            System.out.println("Error en la conexión");
            ex.printStackTrace();
            throw new ConexionException();
        }
    }

}
