/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aplication.concursoCanino.interfaces;

import com.aplication.concursoCanino.Logica.Perro;
import com.aplication.concursoCanino.Logica.PerroImplements;
import com.sun.jdi.connect.ListeningConnector;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Familia Mamani
 */
public class PanelTablaPerros extends JPanel implements ActionListener {
    
    JTable listaTabla;
    DefaultTableModel m;
    InterfazPrincipal interfazP;
    
    //Botones valor
    
   
    
    private JRadioButton radioButtonOpcion1,radioButtonOpcion2,radioButtonOpcion3;
    
    //JTextField
    
    JTextField txtBuscar;
    
    //private Jbutton Eliminar
    private JButton btnEliminar;
    
    private JButton btnEditar;
    
    public PanelTablaPerros(InterfazPrincipal interfaz) {
        
        
        interfazP = interfaz;
        GridBagLayout gPrincipal=new GridBagLayout();
        
        this.setLayout(gPrincipal);
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
                BorderFactory.createEmptyBorder(10, 14, 10, 14)
        ));
        setPreferredSize(new Dimension(300,300));
        GridBagLayout gb=new GridBagLayout();
        JPanel panelTable=new JPanel();
        panelTable.setLayout(gb);
        GridBagConstraints gbs = new GridBagConstraints();
        gbs.insets = new Insets(5, 5, 5, 5);
        
        //TITULO
        gbs.gridx=0;
        gbs.gridy=0;
        gbs.weightx=1.0;
        //gbs.weighty=1.0;
        gbs.fill = GridBagConstraints.CENTER;
        JLabel lblTittle= new JLabel("lista de perros");
        add(lblTittle,gbs);
        
        //Buscador
        gbs.gridx=1;
        gbs.gridy=0;
        gbs.weightx=2.0;
        gbs.fill = GridBagConstraints.BOTH;
        txtBuscar = new JTextField("");
        add(txtBuscar,gbs);

        //PANEL CABECERA
        
        JPanel panelCabecera=new JPanel();
        panelCabecera.setLayout(new GridLayout(1, 3));
        
        
        //BUSCAR PERRO
        
        JButton btnBuscar=new JButton("Buscar");
        btnBuscar.setPreferredSize(new Dimension(80, 30));
        btnBuscar.addActionListener(this);
        
        gbs.gridx=2;
        gbs.gridy=0;
        gbs.weightx=0;
        gbs.fill = GridBagConstraints.NONE;
        add(btnBuscar,gbs);
        //gbs.gridwidth=2;
        //gbs.gridheight=4;
        
        
        
        gbs.gridx=0;
        gbs.gridy=1;
        gbs.gridwidth=3;
        
        gbs.weightx=1.0;
        gbs.weighty = 6.0;  
        gbs.fill = GridBagConstraints.BOTH;
        JPanel panelT=new JPanel(new BorderLayout());
        
        
        String array[]= {"Nombre","Edad","Raza","Puntos"};
        m=new DefaultTableModel(array,0);
        
        //m.setValueAt(array, 2, 2);
        listaTabla = new JTable(m);
        listaTabla.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) { // evita que se dispare dos veces
                    int fila = listaTabla.getSelectedRow();
                    if (fila != -1) {
                        String name;
                        name = String.valueOf(listaTabla.getValueAt(fila, 0));
                        interfazP.mostrarDatosPerro(name);
        }
    }
            
            }
        });
        
        JScrollPane scrollPane = new JScrollPane(listaTabla);
        //scrollPane.setBounds(20,40,250,250);
        //scrollPane.setPreferredSize(new Dimension(this.getPreferredSize().width -30,this.getPreferredSize().height -40 ));
        //scrollPane.setPreferredSize(new Dimension(250, 250));
        
        panelT.add(scrollPane,BorderLayout.CENTER);
        add(panelT,gbs);
        System.out.println(""+panelT.getPreferredSize());
        
        gbs.gridx=0;
        gbs.gridy=2;
        gbs.gridwidth=1;
        gbs.weightx=1.0;
        gbs.weighty = 0.05;  
        gbs.fill = GridBagConstraints.NONE;
        btnEditar = new JButton("Editar");
        add(btnEditar,gbs);
        
        
        gbs.gridx=1;
        gbs.gridy=2;
        gbs.gridwidth=1;
        gbs.weightx=1.0;
          
        gbs.fill = GridBagConstraints.CENTER;
        btnEliminar = new JButton("Eliminar");
       add(btnEliminar,gbs);
        
        
        System.out.println(""+this.getPreferredSize().width);
        actualizarTabla();
        
        
        
    }
    
    public int getIndexTable(){
        
        return listaTabla.getSelectedRow();
    }
    
     public void mostrarPerro(Perro p) {
        m.setRowCount(0);
        m.addRow(new Object[]{
            p.getName(),
            p.getEdad(),
            p.getRaza(),
            p.getPuntos()
        });
    }
     
    public void actualizarTabla(ArrayList<Perro> listaPerros){
        m.setRowCount(0);

        if (listaPerros != null) {
            for (Perro perro : listaPerros) {
                if (perro != null) { // protección contra posiciones nulas
                    Object[] fila = {
                        perro.getName(),
                        perro.getEdad(),  // o getPuntos() según tu clase Perro
                        perro.getRaza(),
                        perro.getPuntos()
                    };
                    m.addRow(fila);
                }
            }
        }
     
    }

    
    public void actualizarTabla(){
        m.setRowCount(0);

        if (interfazP.listaPerros != null) {
            for (Perro perro : interfazP.listaPerros) {
                if (perro != null) { // protección contra posiciones nulas
                    Object[] fila = {
                        perro.getName(),
                        perro.getEdad(),  // o getPuntos() según tu clase Perro
                        perro.getRaza(),
                        perro.getPuntos()
                    };
                    m.addRow(fila);
                }
            }
        }
        
        
        
    }
    
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
       
        interfazP.buscarPerro(txtBuscar.getText());
        
    }
    
    
    
    
    
        
            
    
    
    
    
}
