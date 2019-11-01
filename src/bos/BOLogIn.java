/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bos;

import definiciones.IDAOLogIn;
import excepciones.ConexionException;
import excepciones.UsernameIncorrectoException;
import excepciones.PasswordIncorrectoException;
import fabrica.FabricaDAO;
import modelo.Login;

/**
 *
 * @author jose
 */
public class BOLogIn {
    private IDAOLogIn daoLogIn;

    public BOLogIn() {
        daoLogIn = FabricaDAO.getFabrica().crearDAOLogIn();
    }
    
    public Login iniciarSesion(String username, String password) throws ConexionException, UsernameIncorrectoException, PasswordIncorrectoException{
        Login login = daoLogIn.buscar(username);
        if (login == null){
            throw new UsernameIncorrectoException();
        }
        if (login.getPassword().equals(password)){
            return login;
        } else {
            throw new PasswordIncorrectoException();
        }
    }
    
    public boolean agregarDatosDeInicio(Login login) throws ConexionException {
        daoLogIn.agregar(login);
        return true;
    }
}
