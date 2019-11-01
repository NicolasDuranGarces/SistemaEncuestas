/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import definiciones.IDAOCategoria;
import definiciones.IDAOCiudad;
import definiciones.IDAODetalleTema;
import definiciones.IDAOEncuesta;
import definiciones.IDAOLogIn;
import definiciones.IDAOOpciones;
import definiciones.IDAOParticipante;
import definiciones.IDAOPregunta;
import definiciones.IDAOPreguntaEncuesta;
import definiciones.IDAORespuestaUsuario;
import definiciones.IDAOSubcategoria;
import definiciones.IDAOTemaInteres;
import definiciones.IDAOUsuario;
import definiciones.IFabricaDAO;

/**
 *
 * @author jose
 */
public class FabricaDAOJDBC implements IFabricaDAO{

    @Override
    public IDAOCategoria crearDAOCategoria() {
        return new DAOCategoria();
    }

    @Override
    public IDAOCiudad crearDAOCiudad() {
        return new DAOCiudad();
    }

    @Override
    public IDAODetalleTema crearDAODetalleTema() {
        return new DAODetalleTema();
    }

    @Override
    public IDAOEncuesta crearDAOEncuesta() {
        return new DAOEncuesta();
    }

    @Override
    public IDAOOpciones crearDAOOpciones() {
        return new DAOOpciones();
    }

    @Override
    public IDAOParticipante crearDAOParticipante() {
        return new DAOParticipante();
    }

    @Override
    public IDAOPregunta crearDAOPregunta() {
        return new DAOPregunta();
    }

    @Override
    public IDAOPreguntaEncuesta crearDAOPreguntaEncuesta() {
        return new DAOPreguntaEncuesta();
    }

    @Override
    public IDAORespuestaUsuario crearDAORespuestaUsuario() {
        return new DAORespuestaUsuario();
    }

    @Override
    public IDAOSubcategoria crearDAOSubcategoria() {
        return new DAOSubcategoria();
    }

    @Override
    public IDAOTemaInteres crearDAOTemaInteres() {
        return new DAOTemaInteres();
    }

    @Override
    public IDAOUsuario crearDAOUsuario() {
        return new DAOUsuario();
    }

    @Override
    public IDAOLogIn crearDAOLogIn() {
        return new DAOLogIn();
    }
    
}
