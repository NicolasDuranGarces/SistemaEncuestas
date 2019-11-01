/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import bos.BOCiudad;
import bos.BOLogIn;
import bos.BOUsuario;
import excepciones.ConexionException;
import excepciones.DniUnicoExcepcion;
import excepciones.UsuarioYaRegistradoExcepcion;
import java.util.ArrayList;
import modelo.Asset;
import modelo.Login;
import modelo.Usuario;

/**
 *
 * @author jose
 */
public class CtlRegistrate {
    BOLogIn boLogin;
    BOCiudad boCiudad;
    BOUsuario boUsuario;

    public CtlRegistrate() {
        boLogin = new BOLogIn();
        boCiudad = new BOCiudad();
        boUsuario = new BOUsuario();
    }
    
    public boolean agregarDatosDeInicio(Login login) throws ConexionException {
        return boLogin.agregarDatosDeInicio(login);
        
    }
    public ArrayList<Asset> listarCiudades() throws ConexionException{
        return boCiudad.listado();
    }
    
    public boolean crearUsuario(Usuario user) throws UsuarioYaRegistradoExcepcion, DniUnicoExcepcion, ConexionException {       
        boUsuario.crear(user);
        return true;

    }
    
}
