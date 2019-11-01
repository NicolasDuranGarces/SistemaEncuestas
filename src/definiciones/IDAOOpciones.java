/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package definiciones;

import excepciones.ConexionException;
import java.util.ArrayList;
import modelo.Opcion;

/**
 *
 * @author jose
 */
public interface IDAOOpciones {
    
    public boolean agregar(Opcion opcion) throws ConexionException;
    
    public boolean modificar(Opcion opcion) throws ConexionException;
    
    public Opcion buscar(long idPregunta, int idOpcion) throws ConexionException;
    
    public boolean eliminar(long idPregunta, int idOpcion) throws ConexionException;
    
    public ArrayList<Opcion> listaOpciones() throws ConexionException;
}
