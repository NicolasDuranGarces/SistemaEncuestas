/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 *
 * @author SEBASTIAN
 */
public class UsuarioYaRegistradoExcepcion extends Exception{
    //el exception puede parar el fujo de ejecucion
    //y el runtimeexcepcion segue continuando la ejecucion
    public UsuarioYaRegistradoExcepcion (){
        super("Lo sentimos , Este Usuario ya existe");
    }
}
