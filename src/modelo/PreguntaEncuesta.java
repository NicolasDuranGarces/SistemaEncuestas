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
public class PreguntaEncuesta {

    private int idEncuesta;
    private long idPregunta;
    private int numeroPregunta;
    private long idPreguntaRequisito;
    private int idOpcionRequisito;

    public PreguntaEncuesta(int idEncuesta, long idPregunta, int numeroPregunta, long idPreguntaRequisito, int idOpcionRequisito) {
        this.idEncuesta = idEncuesta;
        this.idPregunta = idPregunta;
        this.numeroPregunta = numeroPregunta;
        this.idPreguntaRequisito = idPreguntaRequisito;
        this.idOpcionRequisito = idOpcionRequisito;
    }

    public int getIdEncuesta() {
        return idEncuesta;
    }

    public void setIdEncuesta(int idEncuesta) {
        this.idEncuesta = idEncuesta;
    }

    public long getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(long idPregunta) {
        this.idPregunta = idPregunta;
    }

    public int getNumeroPregunta() {
        return numeroPregunta;
    }

    public void setNumeroPregunta(int numeroPregunta) {
        this.numeroPregunta = numeroPregunta;
    }

    public long getIdPreguntaRequisito() {
        return idPreguntaRequisito;
    }

    public void setIdPreguntaRequisito(long idPreguntaRequisito) {
        this.idPreguntaRequisito = idPreguntaRequisito;
    }

    public int getIdOpcionRequisito() {
        return idOpcionRequisito;
    }

    public void setIdOpcionRequisito(int idOpcionRequisito) {
        this.idOpcionRequisito = idOpcionRequisito;
    }

}
