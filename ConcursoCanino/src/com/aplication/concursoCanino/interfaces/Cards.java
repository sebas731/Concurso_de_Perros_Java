/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aplication.concursoCanino.interfaces;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Familia Mamani
 */
public class Cards extends JPanel{
    
    
    private static final Color COLOR_FONDO= Color.WHITE;
    
    private static final Color COLOR_BARRA=new Color(55, 138, 221);
    
    private JLabel lblTitulo;
    
    private JLabel lblSubtitulo;
    
    private JLabel lblValor;

    public Cards(String titulo, String subTitulo, String valor) {
        
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        setOpaque(true);
        
        //padding interno
        setBorder(BorderFactory.createEmptyBorder(12, 16, 12, 16));
        
        lblTitulo = new JLabel(titulo);
        lblTitulo.setForeground(Color.BLACK);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 15));
        
        lblSubtitulo = new JLabel(subTitulo);
        lblSubtitulo.setForeground(new Color(130, 130, 130));
        
        lblValor = new JLabel(valor);
        lblValor.setForeground(new Color(130, 130, 130));
        
        JPanel panelContenedor=new JPanel();
        panelContenedor.setLayout(new BoxLayout(panelContenedor, BoxLayout.Y_AXIS));
        panelContenedor.setOpaque(false);
        panelContenedor.add(lblTitulo);
        panelContenedor.add(Box.createVerticalStrut(4));//espacio fijo
        panelContenedor.add(lblValor);
        panelContenedor.add(Box.createVerticalStrut(2));
        panelContenedor.add(lblSubtitulo);
        
        add(panelContenedor,BorderLayout.CENTER);
        
        
    }
    
    public void actualizar(String titulo, String subTitulo, String valor){
        this.lblSubtitulo.setText(subTitulo);
        this.lblTitulo.setText(titulo);
        this.lblValor.setText(valor);
        repaint();
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        Graphics2D g2= (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
        // sin esto los bordes redondeados se ven pixelados
        // con esto se ven suaves
        
       
        g2.setColor(Color.WHITE);
        g2.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 30, 30);
        
        g2.setColor(Color.GRAY);
        g2.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 12, 12);
        
        g2.setColor(COLOR_BARRA);
        g2.setStroke(new BasicStroke(3));
        g2.drawLine(3, 12, 3, getHeight()-12); // línea vertical izquierda
        g2.dispose();
        
       
        

    }
    
    
    
    
    
    
}
