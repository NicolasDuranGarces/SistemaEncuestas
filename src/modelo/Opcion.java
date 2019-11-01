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
public class Opcion {

    private long idPregunta;
    private int idOpcion;
    private String textoOpcion;
    private boolean abierta;

    public Opcion(long idPregunta, int idOpcion, String textoOpcion, boolean isAbierta) {
        this.idPregunta = idPregunta;
        this.idOpcion = idOpcion;
        this.textoOpcion = textoOpcion;
        this.abierta = isAbierta;
    }

    public long getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(long idPregunta) {
        this.idPregunta = idPregunta;
    }

    public int getIdOpcion() {
        return idOpcion;
    }

    public void setIdOpcion(int idOpcion) {
        this.idOpcion = idOpcion;
    }

    public String getTextoOpcion() {
        return textoOpcion;
    }

    public void setTextoOpcion(String textoOpcion) {
        this.textoOpcion = textoOpcion;
    }

    public boolean isAbierta() {
        return abierta;
    }

    public void setAbierta(boolean abierta) {
        this.abierta = abierta;
    }

}
