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
import dtos.DTOPreguntaOpciones;
import excepciones.ConexionException;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Encuesta;
import modelo.Opcion;
import modelo.Pregunta;
import modelo.PreguntaEncuesta;

/**
 *
 * @author SEBASTIAN
 */
public class CtlPresentarEncuesta {

    BOPregunta boPregunta;
    BOOpciones boOpciones;
    BOEncuesta boEncuesta;
    BOPreguntasEncuesta boPreguntaEncuesta;

    public CtlPresentarEncuesta() {
        boPregunta = new BOPregunta();
        boOpciones = new BOOpciones();
        boEncuesta = new BOEncuesta();
        boPreguntaEncuesta = new BOPreguntasEncuesta();
    }
    
    
//    public ArrayList<DTOPreguntaOpciones> listarPreguntas() throws ConexionException{
//        return boPregunta.ListadoPregunta();
//    }
    
    public ArrayList<Pregunta> listarPreguntas() throws ConexionException{
        return boPregunta.ListarTodasLasPreguntas();
    }
    
    public ArrayList<PreguntaEncuesta> listarPreguntasEncuesta(int idEncuesta) throws ConexionException{
        return boPreguntaEncuesta.cargarPreguntasEncuesta(idEncuesta);
    }
    
    public ArrayList<Opcion> listarOpciones() throws ConexionException{
        return boOpciones.litaOpciones();
    }
    
    public ArrayList<Encuesta> listaEncuestas() throws ConexionException{
        return boEncuesta.cargarEncuestas();
    }
}
