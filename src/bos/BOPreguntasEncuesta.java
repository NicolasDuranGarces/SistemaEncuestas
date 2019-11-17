/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bos;

import definiciones.IDAOPregunta;
import definiciones.IDAOPreguntaEncuesta;
import excepciones.ConexionException;
import excepciones.NoExistenteException;
import excepciones.PreguntaYaEnLaEncuestaException;
import excepciones.PreguntasInsuficientesException;
import fabrica.FabricaDAO;
import static java.lang.Math.random;
import java.util.ArrayList;
import modelo.Pregunta;
import modelo.PreguntaEncuesta;

/**
 *
 * @author jose
 */
public class BOPreguntasEncuesta {

    private IDAOPreguntaEncuesta daoPreguntasEncuesta;
    private IDAOPregunta daoPreguntas;

    public BOPreguntasEncuesta() {
        daoPreguntasEncuesta = FabricaDAO.getFabrica().crearDAOPreguntaEncuesta();
        daoPreguntas = FabricaDAO.getFabrica().crearDAOPregunta();
    }
    
    public boolean verificarSiPreguntaNoAgregada(PreguntaEncuesta preguntaEncuesta) throws ConexionException, PreguntaYaEnLaEncuestaException{
        ArrayList<PreguntaEncuesta> lista = cargarPreguntasEncuesta(preguntaEncuesta.getIdEncuesta());
        for (int i=0; i<lista.size(); i++){
            if (lista.get(i).getIdPregunta() == preguntaEncuesta.getIdPregunta()){
                throw new PreguntaYaEnLaEncuestaException();
            }
        }
        return true;
    }

    public boolean agregarPreguntaALaEncuesta(PreguntaEncuesta preguntaEncuesta) throws ConexionException, PreguntaYaEnLaEncuestaException {
        PreguntaEncuesta preguntaGuardada = daoPreguntasEncuesta.buscar(preguntaEncuesta.getIdEncuesta(), preguntaEncuesta.getNumeroPregunta());
//        ArrayList<PreguntaEncuesta> lista = cargarPreguntasEncuesta(preguntaEncuesta.getIdEncuesta());
//        for (int i=0; i<lista.size(); i++){
//            if (lista.get(i).getIdPregunta() == preguntaEncuesta.getIdPregunta()){
//                throw new PreguntaYaEnLaEncuestaException();
//            }
//        }
        verificarSiPreguntaNoAgregada(preguntaEncuesta);
        
        if (preguntaGuardada == null) {
            if (preguntaEncuesta.getIdPreguntaRequisito() == 0) {
                daoPreguntasEncuesta.agregarIndependiente(preguntaEncuesta);
            } else {
                daoPreguntasEncuesta.agregarDependiente(preguntaEncuesta);
            }
            return true;
        } else {
            throw new PreguntaYaEnLaEncuestaException();
        }
    }

    public PreguntaEncuesta obtenerPreguntaEncuesta(int idEncuesta, int numeroPregunta) throws ConexionException {
        PreguntaEncuesta preguntaEncuesta = daoPreguntasEncuesta.buscar(idEncuesta, numeroPregunta);
        return preguntaEncuesta;
    }

    public boolean quitarPreguntaDeLaEncuesta(int idEncuesta, int numeroPregunta) throws ConexionException {
        daoPreguntasEncuesta.eliminar(idEncuesta, numeroPregunta);
        ArrayList<PreguntaEncuesta> lista = cargarPreguntasEncuesta(idEncuesta);
        if ((numeroPregunta - 1) < lista.size()) {
            for (int i = numeroPregunta - 1; i < lista.size(); i++) {
                daoPreguntasEncuesta.restarNumero(idEncuesta, (i + 2));
            }
        }
        return true;
    }

    public ArrayList<PreguntaEncuesta> cargarPreguntasEncuesta(int idEncuesta) throws ConexionException {
        ArrayList<PreguntaEncuesta> preguntasEncuesta = daoPreguntasEncuesta.cargarPreguntasEncuesta(idEncuesta);
        return preguntasEncuesta;
    }

    public boolean generarCuestionarioAleatorio(int idEncuesta, int cantidadPreguntasEncuesta, int idSubcategoria) throws ConexionException, PreguntasInsuficientesException {
        ArrayList<Pregunta> listado = daoPreguntas.cargarPreguntasPorSubcategoria(idSubcategoria);
//        ArrayList<Pregunta> preguntasEncuesta = new ArrayList();
        int aleatorio;
        Pregunta pregunta;
        PreguntaEncuesta preguntaEncuesta;
        if (cantidadPreguntasEncuesta <= listado.size()) {
            for (int i = 0; i < cantidadPreguntasEncuesta; i++) {
                aleatorio = (int) (random() * listado.size());
                pregunta = listado.get(aleatorio);
//                preguntasEncuesta.add(pregunta);
                preguntaEncuesta = new PreguntaEncuesta(idEncuesta, pregunta.getIdPregunta(), (i + 1), 0, 0);
                daoPreguntasEncuesta.agregarIndependiente(preguntaEncuesta);
                listado.remove(aleatorio);
            }
//            return preguntasEncuesta;
            return true;
        } else {
            throw new PreguntasInsuficientesException(cantidadPreguntasEncuesta, listado.size());
        }
    }
    
    public boolean verificarPregunta(int idEncuesta, int numeroPregunta) throws ConexionException, PreguntaYaEnLaEncuestaException, NoExistenteException {
        if (daoPreguntasEncuesta.buscar(idEncuesta, numeroPregunta) == null) {
            throw new NoExistenteException("La pregunta", "referenciar");
        } 
        return true;
    }
}
