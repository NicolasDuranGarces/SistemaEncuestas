/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import bos.BOCategorias;
import bos.BOEncuesta;
import bos.BOSubcategorias;
import excepciones.ConexionException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.Categoria;
import modelo.Encuesta;
import modelo.Subcategoria;

/**
 *
 * @author jose
 */
public class CtlElegirEncuesta {
    
    BOCategorias boCategorias;
    BOSubcategorias boSubcategorias;
    BOEncuesta boEncuesta;
    ArrayList<Categoria> listaCategorias;
    ArrayList<Subcategoria> listaSubcategorias;
    ArrayList<Encuesta> listaEncuestas;

    public CtlElegirEncuesta() {
        boCategorias = new BOCategorias();
        boSubcategorias = new BOSubcategorias();
        boEncuesta = new BOEncuesta();
        listaEncuestas = new ArrayList<>();
    }

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

    public ArrayList<Encuesta> getListaEncuestas() {
        return listaEncuestas;
    }

    public void setListaEncuestas(ArrayList<Encuesta> listaEncuestas) {
        this.listaEncuestas = listaEncuestas;
    }
            
    public ArrayList<Subcategoria> obtenerSubcategorias(int idCategoria) throws ConexionException{
        listaSubcategorias = boSubcategorias.cargarSubcategorias(idCategoria);
        return listaSubcategorias;
    }
    
    public ArrayList<Categoria> obtenerCategorias() throws ConexionException{
        listaCategorias = boCategorias.cargarCategorias();
        return listaCategorias;
    }
    
    public Encuesta cargarEncuestaSeleccionada(int pos){
        return listaEncuestas.get(pos);
    }
    
    public void cargarEncuestas() throws ConexionException {
        setListaEncuestas(boEncuesta.cargarEncuestas());
    }
    
    public void cargarEncuestasPublicas() throws ConexionException{
        setListaEncuestas(boEncuesta.cargarEncuestasPublicas());
    }
    
    public void cargarEncuestasPrivadas(long dni) throws ConexionException{
        setListaEncuestas(boEncuesta.cargarEncuestasPrivadas(dni));
    }
    
    public DefaultTableModel listarEncuestas() throws ConexionException {

        String[] nombreColumnas = {"ID Encuesta", "Nombre Encuesta", "Descripción", "Visibilidad"};
        DefaultTableModel modelo;
        modelo = new DefaultTableModel(null, nombreColumnas);
        String visibilidad;
        for (int i = 0; i < listaEncuestas.size(); i++) {
            if (listaEncuestas.get(i).isPublica()){
                visibilidad = "Pública";
            } else {
                visibilidad = "Privada";
            }
            modelo.addRow(new Object[]{
                listaEncuestas.get(i).getId(),
                listaEncuestas.get(i).getNombre(),
                listaEncuestas.get(i).getDescripcion(),
                visibilidad});
        }
        return modelo;
    }
}
