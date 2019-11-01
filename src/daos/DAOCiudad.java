/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import conexion.FabricaConexion;
import definiciones.IDAOCiudad;
import excepciones.ConexionException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Asset;
import modelo.Ciudad;

/**
 *
 * @author jose
 */
public class DAOCiudad implements IDAOCiudad{
    @Override
    public boolean agregar(Ciudad ciudad) throws ConexionException {
        try (Connection con = FabricaConexion.getConexion()) {
            PreparedStatement pstm
                    = con.prepareStatement("insert into ciudades (idciudad, nombre) "
                            + "values (?, ?)");
            pstm.setInt(1, ciudad.getId());
            pstm.setString(2, ciudad.getNombre());
            

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
    public boolean modificar(Ciudad ciudad) throws ConexionException {
        try (Connection con = FabricaConexion.getConexion()) {
            PreparedStatement pstm
                    = con.prepareStatement("update ciudades set idciudad = ?, nombre = ? "
                            + " where idciudad = ?");
            pstm.setInt(1, ciudad.getId());
            pstm.setString(2, ciudad.getNombre());
            pstm.setInt(3, ciudad.getId());

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
    public Ciudad buscar(int id) throws ConexionException {
        try (Connection con = FabricaConexion.getConexion()) {
            PreparedStatement pstm
                    = con.prepareStatement("SELECT idciudad, nombre"
                    + " from ciudades WHERE idciudad = ?");
            pstm.setInt(1, id);

            ResultSet res = pstm.executeQuery();

            
            String nombre;
            

            Ciudad ciudad = null;

            while (res.next()) {
                
                nombre = res.getString(2);
                
                ciudad = new Ciudad(id, nombre);
            }

            return ciudad;

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
                    = con.prepareStatement("delete from ciudades where idciudad = ? ");
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
    
    @Override
    public ArrayList<Asset> listado() throws ConexionException {
        try (Connection con = FabricaConexion.getConexion()) {
            ArrayList<Asset> ciu = new ArrayList<Asset>();
            PreparedStatement pstm
                    = con.prepareStatement("SELECT idciudad, nombre"
                    + " from ciudades");
          
            ResultSet res = pstm.executeQuery();

            while (res.next()) {
                Asset ciudad = new Asset();
                ciudad.setId(res.getInt(1));
                ciudad.setNombre(res.getString(2));
                
                ciu.add(ciudad);
            }
            return ciu;

        } catch (SQLException ex) {
            System.out.println("Error en la conexión");
            ex.printStackTrace();
            throw new ConexionException();
        }
    }
}
