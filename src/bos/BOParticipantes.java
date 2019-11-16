/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bos;

import definiciones.IDAOParticipante;
import excepciones.ConexionException;
import fabrica.FabricaDAO;
import java.util.ArrayList;
import modelo.Participante;

/**
 *
 * @author jose
 */
public class BOParticipantes {
    private IDAOParticipante daoParticipante;

    public BOParticipantes() {
        daoParticipante = FabricaDAO.getFabrica().crearDAOParticipante();
    }
    
    public boolean agregar(Participante participante) throws ConexionException {
        return daoParticipante.agregar(participante);
    }
    
    public ArrayList<Participante> listar(int idEncuesta) throws ConexionException {
        return daoParticipante.listar(idEncuesta);
    }
}
