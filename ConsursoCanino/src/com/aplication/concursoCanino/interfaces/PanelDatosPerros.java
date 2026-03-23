/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aplication.concursoCanino.interfaces;

import com.aplication.concursoCanino.Logica.Perro;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Familia Mamani
 */
public class PanelDatosPerros extends JPanel {

    
    JLabel lblImagen;
    
    private String rutaImg;
    
    private BufferedImage img;
    
    public PanelDatosPerros() {
        
        
        setLayout(new GridBagLayout());
        GridBagConstraints gbs=new GridBagConstraints();
        setBorder( new CompoundBorder( new EmptyBorder( 4, 3, 3, 3 ),  new EmptyBorder( 4, 3, 3, 3 )));
        
        
        gbs.gridx=0;
        gbs.gridy=0;
        
        JLabel lblTitulo=new JLabel(" DETALLES ");
        add(lblTitulo,gbs);
        
        //  Panel Imagen
        gbs.gridx=0;
        gbs.gridy=1;
        JPanel panelImg=new JPanel();
        lblImagen = new JLabel( );
        lblImagen.setMinimumSize( new Dimension( 230, 153 ) );
        lblImagen.setMaximumSize( new Dimension( 230, 153 ) );
        panelImg.add(lblImagen);
        add(panelImg,gbs);
        
        
        //
        
        
       
        
        
        
        
    
    }
    
    public void cargarDatos(Perro p){
        
        try {
            rutaImg = p.getImagen();
            img = ImageIO.read( new File( rutaImg ) );
            img.getScaledInstance(230,153, Image.SCALE_SMOOTH);
            lblImagen.setIcon(new ImageIcon(img));
        } catch (IOException e) {
            
        }
        
        
        
    }
    
    
    
}
