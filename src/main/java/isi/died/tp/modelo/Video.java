/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isi.died.tp.modelo;

import static isi.died.tp.modelo.EstadoPromocion.*;

/**
 *
 * @author st
 */
public class Video extends MaterialCapacitacion{
    private Double costoSeg;
    private Integer duracion;
    
    public Video() {
    }    
    
    public Video(String title, Integer durac,Double costo){
        titulo=title;
        costoSeg=costo;
        duracion=durac;
        estado=EstadoPromocion.REGULAR;
    }
    
    @Override
    public Double precio(){        
        switch(estado){
            case REGULAR:
                return costoSeg*duracion;
            case OFERTA:
                return costoSeg*duracion*0.50;
            default:
                return 0.0;
        }
    }
    @Override
    public void liquidar() {
                estado=EstadoPromocion.OFERTA;
    }
    
    @Override
    public boolean equals(Object o){
        if(o instanceof Video && super.equals(o)){
            return true;
        }
        return false;
    }
    
    @Override
    public void publicar(String fechaEspecifica){
        super.publicar(fechaEspecifica);
        this.estado = EstadoPromocion.REGULAR;
    }
}
