/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import conexion.FabricaConexion;
import definiciones.IDAOPregunta;
import dtos.DTOPreguntaOpciones;
import excepciones.ConexionException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Pregunta;

/**
 *
 * @author jose
 */
public class DAOPregunta implements IDAOPregunta {

    @Override
    public long generarId() throws ConexionException {
        try (Connection con = FabricaConexion.getConexion()) {
            PreparedStatement pstm
                    = con.prepareStatement("Select idpregunta from (select idpregunta from preguntas "
                            + "order by idpregunta desc ) where rownum = 1");
            ResultSet res = pstm.executeQuery();
            long idPregunta = 0;
            while (res.next()){
               idPregunta = (res.getLong(1))+1;             
            }
            return idPregunta;
            
        } catch (SQLException ex) {
//            System.out.println("Error en la conexión");
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            throw new ConexionException();
        }
    }
    
    @Override
    public boolean crear(Pregunta pregunta) throws ConexionException {
        try (Connection con = FabricaConexion.getConexion()) {
            PreparedStatement pstm
                    = con.prepareStatement("insert into preguntas (idpregunta, enunciado,"
                            + " idsubcategoria, tipopregunta) values (?, ?, ?, ?)");

            pstm.setLong(1, pregunta.getIdPregunta());
            pstm.setString(2, pregunta.getEnunciado());
            pstm.setInt(3, pregunta.getIdSubcategoria());
            pstm.setInt(4, pregunta.getTipoPregunta());

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
    public boolean modificar(Pregunta pregunta) throws ConexionException {
        try (Connection con = FabricaConexion.getConexion()) {
            PreparedStatement pstm
                    = con.prepareStatement("update preguntas set idpregunta = ?, enunciado = ?, "
                            + "idsubcategoria = ?, tipopregunta = ? where idpregunta = ?");
            pstm.setLong(1, pregunta.getIdPregunta());
            pstm.setString(2, pregunta.getEnunciado());
            pstm.setInt(3, pregunta.getIdSubcategoria());
            pstm.setInt(4, pregunta.getTipoPregunta());
            pstm.setLong(5, pregunta.getIdPregunta());

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
    public Pregunta buscar(long idPregunta) throws ConexionException {
        try (Connection con = FabricaConexion.getConexion()) {
            PreparedStatement pstm
                    = con.prepareStatement("select idpregunta,enunciado,idsubacategoria,tipopregunta"
                            + " from preguntas WHERE idpregunta = ?");
            pstm.setLong(1, idPregunta);

            ResultSet res = pstm.executeQuery();

            String enunciado;
            int idsubcategoria;
            int tipopregunta;

            Pregunta pregunta = null;

            while (res.next()) {

                enunciado = res.getString(2);
                idsubcategoria = res.getInt(3);
                tipopregunta = res.getInt(4);

                pregunta = new Pregunta(idPregunta, enunciado, idsubcategoria, tipopregunta);
            }

            return pregunta;

        } catch (SQLException ex) {
            System.out.println("Error en la conexión");
            ex.printStackTrace();
            throw new ConexionException();
        }
    }

    @Override
    public DTOPreguntaOpciones buscarPreguntaOpcion(long idPregunta) throws ConexionException {
        try (Connection con = FabricaConexion.getConexion()) {
            PreparedStatement pstm
                    = con.prepareStatement("SELECT p.enunciado, p.tipopregunta, c.idcategoria, c.nombre, sc.idsubcategoria, sc.nombre \n"
                            + "from preguntas p join subcategoria sc on p.idsubcategoria=sc.idsubcategoria join"
                            + " categoria c on sc.idcategoria=c.idcategoria where p.idpregunta=?");
            pstm.setLong(1, idPregunta);

            ResultSet res = pstm.executeQuery();

            String enunciado,nombreSubCategoria,nombreCategoria;
            int tipoPregunta,idSubcategoria, idCategoria;

            DTOPreguntaOpciones pregunta = null;

            while (res.next()) {

                enunciado = res.getString(2);
                tipoPregunta = res.getInt(3);
                idCategoria = res.getInt(4);
                nombreCategoria = res.getString(5);
                idSubcategoria = res.getInt(6);
                nombreSubCategoria = res.getString(7);

                pregunta = new DTOPreguntaOpciones(idPregunta, enunciado, tipoPregunta, idSubcategoria, nombreSubCategoria, idCategoria, nombreCategoria);
            }

            return pregunta;

        } catch (SQLException ex) {
            System.out.println("Error en la conexión");
            ex.printStackTrace();
            throw new ConexionException();
        }
    }
    
    @Override
    public ArrayList<Pregunta> cargarTodasLasPreguntas() throws ConexionException {
        try (Connection con = FabricaConexion.getConexion()) {
            PreparedStatement pstm
                    = con.prepareStatement("SELECT idpregunta, enunciado, idsubcategoria, "
                            + "tipopregunta from preguntas");
            

            ResultSet res = pstm.executeQuery();

            long idPregunta;
            String enunciado;
            int idsubcategoria;
            int tipopregunta;

            Pregunta pregunta = null;
            ArrayList<Pregunta> lista = new ArrayList();
            while (res.next()) {

                idPregunta = res.getInt(1);
                enunciado = res.getString(2);
                idsubcategoria = res.getInt(3);
                tipopregunta = res.getInt(4);

                pregunta = new Pregunta(idPregunta, enunciado, idsubcategoria, tipopregunta);
                lista.add(pregunta);
            }

            return lista;

        } catch (SQLException ex) {
            System.out.println("Error en la conexión");
            ex.printStackTrace();
            throw new ConexionException();
        }
    }

    @Override
    public ArrayList<Pregunta> cargarPreguntasPorCategoria(int idCategoria) throws ConexionException {
        try (Connection con = FabricaConexion.getConexion()) {
            PreparedStatement pstm
                    = con.prepareStatement("SELECT p.idpregunta, p.enunciado, p.idsubcategoria, "
                            + "p.tipopregunta from preguntas p join subcategoria s on p.idSubcategoria = s.idSubcategoria "
                            + "join categoria c on s.idCategoria=c.idCategoria WHERE idCategoria = ?");
            pstm.setInt(1, idCategoria);

            ResultSet res = pstm.executeQuery();

            long idPregunta;
            String enunciado;
            int idsubcategoria;
            int tipopregunta;

            Pregunta pregunta = null;
            ArrayList<Pregunta> lista = new ArrayList();
            while (res.next()) {

                idPregunta = res.getInt(1);
                enunciado = res.getString(2);
                idsubcategoria = res.getInt(3);
                tipopregunta = res.getInt(4);

                pregunta = new Pregunta(idPregunta, enunciado, idsubcategoria, tipopregunta);
                lista.add(pregunta);
            }

            return lista;

        } catch (SQLException ex) {
            System.out.println("Error en la conexión");
            ex.printStackTrace();
            throw new ConexionException();
        }
    }
    
    @Override
    public ArrayList<Pregunta> cargarPreguntasPorSubcategoria(int idSubcategoria) throws ConexionException {
        try (Connection con = FabricaConexion.getConexion()) {
            PreparedStatement pstm
                    = con.prepareStatement("SELECT p.idpregunta, p.enunciado, p.idsubcategoria, "
                            + "p.tipopregunta from preguntas p join subcategoria s on p.idSubcategoria = s.idSubcategoria "
                            + "WHERE p.idSubcategoria = ?");
            pstm.setInt(1, idSubcategoria);

            ResultSet res = pstm.executeQuery();

            long idPregunta;
            String enunciado;
            int tipopregunta;

            Pregunta pregunta = null;
            ArrayList<Pregunta> lista = new ArrayList();
            while (res.next()) {

                idPregunta = res.getInt(1);
                enunciado = res.getString(2);
                tipopregunta = res.getInt(4);

                pregunta = new Pregunta(idPregunta, enunciado, idSubcategoria, tipopregunta);
                lista.add(pregunta);
            }

            return lista;

        } catch (SQLException ex) {
            System.out.println("Error en la conexión");
            ex.printStackTrace();
            throw new ConexionException();
        }
    }

    @Override
    public boolean eliminar(long idPregunta) throws ConexionException {
        try (Connection con = FabricaConexion.getConexion()) {
            PreparedStatement pstm
                    = con.prepareStatement("delete from preguntas where idpregunta = ? ");
            pstm.setLong(1, idPregunta);
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
    public ArrayList<DTOPreguntaOpciones> ListadoPregunta() throws ConexionException {
        try (Connection con = FabricaConexion.getConexion()) {
            PreparedStatement pstm
                    = con.prepareStatement("SELECT p.idpregunta, p.enunciado, p.tipopregunta, c.idcategoria, c.nombre, sc.idsubcategoria, sc.nombre \n"
                            + "from preguntas p join subcategoria sc on p.idsubcategoria=sc.idsubcategoria join"
                            + " categoria c on sc.idcategoria=c.idcategoria");

            ResultSet res = pstm.executeQuery();

            long idPregunta;
            String enunciado,nombreSubCategoria,nombreCategoria;
            int tipoPregunta,idSubcategoria, idCategoria; 

            DTOPreguntaOpciones pregunta = null;
            ArrayList<DTOPreguntaOpciones> lista = new ArrayList();
            while (res.next()) {

                idPregunta = res.getInt(1);
                enunciado = res.getString(2);
                tipoPregunta = res.getInt(3);
                idCategoria = res.getInt(4);
                nombreCategoria = res.getString(5);
                idSubcategoria = res.getInt(6);
                nombreSubCategoria = res.getString(7);

                pregunta = new DTOPreguntaOpciones(idPregunta, enunciado, tipoPregunta, idSubcategoria, nombreSubCategoria, idCategoria, nombreCategoria);
                lista.add(pregunta);
            }

            return lista;

        } catch (SQLException ex) {
            System.out.println("Error en la conexión");
            ex.printStackTrace();
            throw new ConexionException();
        }
    }
}
