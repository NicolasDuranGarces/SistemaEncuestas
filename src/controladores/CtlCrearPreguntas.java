/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import bos.BOOpciones;
import bos.BOPregunta;
import dtos.DTOPreguntaOpciones;
import excepciones.ConexionException;
import excepciones.DniUnicoExcepcion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Opcion;
import modelo.Pregunta;

/**
 *
 * @author jose
 */
public class CtlCrearPreguntas {

    BOPregunta boPregunta;
    BOOpciones boOpciones;
    ArrayList<Opcion> opciones;

    public CtlCrearPreguntas() {
        boPregunta = new BOPregunta();
        boOpciones = new BOOpciones();
        opciones = new ArrayList<>();
    }

    public void setOpciones(ArrayList<Opcion> opciones) {
        this.opciones = opciones;
    }

    public void limpiarArray() {
        opciones.clear();
    }

    public void eliminarOpcion(int indice) {
        for (int i = 0; i < opciones.size(); i++) {
            if (indice == opciones.get(i).getIdOpcion()) {
                opciones.remove(i);
            }
        }
    }

    public boolean crear(int tipoPregunta, int idSupCategoria, String enunciado, boolean abierto) throws DniUnicoExcepcion, ConexionException {
        Pregunta pregunta = new Pregunta(boPregunta.generarId(), enunciado, idSupCategoria, tipoPregunta);
        Opcion opc;
        boPregunta.crear(pregunta);
        if (tipoPregunta != 9) {
            for (int i = 0; i < opciones.size(); i++) {
                opc = new Opcion(pregunta.getIdPregunta(), opciones.get(i).getIdOpcion(), opciones.get(i).getTextoOpcion(), false);
                boOpciones.crear(opc);
            }
        } else {
            for (int i = 0; i < opciones.size(); i++) {
                opc = new Opcion(pregunta.getIdPregunta(), opciones.get(i).getIdOpcion(), opciones.get(i).getTextoOpcion(), false);
                boOpciones.crear(opc);
            }
            opc = new Opcion(pregunta.getIdPregunta(), opciones.size() + 1, "Otro", true);
            boOpciones.crear(opc);
        }
        return true;
    }

    public DefaultTableModel ListadoPregunta(JTable listar) throws ConexionException {
        ArrayList<DTOPreguntaOpciones> arrayPregunta = boPregunta.ListadoPregunta();
        String[] nombreColumnas = {"DNI", "ENUNCIADO", "TIPO PREGUNTA", "CATEGORIA", "SUBCATEGORIA"};
        DefaultTableModel modelo;
        modelo = new DefaultTableModel(null, nombreColumnas);
        for (int i = 0; i < arrayPregunta.size(); i++) {
            modelo.addRow(new Object[]{
                arrayPregunta.get(i).getIdPregunta(),
                arrayPregunta.get(i).getEnunciado(),
                arrayPregunta.get(i).getTipoPregunta(),
                arrayPregunta.get(i).getNombreCategoria(),
                arrayPregunta.get(i).getNombreSubCategoria(),});
        }
        return modelo;
    }

    public DefaultTableModel cargarTabla(Opcion op, JTable listar) {
        if (op == null) {
            String[] nombreColumnas = {"ID", "Opcion"};
            DefaultTableModel modelo;
            modelo = new DefaultTableModel(null, nombreColumnas);

            for (int i = 0; i < opciones.size(); i++) {
                modelo.addRow(new Object[]{
                    opciones.get(i).getIdOpcion(),
                    opciones.get(i).getTextoOpcion()
                });
            }
            return modelo;
        } else {
            opciones.add(op);
            String[] nombreColumnas = {"ID", "Opcion"};
            DefaultTableModel modelo;
            modelo = new DefaultTableModel(null, nombreColumnas);

            for (int i = 0; i < opciones.size(); i++) {
                modelo.addRow(new Object[]{
                    opciones.get(i).getIdOpcion(),
                    opciones.get(i).getTextoOpcion()
                });
            }
            return modelo;
        }

    }

}
