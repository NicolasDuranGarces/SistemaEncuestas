/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package definiciones;

import excepciones.ConexionException;
import java.util.ArrayList;
import modelo.Subcategoria;

/**
 *
 * @author jose
 */
public interface IDAOSubcategoria {
    
    public boolean agregar(Subcategoria subcategoria) throws ConexionException;
    
    public boolean modificar(Subcategoria subcategoria) throws ConexionException;
    
    public Subcategoria buscar(int id) throws ConexionException;
    
    public ArrayList<Subcategoria> cargarPorCategoria(int idCategoria) throws ConexionException;
    
    public boolean eliminar(int id) throws ConexionException;
}
