/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bos;

import daos.DAOUsuario;
import definiciones.IDAOUsuario;
import excepciones.ConexionException;
import excepciones.DniUnicoExcepcion;
import excepciones.UsuarioNoexisteExcepcion;
import excepciones.UsuarioYaRegistradoExcepcion;
import fabrica.FabricaDAO;
import java.util.ArrayList;
import modelo.Usuario;

/**
 *
 * @author SEBASTIAN
 */
public class BOUsuario {
    private IDAOUsuario daoUsuario;

    public BOUsuario() {
        daoUsuario = FabricaDAO.getFabrica().crearDAOUsuario();
    }

    public boolean crear(Usuario usuario) throws UsuarioYaRegistradoExcepcion, DniUnicoExcepcion, ConexionException {
        
        if (daoUsuario.buscar(usuario.getDni()) == null) {
            if (daoUsuario.agregar(usuario)) {
                return true;
            } else {
                throw new DniUnicoExcepcion();
            }
        } else {
            throw new UsuarioYaRegistradoExcepcion();
        }
    }

    public Usuario buscar(long dni) throws UsuarioNoexisteExcepcion, ConexionException {
        Usuario estudiante = daoUsuario.buscar(dni);
        if (estudiante != null) {
            return estudiante;
        } else {
            throw new UsuarioNoexisteExcepcion();
        }
    }

    public boolean modificar(Usuario user) throws ConexionException {
            if (daoUsuario.modificar(user)) {
                return true;
            } else {
                throw  new ConexionException();
            }
    }
    
    public boolean eliminar(long dni) throws ConexionException{
        if (daoUsuario.eliminar(dni)) {
            return true;
        }else{
            throw new ConexionException();
        }
    }
    public ArrayList<Usuario> listar() throws ConexionException{
        return daoUsuario.listar();
    }
}
