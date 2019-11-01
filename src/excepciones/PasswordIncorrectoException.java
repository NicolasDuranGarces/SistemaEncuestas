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
public class PasswordIncorrectoException extends Exception{

    public PasswordIncorrectoException() {
        super("Contraseña Incorrecta");
    }
    
}
