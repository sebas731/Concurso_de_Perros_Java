/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aplication.concursoCanino.interfaces;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 *
 * @author Familia Mamani
 */
public class PanelCardsInformativas extends JPanel {
    
    private JLabel lblGanador,lblMayor,lblMenor,lbl;
    
    
    public PanelCardsInformativas(InterfazPrincipal principal) {
        
        GridLayout gb=new GridLayout(1, 4);
        gb.setVgap(4);
        gb.setHgap(4);
        setLayout(gb);
         
    }
    
    public void agregarCard(Cards cartaInfo){
        if (this.getComponentCount()>=4) {
            JOptionPane.showMessageDialog(this, "No se puede Agregar");
        }else{
          add(cartaInfo);  
        }
        
        
    }
    
    
    
    
}
