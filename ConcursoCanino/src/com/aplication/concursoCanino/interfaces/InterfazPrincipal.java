/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.aplication.concursoCanino.interfaces;

import com.aplication.concursoCanino.Logica.Perro;
import com.aplication.concursoCanino.Logica.PerroImplements;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author Familia Mamani
 */
public class InterfazPrincipal extends JFrame{
    

    
    private ArrayList<Perro> listaPerros=new ArrayList<Perro>(); 
    
    private PanelTablaPerros panel;
    private PerroImplements implPerro;
    private PanelDatosPerros panelDatos;
    private PanelBotonesOrdenamientos panelOrdenamiento;
    private PanelFormulario panelForm;
    private int cantidadPerros;
    
    
    //cards de datos
    private PanelCardsInformativas panelInformativo;
    private Cards cardInformativas;
    private Cards cardGanador;
    private Cards cardPerroViejo;
    private Cards cardMenorPuntaje;
    
    public InterfazPrincipal(){
        
       // cargar();
        
        implPerro=new PerroImplements();
        
        listaPerros = implPerro.getPerros();
        setCantidadPerros(listaPerros.size());
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
        panelForm = new PanelFormulario(this);
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
   
    public void editarPerro(String name){
        
        Perro p = implPerro.BuscarPerroNombre(name);
        
        JSpinner txtEdad, txtPuntos;
        JDialog jDialog = new JDialog(this,true);
        jDialog.setTitle("Editar Perro");
        jDialog.setLayout(new GridLayout(7, 2));
        jDialog.add(new JLabel("Nombre :"));
        JTextField txtNombre = new JTextField(p.getName());
        jDialog.add(txtNombre);
        jDialog.add(new JLabel("Raza :"));
        JTextField txtRaza = new JTextField(p.getRaza());
        jDialog.add(txtRaza);
        jDialog.add(new JLabel("Edad :"));
        txtEdad = new JSpinner(new SpinnerNumberModel(1, 0, 30, 1));
        txtEdad.setValue(p.getEdad());
        jDialog.add(txtEdad);
        jDialog.add(new JLabel("Puntos :"));
        txtPuntos = new JSpinner(new SpinnerNumberModel(1, 0, 30, 1));
        txtPuntos.setValue(p.getPuntos());
        jDialog.add(txtPuntos);
        jDialog.add(new JLabel("Imagen :"));
        jDialog.add(new JLabel(""));
        JTextField txtImg = new JTextField(p.getImagen());
        jDialog.add(txtImg);
        JButton btnEditarImg=new JButton("Editar");
        btnEditarImg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser=new JFileChooser();
                int n = fileChooser.showOpenDialog(panel);
                if (n==JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                String ruta=file.getAbsolutePath();
                int index= ruta.indexOf("data");
                
                txtImg.setText("./"+ruta.substring(index));
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Ningun archivo seleccionado");
                }
                
            }
        });
        jDialog.add(btnEditarImg);
        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = txtNombre.getText();
                String Raza = txtRaza.getText();
                int Edad = (int) txtEdad.getValue();
                int Puntos = (int) txtPuntos.getValue();
                String imgFile = txtImg.getText();
                int index = p.getIndex();
                Perro nuevoP=new Perro(name,Raza,imgFile,Puntos,Edad,index);
                implPerro.editarPerro(p.getName(),nuevoP);
                actualizarCards();
                jDialog.dispose();
            }
        });
        jDialog.add(btnAceptar);
        
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jDialog.dispose();
            }
        });
        jDialog.add(btnCancelar);
        jDialog.pack();
        jDialog.setLocationRelativeTo(this);
        jDialog.setVisible(true);
    }
    
    public void actualizarCards(){
        Perro perro;
        perro = implPerro.mayorPuntaje();
        
        cardGanador.actualizar("GANADOR",""+perro.getName() , ""+perro.getPuntos()+" pts - "+perro.getRaza());
        
        perro = implPerro.menorPuntaje();
        cardMenorPuntaje.actualizar("PUNTAJE MENOR ",""+perro.getName().toUpperCase() , ""+perro.getPuntos()+" PTS - "+perro.getRaza().toUpperCase());
        
        
        perro = implPerro.perroViejo();
        cardPerroViejo.actualizar("PERRO MAYOR ",""+perro.getName().toUpperCase() , ""+perro.getEdad()+" AÑOS - "+perro.getRaza().toUpperCase());
       
        
        
        cardInformativas.actualizar("CANTIDAD DE PERROS ",""+String.valueOf(getCantidadPerros()) , " PERROS EN COMPETENCIA ");

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
    
    
    public void buscarPerro(String nombre){
        Perro p = implPerro.BuscarPerroNombre(nombre);
        
        if (p!=null) {
            Object[] fila = {
                p.getName(),
                p.getEdad(),
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
        
        
        cardGanador =new Cards("GANADOR",""+perro.getName() , ""+perro.getPuntos()+" pts - "+perro.getRaza());
        
        panelInformativo.agregarCard(cardGanador);
        
       
        
        perro = implPerro.menorPuntaje();
        cardMenorPuntaje =new Cards("PUNTAJE MENOR ",""+perro.getName().toUpperCase() , ""+perro.getPuntos()+" PTS - "+perro.getRaza().toUpperCase());
        panelInformativo.agregarCard(cardMenorPuntaje);
        
        perro = implPerro.perroViejo();
        cardPerroViejo =new Cards("PERRO MAYOR ",""+perro.getName().toUpperCase() , ""+perro.getEdad()+" AÑOS - "+perro.getRaza().toUpperCase());
        panelInformativo.agregarCard(cardPerroViejo);
        
        
        cardInformativas =new Cards("CANTIDAD DE PERROS ",""+String.valueOf(getCantidadPerros()) , " PERROS EN COMPETENCIA ");
        panelInformativo.agregarCard(cardInformativas);
         
        
    }

    public int getCantidadPerros() {
        return cantidadPerros;
    }

    public void setCantidadPerros(int cantidadPerros) {
        this.cantidadPerros = cantidadPerros;
    }

    public static void main(String[] args) {
        
        
        InterfazPrincipal i=new InterfazPrincipal();
        i.setVisible(true);
    }

    public void agregarPerro(Perro p) {
        
        implPerro.insertarPerro(p);
        setCantidadPerros(implPerro.getPerros().size());
        panel.actualizarTabla();
        
    }

    public void mostrarDatosPerro(String name) {
        Perro p;
        p = implPerro.BuscarPerroNombre(name);
        panelDatos.cargarDatos(p);
    
    }
     public void eliminarPerro(String name){
        Perro p = implPerro.BuscarPerroNombre(name);
        if (p != null) {
            implPerro.eliminarPerro(p);
            setCantidadPerros(implPerro.getPerros().size());
            actualizarCards();
        }else{
            JOptionPane.showMessageDialog(this, "PERRO NO ENCONTRADO");
        }
        
    }

    public ArrayList<Perro> getListaPerros() {
        return listaPerros;
    }

    public void setListaPerros(ArrayList<Perro> listaPerros) {
        this.listaPerros = listaPerros;
    }
     
    
    
    
}
