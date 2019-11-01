/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package definiciones;

import excepciones.ConexionException;
import java.util.ArrayList;
import modelo.Asset;
import modelo.Ciudad;

/**
 *
 * @author jose
 */
public interface IDAOCiudad {
    
    public boolean agregar(Ciudad ciudad) throws ConexionException;
    
    public boolean modificar(Ciudad ciudad) throws ConexionException;
    
    public Ciudad buscar(int id) throws ConexionException;
    
    public boolean eliminar(int id) throws ConexionException;
    
    public ArrayList<Asset> listado() throws ConexionException;
}
