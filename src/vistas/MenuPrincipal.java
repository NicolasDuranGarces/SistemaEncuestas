/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controladores.CtlAgregarPreguntas;
import excepciones.ConexionException;

import java.awt.Dimension;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import excepciones.DniUnicoExcepcion;
import excepciones.PreguntasInsuficientesException;
import excepciones.YaExistenteException;
import java.text.ParseException;

/**
 *
 * @author jose
 */
public class MenuPrincipal extends javax.swing.JFrame {

    public static JInternalFrame ventanaActual;
    CtlAgregarPreguntas controlador;
    public MenuPrincipal() {
        initComponents();
        controlador = new CtlAgregarPreguntas();
        this.setExtendedState(MAXIMIZED_BOTH);

        if (FrmLogin.role.equals("Usuario")) {
//            jMenuAdministrar.setVisible(false);
            jmiCrearEncuesta.setVisible(false);
            jmiAgregarPreguntas.setVisible(false);
            jmiInvitarUsuarios.setVisible(false);
            jMenuPreguntas.setVisible(false);
            jMenuUsuarios.setVisible(false);
        } else if (FrmLogin.role.equals("Administrador")) {
            jmiPresentarEncuesta.setVisible(false);

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelInterno1 = new vistas.PanelInterno();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuEncuestas = new javax.swing.JMenu();
        jmiCrearEncuesta = new javax.swing.JMenuItem();
        jmiAgregarPreguntas = new javax.swing.JMenuItem();
        jmiInvitarUsuarios = new javax.swing.JMenuItem();
        jmiPresentarEncuesta = new javax.swing.JMenuItem();
        jmiImportacionEncuestas = new javax.swing.JMenuItem();
        jMenuPreguntas = new javax.swing.JMenu();
        jmiCrearPreguntas = new javax.swing.JMenuItem();
        jmiDespachos = new javax.swing.JMenuItem();
        jmiHistorial = new javax.swing.JMenuItem();
        jmiHabilitarVehiculos = new javax.swing.JMenuItem();
        jMenuUsuarios = new javax.swing.JMenu();
        jmiRegistrarUsuarios = new javax.swing.JMenuItem();
        jmiGestionarViajes = new javax.swing.JMenuItem();
        jmiMisTiquetes = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(1380, 735));
        setResizable(false);

        panelInterno1.setDoubleBuffered(true);
        panelInterno1.setMaximumSize(new java.awt.Dimension(1380, 712));
        panelInterno1.setMinimumSize(new java.awt.Dimension(1380, 712));

        jMenuEncuestas.setBackground(new java.awt.Color(255, 255, 255));
        jMenuEncuestas.setText("Encuestas");
        jMenuEncuestas.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N

        jmiCrearEncuesta.setBackground(new java.awt.Color(255, 255, 255));
        jmiCrearEncuesta.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jmiCrearEncuesta.setText("Crear Encuesta");
        jmiCrearEncuesta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCrearEncuestaActionPerformed(evt);
            }
        });
        jMenuEncuestas.add(jmiCrearEncuesta);

        jmiAgregarPreguntas.setBackground(new java.awt.Color(255, 255, 255));
        jmiAgregarPreguntas.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jmiAgregarPreguntas.setText("Agregar Preguntas");
        jmiAgregarPreguntas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAgregarPreguntasActionPerformed(evt);
            }
        });
        jMenuEncuestas.add(jmiAgregarPreguntas);

        jmiInvitarUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        jmiInvitarUsuarios.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jmiInvitarUsuarios.setText("Invitar Usuarios");
        jmiInvitarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiInvitarUsuariosActionPerformed(evt);
            }
        });
        jMenuEncuestas.add(jmiInvitarUsuarios);

        jmiPresentarEncuesta.setBackground(new java.awt.Color(255, 255, 255));
        jmiPresentarEncuesta.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jmiPresentarEncuesta.setText("Presentar Encuestas");
        jmiPresentarEncuesta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPresentarEncuestaActionPerformed(evt);
            }
        });
        jMenuEncuestas.add(jmiPresentarEncuesta);

        jmiImportacionEncuestas.setBackground(new java.awt.Color(255, 255, 255));
        jmiImportacionEncuestas.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jmiImportacionEncuestas.setText("Importar Encuesta");
        jmiImportacionEncuestas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiImportacionEncuestasActionPerformed(evt);
            }
        });
        jMenuEncuestas.add(jmiImportacionEncuestas);

        jMenuBar1.add(jMenuEncuestas);

        jMenuPreguntas.setBackground(new java.awt.Color(255, 255, 255));
        jMenuPreguntas.setText("Preguntas");
        jMenuPreguntas.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N

        jmiCrearPreguntas.setBackground(new java.awt.Color(255, 255, 255));
        jmiCrearPreguntas.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jmiCrearPreguntas.setText("Crear Preguntas");
        jmiCrearPreguntas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCrearPreguntasActionPerformed(evt);
            }
        });
        jMenuPreguntas.add(jmiCrearPreguntas);

        jmiDespachos.setBackground(new java.awt.Color(255, 255, 255));
        jmiDespachos.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jmiDespachos.setText("--");
        jmiDespachos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiDespachosActionPerformed(evt);
            }
        });
        jMenuPreguntas.add(jmiDespachos);

        jmiHistorial.setBackground(new java.awt.Color(255, 255, 255));
        jmiHistorial.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jmiHistorial.setText("--");
        jmiHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiHistorialActionPerformed(evt);
            }
        });
        jMenuPreguntas.add(jmiHistorial);

        jmiHabilitarVehiculos.setBackground(new java.awt.Color(255, 255, 255));
        jmiHabilitarVehiculos.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jmiHabilitarVehiculos.setText("--");
        jmiHabilitarVehiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiHabilitarVehiculosActionPerformed(evt);
            }
        });
        jMenuPreguntas.add(jmiHabilitarVehiculos);

        jMenuBar1.add(jMenuPreguntas);

        jMenuUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        jMenuUsuarios.setText("Usuarios");
        jMenuUsuarios.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N

        jmiRegistrarUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        jmiRegistrarUsuarios.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jmiRegistrarUsuarios.setText("Registrar Usuario");
        jmiRegistrarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiRegistrarUsuariosActionPerformed(evt);
            }
        });
        jMenuUsuarios.add(jmiRegistrarUsuarios);

        jmiGestionarViajes.setBackground(new java.awt.Color(255, 255, 255));
        jmiGestionarViajes.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jmiGestionarViajes.setText("--");
        jmiGestionarViajes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiGestionarViajesActionPerformed(evt);
            }
        });
        jMenuUsuarios.add(jmiGestionarViajes);

        jmiMisTiquetes.setBackground(new java.awt.Color(255, 255, 255));
        jmiMisTiquetes.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jmiMisTiquetes.setText("--");
        jmiMisTiquetes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiMisTiquetesActionPerformed(evt);
            }
        });
        jMenuUsuarios.add(jmiMisTiquetes);

        jMenuBar1.add(jMenuUsuarios);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelInterno1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelInterno1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jmiCrearEncuestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCrearEncuestaActionPerformed
        if (ventanaActual == null) {
            ventanaActual = new FrmCrearEncuesta();
            panelInterno1.add(ventanaActual);
        } else {
            panelInterno1.remove(ventanaActual);
            panelInterno1.repaint();
            ventanaActual = new FrmCrearEncuesta();
            panelInterno1.add(ventanaActual);
        }
    }//GEN-LAST:event_jmiCrearEncuestaActionPerformed

    private void jmiAgregarPreguntasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAgregarPreguntasActionPerformed
        if (ventanaActual == null) {
            ventanaActual = new FrmAgregarPreguntas();
            panelInterno1.add(ventanaActual);
        } else {
            panelInterno1.remove(ventanaActual);
            panelInterno1.repaint();
            ventanaActual = new FrmAgregarPreguntas();
            panelInterno1.add(ventanaActual);
        }
    }//GEN-LAST:event_jmiAgregarPreguntasActionPerformed

    private void jmiInvitarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiInvitarUsuariosActionPerformed

            if (ventanaActual == null) {
                ventanaActual = new FrmInvitarUsuarios();
                panelInterno1.add(ventanaActual);
            } else {
                panelInterno1.remove(ventanaActual);
                panelInterno1.repaint();
                ventanaActual = new FrmInvitarUsuarios();
                panelInterno1.add(ventanaActual);
            }

    }//GEN-LAST:event_jmiInvitarUsuariosActionPerformed

    private void jmiRegistrarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiRegistrarUsuariosActionPerformed

        if (ventanaActual == null) {
            ventanaActual = new FrmRegistrarUsuario();
            panelInterno1.add(ventanaActual);
        } else {
            panelInterno1.remove(ventanaActual);
            panelInterno1.repaint();
            ventanaActual = new FrmRegistrarUsuario();
            panelInterno1.add(ventanaActual);
        }

    }//GEN-LAST:event_jmiRegistrarUsuariosActionPerformed

    private void jmiGestionarViajesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiGestionarViajesActionPerformed

    }//GEN-LAST:event_jmiGestionarViajesActionPerformed

    private void jmiDespachosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiDespachosActionPerformed

    }//GEN-LAST:event_jmiDespachosActionPerformed

    private void jmiHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiHistorialActionPerformed

    }//GEN-LAST:event_jmiHistorialActionPerformed

    private void jmiCrearPreguntasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCrearPreguntasActionPerformed
        // TODO add your handling code here:
        if (ventanaActual == null) {
            ventanaActual = new FrmCrearPreguntas();
            panelInterno1.add(ventanaActual);
            Dimension desktopSize = panelInterno1.getSize();
            Dimension FrameSize = ventanaActual.getSize();
            ventanaActual.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
            ventanaActual.show();
        } else {
            panelInterno1.remove(ventanaActual);
            panelInterno1.repaint();
            ventanaActual = new FrmCrearPreguntas();
            panelInterno1.add(ventanaActual);
            Dimension desktopSize = panelInterno1.getSize();
            Dimension FrameSize = ventanaActual.getSize();
            ventanaActual.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
            ventanaActual.show();
        }
    }//GEN-LAST:event_jmiCrearPreguntasActionPerformed

    private void jmiHabilitarVehiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiHabilitarVehiculosActionPerformed

    }//GEN-LAST:event_jmiHabilitarVehiculosActionPerformed

    private void jmiMisTiquetesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiMisTiquetesActionPerformed

    }//GEN-LAST:event_jmiMisTiquetesActionPerformed

    private void jmiPresentarEncuestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPresentarEncuestaActionPerformed
        if (ventanaActual == null) {
            ventanaActual = new FrmElegirEncuesta();
            panelInterno1.add(ventanaActual);
        } else {
            panelInterno1.remove(ventanaActual);
            panelInterno1.repaint();
            ventanaActual = new FrmElegirEncuesta();
            panelInterno1.add(ventanaActual);
        }
    }//GEN-LAST:event_jmiPresentarEncuestaActionPerformed

    private void jmiImportacionEncuestasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiImportacionEncuestasActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        //Creamos el objeto JFileChooser
        JFileChooser fc = new JFileChooser();
        //Indicamos lo que podemos seleccionar
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        //Creamos el filtro
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.JSON", "json");
        //Le indicamos el filtro
        fc.setFileFilter(filtro);
        //Abrimos la ventana, guardamos la opcion seleccionada por el usuario
        int seleccion = fc.showOpenDialog(jmiImportacionEncuestas);
        //Si el usuario, pincha en aceptar
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            //Seleccionamos el fichero
            File fichero = fc.getSelectedFile();
            try {
                if (controlador.importarPreguntas(fichero.getAbsolutePath())) {
                    JOptionPane.showMessageDialog(null, "Importacion Exitosa");
                }
            } catch (ConexionException | YaExistenteException | PreguntasInsuficientesException | DniUnicoExcepcion ex) {
                Logger.getLogger(FrmAgregarPreguntas.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jmiImportacionEncuestasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuEncuestas;
    private javax.swing.JMenu jMenuPreguntas;
    private javax.swing.JMenu jMenuUsuarios;
    private javax.swing.JMenuItem jmiAgregarPreguntas;
    private javax.swing.JMenuItem jmiCrearEncuesta;
    private javax.swing.JMenuItem jmiCrearPreguntas;
    private javax.swing.JMenuItem jmiDespachos;
    private javax.swing.JMenuItem jmiGestionarViajes;
    private javax.swing.JMenuItem jmiHabilitarVehiculos;
    private javax.swing.JMenuItem jmiHistorial;
    private javax.swing.JMenuItem jmiImportacionEncuestas;
    private javax.swing.JMenuItem jmiInvitarUsuarios;
    private javax.swing.JMenuItem jmiMisTiquetes;
    private javax.swing.JMenuItem jmiPresentarEncuesta;
    private javax.swing.JMenuItem jmiRegistrarUsuarios;
    public static vistas.PanelInterno panelInterno1;
    // End of variables declaration//GEN-END:variables
}
