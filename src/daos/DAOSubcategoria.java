/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import conexion.FabricaConexion;
import definiciones.IDAOSubcategoria;
import excepciones.ConexionException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Subcategoria;

/**
 *
 * @author jose
 */
public class DAOSubcategoria implements IDAOSubcategoria{
    @Override
    public boolean agregar(Subcategoria subcategoria) throws ConexionException {
        try (Connection con = FabricaConexion.getConexion()) {
            PreparedStatement pstm
                    = con.prepareStatement("insert into subcategoria (idsubcategoria, nombre, idcategoria) "
                            + "values (?, ?, ?)");
            pstm.setInt(1, subcategoria.getId());
            pstm.setString(2, subcategoria.getNombre());
            pstm.setInt(3, subcategoria.getIdCategoria());
            

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
    public boolean modificar(Subcategoria subcategoria) throws ConexionException {
        try (Connection con = FabricaConexion.getConexion()) {
            PreparedStatement pstm
                    = con.prepareStatement("update subcategoria set idsubcategoria = ?, nombre = ?, idcategoria = ? "
                            + " where idsubcategoria = ?");
            pstm.setInt(1, subcategoria.getId());
            pstm.setString(2, subcategoria.getNombre());
            pstm.setInt(3, subcategoria.getIdCategoria());
            pstm.setInt(4, subcategoria.getId());

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
    public Subcategoria buscar(int id) throws ConexionException {
        try (Connection con = FabricaConexion.getConexion()) {
            PreparedStatement pstm
                    = con.prepareStatement("SELECT idsubcategoria, nombre, idcategoria"
                    + " from subcategoria WHERE idsubcategoria = ?");
            pstm.setInt(1, id);

            ResultSet res = pstm.executeQuery();

            
            String nombre;
            int idcategoria;
            
            Subcategoria subcategoria = null;

            while (res.next()) {
                
                nombre = res.getString(2);
                idcategoria = res.getInt(3);
                
                subcategoria = new Subcategoria(id, nombre, idcategoria);
            }

            return subcategoria;

        } catch (SQLException ex) {
            System.out.println("Error en la conexión");
            ex.printStackTrace();
            throw new ConexionException();
        }
    }
    
    public ArrayList<Subcategoria> cargarPorCategoria(int idCategoria) throws ConexionException {
        try (Connection con = FabricaConexion.getConexion()) {
            PreparedStatement pstm
                    = con.prepareStatement("SELECT idsubcategoria, nombre, idcategoria"
                    + " from subcategoria WHERE idcategoria = ?");
            pstm.setInt(1, idCategoria);

            ResultSet res = pstm.executeQuery();

            int idsubcategoria;
            String nombre;
            
            
            Subcategoria subcategoria = null;
            ArrayList<Subcategoria> lista = new ArrayList();

            while (res.next()) {
                
                idsubcategoria = res.getInt(1);
                nombre = res.getString(2);
                
                subcategoria = new Subcategoria(idsubcategoria, nombre, idCategoria);
                lista.add(subcategoria);
            }

            return lista;

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
                    = con.prepareStatement("delete from subcategoria where idsubcategoria = ? ");
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
