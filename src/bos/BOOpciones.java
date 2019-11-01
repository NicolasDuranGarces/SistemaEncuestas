/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bos;

import definiciones.IDAOOpciones;
import excepciones.ConexionException;
import excepciones.DniUnicoExcepcion;
import excepciones.NoExistenteException;
import fabrica.FabricaDAO;
import java.util.ArrayList;
import modelo.Opcion;

/**
 *
 * @author SEBASTIAN
 */
public class BOOpciones {

    private IDAOOpciones dAOOpciones;

    public BOOpciones() {
        dAOOpciones = FabricaDAO.getFabrica().crearDAOOpciones();
    }

    public boolean crear(Opcion opcion) throws DniUnicoExcepcion, ConexionException {
        if (dAOOpciones.agregar(opcion)) {
            return true;
        } else {
            throw new ConexionException();
        }
    }

    public Opcion buscar(long idPregunta, int idOpcion) throws NoExistenteException, ConexionException {
        Opcion opcion = dAOOpciones.buscar(idPregunta, idOpcion);
        if (opcion != null) {
            return opcion;
        } else {
            throw new NoExistenteException();
        }
    }

    public boolean modificar(Opcion opcion) throws ConexionException {
        if (dAOOpciones.modificar(opcion)) {
            return true;
        } else {
            throw new ConexionException();
        }
    }

    public boolean eliminar(long idPregunta, int idOpcion) throws ConexionException {
        if (dAOOpciones.eliminar(idPregunta, idOpcion)) {
            return true;
        } else {
            throw new ConexionException();
        }
    }
    
    public ArrayList<Opcion> litaOpciones() throws ConexionException{
        return dAOOpciones.listaOpciones();
    }
}
