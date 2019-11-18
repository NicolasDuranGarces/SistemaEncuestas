 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author jose
 */
public class Encuesta extends Asset {

    private String descripcion;
    private boolean publica;
    private Date fechaInicio;
    private Date fechaFin;
    private int maximoEncuestados;
    private String objetivo;
    private int edadMinima;
    private int edadMaxima;
    private String generoObjetivo;
    private int idSubcategoria;

    public Encuesta(int id, String nombre, String descripcion, boolean isPublic, Date fechaInicio, Date fechaFin, int maximoEncuestados, String objetivo, int edadMinima, int edadMaxima, String generoObjetivo, int idSubcategoria) {
        super(id, nombre);
        this.descripcion = descripcion;
        this.publica = isPublic;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.maximoEncuestados = maximoEncuestados;
        this.objetivo = objetivo;
        this.edadMinima = edadMinima;
        this.edadMaxima = edadMaxima;
        this.generoObjetivo = generoObjetivo;
        this.idSubcategoria = idSubcategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isPublica() {
        return publica;
    }

    public void setPublica(boolean publica) {
        this.publica = publica;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getMaximoEncuestados() {
        return maximoEncuestados;
    }

    public void setMaximoEncuestados(int maximoEncuestados) {
        this.maximoEncuestados = maximoEncuestados;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public int getEdadMinima() {
        return edadMinima;
    }

    public void setEdadMinima(int edadMinima) {
        this.edadMinima = edadMinima;
    }

    public int getEdadMaxima() {
        return edadMaxima;
    }

    public void setEdadMaxima(int edadMaxima) {
        this.edadMaxima = edadMaxima;
    }

    public String getGeneroObjetivo() {
        return generoObjetivo;
    }

    public void setGeneroObjetivo(String generoObjetivo) {
        this.generoObjetivo = generoObjetivo;
    }

    public int getIdSubcategoria() {
        return idSubcategoria;
    }

    public void setIdSubcategoria(int idSubcategoria) {
        this.idSubcategoria = idSubcategoria;
    }

}
