/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aplication.concursoCanino.interfaces;

import com.aplication.concursoCanino.Logica.Perro;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Familia Mamani
 */
public class PanelDatosPerros extends JPanel {

    
    JLabel lblImagen;
    
    JLabel lblNombre,lblEdad,lblPuntos,lblRaza;
    
    JTextField txtNombre, txtEdad,txtPuntos,txtRaza;
    
    private String rutaImg;
    
    private BufferedImage img;
    
    private InterfazPrincipal interfaz;
    
    public PanelDatosPerros(InterfazPrincipal ventanaPrincipal) {
        
        interfaz = ventanaPrincipal;
        setLayout(new GridBagLayout());
        GridBagConstraints gbs=new GridBagConstraints();
        //setBorder( new CompoundBorder( new EmptyBorder( 4, 3, 3, 3 ),  new EmptyBorder( 4, 3, 3, 3 )));
        /*setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
                BorderFactory.createEmptyBorder(10, 14, 10, 14)
        ));*/
        setOpaque(false);
         setBackground(Color.WHITE); 
        gbs.insets =new Insets(2, 2, 2, 2);
        gbs.gridx=0;
        gbs.gridy=0;
        gbs.gridwidth =4;
        JLabel lblTitulo=new JLabel(" DETALLES ");
        add(lblTitulo,gbs);
        
        //  Panel Imagen
        gbs.gridx=0;
        gbs.gridy=1;
        
        gbs.gridwidth =4;
        
        JPanel panelImg=new JPanel();
        lblImagen = new JLabel( );
        lblImagen.setMinimumSize( new Dimension( 230, 153 ) );
        lblImagen.setMaximumSize( new Dimension( 230, 153 ) );
        panelImg.add(lblImagen);
        add(panelImg,gbs);
        
        gbs.gridwidth =1;
        gbs.fill = GridBagConstraints.BOTH;
        
        //agregar datos
        
        gbs.gridx=0;
        gbs.gridy=2;
        lblNombre =new JLabel("NOMBRE: ");
        add(lblNombre,gbs);
        
        gbs.gridx=1;
        gbs.gridy=2;
        txtNombre = new JTextField();
        txtNombre.setEnabled( false );
        add(txtNombre,gbs);
        
        //RAZA
        
        gbs.gridx=2;
        gbs.gridy=2;
        lblRaza =new JLabel("RAZA: ");
        add(lblRaza,gbs);
        
        gbs.gridx=3;
        gbs.gridy=2;
        txtRaza = new JTextField();
        txtRaza.setEnabled( false );
        add(txtRaza,gbs);
        
        //EDAD
        gbs.gridx=0;
        gbs.gridy=3;
        lblEdad =new JLabel("EDAD: ");
        add(lblEdad,gbs);
        
        gbs.gridx=1;
        gbs.gridy=3;
        txtEdad = new JTextField();
        txtEdad.setEnabled( false );
        add(txtEdad,gbs);
        
        //PUNTOS
        
        gbs.gridx=2;
        gbs.gridy=3;
        lblPuntos=new JLabel("PUNTOS: ");
        add(lblPuntos,gbs);
        
        gbs.gridx=3;
        gbs.gridy=3;
        txtPuntos = new JTextField();
        txtPuntos.setEnabled( false );
        add(txtPuntos,gbs);
        
        
       
        
        
       
        
        
        
        
    
    }
    
    public void cargarDatos(Perro p){
        
        try {
            rutaImg = p.getImagen();
            img = ImageIO.read( new File( rutaImg ) );
            Image imgEscalada = img.getScaledInstance(230,153, Image.SCALE_SMOOTH);
            lblImagen.setIcon(new ImageIcon(imgEscalada));
            
            //cargando datos
            txtNombre.setText(p.getName());
            
            txtRaza.setText(p.getRaza());
            txtEdad.setText(String.valueOf(p.getEdad()));
            txtPuntos.setText(String.valueOf(p.getPuntos()));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,
                    "No se encontró el archivo de datos.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
        // fondo blanco redondeado
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 12, 12);

        // borde gris exterior
        g2.setColor(new Color(220, 220, 220));
        g2.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 12, 12);

        // borde izquierdo de color (el acento)
        g2.setColor(new Color(55, 138, 221));
        g2.setStroke(new BasicStroke(3));
        g2.drawLine(3, 12, 3, getHeight()-12); // línea vertical izquierda
        
        g2.setBackground(Color.WHITE);
        g2.dispose();
        
        super.paintComponent(g);
    }
    
    

    
    
    
    
}
