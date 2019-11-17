/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import conexion.FabricaConexion;
import definiciones.IDAOEncuesta;
import excepciones.ConexionException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Encuesta;

/**
 *
 * @author jose
 */
public class DAOEncuesta implements IDAOEncuesta {

    @Override
    public int agregar(Encuesta encuesta) throws ConexionException {
        try (Connection con = FabricaConexion.getConexion()) {
            PreparedStatement pstm
                    = con.prepareStatement("insert into encuestas (idencuesta, nombre,"
                            + " descripcion, ispublic, fechainicio, fechafin, maximoencuestados, "
                            + "objetivo, edadminima, edadmaxima, generoobjetivo, idsubcategoria) "
                            + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            //pstm.setInt(1, encuesta.getId());
            int id = generarId();
            pstm.setInt(1, id);
            pstm.setString(2, encuesta.getNombre());
            pstm.setString(3, encuesta.getDescripcion());
            pstm.setBoolean(4, encuesta.isPublica());
            pstm.setDate(5, encuesta.getFechaInicio());
            pstm.setDate(6, encuesta.getFechaFin());
            pstm.setInt(7, encuesta.getMaximoEncuestados());
            pstm.setString(8, encuesta.getObjetivo());
            pstm.setInt(9, encuesta.getEdadMinima());
            pstm.setInt(10, encuesta.getEdadMaxima());
            pstm.setString(11, encuesta.getGeneroObjetivo());
            pstm.setInt(12, encuesta.getIdSubcategoria());

            pstm.executeQuery();

            return id;

        } catch (SQLException ex) {
//            System.out.println("Error en la conexión");
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            throw new ConexionException();
        }
    }
    
    public int generarId() throws ConexionException {
        try (Connection con = FabricaConexion.getConexion()) {
            PreparedStatement pstm
                    = con.prepareStatement("Select idencuesta from (select idencuesta from encuestas \n"
                            + "order by idencuesta desc ) where rownum = 1");
            ResultSet res = pstm.executeQuery();
            int id = 0;
            while (res.next()) {
                id = res.getInt(1)+1;
            }
            return id;
            
        } catch (SQLException ex) {
//            System.out.println("Error en la conexión");
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            throw new ConexionException();
        }
    }

    @Override
    public boolean modificar(Encuesta encuesta) throws ConexionException {
        try (Connection con = FabricaConexion.getConexion()) {
            PreparedStatement pstm
                    = con.prepareStatement("update encuestas set idencuesta = ?, nombre = ?, "
                            + "descripcion = ?, ispublic = ?, fechainicio = ?, fechafin = ?, "
                            + "maximoencuestados = ?, objetivo = ?, edadminima = ?, edadmaxima = ?, "
                            + "generoobjetivo = ?, idsubcategoria = ? where idencuesta = ?");
            pstm.setInt(1, encuesta.getId());
            pstm.setString(2, encuesta.getNombre());
            pstm.setString(3, encuesta.getDescripcion());
            pstm.setBoolean(4, encuesta.isPublica());
            pstm.setDate(5, encuesta.getFechaInicio());
            pstm.setDate(6, encuesta.getFechaFin());
            pstm.setInt(7, encuesta.getMaximoEncuestados());
            pstm.setString(8, encuesta.getObjetivo());
            pstm.setInt(9, encuesta.getEdadMinima());
            pstm.setInt(10, encuesta.getEdadMaxima());
            pstm.setString(11, encuesta.getGeneroObjetivo());
            pstm.setInt(12, encuesta.getIdSubcategoria());
            pstm.setInt(13, encuesta.getId());

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
    public Encuesta buscar(int idEncuesta) throws ConexionException {
        try (Connection con = FabricaConexion.getConexion()) {
            PreparedStatement pstm
                    = con.prepareStatement("SELECT idEncuesta, nombre, "
                            + "descripcion, ispublic, fechainicio, fechafin, maximoencuestados, "
                            + "objetivo, edadminima, edadmaxima, generoobjetivo, "
                            + "idsubcategoria from encuestas WHERE idEncuesta = ?");
            pstm.setLong(1, idEncuesta);

            
            ResultSet res = pstm.executeQuery();

            String nombre;
            String descripcion;
            boolean publica;
            Date fechaInicio;
            Date fechaFin;
            int maximoEncuestados;
            String objetivo;
            int edadMinima;
            int edadMaxima;
            String generoObjetivo;
            int idSubcategoria;

            Encuesta encuesta = null;

            while (res.next()) {

                nombre = res.getString(2);
                descripcion = res.getString(3);
                publica = res.getBoolean(4);
                fechaInicio = res.getDate(5);
                fechaFin = res.getDate(6);
                maximoEncuestados = res.getInt(7);
                objetivo = res.getString(8);
                edadMinima = res.getInt(9);
                edadMaxima = res.getInt(10);
                generoObjetivo = res.getString(11);
                idSubcategoria = res.getInt(12);

                encuesta = new Encuesta(idEncuesta, nombre, descripcion, publica, fechaInicio, fechaFin,
                        maximoEncuestados, objetivo, edadMinima, edadMaxima, generoObjetivo, idSubcategoria);
            }

            return encuesta;

        } catch (SQLException ex) {
            System.out.println("Error en la conexión");
            ex.printStackTrace();
            throw new ConexionException();
        }
    }
    
    @Override
    public ArrayList<Encuesta> cargarEncuestas() throws ConexionException {
        try (Connection con = FabricaConexion.getConexion()) {
            PreparedStatement pstm
                    = con.prepareStatement("SELECT idEncuesta, nombre, "
                            + "descripcion, ispublic, fechainicio, fechafin, maximoencuestados, "
                            + "objetivo, edadminima, edadmaxima, generoobjetivo, "
                            + "idsubcategoria from encuestas ");
            

            ResultSet res = pstm.executeQuery();
            
            int idEncuesta;
            String nombre;
            String descripcion;
            boolean publica;
            Date fechaInicio;
            Date fechaFin;
            int maximoEncuestados;
            String objetivo;
            int edadMinima;
            int edadMaxima;
            String generoObjetivo;
            int idSubcategoria;

            Encuesta encuesta = null;
            ArrayList<Encuesta> lista = new ArrayList<>();

            while (res.next()) {

                idEncuesta = res.getInt(1);
                nombre = res.getString(2);
                descripcion = res.getString(3);
                publica = res.getBoolean(4);
                fechaInicio = res.getDate(5);
                fechaFin = res.getDate(6);
                maximoEncuestados = res.getInt(7);
                objetivo = res.getString(8);
                edadMinima = res.getInt(9);
                edadMaxima = res.getInt(10);
                generoObjetivo = res.getString(11);
                idSubcategoria = res.getInt(12);

                encuesta = new Encuesta(idEncuesta, nombre, descripcion, publica, fechaInicio, fechaFin,
                        maximoEncuestados, objetivo, edadMinima, edadMaxima, generoObjetivo, idSubcategoria);
                lista.add(encuesta);
            }

            return lista;

        } catch (SQLException ex) {
            System.out.println("Error en la conexión");
            ex.printStackTrace();
            throw new ConexionException();
        }
    }

    @Override
    public boolean eliminar(int idEncuesta) throws ConexionException {
        try (Connection con = FabricaConexion.getConexion()) {
            PreparedStatement pstm
                    = con.prepareStatement("delete from encuestas where idencuesta = ? ");
            pstm.setLong(1, idEncuesta);
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
    public ArrayList<Encuesta> cargarEncuestasPublicas() throws ConexionException {
        try (Connection con = FabricaConexion.getConexion()) {
            PreparedStatement pstm
                    = con.prepareStatement("SELECT idEncuesta, nombre, "
                            + "descripcion, ispublic, fechainicio, fechafin, maximoencuestados, "
                            + "objetivo, edadminima, edadmaxima, generoobjetivo, "
                            + "idsubcategoria from encuestas where ispublic = 1 ");
            

            ResultSet res = pstm.executeQuery();
            
            int idEncuesta;
            String nombre;
            String descripcion;
            boolean publica;
            Date fechaInicio;
            Date fechaFin;
            int maximoEncuestados;
            String objetivo;
            int edadMinima;
            int edadMaxima;
            String generoObjetivo;
            int idSubcategoria;

            Encuesta encuesta = null;
            ArrayList<Encuesta> lista = new ArrayList<>();

            while (res.next()) {

                idEncuesta = res.getInt(1);
                nombre = res.getString(2);
                descripcion = res.getString(3);
                publica = res.getBoolean(4);
                fechaInicio = res.getDate(5);
                fechaFin = res.getDate(6);
                maximoEncuestados = res.getInt(7);
                objetivo = res.getString(8);
                edadMinima = res.getInt(9);
                edadMaxima = res.getInt(10);
                generoObjetivo = res.getString(11);
                idSubcategoria = res.getInt(12);

                encuesta = new Encuesta(idEncuesta, nombre, descripcion, publica, fechaInicio, fechaFin,
                        maximoEncuestados, objetivo, edadMinima, edadMaxima, generoObjetivo, idSubcategoria);
                lista.add(encuesta);
            }

            return lista;

        } catch (SQLException ex) {
            System.out.println("Error en la conexión");
            ex.printStackTrace();
            throw new ConexionException();
        }
    }
    
    @Override
    public ArrayList<Encuesta> cargarEncuestasPrivadas(long dni) throws ConexionException {
        try (Connection con = FabricaConexion.getConexion()) {
            PreparedStatement pstm
                    = con.prepareStatement("SELECT e.idEncuesta, e.nombre, "
                            + "e.descripcion, e.ispublic, e.fechainicio, e.fechafin, e.maximoencuestados, "
                            + "e.objetivo, e.edadminima, e.edadmaxima, e.generoobjetivo, "
                            + "e.idsubcategoria from encuestas e join participantes p "
                            + "on e.idencuesta=p.idencuesta where e.ispublic = 0 and p.dni = ? ");
            pstm.setLong(1, dni);

            ResultSet res = pstm.executeQuery();
            
            int idEncuesta;
            String nombre;
            String descripcion;
            boolean publica;
            Date fechaInicio;
            Date fechaFin;
            int maximoEncuestados;
            String objetivo;
            int edadMinima;
            int edadMaxima;
            String generoObjetivo;
            int idSubcategoria;

            Encuesta encuesta = null;
            ArrayList<Encuesta> lista = new ArrayList<>();

            while (res.next()) {

                idEncuesta = res.getInt(1);
                nombre = res.getString(2);
                descripcion = res.getString(3);
                publica = res.getBoolean(4);
                fechaInicio = res.getDate(5);
                fechaFin = res.getDate(6);
                maximoEncuestados = res.getInt(7);
                objetivo = res.getString(8);
                edadMinima = res.getInt(9);
                edadMaxima = res.getInt(10);
                generoObjetivo = res.getString(11);
                idSubcategoria = res.getInt(12);

                encuesta = new Encuesta(idEncuesta, nombre, descripcion, publica, fechaInicio, fechaFin,
                        maximoEncuestados, objetivo, edadMinima, edadMaxima, generoObjetivo, idSubcategoria);
                lista.add(encuesta);
            }

            return lista;

        } catch (SQLException ex) {
            System.out.println("Error en la conexión");
            ex.printStackTrace();
            throw new ConexionException();
        }
    }
}
