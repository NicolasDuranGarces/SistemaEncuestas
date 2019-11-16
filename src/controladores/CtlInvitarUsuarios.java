/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import bos.BOEncuesta;
import bos.BOParticipantes;
import bos.BOUsuario;
import excepciones.ConexionException;
import excepciones.NoExistenteException;
import excepciones.UsuarioNoexisteExcepcion;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.Participante;
import modelo.Usuario;

/**
 *
 * @author jose
 */
public class CtlInvitarUsuarios {

    BOUsuario boUsuario;
    BOParticipantes boParticipantes;
    BOEncuesta boEncuesta;
    ArrayList<Usuario> listaUsuarios;
    ArrayList<Participante> listaParticipantes;
    ArrayList<Usuario> listaUsuariosParticipantes;

    public CtlInvitarUsuarios() {
        boUsuario = new BOUsuario();
        boParticipantes = new BOParticipantes();
        boEncuesta = new BOEncuesta();
        listaUsuarios = new ArrayList<>();
        listaParticipantes = new ArrayList<>();
        listaUsuariosParticipantes = new ArrayList<>();
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public ArrayList<Participante> getListaParticipantes() {
        return listaParticipantes;
    }

    public void setListaParticipantes(ArrayList<Participante> listaParticipantes) {
        this.listaParticipantes = listaParticipantes;
    }

    public ArrayList<Usuario> getListaUsuariosParticipantes() {
        return listaUsuariosParticipantes;
    }

    public void setListaUsuariosParticipantes(ArrayList<Usuario> listaUsuariosParticipantes) {
        this.listaUsuariosParticipantes = listaUsuariosParticipantes;
    }

    public boolean verificarEncuestaPrivada(int idEncuesta) throws ConexionException, NoExistenteException {
        return !boEncuesta.buscarEncuesta(idEncuesta).isPublica();

    }

    public void cargarUsuarios() throws ConexionException {
        listaUsuarios = boUsuario.listar();
    }

    public void cargarParticipantesEncuesta(int idEncuesta) throws ConexionException, UsuarioNoexisteExcepcion {
        listaParticipantes = boParticipantes.listar(idEncuesta);
        for (int i = 0; i < listaParticipantes.size(); i++) {
            listaUsuariosParticipantes.add(boUsuario.buscar(listaParticipantes.get(i).getDni()));
        }
    }

    public DefaultTableModel listarUsuarios() throws ConexionException {

        String[] nombreColumnas = {"DNI", "Nombre", "Apellido", "Edad", "Género"};
        DefaultTableModel modelo;
        modelo = new DefaultTableModel(null, nombreColumnas);
        for (int i = 0; i < listaUsuarios.size(); i++) {

            modelo.addRow(new Object[]{
                listaUsuarios.get(i).getDni(),
                listaUsuarios.get(i).getNombre(),
                listaUsuarios.get(i).getApellido(),
                listaUsuarios.get(i).getEdad(),
                listaUsuarios.get(i).getGenero()});
        }
        return modelo;
    }

    public DefaultTableModel listarParticipantesEncuesta() throws ConexionException {

        String[] nombreColumnas = {"ID Pregunta", "Número Pregunta", "ID Pregunta Requisito", "ID Opción Requisito"};
        DefaultTableModel modelo;
        modelo = new DefaultTableModel(null, nombreColumnas);
        if (listaUsuariosParticipantes.size()>0) {
            for (int i = 0; i < listaUsuariosParticipantes.size(); i++) {

                modelo.addRow(new Object[]{
                    listaUsuariosParticipantes.get(i).getDni(),
                    listaUsuariosParticipantes.get(i).getNombre(),
                    listaUsuariosParticipantes.get(i).getApellido(),
                    listaUsuariosParticipantes.get(i).getEdad(),
                    listaUsuariosParticipantes.get(i).getGenero()});
            }
        }
        return modelo;
    }
}
