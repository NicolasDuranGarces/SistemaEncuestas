/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author jose
 */
public class Pregunta {

    private long idPregunta;
    private String enunciado;
    private int idSubcategoria;
    private int tipoPregunta;

    public Pregunta(long idPregunta, String enunciado, int idSubcategoria, int tipoPregunta) {
        this.idPregunta = idPregunta;
        this.enunciado = enunciado;
        this.idSubcategoria = idSubcategoria;
        this.tipoPregunta = tipoPregunta;
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

}
