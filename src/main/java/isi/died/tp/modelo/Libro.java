/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isi.died.tp.modelo;

import static isi.died.tp.modelo.EstadoPromocion.*;
import java.util.Date;

/**
 *
 * @author mdominguez
 */
public class Libro extends MaterialCapacitacion{
    private Double costo;
    private String isbn;
    private Integer paginas;
    
    public Libro() {
    }    
    
    public Libro(String title, Double cost, String c_isbn, Integer pages){
        titulo=title;
        costo=cost;
        isbn=c_isbn;
        paginas=pages;
        estado=EstadoPromocion.ACCESO_TEMPRANO;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    public Date getFechaPublicacion(){
        return this.fechaPublicacion;
    }
        
    public void publicar(Date fechaEspecifica){
        this.estado = EstadoPromocion.LANZAMIENTO;
        this.fechaPublicacion = fechaEspecifica;
    }
    
    @Override
    public void publicar(String fechaEspecifica){
        super.publicar(fechaEspecifica);
        this.estado = EstadoPromocion.LANZAMIENTO;
    }
    
    @Override
    public Double precio(){        
        switch(estado){
            case REGULAR:
                return costo + 0.03*((int)(paginas/150))*costo;
            case ACCESO_TEMPRANO:
                return  0.9*(costo + 0.03*((int)(paginas/150))*costo);
            case LANZAMIENTO:
                return 1.2*(costo + 0.03*((int)(paginas/150))*costo);
            case OFERTA:
                return costo*0.8;
        }
        return 0.0;       
    }
          
    @Override
    public void liquidar() {
                estado=EstadoPromocion.OFERTA;
    }

    @Override
    public void suscribir(){
        
        super.suscribir();
        if(suscripciones()>=2)
        {
            estado=EstadoPromocion.REGULAR;
        }
    }
    
    @Override
    public boolean equals(Object o){
        if(o instanceof Libro && super.equals(o)){
            return true;
        }
        return false;
    }
}