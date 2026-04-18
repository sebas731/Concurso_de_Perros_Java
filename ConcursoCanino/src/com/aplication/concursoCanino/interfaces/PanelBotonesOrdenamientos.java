/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aplication.concursoCanino.interfaces;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Familia Mamani
 */
public class PanelBotonesOrdenamientos extends JPanel implements ActionListener{
    
    
    private static final String ORDENAR_POR_RAZA = "ordenarRaza";
    
    private static final String ORDENAR_POR_EDAD = "ordenarEdad";
    
    private static final String ORDENAR_POR_PUNTOS = "ordenarPuntos";
    
    private static final String ORDENAR_POR_NOMBRE = "ordenarNombre";
    
    
    private InterfazPrincipal principal;
    
    //Botones
    
        private JButton btnOrdenarRaza, btnOrdenarEdad, btnOrdenarNombre, btnOrdenarPuntos;

    public PanelBotonesOrdenamientos(InterfazPrincipal interfaz) {
        
        principal = interfaz;
        
        GridLayout gl=new GridLayout(1, 4);
        gl.setHgap(5);
     
        
        setLayout(gl);
        
        //Componentes
        btnOrdenarEdad = new JButton(" EDAD ");
        btnOrdenarEdad.setActionCommand(ORDENAR_POR_EDAD);
        btnOrdenarEdad.addActionListener(this);
        add(btnOrdenarEdad);
        
        btnOrdenarRaza = new JButton(" RAZA ");
        btnOrdenarRaza.setActionCommand(ORDENAR_POR_RAZA);
        btnOrdenarRaza.addActionListener(this);
        add(btnOrdenarRaza);
        
        btnOrdenarNombre = new JButton(" NOMBRE ");
        btnOrdenarNombre.setActionCommand(ORDENAR_POR_NOMBRE);
        btnOrdenarNombre.addActionListener(this);
        add(btnOrdenarNombre);
        
        btnOrdenarPuntos = new JButton(" PUNTOS ");
        btnOrdenarPuntos.setActionCommand(ORDENAR_POR_PUNTOS);
        btnOrdenarPuntos.addActionListener(this);
        add(btnOrdenarPuntos);
        
       
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (ORDENAR_POR_EDAD.equals(e.getActionCommand())) {
            principal.ordenarPorEdad();
        }else if(ORDENAR_POR_NOMBRE.equals(e.getActionCommand())){
            principal.ordenarPorNombre();
        }else if (ORDENAR_POR_RAZA.equals(e.getActionCommand())) {
            principal.ordenarPorRaza();
        }else if (ORDENAR_POR_PUNTOS.equals(e.getActionCommand())) {
            principal.ordenarPorPuntos();
        }
    
    }
    
    
}
