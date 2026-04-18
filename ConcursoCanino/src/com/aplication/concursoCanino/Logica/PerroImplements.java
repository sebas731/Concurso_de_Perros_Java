/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aplication.concursoCanino.Logica;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author Familia Mamani
 */
public class PerroImplements {

    private ArrayList<Perro> perros;

    private int cantidadPerros;

    private FileInputStream fis;

    private Properties propiedad;

    public PerroImplements() {
        this.perros = new ArrayList<Perro>();
        cargar();
    }

    public ArrayList<Perro> getPerros() {
        return perros;
    }

    public void setPerros(ArrayList<Perro> perros) {
        this.perros = perros;
    }

    public int indexPerro(String name) {
        for (int i = 0; i < perros.size(); i++) {

            if (perros.get(i).getName().equals(name)) {

                return i;

            }
        }
        return -1;
    }

    public Perro BuscarPerroNombre(String name) {
        //this.perros.forEach(e -> System.out.println(e.getName()));
        Perro p = new Perro();

        for (Perro perro : perros) {

            if (perro.getName().equalsIgnoreCase(name)) {

                p = perro;
                return p;
            }

        }

        return null;
    }

    /**
     * Ordenar a los perros por raza y actualiza la lista.
     */
    public void ordenarPorRaza() {
        
        perros.sort((p1, p2) -> p1.getRaza().compareToIgnoreCase(p2.getRaza()));

    }

    public void ordenarPorEdad() {

        perros.sort((p1, p2) -> Integer.compare(p1.getEdad(), p2.getEdad()));

    }

    public void ordenarPorNombre() {

        perros.sort((p1, p2) -> p1.getName().compareToIgnoreCase(p2.getName()));

    }

    public void ordenarPorPuntos() {

        
        for (int i = perros.size(); i > 0; i--) {

            for (int j = 0; j < i - 1; j++) {

                Perro p1 = perros.get(j);
                Perro p2 = perros.get(j + 1);

                if (p1.getPuntos() < p2.getPuntos()) {

                    perros.set(j, p2);
                    perros.set(j + 1, p1);

                }

            }

        }

    }

    public Perro mayorPuntaje() {

        int puntajeMayor = 0;
        Perro pMayor = new Perro();

        for (int i = 0; i < perros.size(); i++) {

            if (puntajeMayor < perros.get(i).getPuntos()) {
                puntajeMayor = perros.get(i).getPuntos();
                pMayor = perros.get(i);
            }

        }

        return pMayor;
    }

    public Perro menorPuntaje() {

        int puntajeMayor = 1000;
        Perro pMenor = new Perro();

        for (int i = 0; i < perros.size(); i++) {

            if (puntajeMayor > perros.get(i).getPuntos()) {
                puntajeMayor = perros.get(i).getPuntos();
                pMenor = perros.get(i);
            }

        }

        return pMenor;
    }

    public Perro perroViejo() {

        int edadMayor = 0;
        Perro pMayor = new Perro();

        for (int i = 0; i < perros.size(); i++) {

            if (edadMayor < perros.get(i).getEdad()) {
                edadMayor = perros.get(i).getEdad();
                pMayor = perros.get(i);
            }

        }

        return pMayor;
    }

    //cargar datos
    private void cargar() {

        try {

            fis = new FileInputStream(new File("./data/perros.txt"));

            propiedad = new Properties();

            propiedad.load(fis);

            String nombre;
            String raza;
            String image;
            int puntos;
            int edad;
            int cantidad = Integer.valueOf(propiedad.getProperty("total.perros"));
            int index;
            setCantidadPerros(cantidad);
            //lista = new Perro[cantidad];
            for (int i = 0; i < cantidad; i++) {

                String para = "perro" + (i + 1);

                nombre = propiedad.getProperty(para + ".nombre");
                raza = propiedad.getProperty(para + ".raza");
                image = propiedad.getProperty(para + ".imagen");
                puntos = Integer.valueOf(propiedad.getProperty(para + ".puntos"));
                edad = Integer.valueOf(propiedad.getProperty(para + ".edad"));
                index = i + 1;
                Perro p = new Perro(nombre, raza, image, puntos, edad, index);
                perros.add(p);
            }

        } catch (FileNotFoundException e) {
            System.out.println("" + e.getLocalizedMessage());
        } catch (IOException e) {
            System.out.println("" + e.getMessage());
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }

            } catch (IOException e) {
                System.out.println("" + e.getMessage());
            }

        }

    }

    public int getCantidadPerros() {
        return cantidadPerros;
    }

    public void setCantidadPerros(int cantidadPerros) {
        this.cantidadPerros = cantidadPerros;
    }

    public void insertarPerro(Perro p) {

        try {
            perros.add(p);
            fis = new FileInputStream(new File("./data/perros.txt"));
            propiedad.load(fis);
            setCantidadPerros(cantidadPerros + 1);
            int nuevoTotal = getCantidadPerros();
            propiedad.setProperty("total.perros", String.valueOf(nuevoTotal));
            propiedad.setProperty("perro" + nuevoTotal + ".nombre", p.getName());
            propiedad.setProperty("perro" + nuevoTotal + ".raza", p.getRaza());
            propiedad.setProperty("perro" + nuevoTotal + ".imagen", p.getImagen());
            propiedad.setProperty("perro" + nuevoTotal + ".puntos", String.valueOf(p.getPuntos()));
            propiedad.setProperty("perro" + nuevoTotal + ".edad", String.valueOf(p.getEdad()));

            propiedad.store(new FileOutputStream(new File("./data/perros.txt")), "perros");
        } catch (IOException e) {

            System.out.println("" + e.getMessage());
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }

            } catch (IOException e) {
                System.out.println("" + e.getMessage());
            }
        }

    }

    public void editarPerro(String name, Perro p) {
        //posicion del perro en el arraylist
        int index = indexPerro(name);
        perros.set(index, p);

        try {
            fis = new FileInputStream(new File("./data/perros.txt"));
            propiedad.load(fis);
            propiedad.setProperty("perro" + p.getIndex() + ".nombre", p.getName());
            propiedad.setProperty("perro" + p.getIndex() + ".raza", p.getRaza());
            propiedad.setProperty("perro" + p.getIndex() + ".imagen", p.getImagen());
            propiedad.setProperty("perro" + p.getIndex() + ".puntos", String.valueOf(p.getPuntos()));
            propiedad.setProperty("perro" + p.getIndex() + ".edad", String.valueOf(p.getEdad()));

            propiedad.store(new FileOutputStream(new File("./data/perros.txt")), "perros");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }

            } catch (IOException e) {
                System.out.println("" + e.getMessage());
            }
        }

    }

    public void eliminarPerro(Perro p) {
        int pos = perros.indexOf(p);
        perros.remove(pos);

        //Eliminar del registro
        try {
            fis = new FileInputStream(new File("./data/perros.txt"));
            Properties props = new Properties();
            props.load(fis);

            int total = Integer.parseInt(props.getProperty("total.perros"));

            for (int i = 1; i <= total; i++) {
                props.remove("perro" + i + ".nombre");
                props.remove("perro" + i + ".raza");
                props.remove("perro" + i + ".imagen");
                props.remove("perro" + i + ".puntos");
                props.remove("perro" + i + ".edad");

            }

            // 5. Reescribir desde el ArrayList actualizado
            int nuevoTotal = perros.size();
            

            for (int i = 0; i < nuevoTotal; i++) {
                props.setProperty("perro" + (i + 1) + ".nombre", perros.get(i).getName());
                props.setProperty("perro" + (i + 1) + ".raza", perros.get(i).getRaza());
                props.setProperty("perro" + (i + 1) + ".imagen", perros.get(i).getImagen());
                props.setProperty("perro" + (i + 1) + ".puntos", String.valueOf(perros.get(i).getPuntos()));
                props.setProperty("perro" + (i + 1) + ".edad", String.valueOf(perros.get(i).getEdad()));

            }

            try (FileOutputStream fos = new FileOutputStream(new File("./data/perros.txt"));) {
                props.store(fos, "perros");
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                fis.close();

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

    }

}
