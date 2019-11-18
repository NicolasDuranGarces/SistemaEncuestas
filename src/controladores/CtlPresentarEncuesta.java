/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import bos.BOEncuesta;
import bos.BOOpciones;
import bos.BOPregunta;
import bos.BOPreguntasEncuesta;
import bos.BORespuestasUsuario;
import dtos.DTOPreguntaOpciones;
import excepciones.ConexionException;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Encuesta;
import modelo.Opcion;
import modelo.Pregunta;
import modelo.PreguntaEncuesta;
import modelo.RespuestaUsuario;

/**
 *
 * @author SEBASTIAN
 */
public class CtlPresentarEncuesta {

    BOPregunta boPregunta;
    BOOpciones boOpciones;
    BOEncuesta boEncuesta;
    BOPreguntasEncuesta boPreguntaEncuesta;
    BORespuestasUsuario boRespuestas;

    public CtlPresentarEncuesta() {
        boPregunta = new BOPregunta();
        boOpciones = new BOOpciones();
        boEncuesta = new BOEncuesta();
        boPreguntaEncuesta = new BOPreguntasEncuesta();
        boRespuestas = new BORespuestasUsuario();
    }
    
    
//    public ArrayList<DTOPreguntaOpciones> listarPreguntas() throws ConexionException{
//        return boPregunta.ListadoPregunta();
//    }
    
    public ArrayList<Pregunta> listarTodasLasPreguntas() throws ConexionException{
        return boPregunta.ListarTodasLasPreguntas();
    }
    
    public ArrayList<PreguntaEncuesta> listarPreguntasEncuesta(int idEncuesta) throws ConexionException{
        return boPreguntaEncuesta.cargarPreguntasEncuesta(idEncuesta);
    }
    
    public ArrayList<Pregunta> listarPreguntasAsociadas(int idEncuesta) throws ConexionException{
        return boPregunta.ListarPreguntasAsociadas(idEncuesta);
    }
    
    public ArrayList<Opcion> listarOpciones() throws ConexionException{
        return boOpciones.litaOpciones();
    }
    
    public ArrayList<Encuesta> listaEncuestas() throws ConexionException{
        return boEncuesta.cargarEncuestas();
    }
    
    public boolean guardarRespuestaUnica(RespuestaUsuario respuesta) throws ConexionException{
        return boRespuestas.agregarRespuestaUnica(respuesta);
    }
    
    public boolean guardarRespuestaMultiple(ArrayList<RespuestaUsuario> listaRespuestas) throws ConexionException{
        return boRespuestas.agregarRespuestaMultiple(listaRespuestas);
    }
    
    public boolean verificarSiContestada(int idEncuesta, int numeroPregunta, long dni) throws ConexionException{
        return boRespuestas.verificarSiContestada(idEncuesta, numeroPregunta, dni);
    }
//    public ArrayList<RespuestaUsuario> traerMisRespuestas(){
//        return boRespuestas.traerMisRespuestas();
//    }
}
