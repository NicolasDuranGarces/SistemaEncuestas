/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import conexion.FabricaConexion;
import definiciones.IDAOOpciones;
import excepciones.ConexionException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Opcion;

/**
 *
 * @author jose
 */
public class DAOOpciones implements IDAOOpciones {

    @Override
    public boolean agregar(Opcion opcion) throws ConexionException {

        try (Connection con = FabricaConexion.getConexion()) {
            PreparedStatement pstm
                    = con.prepareStatement("insert into opciones (idpregunta, idopcion,"
                            + " opcion, opcionabierta) values (?, ?, ?, ?)");
            pstm.setLong(1, opcion.getIdPregunta());
            pstm.setInt(2, opcion.getIdOpcion());
            pstm.setString(3, opcion.getTextoOpcion());
            pstm.setString(4, String.valueOf(opcion.isAbierta()));

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
    public boolean modificar(Opcion opcion) throws ConexionException {
        try (Connection con = FabricaConexion.getConexion()) {
            PreparedStatement pstm
                    = con.prepareStatement("update opciones set idpregunta = ?, idopcion = ?, "
                            + "opcion = ?, opcionabierta = ? where idpregunta = ? and idopcion = ?");
            pstm.setLong(1, opcion.getIdPregunta());
            pstm.setInt(2, opcion.getIdOpcion());
            pstm.setString(3, opcion.getTextoOpcion());
            pstm.setBoolean(4, opcion.isAbierta());
            pstm.setLong(5, opcion.getIdPregunta());
            pstm.setInt(6, opcion.getIdOpcion());

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
    public Opcion buscar(long idPregunta, int idOpcion) throws ConexionException {
        try (Connection con = FabricaConexion.getConexion()) {
            PreparedStatement pstm
                    = con.prepareStatement("SELECT idpregunta, idopcion, opcion, "
                            + "opcionabierta from opciones WHERE idpregunta = ?  and idopcion = ?");
            pstm.setLong(1, idPregunta);
            pstm.setInt(2, idOpcion);

            ResultSet res = pstm.executeQuery();

            String textoOpcion;
            boolean abierta;

            Opcion opcion = null;

            while (res.next()) {

                textoOpcion = res.getString(3);
                abierta = res.getBoolean(4);

                opcion = new Opcion(idPregunta, idOpcion, textoOpcion, abierta);
            }

            return opcion;

        } catch (SQLException ex) {
            System.out.println("Error en la conexión");
            ex.printStackTrace();
            throw new ConexionException();
        }
    }

    @Override
    public boolean eliminar(long idPregunta, int idOpcion) throws ConexionException {
        try (Connection con = FabricaConexion.getConexion()) {
            PreparedStatement pstm
                    = con.prepareStatement("delete from opciones WHERE idpregunta = ? , and idopcion = ?");
            pstm.setLong(1, idPregunta);
            pstm.setInt(2, idOpcion);
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
    public ArrayList<Opcion> listaOpciones() throws ConexionException {
        try (Connection con = FabricaConexion.getConexion()) {
            PreparedStatement pstm
                    = con.prepareStatement("SELECT idpregunta, idopcion, opcion, opcionabierta FROM opciones");

            ResultSet res = pstm.executeQuery();

            long idPregunta;
            int idOpcion;
            String textoOpcion;
            boolean abierta;

            Opcion opciones = null;
            ArrayList<Opcion> lista = new ArrayList();

            while (res.next()) {

                idPregunta = res.getInt(1);
                idOpcion = res.getInt(2);
                textoOpcion = res.getString(3);
                abierta = res.getBoolean(4);

                opciones = new Opcion(idPregunta, idOpcion, textoOpcion, abierta);
                lista.add(opciones);
            }

            return lista;

        } catch (SQLException ex) {
            System.out.println("Error en la conexión");
            ex.printStackTrace();
            throw new ConexionException();
        }
    }
}
