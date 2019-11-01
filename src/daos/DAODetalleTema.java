/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import conexion.FabricaConexion;
import definiciones.IDAODetalleTema;
import excepciones.ConexionException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.DetalleTema;

/**
 *
 * @author jose
 */
public class DAODetalleTema implements IDAODetalleTema{
    @Override
    public boolean agregar(DetalleTema detalleTema) throws ConexionException {
        try (Connection con = FabricaConexion.getConexion()) {
            PreparedStatement pstm
                    = con.prepareStatement("insert into detalle_temas (tema, dni) "
                            + "values (?, ?)");
            pstm.setInt(1, detalleTema.getIdTema());
            pstm.setLong(2, detalleTema.getDni());
            

            pstm.executeQuery();

            return true;

        } catch (SQLException ex) {
//            System.out.println("Error en la conexión");
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            throw new ConexionException();
        }
    }
        
    
//    public DetalleTema buscar(int tema, long dni) throws ConexionException {
//        try (Connection con = FabricaConexion.getConexion()) {
//            PreparedStatement pstm
//                    = con.prepareStatement("SELECT tema, dni,"
//                    + " from detalle_temas where tema = ? and dni = ?");
//            pstm.setInt(1, tema);
//            pstm.setLong(2, dni);
//            
//            ResultSet res = pstm.executeQuery();
//
//            
//            String nombre;
//            
//
//            DetalleTema detalleTema = null;
//
//            while (res.next()) {
//                
//                nombre = res.getString(2);
//                
//                detalleTema = new DetalleTema(tema, dni);
//            }
//
//            return detalleTema;
//
//        } catch (SQLException ex) {
//            System.out.println("Error en la conexión");
//            ex.printStackTrace();
//            throw new ConexionException();
//        }
//    }
    
    @Override
    public boolean eliminar(int tema, long dni) throws ConexionException{
        try (Connection con = FabricaConexion.getConexion()) {
            PreparedStatement pstm
                    = con.prepareStatement("delete from detalle_temas where tema = ? and dni = ?");
            pstm.setInt(1, tema);
            pstm.setLong(2, dni);
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
