/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package definiciones;

import excepciones.ConexionException;
import java.util.ArrayList;
import modelo.PreguntaEncuesta;

/**
 *
 * @author jose
 */
public interface IDAOPreguntaEncuesta {
    
    public boolean agregarDependiente(PreguntaEncuesta pregunta) throws ConexionException;
    
    public boolean agregarIndependiente(PreguntaEncuesta pregunta) throws ConexionException;
    
    public boolean modificar(PreguntaEncuesta pregunta) throws ConexionException;
    
    public boolean restarNumero(int idEncuesta, int numeroPregunta) throws ConexionException;
    
    public PreguntaEncuesta buscar(int idEncuesta, int numeroPregunta) throws ConexionException;
    
    public boolean eliminar(int idEncuesta, int numeroPregunta) throws ConexionException;
    
    public ArrayList<PreguntaEncuesta> cargarPreguntasEncuesta(int idEncuesta) throws ConexionException;
}
