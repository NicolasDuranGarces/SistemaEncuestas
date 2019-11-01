/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package definiciones;

import excepciones.ConexionException;
import java.util.ArrayList;
import modelo.Categoria;

/**
 *
 * @author jose
 */
public interface IDAOCategoria {
    
    public boolean agregar(Categoria categoria) throws ConexionException;
    
    public boolean modificar(Categoria categoria) throws ConexionException;
    
    public Categoria buscar(int id) throws ConexionException;
    
    public ArrayList<Categoria> cargarCategorias() throws ConexionException;
    
    public boolean eliminar(int id) throws ConexionException;
}
