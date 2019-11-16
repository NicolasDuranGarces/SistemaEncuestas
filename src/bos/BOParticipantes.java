/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bos;

import definiciones.IDAOParticipante;
import excepciones.ConexionException;
import excepciones.ParticipanteYaAsociadoException;
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

    public boolean agregar(Participante participante) throws ConexionException, ParticipanteYaAsociadoException {
        if (daoParticipante.buscar(participante) == null) {
            return daoParticipante.agregar(participante);
            
        } else {
            throw new ParticipanteYaAsociadoException();
        }
    }

    public boolean quitar(long dni, int idEncuesta) throws ConexionException {
        return daoParticipante.eliminar(dni, idEncuesta);
    }

    public ArrayList<Participante> listar(int idEncuesta) throws ConexionException {
        return daoParticipante.listar(idEncuesta);
    }
}
