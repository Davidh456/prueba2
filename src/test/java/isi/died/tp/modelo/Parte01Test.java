/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isi.died.tp.modelo;

import isi.died.tp.modelo.Libro;
import isi.died.tp.modelo.MaterialCapacitacion;
import isi.died.tp.modelo.Suscriptor;

/**
 *
 * @author mdominguez
 */
public class Parte01Test {
 
    public static void main(String[] args){
        MaterialCapacitacion material1 = new Libro("Java 1", 99.0, "23452345", 600);
        MaterialCapacitacion material2 = new Libro("Java 2", 78.0, "73453434", 400);
        MaterialCapacitacion material3 = new Libro("Java 3", 31.0, "62562344", 700);
        MaterialCapacitacion material4 = new Libro("Java 4", 233.0, "78930132", 1600);
        MaterialCapacitacion material5 = new Libro("Java 5", 150.0, "80341123", 520);
        
        System.out.println("=== Listar material disponible ===");
        System.out.println("libro "+material1.getTitulo()+ " - Precio: "+ material1.precio());
        System.out.println("libro "+material2.getTitulo()+ " - Precio: "+material2.precio());
        System.out.println("libro "+material3.getTitulo()+ " - Precio: "+material3.precio());
        System.out.println("libro "+material4.getTitulo()+ " - Precio: "+material4.precio());
        System.out.println("libro "+material5.getTitulo()+ " - Precio: "+material5.precio());
        
        Suscriptor suscriptor1 = new Suscriptor("martin");
        System.out.println("Crear un suscriptor: "+suscriptor1.toString());
        suscriptor1.agregar(material1);
        suscriptor1.setCredito(250.0);
        System.out.println("Disponible: "+suscriptor1.disponible());
        System.out.println("Agrega material 1");
        suscriptor1.agregar(material1);
        suscriptor1.listarSuscripciones();
        System.out.println("Disponible: "+suscriptor1.disponible());
        System.out.println("Agrega material 2");
        suscriptor1.agregar(material2);
        suscriptor1.listarSuscripciones();
        System.out.println("Disponible: "+suscriptor1.disponible());
        System.out.println("Agrega material 5");
        suscriptor1.agregar(material5);
        suscriptor1.listarSuscripciones();
        System.out.println("QUITAR material 1");
        suscriptor1.quitar(material1);
        suscriptor1.listarSuscripciones();
        System.out.println("Disponible: "+suscriptor1.disponible());
        System.out.println("Agrega material 5");
        suscriptor1.agregar(material5);
        suscriptor1.listarSuscripciones();
        System.out.println("Disponible: "+suscriptor1.disponible());
        suscriptor1.agregar(material3);
        // verificar que baja su precio y se puede agregar
        System.out.println("Material 3: "+material3.precio());
        System.out.println("Liquidar Material 3!! ");
        material3.liquidar();
        System.out.println("Material 3 luego de precio de liquidacion: "+material3.precio());
        suscriptor1.agregar(material3);
        suscriptor1.listarSuscripciones();        
        System.out.println("Disponible: "+suscriptor1.disponible());
        Suscriptor suscriptor2 = new Suscriptor("lucas");
        suscriptor2.setCredito(350.0);
        System.out.println("Material 2 antes de 2 suscripciones (acceso temprano): "+material2.precio()+ " suscripciones "+material2.suscripciones());
        suscriptor2.agregar(material2);
        System.out.println("Material 2 luego de 2 suscripciones: (lanzamiento) "+material2.precio()+ " suscripciones "+material2.suscripciones());
        
        MaterialCapacitacion material6 = new Video("PeliculaJava 1", 138, 0.32);
        MaterialCapacitacion material7 = new Video("PeliculaJava 2", 340, 0.80);
                System.out.println("=== Listar material disponible ===");
        System.out.println("Video "+material6.getTitulo()+ " - Precio: "+ material6.precio());
        System.out.println("Video "+material7.getTitulo()+ " - Precio: "+material7.precio());
        material7.liquidar();
        System.out.println("El Video "+material7.getTitulo()+ " tiene nuevo Precio: "+material7.precio());
        suscriptor2.agregar(material6);
        suscriptor2.agregar(material7);
    }
}
