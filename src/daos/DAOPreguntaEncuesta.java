/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import conexion.FabricaConexion;
import definiciones.IDAOPreguntaEncuesta;
import excepciones.ConexionException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.PreguntaEncuesta;

/**
 *
 * @author jose
 */
public class DAOPreguntaEncuesta implements IDAOPreguntaEncuesta {

    @Override
    public boolean agregarDependiente(PreguntaEncuesta pregunta) throws ConexionException {
        try (Connection con = FabricaConexion.getConexion()) {

            PreparedStatement pstm
                    = con.prepareStatement("insert into preguntas_encuesta (idencuesta, idpregunta, numeropregunta,"
                            + " idpreguntarequisito, idopcionrequisito) values (?, ?, ?, ?, ?)");
            pstm.setInt(1, pregunta.getIdEncuesta());
            pstm.setLong(2, pregunta.getIdPregunta());
            pstm.setInt(3, pregunta.getNumeroPregunta());
            pstm.setLong(4, pregunta.getIdPreguntaRequisito());
            pstm.setInt(5, pregunta.getIdOpcionRequisito());

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
    public boolean agregarIndependiente(PreguntaEncuesta pregunta) throws ConexionException {
        try (Connection con = FabricaConexion.getConexion()) {

            PreparedStatement pstm
                    = con.prepareStatement("insert into preguntas_encuesta (idencuesta, idpregunta, numeropregunta,"
                            + " idpreguntarequisito, idopcionrequisito) values (?, ?, ?, null, null)");
            pstm.setInt(1, pregunta.getIdEncuesta());
            pstm.setLong(2, pregunta.getIdPregunta());
            pstm.setInt(3, pregunta.getNumeroPregunta());
            
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
    public boolean modificar(PreguntaEncuesta pregunta) throws ConexionException {
        try (Connection con = FabricaConexion.getConexion()) {
            PreparedStatement pstm
                    = con.prepareStatement("update preguntas_encuesta set idencuesta = ?, idpregunta = ?, numeropregunta = ?, "
                            + "idpreguntarequisito = ?, idopcionrequisito = ? where idencuesta = ? and numeropregunta = ? ");
            pstm.setInt(1, pregunta.getIdEncuesta());
            pstm.setLong(2, pregunta.getIdPregunta());
            pstm.setInt(3, pregunta.getNumeroPregunta());
            pstm.setLong(4, pregunta.getIdPreguntaRequisito());
            pstm.setInt(5, pregunta.getIdOpcionRequisito());
            pstm.setInt(6, pregunta.getIdEncuesta());
            pstm.setInt(7, pregunta.getNumeroPregunta());

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
    public boolean restarNumero(int idEncuesta, int numeroPregunta) throws ConexionException {
        try (Connection con = FabricaConexion.getConexion()) {
            PreparedStatement pstm
                    = con.prepareStatement("update preguntas_encuesta set numeropregunta = ? "
                            + "where idencuesta = ? and numeropregunta = ? ");
            
            pstm.setInt(1, (numeroPregunta-1));
            pstm.setInt(2, idEncuesta);
            pstm.setInt(3, numeroPregunta);

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
    public PreguntaEncuesta buscar(int idEncuesta, int numeroPregunta) throws ConexionException {
        try (Connection con = FabricaConexion.getConexion()) {
            PreparedStatement pstm
                    = con.prepareStatement("SELECT idencuesta, idpregunta, numeropregunta, idpreguntarequisito, "
                            + "idopcionrequisito from preguntas_encuesta where idencuesta = ? and numeropregunta = ? ");
            pstm.setInt(1, idEncuesta);
            pstm.setInt(2, numeroPregunta);

            ResultSet res = pstm.executeQuery();

            long idPregunta;
            long idPreguntaRequisito;
            int idopcionrequisito;

            PreguntaEncuesta pregunta = null;

            while (res.next()) {

                idPregunta = res.getLong(2);
                idPreguntaRequisito = res.getLong(4);
                idopcionrequisito = res.getInt(5);

                pregunta = new PreguntaEncuesta(idEncuesta, idPregunta, numeroPregunta, idPreguntaRequisito, idopcionrequisito);
            }

            return pregunta;

        } catch (SQLException ex) {
            System.out.println("Error en la conexión");
            ex.printStackTrace();
            throw new ConexionException();
        }
    }

    @Override
    public boolean eliminar(int idEncuesta, int numeroPregunta) throws ConexionException {
        try (Connection con = FabricaConexion.getConexion()) {
            PreparedStatement pstm
                    = con.prepareStatement("delete from preguntas_encuesta where idencuesta = ? and numeropregunta = ? ");
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

    @Override
    public ArrayList<PreguntaEncuesta> cargarPreguntasEncuesta(int idEncuesta) throws ConexionException {
        try (Connection con = FabricaConexion.getConexion()) {
            PreparedStatement pstm
                    = con.prepareStatement("SELECT idencuesta, idpregunta, numeropregunta, idpreguntarequisito, "
                            + "idopcionrequisito from preguntas_encuesta where idencuesta = ? order by numeropregunta");
            pstm.setInt(1, idEncuesta);

            ResultSet res = pstm.executeQuery();

            int numeroPregunta;
            long idPregunta;
            long idPreguntaRequisito;
            int idopcionrequisito;

            PreguntaEncuesta preguntaEncuesta = null;
            ArrayList<PreguntaEncuesta> lista = new ArrayList<>();

            while (res.next()) {

                idPregunta = res.getLong(2);
                numeroPregunta = res.getInt(3);
                idPreguntaRequisito = res.getLong(4);
                idopcionrequisito = res.getInt(5);

                preguntaEncuesta = new PreguntaEncuesta(idEncuesta, idPregunta, numeroPregunta, idPreguntaRequisito, idopcionrequisito);
                lista.add(preguntaEncuesta);
            }

            return lista;

        } catch (SQLException ex) {
            System.out.println("Error en la conexión");
            ex.printStackTrace();
            throw new ConexionException();
        }
    }
}
