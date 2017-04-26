/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isi.died.tp.modelo;

import isi.died.tp.ordenamiento.ArregloDied;
import isi.died.tp.ordenamiento.Ordenable;
import isi.died.tp.ordenamiento.OrdenadorService;
import java.util.ArrayList;

/**
 *
 * @author mdominguez
 */
public class Portal2 extends Portal {
    private ArrayList<MaterialCapacitacion> lista;        
    
    public Portal2(){
        lista=new ArrayList<MaterialCapacitacion>();
    }
    
    public void agregar(MaterialCapacitacion m){
        this.lista.add(m);
        super.agregarMaterial(lista.size()-1, m);
    }       
    
    public ArrayList<MaterialCapacitacion> listar(){
        return lista;
    }    
}
