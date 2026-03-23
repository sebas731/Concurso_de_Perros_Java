/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aplication.concursoCanino.Logica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Familia Mamani
 */
public class PerroImplements {
    
    private ArrayList<Perro> perros;

    public PerroImplements() {
        this.perros = new ArrayList<Perro>();
    }

    public ArrayList<Perro> getPerros() {
        return perros;
    }

    public void setPerros(ArrayList<Perro> perros) {
        this.perros = perros;
    }
    
   public Perro BuscarPerro(List<Perro> listPerros, String name){
       
       Perro p=new Perro();
       
       for (Perro perro : listPerros) {
           
           if (true) {
               p=perro;
               
               return p;
           }
           
       }
       
       
       
       return null;
   }
   
   public Perro BuscarPerroNombre(String name){
       this.perros.forEach(e -> System.out.println(e.getName()));
       Perro p=new Perro();
       
       for (Perro perro : perros) {
           
           if (perro.getName().equals(name)) {
               
               p = perro;
               return p ;
           }
           
       }
       
       
       
       return null;
   }
    
    
    
    
}
