/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bos;

import daos.DAOCiudad;
import definiciones.IDAOCiudad;
import excepciones.ConexionException;
import fabrica.FabricaDAO;
import java.util.ArrayList;
import modelo.Asset;

/**
 *
 * @author SEBASTIAN
 */
public class BOCiudad {
    private IDAOCiudad daoCiudad;

    public BOCiudad() {
        daoCiudad = FabricaDAO.getFabrica().crearDAOCiudad();
    }
    
    public ArrayList<Asset> listado() throws ConexionException{
        return daoCiudad.listado();
    }
}
