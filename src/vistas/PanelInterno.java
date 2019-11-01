/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.awt.Component;
import java.awt.Graphics;
import javax.swing.JDesktopPane;

/**
 *
 * @author jose
 */
public class PanelInterno extends JDesktopPane {
    
    public PanelInterno(){
        super();
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        for (Component component : getComponents()){
            component.repaint();
        }
    }
}
