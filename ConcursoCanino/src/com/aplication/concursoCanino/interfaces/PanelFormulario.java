/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aplication.concursoCanino.interfaces;

import com.aplication.concursoCanino.Logica.Perro;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Familia Mamani
 * 
 */
public class PanelFormulario extends JPanel implements ActionListener{

    private JLabel lblTitulo;

    private JTextField txtNombre;

    private JTextField txtRaza;

    private JSpinner txtEdad;

    private JSpinner txtPuntos;

    private JTextField txtFile;

    private JButton btnFile;
    
    private JButton btnAgregar;
    
    private JButton btnLimpiar;
    
    private InterfazPrincipal interfazMain;
    

    /*
    txtPuntos = new JSpinner(new SpinnerNumberModel(
    0,    // valor inicial
    0,    // mínimo
    100,  // máximo
    1     // incremento
    ));
     */
    //private static final SpinnerNumberModel spinerM= new SpinnerNumberModel(1,1, 100, 1);
    // String Commands de txt
    private static final String LIMPIAR_FORMULARIO = "Limpiar";
    private static final String AGREGAR_FORMULARIO = "Insertar";
    private static final String EXAMINAR_FILE = "Examinar";

    //PARA RECOGER EL FILE
    private File f;

    //CLASE ANONIMA FOCUSLISTENER
    private FocusListener oyenteFocus;

    public PanelFormulario(InterfazPrincipal interfaz) {
        
        interfazMain=interfaz;
        
        crearFocusListener();
        
        GridBagConstraints gbs = new GridBagConstraints();
        gbs.insets = new Insets(5, 5, 0, 5);

        GridBagLayout gb = new GridBagLayout();

        setLayout(gb);

        //TITULO
        gbs.gridx = 0;
        gbs.gridy = 0;
        gbs.gridwidth = 2;
        gbs.fill = GridBagConstraints.CENTER;
        lblTitulo = new JLabel(" INGRESAR NUEVO PERRO ");
        lblTitulo.setFont(new Font(" Arial ", Font.BOLD, 18));

        add(lblTitulo, gbs);

        //TXTNOMBRE
        gbs.fill = GridBagConstraints.BOTH;
        gbs.gridx = 0;
        gbs.gridy = 1;
        gbs.gridwidth = 1;
        gbs.weightx = 1.0;
        txtNombre = new JTextField("Nombre");
        txtNombre.setBorder(BorderFactory.createTitledBorder("Nombre"));
        txtNombre.setForeground(Color.GRAY);
        txtNombre.addFocusListener(oyenteFocus);
        add(txtNombre, gbs);
        
        //TXTRAZA
        gbs.gridx = 1;
        gbs.gridy = 1;
        gbs.gridwidth = 1;
        txtRaza = new JTextField("Raza");
        txtRaza.setBorder(BorderFactory.createTitledBorder("Raza"));
        txtRaza.addFocusListener(oyenteFocus);
        add(txtRaza, gbs);

        //TXTEdad
        gbs.gridx = 0;
        gbs.gridy = 2;
        gbs.gridwidth = 1;
        txtEdad = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
        txtEdad.addFocusListener(oyenteFocus);
        txtEdad.setBorder(BorderFactory.createTitledBorder("Edad"));
        add(txtEdad, gbs);

        //TXTPuntos
        gbs.gridx = 1;
        gbs.gridy = 2;
        gbs.gridwidth = 1;
        txtPuntos = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
        txtPuntos.setBorder(BorderFactory.createTitledBorder("Puntos"));
        txtPuntos.addFocusListener(oyenteFocus);
        add(txtPuntos, gbs);

        //FileChooser
        //txtFile =new JFileChooser( );
        //int resultado = txtFile.showOpenDialog(null);
        gbs.gridx = 0;
        gbs.gridy = 3;
        gbs.gridwidth = 1;
        txtFile = new JTextField("./data");
        txtFile.setForeground(Color.GRAY);
        txtFile.setBorder(BorderFactory.createTitledBorder("Imagen"));

        add(txtFile, gbs);

        gbs.gridx = 1;
        gbs.gridy = 3;
        gbs.gridwidth = 1;
        btnFile = new JButton("Examinar");
        btnFile.setActionCommand(EXAMINAR_FILE);
        btnFile.addActionListener(this);
        add(btnFile, gbs);
        
        //boton de agregar y agregar
        
        gbs.gridx = 0;
        gbs.gridy = 4;
        gbs.gridwidth = 1;
        btnAgregar = new JButton("Agregar");
        btnAgregar.setActionCommand(AGREGAR_FORMULARIO);
        btnAgregar.addActionListener(this);
        add(btnAgregar, gbs);
        
        gbs.gridx = 1;
        gbs.gridy = 4;
        gbs.gridwidth = 1;
        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setActionCommand(LIMPIAR_FORMULARIO);
        btnLimpiar.addActionListener(this);
        add(btnLimpiar, gbs);

    }
    
    public void limpiar(){
        txtNombre.setForeground(Color.GRAY);
        txtNombre.setText("Nombre");
        
        txtFile.setForeground(Color.GRAY);
        txtFile.setText("./data");
        
        txtRaza.setForeground(Color.GRAY);
        txtRaza.setText("Raza");
        
        txtEdad.setValue(1);
        
        txtPuntos.setValue(1);
    }
    

    public void crearFocusListener() {

        oyenteFocus = new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {

                if (e.getSource()instanceof JTextField) {
                    JTextField campo = (JTextField) e.getSource();
                    if (campo.getText().isBlank()||campo.getText().equalsIgnoreCase("Nombre") || campo.getText().equalsIgnoreCase("Raza")) {
                    campo.setForeground(Color.black);
                    campo.setText("");
                    }
                    
                    

                } else if (e.getSource() instanceof JSpinner) {
                    JSpinner campo = (JSpinner) e.getSource();
                    campo.setForeground(Color.black);

                }

            }

        };

    }
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals(EXAMINAR_FILE)) {

            JFileChooser fileChooser = new JFileChooser("./data");

            int n = fileChooser.showOpenDialog(this);

            if (n == JFileChooser.APPROVE_OPTION) {
                f = fileChooser.getSelectedFile();
                
                String ruta=f.getAbsolutePath();
                int index= ruta.indexOf("data");
                
                txtFile.setText("./"+ruta.substring(index));
            } else if (n == JFileChooser.CANCEL_OPTION) {
                
                if (!(txtFile.getText().equals("./data"))) {
                    
                    JOptionPane.showMessageDialog(this, "No se pudo editar el archivo");
                    
                }else{
                    txtFile.setText("./data");
                    JOptionPane.showMessageDialog(this, "Ningun archivo seleccionado");
                }

            }

        }else if (e.getActionCommand().equals(AGREGAR_FORMULARIO)) {
            
            String nombre=txtNombre.getText();
            String raza=txtRaza.getText();
            int edad= (int) txtEdad.getValue();
            int puntos= (int) txtPuntos.getValue();
            String img=txtFile.getText();
            int index = interfazMain.getCantidadPerros()+1;
            
            
            
            Perro p=new Perro(nombre,raza,img,puntos , edad,index);
            interfazMain.agregarPerro(p);
            limpiar();
            interfazMain.actualizarCards();
            
            
        }else if (e.getActionCommand().equals(LIMPIAR_FORMULARIO)) {
           //volviendo a la normalidad los campor
            limpiar();
            
            
            
            
        }
    }

}
    
    
    


