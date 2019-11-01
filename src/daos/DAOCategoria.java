/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import conexion.FabricaConexion;
import definiciones.IDAOCategoria;
import excepciones.ConexionException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Categoria;

/**
 *
 * @author jose
 */
public class DAOCategoria implements IDAOCategoria{
    @Override
    public boolean agregar(Categoria categoria) throws ConexionException {
        try (Connection con = FabricaConexion.getConexion()) {
            PreparedStatement pstm
                    = con.prepareStatement("insert into categoria (idcategoria, nombre) "
                            + "values (?, ?)");
            pstm.setInt(1, categoria.getId());
            pstm.setString(2, categoria.getNombre());
            

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
    public boolean modificar(Categoria categoria) throws ConexionException {
        try (Connection con = FabricaConexion.getConexion()) {
            PreparedStatement pstm
                    = con.prepareStatement("update categoria set idcategoria = ?, nombre = ? "
                            + " where idcategoria = ?");
            pstm.setInt(1, categoria.getId());
            pstm.setString(2, categoria.getNombre());
            pstm.setInt(3, categoria.getId());

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
    public Categoria buscar(int id) throws ConexionException {
        try (Connection con = FabricaConexion.getConexion()) {
            PreparedStatement pstm
                    = con.prepareStatement("SELECT idcategoria, nombre,"
                    + " from categoria WHERE idcategoria = ?");
            pstm.setInt(1, id);

            ResultSet res = pstm.executeQuery();

            
            String nombre;
            

            Categoria categoria = null;

            while (res.next()) {
                
                nombre = res.getString(2);
                
                categoria = new Categoria(id, nombre);
            }

            return categoria;

        } catch (SQLException ex) {
            System.out.println("Error en la conexión");
            ex.printStackTrace();
            throw new ConexionException();
        }
    }
    
    public ArrayList<Categoria> cargarCategorias() throws ConexionException {
        try (Connection con = FabricaConexion.getConexion()) {
            PreparedStatement pstm
                    = con.prepareStatement("SELECT idcategoria, nombre"
                    + " from categoria");
            
            ResultSet res = pstm.executeQuery();

            int idCategoria;
            String nombre;
            

            Categoria categoria = null;
            ArrayList<Categoria> lista = new ArrayList();

            while (res.next()) {
                idCategoria = res.getInt(1);
                nombre = res.getString(2);
                
                categoria = new Categoria(idCategoria, nombre);
                lista.add(categoria);
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
                    = con.prepareStatement("delete from categoria where idcategoria = ? ");
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
