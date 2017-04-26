/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isi.died.tp.ordenamiento;

import java.util.ArrayList;

/**
 *
 * @author mdominguez
 */
public class OrdenarRadix extends OrdenadorService{

    @Override
    public ArregloDied ordenar(ArregloDied arrDesordenado) {
        arregloOrdenado = arrDesordenado.clonar();
        arregloOrdenado.inicializarContadores();
        int ndig =0;
        int posicion = 0;       
        double ledigito = 10;
        ArrayList[] urnas = new ArrayList[10];
        for (int i=0; i<arregloOrdenado.tamanio();i++)
            if (ndig < arregloOrdenado.get(i).valorOrdenamiento().toString().length())
                ndig= arregloOrdenado.get(i).valorOrdenamiento().toString().length();
        for(int i=0; i<10;i++)                                                  // se crea las urnas
            urnas[i]=new ArrayList<>();
        for(int i=0;i<ndig;i++){                                                // avanzar en digitos
            for(int j=0; j<arregloOrdenado.tamanio();j++)                       // recorrer distintos registros
                urnas[(int)((arregloOrdenado.get(j).valorOrdenamiento()%ledigito)/(ledigito/10))].add(arregloOrdenado.get(j));                        
                                                                                        // pongo en urna ^
            for(int j=0; j<10;j++){                                             // recorrer urnas
                for(int k=0; k<urnas[j].size(); k++){                           // por cada urna tomar los elementos en orden                                   
                    arregloOrdenado.agregarEnPosicion(posicion, (Ordenable)urnas[j].get(k));  // y reubicar en el arreglo ordenado (concatenando urnas)
                    posicion++;
                }
                urnas[j].clear();                                               // limpiando urnas recorridas
            }
            posicion=0;
            ledigito=Math.pow(10, i+2);
        }
        return arregloOrdenado;
    }
}
