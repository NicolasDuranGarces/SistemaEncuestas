/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import bos.BOPreguntasEncuesta;
import dtos.DTOPreguntaOpciones;
import excepciones.ConexionException;
import excepciones.PreguntaYaEnLaEncuestaException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.PreguntaEncuesta;

/**
 *
 * @author jose
 */
public class CtlAgregarPreguntas {
    BOPreguntasEncuesta boPreguntasEncuesta;
    ArrayList<PreguntaEncuesta> listaPreguntasEncuesta;
    
    

    public CtlAgregarPreguntas() {
        boPreguntasEncuesta = new BOPreguntasEncuesta();
        listaPreguntasEncuesta = new ArrayList<>();
    }

    public ArrayList<PreguntaEncuesta> getListaPreguntasEncuesta() {
        return listaPreguntasEncuesta;
    }

    public void setListaPreguntasEncuesta(ArrayList<PreguntaEncuesta> listaPreguntasEncuesta) {
        this.listaPreguntasEncuesta = listaPreguntasEncuesta;
    }
    
    
    
    public void cargarPreguntasEncuesta(int idEncuesta) throws ConexionException{
        setListaPreguntasEncuesta(boPreguntasEncuesta.cargarPreguntasEncuesta(idEncuesta));
    }
    
    public DefaultTableModel listarPreguntasEncuesta() throws ConexionException {

        String[] nombreColumnas = {"ID Pregunta", "Número Pregunta", "ID Pregunta Requisito", "ID Opción Requisito"};
        DefaultTableModel modelo;
        modelo = new DefaultTableModel(null, nombreColumnas);
        for (int i = 0; i < listaPreguntasEncuesta.size(); i++) {

            modelo.addRow(new Object[]{
                listaPreguntasEncuesta.get(i).getIdPregunta(),
                listaPreguntasEncuesta.get(i).getNumeroPregunta(),
                listaPreguntasEncuesta.get(i).getIdPreguntaRequisito(),
                listaPreguntasEncuesta.get(i).getIdOpcionRequisito()});
        }
        return modelo;
    }
    
    public boolean agregarAEncuesta(DTOPreguntaOpciones preguntaAgregar, int idEncuesta) 
            throws ConexionException, PreguntaYaEnLaEncuestaException{
        
        int numeroPregunta = listaPreguntasEncuesta.size()+1;
        
        PreguntaEncuesta preguntaEncuesta = new PreguntaEncuesta(idEncuesta, preguntaAgregar.getIdPregunta(), numeroPregunta, 0, 0);
        return boPreguntasEncuesta.agregarPreguntaALaEncuesta(preguntaEncuesta);
    }
    
    public boolean quitarDeEncuesta(int idEncuesta, int numeroPregunta) throws ConexionException{
        return boPreguntasEncuesta.quitarPreguntaDeLaEncuesta(idEncuesta, numeroPregunta);
    }
    
    public PreguntaEncuesta cargarPreguntaSeleccionada(int pos){
        return listaPreguntasEncuesta.get(pos);
    }
}
