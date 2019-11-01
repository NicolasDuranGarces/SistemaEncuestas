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
public class NoExistenteException extends Exception{
    public NoExistenteException(String elObjeto, String operacion) {
        super(elObjeto+" que ha intentado "+operacion+" no existe");
    }

    public NoExistenteException() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
