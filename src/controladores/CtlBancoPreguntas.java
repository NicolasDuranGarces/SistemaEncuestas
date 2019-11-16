/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import bos.BOCategorias;
import bos.BOPregunta;
import bos.BOSubcategorias;
import dtos.DTOPreguntaOpciones;
import excepciones.ConexionException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.Categoria;
import modelo.Subcategoria;

/**
 *
 * @author jose
 */
public class CtlBancoPreguntas {

    BOPregunta boPregunta;
    BOCategorias boCategorias;
    BOSubcategorias boSubcategorias;
    ArrayList<DTOPreguntaOpciones> listaPreguntas;
    ArrayList<Categoria> listaCategorias;
    ArrayList<Subcategoria> listaSubcategorias;

    public CtlBancoPreguntas() {
        boPregunta = new BOPregunta();
        boCategorias = new BOCategorias();
        boSubcategorias = new BOSubcategorias();        
        listaPreguntas = new ArrayList<>();
    }

    public ArrayList<DTOPreguntaOpciones> getListaPreguntas() {
        return listaPreguntas;
    }

    public void setListaPreguntas(ArrayList<DTOPreguntaOpciones> listaPreguntas) {
        this.listaPreguntas = listaPreguntas;
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
    
    public ArrayList<Subcategoria> obtenerSubcategorias(int idCategoria) throws ConexionException{
        listaSubcategorias = boSubcategorias.cargarSubcategorias(idCategoria);
        return listaSubcategorias;
    }
    
    public ArrayList<Categoria> obtenerCategorias() throws ConexionException{
        listaCategorias = boCategorias.cargarCategorias();
        return listaCategorias;
    }
    
    public void cargarPreguntas() throws ConexionException {
        setListaPreguntas(boPregunta.ListadoPregunta());
    }

    public void cargarPreguntas(int idSubcategoria) throws ConexionException {
        setListaPreguntas(boPregunta.ListadoPregunta(idSubcategoria));
    }

    public DefaultTableModel listarPreguntas() throws ConexionException {

        String[] nombreColumnas = {"ID", "ENUNCIADO", "TIPO PREGUNTA", "CATEGORIA", "SUBCATEGORIA"};
        DefaultTableModel modelo;
        modelo = new DefaultTableModel(null, nombreColumnas);
        for (int i = 0; i < listaPreguntas.size(); i++) {

            modelo.addRow(new Object[]{
                listaPreguntas.get(i).getIdPregunta(),
                listaPreguntas.get(i).getEnunciado(),
                listaPreguntas.get(i).getTipoPregunta(),
                listaPreguntas.get(i).getNombreCategoria(),
                listaPreguntas.get(i).getNombreSubCategoria()});
        }
        return modelo;
    }
    
    public void filtrarPorCategoria(String nombreCategoria) throws ConexionException{
        ArrayList<DTOPreguntaOpciones> listaFiltrada = new ArrayList<>();
        cargarPreguntas();
        for (int i = 0; i < listaPreguntas.size(); i++) {
            if (listaPreguntas.get(i).getNombreCategoria().equals(nombreCategoria)) {
                listaFiltrada.add(listaPreguntas.get(i));
            }
        }
        setListaPreguntas(listaFiltrada);
    }
    
    public void filtrarPorSubcategoria(String nombreSubcategoria) throws ConexionException{
        ArrayList<DTOPreguntaOpciones> listaFiltrada = new ArrayList<>();
        cargarPreguntas();
        for (int i = 0; i < listaPreguntas.size(); i++) {
            if (listaPreguntas.get(i).getNombreSubCategoria().equals(nombreSubcategoria)) {
                listaFiltrada.add(listaPreguntas.get(i));
            }
        }
        setListaPreguntas(listaFiltrada);
    }

       
    public DTOPreguntaOpciones cargarPreguntaSeleccion(int pos){
        return listaPreguntas.get(pos);
    }
}
