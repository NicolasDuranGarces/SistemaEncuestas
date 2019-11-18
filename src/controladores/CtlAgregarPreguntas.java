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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import modelo.Encuesta;
import modelo.Opcion;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
import modelo.PreguntaEncuesta;
import org.json.simple.JSONArray;
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
        controlEncuesta = new CtlCrearEncuesta();
        controlPreguntas = new CtlCrearPreguntas();
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
    
     public boolean importarPreguntas(String archivo) throws ConexionException, YaExistenteException, PreguntasInsuficientesException, DniUnicoExcepcion, java.text.ParseException {
        try {
            JSONParser parser = new JSONParser();
            //restivo por parametros la direccion del archivo json
            // y lo defino como un object
            Object obj = parser.parse(new FileReader(archivo));
            //el object lo defino como un tipo JSONObject
            JSONObject jSONObject = (JSONObject) obj;
            //definos las variables con los campos que va ha recivir el json
         
            String nombre = jSONObject.get("nombre").toString();
            String descripcion = jSONObject.get("descripcion").toString();
            int val = Integer.parseInt(jSONObject.get("isPublic").toString());
            boolean isPublic = false;
            if (val == 1) {
                isPublic = true;
            }
            SimpleDateFormat valor = new SimpleDateFormat("yyyy-mm-dd");
            java.util.Date date = valor.parse(jSONObject.get("inicio").toString());
            Date fechaInicio = new java.sql.Date(date.getTime());
            java.util.Date date2 = valor.parse(jSONObject.get("fin").toString());
            Date fechaFin = new java.sql.Date(date2.getTime());
            int maximoEncuestados = (int) Double.parseDouble(jSONObject.get("maximoEncuestados").toString());
            String objetivo = jSONObject.get("objetivo").toString();
            int edadMinima = (int) Double.parseDouble(jSONObject.get("edadMinima").toString());
            int edadMaxima = (int) Double.parseDouble(jSONObject.get("edadMaxima").toString());
            String generoObjetivo = jSONObject.get("generoObjetivo").toString();
            int idSubcategoria = (int) Double.parseDouble(jSONObject.get("idSubcategoria").toString());
            
            Encuesta encuesta = new Encuesta(0, nombre, descripcion, isPublic, fechaInicio, fechaFin, maximoEncuestados, objetivo, edadMinima, edadMaxima, generoObjetivo, idSubcategoria);
            System.out.println(encuesta.getId());
            int idEncuesta = controlEncuesta.crear(encuesta, idSubcategoria, false, 8);
            System.out.println("Registrar ENCUESTA\n" + idEncuesta + "," + nombre + "," + descripcion + "," + isPublic + "," + fechaInicio + "," + fechaFin + "," + maximoEncuestados + "," + objetivo + "," + edadMinima + "," + edadMaxima + "," + generoObjetivo + "," + idSubcategoria);
            //defino de un objeto tipo preguntaEncuesta un arrayJSON 
            JSONArray preguntasEncuestaArray = (JSONArray) jSONObject.get("preguntasEncuesta");
            //y lo recorro para setiar las variables que contenga
            for (int i = 0; i < preguntasEncuestaArray.size(); i++) {

                JSONObject preguntasEncuesta = (JSONObject) preguntasEncuestaArray.get(i);

                int numeroPregunta = (int) Double.parseDouble(preguntasEncuesta.get("numeroPregunta").toString());
                long idPreguntaRequisito = (long) Double.parseDouble(preguntasEncuesta.get("idPreguntaRequisito").toString());
                int idOpcionRequisito = (int) Double.parseDouble(preguntasEncuesta.get("idOpcionRequisito").toString());

                JSONArray preguntaArray = (JSONArray) preguntasEncuesta.get("pregunta");
                long idPregunta = 0;
                for (int j = 0; j < preguntaArray.size(); j++) {

                    JSONObject pregunta = (JSONObject) preguntaArray.get(j);

                    idPregunta = (long) Double.parseDouble(pregunta.get("idPregunta").toString());
                    String enunciado = pregunta.get("enunciado").toString();
                    int tipoPregunta = (int) Double.parseDouble(pregunta.get("tipoPregunta").toString());

                    controlPreguntas.crear(tipoPregunta, idSubcategoria, enunciado, isPublic);
                    System.out.println("Registrar PREGUNTA\n" + tipoPregunta + "," + idSubcategoria + "," + enunciado + "," + isPublic);

                    JSONArray opcionesArray = (JSONArray) pregunta.get("opciones");
                    ArrayList<Opcion> listaOpciones = new ArrayList<>();
                    for (int k = 0; k < opcionesArray.size(); k++) {

                        JSONObject opciones = (JSONObject) opcionesArray.get(k);

                        int idOpcion = (int) Double.parseDouble(opciones.get("idOpcion").toString());
                        String textoOpcion = opciones.get("opcion").toString();
                        boolean isAbierta = false;
                        if (Double.parseDouble(opciones.get("idOpcion").toString()) != 0) {
                            isAbierta = true;
                        }
                        Opcion op = new Opcion(idPregunta, idOpcion, textoOpcion, isAbierta);
                        listaOpciones.add(op);
                        System.out.println(listaOpciones.get(k).getTextoOpcion());
                    }
                    controlPreguntas.setOpciones(listaOpciones);
                }

                //aqui mando el crear PreguntaEncuesta
                PreguntaEncuesta preEncuesta = new PreguntaEncuesta(idEncuesta, i, numeroPregunta, idPreguntaRequisito, idOpcionRequisito);
                System.out.println("Registrar PREGUNTA ENCUESTA\n" + idEncuesta + "," + idPregunta + "," + numeroPregunta + "," + idPreguntaRequisito + "," + idOpcionRequisito);
            }

        } catch (IOException ex) {
            Logger.getLogger(CtlAgregarPreguntas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(CtlAgregarPreguntas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
}