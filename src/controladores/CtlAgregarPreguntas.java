/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import bos.BOEncuesta;
import bos.BOOpciones;
import bos.BOPreguntasEncuesta;
import dtos.DTOPreguntaOpciones;
import excepciones.ConexionException;
import excepciones.NoExistenteException;
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
    BOEncuesta boEncuesta;
    BOOpciones boOpciones;
    ArrayList<PreguntaEncuesta> listaPreguntasEncuesta;

    public CtlAgregarPreguntas() {
        boPreguntasEncuesta = new BOPreguntasEncuesta();
        boEncuesta = new BOEncuesta();
        boOpciones = new BOOpciones();
        listaPreguntasEncuesta = new ArrayList<>();
    }
    
    public boolean verificarEncuesta(int idEncuesta) throws ConexionException, NoExistenteException {
        return boEncuesta.verificarEncuesta(idEncuesta);
    }
    
    public boolean verificarSiPreguntaNoAgregada(DTOPreguntaOpciones preguntaAgregar,int idEncuesta) throws ConexionException, PreguntaYaEnLaEncuestaException{
        
        PreguntaEncuesta preguntaEncuesta = new PreguntaEncuesta(idEncuesta, preguntaAgregar.getIdPregunta(), 0, 0, 0);
        return boPreguntasEncuesta.verificarSiPreguntaNoAgregada(preguntaEncuesta);
    }
    
    public boolean verificarPregunta(int idEncuesta, int numeroPregunta) throws ConexionException, PreguntaYaEnLaEncuestaException, NoExistenteException {
        return boPreguntasEncuesta.verificarPregunta(idEncuesta, numeroPregunta);
    }
    
    public boolean verificarOpcion(long idPregunta, int idOpcionRequisito) throws ConexionException, NoExistenteException {
        return boOpciones.verificarOpcion(idPregunta, idOpcionRequisito);
    }
    
    public int obtenerSubcategoria(int idEncuesta) throws ConexionException, NoExistenteException{
        return boEncuesta.buscarEncuesta(idEncuesta).getIdSubcategoria();
    }

    public ArrayList<PreguntaEncuesta> getListaPreguntasEncuesta() {
        return listaPreguntasEncuesta;
    }

    public void setListaPreguntasEncuesta(ArrayList<PreguntaEncuesta> listaPreguntasEncuesta) {
        this.listaPreguntasEncuesta = listaPreguntasEncuesta;
    }

    public void cargarPreguntasEncuesta(int idEncuesta) throws ConexionException {
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
            throws ConexionException, PreguntaYaEnLaEncuestaException {

        int numeroPregunta = listaPreguntasEncuesta.size() + 1;

        PreguntaEncuesta preguntaEncuesta = new PreguntaEncuesta(idEncuesta, preguntaAgregar.getIdPregunta(), numeroPregunta, 0, 0);
        return boPreguntasEncuesta.agregarPreguntaALaEncuesta(preguntaEncuesta);
    }
    
    public boolean agregarDependiente(DTOPreguntaOpciones preguntaAgregar, int idEncuesta, long idPreguntaRequisito, int idOpcionRequisito)
            throws ConexionException, PreguntaYaEnLaEncuestaException {
        
        int numeroPregunta = listaPreguntasEncuesta.size() + 1;

        PreguntaEncuesta preguntaEncuesta = new PreguntaEncuesta(idEncuesta, preguntaAgregar.getIdPregunta(), numeroPregunta, idPreguntaRequisito, idOpcionRequisito);
        return boPreguntasEncuesta.agregarPreguntaALaEncuesta(preguntaEncuesta);
    }

    public boolean quitarDeEncuesta(int idEncuesta, int numeroPregunta) throws ConexionException {
        return boPreguntasEncuesta.quitarPreguntaDeLaEncuesta(idEncuesta, numeroPregunta);
    }

    public PreguntaEncuesta cargarPreguntaSeleccionada(int pos) {
        return listaPreguntasEncuesta.get(pos);
    }
    
}