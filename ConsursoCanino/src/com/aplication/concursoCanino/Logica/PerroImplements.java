/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aplication.concursoCanino.Logica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
   
    /**
     * Ordenar a los perros por raza y actualiza la lista.
    */
    public void ordenarPorRaza(){
       /*
       perros.sort(new Comparator<Perro>() {
           @Override
           public int compare(Perro p1, Perro p2) {
               System.out.println(""+p1.getRaza().compareToIgnoreCase(p2.getRaza()));
               return p1.getRaza().compareToIgnoreCase(p2.getRaza());
               
           }
       });
       */
       perros.sort((p1,p2)-> p1.getRaza().compareToIgnoreCase(p2.getRaza()));
        
        
    }
    
    public void ordenarPorEdad(){
       
       perros.sort((p1,p2)-> Integer.compare(p1.getEdad(), p2.getEdad()));
        
        
    }
    
    public void ordenarPorNombre(){
       
       perros.sort((p1,p2)-> p1.getName().compareToIgnoreCase(p2.getName()));
        
        
    }
    
    public void ordenarPorPuntos(){
        
        //Perro pTemp = new Perro();
       
        for (int i = perros.size(); i > 0; i--) {
            
            for (int j = 0; j <i-1; j++) {
                
                Perro p1 = perros.get(j);
                Perro p2 = perros.get(j+1);
                
                if (p1.getPuntos()< p2.getPuntos()) {
                    
                    perros.set(j, p2);
                    perros.set(j+1, p1);
                    
                }
                
                
            }
            
        }
        
        perros.forEach(e-> System.out.println(""+e.getPuntos()));
        
        
    }
    
    public Perro mayorPuntaje(){
        
        int puntajeMayor=0;
        Perro pMayor=new Perro();
        
        for (int i = 0; i < perros.size(); i++) {
            
            if (puntajeMayor < perros.get(i).getPuntos()) {
                puntajeMayor = perros.get(i).getPuntos();
                pMayor = perros.get(i);
            }
            
            
            
        }
        
        
        return pMayor;
    }
    
    public Perro menorPuntaje(){
        
        long puntajeMayor=1000;
        Perro pMenor=new Perro();
        
        for (int i = 0; i < perros.size(); i++) {
            
            if (puntajeMayor > perros.get(i).getPuntos()) {
                puntajeMayor = perros.get(i).getPuntos();
                pMenor = perros.get(i);
            }
            
            
            
        }
        
        
        return pMenor;
    }
    
    public Perro perroViejo(){
        
        int edadMayor=0;
        Perro pMayor=new Perro();
        
        for (int i = 0; i < perros.size(); i++) {
            
            if (edadMayor < perros.get(i).getEdad()) {
                edadMayor = perros.get(i).getEdad();
                pMayor = perros.get(i);
            }
            
            
            
        }
        
        
        return pMayor;
    }
    
    
    
}
