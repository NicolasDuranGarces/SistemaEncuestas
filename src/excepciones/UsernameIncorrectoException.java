/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 *
 * @author jose
 */
public class UsernameIncorrectoException extends Exception{

    public UsernameIncorrectoException() {
        super("Nombre de usuario incorrecto");
    }
    
}
