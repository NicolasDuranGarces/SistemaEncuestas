/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bos;

import definiciones.IDAOPregunta;
import dtos.DTOPreguntaOpciones;
import excepciones.ConexionException;
import excepciones.DniUnicoExcepcion;
import excepciones.NoExistenteException;
import fabrica.FabricaDAO;
import java.util.ArrayList;
import modelo.Pregunta;

/**
 *
 * @author SEBASTIAN
 */
public class BOPregunta {

    private IDAOPregunta dAOPregunta;

    public BOPregunta() {
        dAOPregunta = FabricaDAO.getFabrica().crearDAOPregunta();
    }

    public boolean crear(Pregunta pregunta) throws DniUnicoExcepcion, ConexionException {
            return dAOPregunta.crear(pregunta);
    }
    
    public long generarId() throws ConexionException {
        return dAOPregunta.generarId();
    }

    public Pregunta buscar(long idPregunta) throws NoExistenteException, ConexionException {
        Pregunta pregunta = dAOPregunta.buscar(idPregunta);
        if (pregunta != null) {
            return pregunta;
        } else {
            throw new NoExistenteException();
        }
    }

    public DTOPreguntaOpciones buscarPreguntaOpcion(long idPregunta) throws NoExistenteException, ConexionException {
        DTOPreguntaOpciones pregunta = dAOPregunta.buscarPreguntaOpcion(idPregunta);
        if (pregunta != null) {
            return pregunta;
        } else {
            throw new NoExistenteException();
        }
    }

    public boolean modificar(Pregunta pregunta) throws ConexionException {
        if (dAOPregunta.modificar(pregunta)) {
            return true;
        } else {
            throw new ConexionException();
        }
    }

    public boolean eliminar(long idPregunta) throws ConexionException {
        if (dAOPregunta.eliminar(idPregunta)) {
            return true;
        } else {
            throw new ConexionException();
        }
    }

    public ArrayList<Pregunta> cargarPreguntasPorCategoria(int idCategoria) throws ConexionException {
        return dAOPregunta.cargarPreguntasPorCategoria(idCategoria);
    }
    
    public ArrayList<DTOPreguntaOpciones> ListadoPregunta() throws ConexionException {
        return dAOPregunta.ListadoPregunta();
    }
    
    public ArrayList<Pregunta> ListarTodasLasPreguntas() throws ConexionException {
        return dAOPregunta.cargarTodasLasPreguntas();
    }
}
