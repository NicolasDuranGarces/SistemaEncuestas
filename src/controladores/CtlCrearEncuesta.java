/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import bos.BOCategorias;
import bos.BOEncuesta;
import bos.BOPreguntasEncuesta;
import bos.BOSubcategorias;
import excepciones.ConexionException;
import excepciones.PreguntasInsuficientesException;
import excepciones.YaExistenteException;
import java.util.ArrayList;
import modelo.Categoria;
import modelo.Encuesta;
import modelo.Subcategoria;

/**
 *
 * @author jose
 */
public class CtlCrearEncuesta {

    BOEncuesta boEncuesta;
    BOPreguntasEncuesta boPreguntasEncuesta;
    BOSubcategorias boSubcategorias;
    BOCategorias boCategorias;
    ArrayList<Categoria> listaCategorias;
    ArrayList<Subcategoria> listaSubcategorias;

    public ArrayList<Categoria> getListaCategorias() {
        return listaCategorias;
    }

    public void setListaCategorias(ArrayList<Categoria> listaCategorias) {
        this.listaCategorias = listaCategorias;
    }

    public ArrayList<Subcategoria> getListaSubcategorias() {
        return listaSubcategorias;
    }

    public void setListaSubcategorias(ArrayList<Subcategoria> listaSubcategorias) {
        this.listaSubcategorias = listaSubcategorias;
    }
    
    

    public CtlCrearEncuesta() {
        boEncuesta = new BOEncuesta();
        boPreguntasEncuesta = new BOPreguntasEncuesta();
        boSubcategorias = new BOSubcategorias();
        boCategorias = new BOCategorias();
    }

    public boolean crear(Encuesta encuesta, int idSubcategoria, boolean isAleatoria, int cantidadPreguntas) throws ConexionException, YaExistenteException, PreguntasInsuficientesException {
        int id;
        id = boEncuesta.crearEncuesta(encuesta);
        if (isAleatoria) {
            boPreguntasEncuesta.generarCuestionarioAleatorio(id, cantidadPreguntas, idSubcategoria);
        }
        return true;
    }
    
    public ArrayList<Subcategoria> obtenerSubcategorias(int idCategoria) throws ConexionException{
        listaSubcategorias = boSubcategorias.cargarSubcategorias(idCategoria);
        return listaSubcategorias;
    }
    
    public ArrayList<Categoria> obtenerCategorias() throws ConexionException{
        listaCategorias = boCategorias.cargarCategorias();
        return listaCategorias;
    }
    
}
