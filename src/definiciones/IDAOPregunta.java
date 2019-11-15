/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package definiciones;

import dtos.DTOPreguntaOpciones;
import excepciones.ConexionException;
import java.util.ArrayList;
import modelo.Pregunta;

/**
 *
 * @author jose
 */
public interface IDAOPregunta {

    public long generarId() throws ConexionException;
    
    public boolean crear(Pregunta pregunta) throws ConexionException;

    public boolean modificar(Pregunta pregunta) throws ConexionException;

    public Pregunta buscar(long idPregunta) throws ConexionException;

    public DTOPreguntaOpciones buscarPreguntaOpcion(long idPregunta) throws ConexionException;

    public ArrayList<DTOPreguntaOpciones> ListadoPregunta() throws ConexionException;
    
    public ArrayList<Pregunta> cargarTodasLasPreguntas() throws ConexionException;

    public ArrayList<Pregunta> cargarPreguntasPorCategoria(int idCategoria) throws ConexionException;
    
    public ArrayList<Pregunta> cargarPreguntasPorSubcategoria(int idSubcategoria) throws ConexionException;

    public boolean eliminar(long idPregunta) throws ConexionException;
    
    public ArrayList<Pregunta> listarPreguntasAsociadas(int idEncuesta) throws ConexionException;
}
