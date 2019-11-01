/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import bos.BOCiudad;
import excepciones.ConexionException;
import java.util.ArrayList;
import modelo.Asset;

/**
 *
 * @author SEBASTIAN
 */
public class CtlCiudad {
    BOCiudad boCiudad;

    public CtlCiudad() {
        boCiudad = new BOCiudad();
    }
    
    public ArrayList<Asset> listado() throws ConexionException{
        return boCiudad.listado();
    }
}
