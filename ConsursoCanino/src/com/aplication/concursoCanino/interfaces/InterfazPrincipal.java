/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.aplication.concursoCanino.interfaces;

import com.aplication.concursoCanino.Logica.Perro;
import com.aplication.concursoCanino.Logica.PerroImplements;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Familia Mamani
 */
public class InterfazPrincipal extends JFrame{
    
    Perro[] lista;
    
    ArrayList<Perro> listaPerros=new ArrayList<Perro>(); 
    
    PanelTablaPerros panel;
    PerroImplements implPerro;
    PanelDatosPerros panelDatos;
    
    public InterfazPrincipal() throws IOException {
        
        cargar();
        
        implPerro=new PerroImplements();
        
        implPerro.setPerros(listaPerros);
        //Configuracion inicial
        setLayout( new GridBagLayout( ) );
        GridBagConstraints gbc=new GridBagConstraints();
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 500)); 
        //añadiendo paneles
        
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.weightx=1.0;
        gbc.weighty = 1.0;  
        gbc.fill = GridBagConstraints.BOTH;
        panel =new PanelTablaPerros(this);
        add(panel,gbc);
        gbc.gridx=1;
        gbc.gridy=0;
        panelDatos = new PanelDatosPerros();
        add(panelDatos,gbc);
        
        panelDatos.cargarDatos(implPerro.getPerros().get(0));
        
        
        pack();
        
        
    }
    
    private void cargar() throws FileNotFoundException, IOException{
        
        try {

            FileInputStream fis = new FileInputStream(new File("./data/perros.txt"));

            Properties propiedad = new Properties();

            propiedad.load(fis);

            String nombre;
            String raza;
            String image;
            int puntos;
            int edad;
            int cantidad = Integer.valueOf(propiedad.getProperty( "total.perros"));
            
            
            lista = new Perro[cantidad];
            for (int i = 0; i < cantidad ; i++) {

                String para = "perro" + (i + 1);

                nombre = propiedad.getProperty(para + ".nombre");
                raza = propiedad.getProperty(para + ".raza");
                image = propiedad.getProperty(para+".imagen");
                puntos = Integer.valueOf(propiedad.getProperty(para + ".puntos"));
                edad = Integer.valueOf(propiedad.getProperty(para + ".edad"));

                Perro p = new Perro(nombre, raza, image ,puntos,edad);
                listaPerros.add(p);
                lista[i] = p;
                System.out.println("" + lista[i].getName());

            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this,
                    "No se encontró el archivo de datos.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,
                    "Error al leer el archivo de datos.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
        //panel.m.addRow(lista);
         
    }
    
    public void buscarPerro(String nombre){
        Perro p = implPerro.BuscarPerroNombre(nombre);
        
        if (p!=null) {
            Object[] fila = {
                p.getName(),
                p.getEdad(), // o getPuntos() según tu clase Perro
                p.getRaza()
            };
            
            panel.mostrarPerro(p);
            
        }else{
           
            JOptionPane.showMessageDialog(this,
                    "No se encontró al perro",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
        
    }
        

    
    public static void main(String[] args) throws IOException {
        
        
        InterfazPrincipal i=new InterfazPrincipal();
        i.setVisible(true);
    }
    
}
