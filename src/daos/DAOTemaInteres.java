/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import conexion.FabricaConexion;
import definiciones.IDAOTemaInteres;
import excepciones.ConexionException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.TemaInteres;

/**
 *
 * @author jose
 */
public class DAOTemaInteres implements IDAOTemaInteres{
    
    @Override
    public boolean agregar(TemaInteres tema) throws ConexionException {
        try (Connection con = FabricaConexion.getConexion()) {
            PreparedStatement pstm
                    = con.prepareStatement("insert into temas_de_interes (idtema, nombre) "
                            + "values (?, ?)");
            pstm.setInt(1, tema.getId());
            pstm.setString(2, tema.getNombre());
            

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
    public boolean modificar(TemaInteres tema) throws ConexionException {
        try (Connection con = FabricaConexion.getConexion()) {
            PreparedStatement pstm
                    = con.prepareStatement("update temas_de_interes set idtema = ?, nombre = ? "
                            + " where idtema = ?");
            pstm.setInt(1, tema.getId());
            pstm.setString(2, tema.getNombre());
            pstm.setInt(3, tema.getId());

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
    public TemaInteres buscar(int id) throws ConexionException {
        try (Connection con = FabricaConexion.getConexion()) {
            PreparedStatement pstm
                    = con.prepareStatement("SELECT idtema, nombre,"
                    + " from temas_de_interes WHERE idtema = ?");
            pstm.setInt(1, id);

            ResultSet res = pstm.executeQuery();

            
            String nombre;
            

            TemaInteres tema = null;

            while (res.next()) {
                
                nombre = res.getString(2);
                
                tema = new TemaInteres(id, nombre);
            }

            return tema;

        } catch (SQLException ex) {
            System.out.println("Error en la conexión");
            ex.printStackTrace();
            throw new ConexionException();
        }
    }
    
    @Override
    public boolean eliminar(int id) throws ConexionException{
        try (Connection con = FabricaConexion.getConexion()) {
            PreparedStatement pstm
                    = con.prepareStatement("delete from temas_de_interes where idtema = ? ");
            pstm.setInt(1, id);
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
