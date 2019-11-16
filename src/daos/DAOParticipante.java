/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import conexion.FabricaConexion;
import definiciones.IDAOParticipante;
import excepciones.ConexionException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Participante;

/**
 *
 * @author jose
 */
public class DAOParticipante implements IDAOParticipante{
    @Override
    public boolean agregar(Participante participante) throws ConexionException {
        try (Connection con = FabricaConexion.getConexion()) {
            PreparedStatement pstm
                    = con.prepareStatement("insert into participantes (dni, idencuesta) "
                            + "values (?, ?)");
            pstm.setLong(1, participante.getDni());
            pstm.setInt(2, participante.getIdEncuesta());
            

            pstm.executeQuery();

            return true;

        } catch (SQLException ex) {
//            System.out.println("Error en la conexión");
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            throw new ConexionException();
        }
    }
        
    
//    public Participante buscar(long dni, int idEncuesta) throws ConexionException {
//        try (Connection con = FabricaConexion.getConexion()) {
//            PreparedStatement pstm
//                    = con.prepareStatement("SELECT dni, idencuesta,"
//                    + " from participantes where dni = ? and idencuesta = ?");
//            pstm.setLong(1, dni);
//            pstm.setInt(2, idEncuesta);
//            
//            ResultSet res = pstm.executeQuery();
//
//            
//            String nombre;
//            
//
//            Participante participante = null;
//
//            while (res.next()) {
//                
//                nombre = res.getString(2);
//                
//                participante = new Participante(dni, idEncuesta);
//            }
//
//            return participante;
//
//        } catch (SQLException ex) {
//            System.out.println("Error en la conexión");
//            ex.printStackTrace();
//            throw new ConexionException();
//        }
//    }
    
    @Override
    public boolean eliminar(long dni, int idEncuesta) throws ConexionException{
        try (Connection con = FabricaConexion.getConexion()) {
            PreparedStatement pstm
                    = con.prepareStatement("delete from participantes where dni = ? and idencuesta = ?");
            pstm.setLong(1, dni);
            pstm.setInt(2, idEncuesta);
            pstm.executeQuery();

            return true;

        } catch (SQLException ex) {
//            System.out.println("Error en la conexión");
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            throw new ConexionException();
        }
    }
    
    public ArrayList<Participante> listar(int idEncuesta) throws ConexionException{
        try (Connection con = FabricaConexion.getConexion()) {
            PreparedStatement pstm
                    = con.prepareStatement("SELECT dni from participantes where idencuesta = ? ");
            pstm.setInt(1, idEncuesta);

            ResultSet res = pstm.executeQuery();
            
            long dni;

            Participante participante = null;
            ArrayList<Participante> lista = new ArrayList<>();

            while (res.next()) {

                dni = res.getLong(1);
                

                participante = new Participante(dni, idEncuesta);
                lista.add(participante);
            }

            return lista;

        } catch (SQLException ex) {
            System.out.println("Error en la conexión");
            ex.printStackTrace();
            throw new ConexionException();
        }
    }
}
