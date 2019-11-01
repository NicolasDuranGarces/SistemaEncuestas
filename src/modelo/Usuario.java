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
public class Usuario {
    private long dni;
    private String nombre;
    private String apellido;
    private int edad;
    private String genero;
    private String ocupacion;
    private int idCiudadResidencia;
    private String direccion;

    public Usuario() {
        
    }
    
    public Usuario(long dni, String nombre, String apellido, int edad, String genero, String ocupacion, int idCiudadResidencia, String direccion) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.ocupacion = ocupacion;
        this.idCiudadResidencia = idCiudadResidencia;
        this.direccion = direccion;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public int getIdCiudadResidencia() {
        return idCiudadResidencia;
    }

    public void setIdCiudadResidencia(int idCiudadResidencia) {
        this.idCiudadResidencia = idCiudadResidencia;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
}
