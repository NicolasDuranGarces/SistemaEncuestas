/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package definiciones;

import excepciones.ConexionException;
import modelo.Login;

/**
 *
 * @author jose
 */
public interface IDAOLogIn {
    
    public boolean agregar(Login login) throws ConexionException;
    
    public Login buscar(String username) throws ConexionException;
}
