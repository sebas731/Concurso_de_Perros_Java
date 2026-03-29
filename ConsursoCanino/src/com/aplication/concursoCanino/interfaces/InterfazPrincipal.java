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
import java.awt.HeadlessException;
import java.awt.Insets;
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
    

    
    ArrayList<Perro> listaPerros=new ArrayList<Perro>(); 
    
    private PanelTablaPerros panel;
    private PerroImplements implPerro;
    private PanelDatosPerros panelDatos;
    private PanelBotonesOrdenamientos panelOrdenamiento;
    private PanelFormulario panelForm;
    private int cantidadPerros;
    
    
    //cards de datos
    private PanelCardsInformativas panelInformativo;
    private Cards cardInformativas;
    
    public InterfazPrincipal() throws IOException {
        
        cargar();
        
        implPerro=new PerroImplements();
        
        implPerro.setPerros(listaPerros);
        //Configuracion inicial
        setLayout( new GridBagLayout());
        GridBagConstraints gbc=new GridBagConstraints();
        gbc.insets = new Insets(3, 3, 3, 3);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(700, 600)); 
        //añadiendo paneles
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridwidth= 2;
        panelInformativo = new PanelCardsInformativas(this);
        add(panelInformativo,gbc);
        
        
        gbc.gridx=0;
        gbc.gridy=1;
        gbc.gridwidth= 1;
        gbc.gridheight=2;
        gbc.weightx=1.0;
        gbc.weighty = 1.0;  
        gbc.fill = GridBagConstraints.BOTH;
        panel =new PanelTablaPerros(this);
        add(panel,gbc);
        
        gbc.gridx=1;
        gbc.gridy=1;
        gbc.gridwidth= 1;
        gbc.gridheight=1;
        panelDatos = new PanelDatosPerros(this);
        add(panelDatos,gbc);
        
        gbc.gridx=1;
        gbc.gridy=2;
        gbc.gridwidth= 2;
        panelForm = new PanelFormulario();
        add(panelForm,gbc);
        
        gbc.gridx=0;
        gbc.gridy=3;
        gbc.gridwidth= 2;
        gbc.fill = GridBagConstraints.NONE;
        panelOrdenamiento = new PanelBotonesOrdenamientos(this);
        add(panelOrdenamiento,gbc);
        
        
        //
        panelDatos.cargarDatos(implPerro.getPerros().get(0));
        
        ingresarCards();
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
            setCantidadPerros(Integer.valueOf(propiedad.getProperty( "total.perros")));
            //lista = new Perro[cantidad];
            for (int i = 0; i < cantidad ; i++) {

                String para = "perro" + (i + 1);

                nombre = propiedad.getProperty(para + ".nombre");
                raza = propiedad.getProperty(para + ".raza");
                image = propiedad.getProperty(para+".imagen");
                puntos = Integer.valueOf(propiedad.getProperty(para + ".puntos"));
                edad = Integer.valueOf(propiedad.getProperty(para + ".edad"));

                Perro p = new Perro(nombre, raza, image ,puntos,edad);
                listaPerros.add(p);
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
    
    public void ordenarPorRaza(){
        
        implPerro.ordenarPorRaza();
        
        panel.actualizarTabla();
        
    }
    
    public void ordenarPorNombre(){
       
        implPerro.ordenarPorNombre();
        
        panel.actualizarTabla();
        
    }
    
    public void ordenarPorPuntos(){
       
        implPerro.ordenarPorPuntos();
        
        panel.actualizarTabla();
        
    }
    
    public void ordenarPorEdad(){
       
        implPerro.ordenarPorEdad();
        
        panel.actualizarTabla();
        
    }

    public InterfazPrincipal( PanelTablaPerros panel, PerroImplements implPerro, PanelDatosPerros panelDatos) throws HeadlessException {
        
        this.panel = panel;
        this.implPerro = implPerro;
        this.panelDatos = panelDatos;
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
    
    private void ingresarCards(){
        Perro perro=new Perro();
        perro = implPerro.mayorPuntaje();
        
        
        
        
        cardInformativas =new Cards("GANADOR",""+perro.getName() , ""+perro.getPuntos()+" pts - "+perro.getRaza());
        
        panelInformativo.AgregarCard(cardInformativas);
        
       
        
        perro = implPerro.menorPuntaje();
        cardInformativas =new Cards("PUNTAJE MENOR ",""+perro.getName().toUpperCase() , ""+perro.getPuntos()+" PTS - "+perro.getRaza().toUpperCase());
        panelInformativo.AgregarCard(cardInformativas);
        
        perro = implPerro.perroViejo();
        cardInformativas =new Cards("PERRO MAYOR ",""+perro.getName().toUpperCase() , ""+perro.getEdad()+" AÑOS - "+perro.getRaza().toUpperCase());
        panelInformativo.AgregarCard(cardInformativas);
        
        
        cardInformativas =new Cards("CANTIDAD DE PERROS ",""+String.valueOf(getCantidadPerros()) , " PERROS EN COMPETENCIA ");
        panelInformativo.AgregarCard(cardInformativas);
        
        System.out.println(""+perro.getName());
        
        
    }

    public int getCantidadPerros() {
        return cantidadPerros;
    }

    public void setCantidadPerros(int cantidadPerros) {
        this.cantidadPerros = cantidadPerros;
    }
    
    
        

    
    public static void main(String[] args) throws IOException {
        
        
        InterfazPrincipal i=new InterfazPrincipal();
        i.setVisible(true);
    }
    
}
