/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import bos.BOUsuario;
import excepciones.ConexionException;
import excepciones.DniUnicoExcepcion;
import excepciones.UsuarioNoexisteExcepcion;
import excepciones.UsuarioYaRegistradoExcepcion;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Usuario;

/**
 *
 * @author SEBASTIAN
 */
public class CtlUsuario {

    BOUsuario boUsuario;

    public CtlUsuario() {
        boUsuario = new BOUsuario();
    }

    public boolean crear(long dni, String nombre, String apellido, int edad, String genero, String ocupacion, int idCiudadResidencia, String direccion) throws UsuarioYaRegistradoExcepcion, DniUnicoExcepcion, ConexionException {
        Usuario user = new Usuario(dni, nombre, apellido, edad, genero, ocupacion, idCiudadResidencia, direccion);
        boUsuario.crear(user);
        return true;

    }

    public Usuario buscar(long dni) throws UsuarioNoexisteExcepcion, ConexionException {

        return boUsuario.buscar(dni);

    }

    public boolean modificar(long dni, String nombre, String apellido, int edad, String genero, String ocupacion, int idCiudadResidencia, String direccion) throws ConexionException {
        Usuario user = new Usuario(dni, nombre, apellido, edad, genero, ocupacion, idCiudadResidencia, direccion);
        boUsuario.modificar(user);
        return true;

    }

    public boolean eliminar(long dni) throws ConexionException {
        boUsuario.eliminar(dni);
        return true;
    }

    public DefaultTableModel listarUsuario(JTable listar) throws ConexionException {
        ArrayList<Usuario> arrayUsuario = boUsuario.listar();
        String[] nombreColumnas = {"DNI", "Nombre", "Apellido", "Edad", "Genero", "Ocupacion"};
        DefaultTableModel modelo;
        modelo = new DefaultTableModel(null, nombreColumnas);
        for (int i = 0; i < arrayUsuario.size(); i++) {
            modelo.addRow(new Object[]{
                arrayUsuario.get(i).getDni(),
                arrayUsuario.get(i).getNombre(),
                arrayUsuario.get(i).getApellido(),
                arrayUsuario.get(i).getEdad(),
                arrayUsuario.get(i).getGenero(),
                arrayUsuario.get(i).getOcupacion(),});
        }
        return modelo;
    }

}
