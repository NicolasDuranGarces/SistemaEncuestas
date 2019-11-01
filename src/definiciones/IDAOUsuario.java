/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package definiciones;

import excepciones.ConexionException;
import java.util.ArrayList;
import modelo.Usuario;

/**
 *
 * @author jose
 */
public interface IDAOUsuario {
    
    public boolean agregar(Usuario usuario) throws ConexionException;
    
    public boolean modificar(Usuario usuario) throws ConexionException;
    
    public Usuario buscar(long codigo) throws ConexionException;

    public boolean eliminar(long dni) throws ConexionException;
    
    public ArrayList<Usuario> listar() throws ConexionException;
}
