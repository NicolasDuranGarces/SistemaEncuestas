/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controladores.CtlPresentarEncuesta;
import excepciones.ConexionException;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import modelo.Opcion;
import modelo.Pregunta;
import modelo.PreguntaEncuesta;
import modelo.RespuestaUsuario;

/**
 *
 * @author nidug
 */
public class FrmPresentarEncuesta extends javax.swing.JFrame implements ActionListener {

    // Variables Generales
    long dni;
    int idEncuesta;
    int cantidadTotalDePreguntas;
    int contadorPregunta = 0;
    int tipoPreguntaActual;
    int idRespuestaActual = 0;
    // Componentes
    ArrayList<JRadioButton> radioButtons = new ArrayList();
    ArrayList<JCheckBox> checboxG = new ArrayList();
    ArrayList<JTextField> textField = new ArrayList();
    ArrayList<JLabel> label = new ArrayList();
    ArrayList<JPanel> panel = new ArrayList();
    JLabel lblDescrpcionPregunta = new JLabel();
    JTextField txtOpcionPreguntsMixtaOtro = new JTextField();
    //Listas Particulares
    ArrayList<Pregunta> listaPreguntas = new ArrayList();
    ArrayList<Pregunta> listadoPreguntaEncuesta = new ArrayList();
    ArrayList<Opcion> listaRespuestas = new ArrayList();

    //Controladores
    CtlPresentarEncuesta controlador;

    public FrmPresentarEncuesta(long dni, int idEncuesta) {
        initComponents();
        this.setVisible(true);
        this.dni = dni;
        this.idEncuesta = idEncuesta;
        btnTerminar.setVisible(false);
        contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.Y_AXIS));
        controlador = new CtlPresentarEncuesta();

        try {
            listadoPreguntaEncuesta = controlador.listarPreguntasAsociadas(idEncuesta);

            cantidadTotalDePreguntas = listadoPreguntaEncuesta.size();
            listaPreguntas = controlador.listarTodasLasPreguntas();
            listaRespuestas = controlador.listarOpciones();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        pintarPregunta();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenedor = new javax.swing.JPanel();
        btnsiguiente = new javax.swing.JButton();
        btnTerminar = new javax.swing.JButton();

        javax.swing.GroupLayout contenedorLayout = new javax.swing.GroupLayout(contenedor);
        contenedor.setLayout(contenedorLayout);
        contenedorLayout.setHorizontalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 795, Short.MAX_VALUE)
        );
        contenedorLayout.setVerticalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 219, Short.MAX_VALUE)
        );

        btnsiguiente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnsiguiente.setText("Siguiente");
        btnsiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsiguienteActionPerformed(evt);
            }
        });

        btnTerminar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnTerminar.setText("Terminar");
        btnTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnsiguiente)
                .addGap(51, 51, 51)
                .addComponent(btnTerminar)
                .addGap(49, 49, 49))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsiguiente)
                    .addComponent(btnTerminar))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsiguienteActionPerformed
        guardarRespuestaUnica();
//        radioButtons.clear();
        if (checboxG.size() > 0) {
            guardarRespuestaMultiple();
        }
//        checboxG.clear();
        limpiarPanelRespuestaUnica();
        limpiarPanelRespuestaMultiple();
        limpiarPanelRespuestaMixta();
        limpiarPanelRespuestaRanking();
        limpiarPanelRespuestaEscala();
        pintarPregunta();

    }//GEN-LAST:event_btnsiguienteActionPerformed

    private void btnTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminarActionPerformed
        guardarRespuestaUnica();
        if (checboxG.size() > 0) {
            guardarRespuestaMultiple();
        }
        this.dispose();
    }//GEN-LAST:event_btnTerminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTerminar;
    private javax.swing.JButton btnsiguiente;
    private javax.swing.JPanel contenedor;
    // End of variables declaration//GEN-END:variables

    public void pintarPregunta() {

        if (contadorPregunta < cantidadTotalDePreguntas || contadorPregunta == 0) {
            lblDescrpcionPregunta.setText(listadoPreguntaEncuesta.get(contadorPregunta).getEnunciado());
            lblDescrpcionPregunta.setName(listadoPreguntaEncuesta.get(contadorPregunta).getIdPregunta() + "");
            contenedor.add(lblDescrpcionPregunta);

            switch (listadoPreguntaEncuesta.get(contadorPregunta).getTipoPregunta()) {
                case 2:
                    cargarRespuestaEleccionUnica(listadoPreguntaEncuesta.get(contadorPregunta).getIdPregunta());
                    tipoPreguntaActual = listadoPreguntaEncuesta.get(contadorPregunta).getTipoPregunta();
                    break;
                case 3:
                    cargarRespuestaEleccionUnica(listadoPreguntaEncuesta.get(contadorPregunta).getIdPregunta());
                    tipoPreguntaActual = listadoPreguntaEncuesta.get(contadorPregunta).getTipoPregunta();
                    break;
                case 4:
                    cargarRespuestaEleccionMultiple(listadoPreguntaEncuesta.get(contadorPregunta).getIdPregunta());
                    tipoPreguntaActual = listadoPreguntaEncuesta.get(contadorPregunta).getTipoPregunta();
                    break;
                case 5:
                    cargarRespuestaRanking(listadoPreguntaEncuesta.get(contadorPregunta).getIdPregunta());
                    tipoPreguntaActual = listaPreguntas.get(contadorPregunta).getTipoPregunta();
                    break;
                case 7:
                    cargarRespuestaNumerica(listadoPreguntaEncuesta.get(contadorPregunta).getIdPregunta());
                    tipoPreguntaActual = listaPreguntas.get(contadorPregunta).getTipoPregunta();
                    break;
                case 8:
                    cargarRespuestaNominal(listadoPreguntaEncuesta.get(contadorPregunta).getIdPregunta());
                    tipoPreguntaActual = listaPreguntas.get(contadorPregunta).getTipoPregunta();
                    break;
                case 9:
                    cargarRespuestaMixta(listadoPreguntaEncuesta.get(contadorPregunta).getIdPregunta());
                    tipoPreguntaActual = listaPreguntas.get(contadorPregunta).getTipoPregunta();
                    break;
                default:
                    break;
            }
        }
        contadorPregunta++;
        if ((contadorPregunta) == cantidadTotalDePreguntas) {
            btnTerminar.setVisible(true);
            btnsiguiente.setVisible(false);
        }

    }

    public void cargarRespuestaEleccionUnica(Long preguntaId) {
        int posicion = 1;
        ButtonGroup grupo = new ButtonGroup();
        for (int i = 0; i < listaRespuestas.size(); i++) {
            if (listaRespuestas.get(i).getIdPregunta() == preguntaId) {
                JRadioButton radio = new JRadioButton();
                grupo.add(radio);
                radio.setText(listaRespuestas.get(i).getTextoOpcion());
                radio.setName(listaRespuestas.get(i).getIdOpcion() + "");
                radio.setBounds(30, 30 + (posicion * 30), 60, 50);
                contenedor.add(radio);
                radioButtons.add(radio);
                radio.addActionListener(this);
            }
            posicion += 1;
        }
    }

    public void cargarRespuestaNominal(Long preguntaId) {
        int posicion = 1;
        ButtonGroup grupo = new ButtonGroup();
        for (int i = 0; i < listaRespuestas.size(); i++) {
            if (listaRespuestas.get(i).getIdPregunta() == preguntaId) {
                JRadioButton radio = new JRadioButton();
                grupo.add(radio);
                radio.setText(listaRespuestas.get(i).getTextoOpcion());
                radio.setName(listaRespuestas.get(i).getIdOpcion() + "");
                radio.setBounds(30, 30 + (posicion * 30), 60, 50);
                contenedor.add(radio);
                radioButtons.add(radio);
                radio.addActionListener(this);
            }
            posicion += 1;
        }
    }

    public void cargarRespuestaNumerica(Long preguntaId) {
        int posicion = 1;
        ButtonGroup grupo = new ButtonGroup();
        for (int i = 0; i < listaRespuestas.size(); i++) {
            if (listaRespuestas.get(i).getIdPregunta() == preguntaId) {
                JRadioButton radio = new JRadioButton();
                grupo.add(radio);
                radio.setText(listaRespuestas.get(i).getTextoOpcion());
                radio.setName(listaRespuestas.get(i).getIdOpcion() + "");
                radio.setBounds(30, 30 + (posicion * 30), 60, 50);
                contenedor.add(radio);
                radioButtons.add(radio);
                radio.addActionListener(this);
            }
            posicion += 1;
        }
    }

    public void cargarRespuestaEleccionMultiple(Long preguntaId) {
        int posicion = 1;
        for (int i = 0; i < listaRespuestas.size(); i++) {
            if (listaRespuestas.get(i).getIdPregunta() == preguntaId) {
                JCheckBox checkBox = new JCheckBox();
                checkBox.setText(listaRespuestas.get(i).getTextoOpcion());
                checkBox.setName(listaRespuestas.get(i).getIdOpcion() + "");
                checkBox.setBounds(30, 30 + (posicion * 30), 60, 50);
//                contenedor.add(checkBox);
//                checboxG.add(checkBox);
//                checkBox.addActionListener(this);
                checboxG.add(checkBox);
                contenedor.add(checkBox);
                checkBox.addActionListener(this);
            }
            posicion += 1;
        }
    }

    public void cargarRespuestaRanking(Long preguntaId) {

        for (int i = 0; i < listaRespuestas.size(); i++) {
            if (listaRespuestas.get(i).getIdPregunta() == preguntaId) {
                JTextField tex = new JTextField();
                JLabel label = new JLabel();
                JPanel panel = new JPanel();
                tex.setName(listaRespuestas.get(i).getIdOpcion() + "");
                label.setText(listaRespuestas.get(i).getTextoOpcion());
                label.setName(listaRespuestas.get(i).getIdOpcion() + "");
                label.setPreferredSize(new Dimension(1000, 50));
                panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
                panel.add(tex);
                this.panel.add(panel);
                tex.setPreferredSize(new Dimension(60, 30));
                panel.add(label);
                contenedor.add(panel);
                textField.add(tex);
//                label.add(label);
            }

        }
    }

    public void cargarRespuestaMixta(Long preguntaId) {
        int posicion = 1;
//        JCheckBox checkBox = new JCheckBox();

        for (int i = 0; i < listaRespuestas.size(); i++) {
            if (listaRespuestas.get(i).getIdPregunta() == preguntaId) {
                if (listaRespuestas.get(i).isAbierta()) {
                    JCheckBox checkBox = new JCheckBox();
                    checkBox.setText(listaRespuestas.get(i).getTextoOpcion());
                    checkBox.setName(listaRespuestas.get(i).getIdOpcion() + "");
                    contenedor.add(checkBox);
                    checboxG.add(checkBox);
                } else {
                    JCheckBox checkBox = new JCheckBox();
                    checkBox.setText(listaRespuestas.get(i).getTextoOpcion());
                    checkBox.setName(listaRespuestas.get(i).getIdOpcion() + "");
                    checkBox.setBounds(30, 30 + (posicion * 30), 60, 50);
                    checboxG.add(checkBox);
                    contenedor.add(checkBox);
                    checkBox.addActionListener(this);
                }
            }
            posicion += 1;
        }
        contenedor.repaint();
    }

    public void limpiarPanelRespuestaUnica() {
        for (int i = 0; i < radioButtons.size(); i++) {
            contenedor.remove(radioButtons.get(i));
        }
        contenedor.repaint();
        radioButtons.clear();
    }

    public void limpiarPanelRespuestaMultiple() {
        for (int i = 0; i < checboxG.size(); i++) {
            contenedor.remove(checboxG.get(i));
        }
        contenedor.repaint();
        checboxG.clear();
    }

    public void limpiarPanelRespuestaMixta() {
        for (int i = 0; i < checboxG.size(); i++) {
            contenedor.remove(checboxG.get(i));
        }

        contenedor.repaint();
        checboxG.clear();
    }

    public void limpiarPanelRespuestaRanking() {
        for (int i = 0; i < panel.size(); i++) {
            contenedor.remove(panel.get(i));
        }
        contenedor.repaint();
        label.clear();
        textField.clear();

    }

    public void limpiarPanelRespuestaEscala() {
        for (int i = 0; i < radioButtons.size(); i++) {
            contenedor.remove(radioButtons.get(i));
        }
        contenedor.repaint();
        radioButtons.clear();

    }

    public void guardarRespuestaUnica() {
        RespuestaUsuario respuesta;

        int numeroPregunta = contadorPregunta;
        long idPregunta = listadoPreguntaEncuesta.get(numeroPregunta-1).getIdPregunta();
        System.out.println(numeroPregunta+","+idPregunta);
        String respuestaAbierta = null;
        int ordenRanking = 0;

        for (int i = 0; i < radioButtons.size(); i++) {
            if (radioButtons.get(i).isSelected()) {
                try {
                    respuesta = new RespuestaUsuario(idEncuesta, numeroPregunta, dni,
                            idPregunta, i + 1, respuestaAbierta, ordenRanking);
                    controlador.guardarRespuestaUnica(respuesta);
                } catch (ConexionException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
            }
        }
    }

    public void guardarRespuestaMultiple() {
        RespuestaUsuario respuesta;
        ArrayList<RespuestaUsuario> listaRespuestas = new ArrayList<>();
        int numeroPregunta = contadorPregunta;
        long idPregunta = listadoPreguntaEncuesta.get(numeroPregunta-1).getIdPregunta();
        String respuestaAbierta = null;
        int ordenRanking = 0;

        for (int i = 0; i < checboxG.size(); i++) {
            if (checboxG.get(i).isSelected()) {

                respuesta = new RespuestaUsuario(idEncuesta, numeroPregunta, dni,
                        idPregunta, i + 1, respuestaAbierta, ordenRanking);
                listaRespuestas.add(respuesta);

            }
        }
        try {
            controlador.guardarRespuestaMultiple(listaRespuestas);
        } catch (ConexionException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

    }
}
