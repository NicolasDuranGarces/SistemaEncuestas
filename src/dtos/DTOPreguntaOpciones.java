/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import modelo.Pregunta;

/**
 *
 * @author SEBASTIAN
 */
public class DTOPreguntaOpciones {

    private long idPregunta;
    private String enunciado;
    private int tipoPregunta;
    private int idSubcategoria;
    private String nombreSubCategoria;
    private int idCategoria;
    private String nombreCategoria;

    public DTOPreguntaOpciones() {
    }

    public DTOPreguntaOpciones(long idPregunta, String enunciado, int tipoPregunta, int idSubcategoria, String nombreSubCategoria, int idCategoria, String nombreCategoria) {
        this.idPregunta = idPregunta;
        this.enunciado = enunciado;
        this.tipoPregunta = tipoPregunta;
        this.idSubcategoria = idSubcategoria;
        this.nombreSubCategoria = nombreSubCategoria;
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
    }

    

    public long getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(long idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public int getIdSubcategoria() {
        return idSubcategoria;
    }

    public void setIdSubcategoria(int idSubcategoria) {
        this.idSubcategoria = idSubcategoria;
    }

    public int getTipoPregunta() {
        return tipoPregunta;
    }

    public void setTipoPregunta(int tipoPregunta) {
        this.tipoPregunta = tipoPregunta;
    }

    public String getNombreSubCategoria() {
        return nombreSubCategoria;
    }

    public void setNombreSubCategoria(String nombreSubCategoria) {
        this.nombreSubCategoria = nombreSubCategoria;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    

}
