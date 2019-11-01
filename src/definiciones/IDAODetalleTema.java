/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package definiciones;

import excepciones.ConexionException;
import modelo.DetalleTema;

/**
 *
 * @author jose
 */
public interface IDAODetalleTema {
    
    public boolean agregar(DetalleTema detalleTema) throws ConexionException;
    
    public boolean eliminar(int tema, long dni) throws ConexionException;
}
