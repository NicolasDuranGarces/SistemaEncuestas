/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package definiciones;

import excepciones.ConexionException;
import modelo.RespuestaUsuario;

/**
 *
 * @author jose
 */
public interface IDAORespuestaUsuario {
    
    public boolean agregar(RespuestaUsuario respuesta) throws ConexionException;
    
    public boolean modificar(RespuestaUsuario respuesta) throws ConexionException;
    
    public RespuestaUsuario buscar(RespuestaUsuario respuesta) throws ConexionException;
    
    public boolean eliminar(int idEncuesta, int numeroPregunta, long dni) throws ConexionException;
    
}
