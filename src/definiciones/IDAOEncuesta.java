/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package definiciones;

import excepciones.ConexionException;
import java.util.ArrayList;
import modelo.Encuesta;

/**
 *
 * @author jose
 */
public interface IDAOEncuesta {
    
    public boolean agregar(Encuesta encuesta) throws ConexionException;
    
    public boolean modificar(Encuesta encuesta) throws ConexionException;
    
    public Encuesta buscar(int idEncuesta) throws ConexionException;
    
    public ArrayList<Encuesta> cargarEncuestas() throws ConexionException;
    
    public boolean eliminar(int idEncuesta) throws ConexionException;
}
