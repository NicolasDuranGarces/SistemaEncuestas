/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package definiciones;

import excepciones.ConexionException;
import modelo.TemaInteres;

/**
 *
 * @author jose
 */
public interface IDAOTemaInteres {
    
    public boolean agregar(TemaInteres tema) throws ConexionException;
    
    public boolean modificar(TemaInteres tema) throws ConexionException;
    
    public TemaInteres buscar(int id) throws ConexionException;
    
    public boolean eliminar(int id) throws ConexionException;
}
