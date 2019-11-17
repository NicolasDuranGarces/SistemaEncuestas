/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import bos.BOOpciones;
import excepciones.NoExistenteException;
import bos.BOEncuesta;
import bos.BOPreguntasEncuesta;
import dtos.DTOPreguntaOpciones;
import excepciones.ConexionException;
import excepciones.DniUnicoExcepcion;
import excepciones.PreguntaYaEnLaEncuestaException;
import excepciones.PreguntasInsuficientesException;
import excepciones.YaExistenteException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import modelo.Encuesta;
import modelo.Opcion;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
import modelo.PreguntaEncuesta;
import org.json.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author jose
 */
public class CtlAgregarPreguntas {
    
    CtlCrearEncuesta controlEncuesta;
    CtlCrearPreguntas controlPreguntas;
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
    
    public boolean importarPreguntas(String archivo) throws ConexionException, YaExistenteException, PreguntasInsuficientesException, DniUnicoExcepcion {
        try {
            JSONParser parser = new JSONParser();
            //restivo por parametros la direccion del archivo json
            // y lo defino como un object
            Object obj = parser.parse(new FileReader(archivo));
            //el object lo defino como un tipo JSONObject
            JSONObject jSONObject = (JSONObject) obj;
            //definos las variables con los campos que va ha recivir el json
            int idEncuesta = 0;
            String nombre = jSONObject.get("nombre").toString();
            String descripcion = jSONObject.get("descripcion").toString();
            int val = (int) jSONObject.get("isPublic");
            boolean isPublic = false;
            if (val == 1) {
                isPublic = true;
            }
            Date fechaInicio = (Date) jSONObject.get("inicio");
            Date fechaFin = (Date) jSONObject.get("fin");
            int maximoEncuestados = (int) jSONObject.get("maximoEncuestados");
            String objetivo = jSONObject.get("objetivo").toString();
            int edadMinima = (int) jSONObject.get("edadMinima");
            int edadMaxima = (int) jSONObject.get("edadMaxima");
            String generoObjetivo = jSONObject.get("generoObjetivo").toString();
            int idSubcategoria = (int) jSONObject.get("idSubcategoria");

            Encuesta encuesta = new Encuesta(idEncuesta, nombre, descripcion, isPublic, fechaInicio, fechaFin, maximoEncuestados, objetivo, edadMinima, edadMaxima, generoObjetivo, idSubcategoria);
            idEncuesta = controlEncuesta.crear(encuesta, idSubcategoria, isPublic, idEncuesta);
            //defino un arrayJSON
            JSONArray preguntasEncuestaArray = (JSONArray) jSONObject.get("preguntasEncuesta");
            //y lo recorro para setiar las variables que contenga
            for (int i = 0; i < preguntasEncuestaArray.length(); i++) {

                JSONObject preguntasEncuesta = (JSONObject) preguntasEncuestaArray.get(i);

                int numeroPregunta = (int) preguntasEncuesta.get("numeroPregunta");
                long idPreguntaRequisito = (long) preguntasEncuesta.get("idPreguntaRequisito");
                int idOpcionRequisito = (int) preguntasEncuesta.get("idOpcionRequisito");
                PreguntaEncuesta preEncuesta = new PreguntaEncuesta(idEncuesta, idPreguntaRequisito, numeroPregunta, idPreguntaRequisito, idOpcionRequisito);
                //FALTA SEGUIR AQUI

                JSONArray preguntaArray = (JSONArray) preguntasEncuesta.get("pregunta");
                for (int j = 0; j < preguntaArray.length(); j++) {

                    JSONObject pregunta = (JSONObject) preguntaArray.get(i);

                    long idPregunta = (long) pregunta.get("idPregunta");
                    String enunciado = pregunta.get("enunciado").toString();
                    int tipoPregunta = (int) pregunta.get("tipoPregunta");

                    controlPreguntas.crear(tipoPregunta, idSubcategoria, enunciado, isPublic);

                    JSONArray opcionesArray = (JSONArray) pregunta.get("pregunta");
                    ArrayList<Opcion> listaOpciones = new ArrayList<>();
                    for (int k = 0; k < opcionesArray.length(); k++) {

                        JSONObject opciones = (JSONObject) opcionesArray.get(i);

                        int idOpcion = (int) opciones.get("idOpcion");
                        String textoOpcion = opciones.get("opcion").toString();
                        boolean isAbierta = false;
                        if ((int) opciones.get("idOpcion") != 0) {
                            isAbierta = true;
                        }
                        Opcion op = new Opcion(idPregunta, idOpcion, textoOpcion, isAbierta);
                        listaOpciones.add(op);
                    }
                    controlPreguntas.setOpciones(listaOpciones);
                }

                //aqui mando el crear PreguntaEncuesta
            }
        } catch (IOException | ParseException ex) {
            Logger.getLogger(CtlAgregarPreguntas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
}