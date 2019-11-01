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
public class ConexionException extends Exception{

    public ConexionException() {
        super("Hubo un problema al conectar con la base de datos");
    }
    
}
