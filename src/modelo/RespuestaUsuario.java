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
public class RespuestaUsuario {

    private int idEncuesta;
    private int numeroPregunta;
    private long dni;
    private long idPregunta;
    private int idOpcion;
    private String respuestaAbierta;
    private int ordenRanking;

    public RespuestaUsuario(int idEncuesta, int numeroPregunta, long dni, long idPregunta, int idOpcion, String respuestaAbierta, int ordenRanking) {
        this.idEncuesta = idEncuesta;
        this.numeroPregunta = numeroPregunta;
        this.dni = dni;
        this.idPregunta = idPregunta;
        this.idOpcion = idOpcion;
        this.respuestaAbierta = respuestaAbierta;
        this.ordenRanking = ordenRanking;
    }

    public int getIdEncuesta() {
        return idEncuesta;
    }

    public void setIdEncuesta(int idEncuesta) {
        this.idEncuesta = idEncuesta;
    }

    public int getNumeroPregunta() {
        return numeroPregunta;
    }

    public void setNumeroPregunta(int numeroPregunta) {
        this.numeroPregunta = numeroPregunta;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
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

    public String getRespuestaAbierta() {
        return respuestaAbierta;
    }

    public void setRespuestaAbierta(String respuestaAbierta) {
        this.respuestaAbierta = respuestaAbierta;
    }

    public int getOrdenRanking() {
        return ordenRanking;
    }

    public void setOrdenRanking(int ordenRanking) {
        this.ordenRanking = ordenRanking;
    }

}
