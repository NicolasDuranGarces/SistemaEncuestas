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
public class YaExistenteException extends Exception{
    public YaExistenteException(String elObjeto){
        super(elObjeto+" que ha intentado crear tiene \nun identificador único que ya existe");
    }
}
