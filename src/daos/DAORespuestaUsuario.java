/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import conexion.FabricaConexion;
import definiciones.IDAORespuestaUsuario;
import excepciones.ConexionException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.RespuestaUsuario;

/**
 *
 * @author jose
 */
public class DAORespuestaUsuario implements IDAORespuestaUsuario{
    @Override
    public boolean agregar(RespuestaUsuario respuesta) throws ConexionException {
        try (Connection con = FabricaConexion.getConexion()) {
            PreparedStatement pstm
                    = con.prepareStatement("insert into respuestas_usuarios (idencuesta, numeropregunta, "
                            + "dni, idpregunta, idopcion, respuestaabierta, ordenranking) "
                            + "values (?, ?, ?, ?, ?, ?, ?)");
            pstm.setInt(1, respuesta.getIdEncuesta());
            pstm.setInt(2, respuesta.getNumeroPregunta());
            pstm.setLong(3, respuesta.getDni());
            pstm.setLong(4, respuesta.getIdPregunta());
            pstm.setInt(5, respuesta.getIdOpcion());
            pstm.setString(6, respuesta.getRespuestaAbierta());
            pstm.setInt(7, respuesta.getOrdenRanking());

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
    public boolean modificar(RespuestaUsuario respuesta) throws ConexionException {
        try (Connection con = FabricaConexion.getConexion()) {
            PreparedStatement pstm
                    = con.prepareStatement("update respuestas_usuarios set idencuesta = ?, numeropregunta = ?, dni = ?, "
                            + "idpregunta = ?, idopcion = ?, respuestaabierta ?, ordenranking = ? "
                            + "where idencuesta = ? and numeropregunta = ? ");
            pstm.setInt(1, respuesta.getIdEncuesta());
            pstm.setInt(2, respuesta.getNumeroPregunta());
            pstm.setLong(3, respuesta.getDni());
            pstm.setLong(4, respuesta.getIdPregunta());
            pstm.setInt(5, respuesta.getIdOpcion());
            pstm.setString(6, respuesta.getRespuestaAbierta());
            pstm.setInt(7, respuesta.getOrdenRanking());
            pstm.setInt(8, respuesta.getIdEncuesta());
            pstm.setInt(9, respuesta.getNumeroPregunta());

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
    public RespuestaUsuario buscar(int idEncuesta, int numeroPregunta) throws ConexionException {
        try (Connection con = FabricaConexion.getConexion()) {
            PreparedStatement pstm
                    = con.prepareStatement("SELECT idencuesta, numeropregunta, dni, idpregunta, "
                    + "idopcion, respuestaabierta, ordenranking from respuestas_usuarios "
                            + "where idencuesta = ? and numeropregunta = ? ");
            pstm.setInt(1, idEncuesta);
            pstm.setInt(2, numeroPregunta);

            ResultSet res = pstm.executeQuery();

            
            long dni;
            long idPregunta;
            int idopcion;
            String respuestaAbierta;
            int ordenRanking;
            
            RespuestaUsuario respuesta = null;

            while (res.next()) {
                
                dni = res.getLong(3);
                idPregunta = res.getLong(4);
                idopcion = res.getInt(5);
                respuestaAbierta = res.getString(6);
                ordenRanking = res.getInt(7);
                
                respuesta = new RespuestaUsuario(idEncuesta, numeroPregunta, dni, idPregunta, idopcion, respuestaAbierta, ordenRanking);
            }

            return respuesta;

        } catch (SQLException ex) {
            System.out.println("Error en la conexión");
            ex.printStackTrace();
            throw new ConexionException();
        }
    }
    
    @Override
    public boolean eliminar(int idEncuesta, int numeroPregunta) throws ConexionException{
        try (Connection con = FabricaConexion.getConexion()) {
            PreparedStatement pstm
                    = con.prepareStatement("delete from respuestas_usuarios where idencuesta = ? and numeropregunta = ? ");
            pstm.setInt(1, idEncuesta);
            pstm.setInt(2, numeroPregunta);
            
            pstm.executeQuery();

            return true;

        } catch (SQLException ex) {
//            System.out.println("Error en la conexión");
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            throw new ConexionException();
        }
    }
}
