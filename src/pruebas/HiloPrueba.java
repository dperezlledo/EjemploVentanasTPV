/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.awt.Component;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Departamento
 */
public class HiloPrueba implements Runnable {

    private Principal gui;

    public HiloPrueba(Principal gui) {
        this.gui = gui;
    }

    @Override
    public void run() {
        try {
            // Creamos 6 ventanas
            for (int i = 0; i < 6; i++) {
                Interna vi = new Interna();
                gui.getPanel().add(vi);
                vi.setVisible(true);
                Thread.sleep(500);

            }
            // Borramos las 6    
            Component[] ventanas = gui.getPanel().getComponents();
            for (int i = 0; i < ventanas.length; i++) {                
                gui.getPanel().remove(ventanas[i]);                                
                gui.getPanel().repaint();                
                Thread.sleep(500);                
            }
            JOptionPane.showMessageDialog(gui, "Nadie se encuentra conectado en este momento");
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloPrueba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
