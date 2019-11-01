/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import bos.BOLogIn;
import excepciones.ConexionException;
import excepciones.PasswordIncorrectoException;
import excepciones.UsernameIncorrectoException;
import modelo.Login;

/**
 *
 * @author jose
 */
public class CtlLogIn {
    BOLogIn boLogIn;

    public CtlLogIn() {
        boLogIn = new BOLogIn();
    }
    
    public Login iniciarSesion(String username, String password) 
            throws ConexionException, UsernameIncorrectoException, PasswordIncorrectoException{
        
        return boLogIn.iniciarSesion(username, password);
    }
    
}
