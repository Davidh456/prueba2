/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isi.died.tp.modelo;

import isi.died.tp.ordenamiento.Ordenable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

/**
 *
 * @author mdominguez
 */
public abstract class MaterialCapacitacion implements Ordenable {
    protected String titulo;
    protected EstadoPromocion estado;
    protected Date fechaPublicacion;
    private Integer suscripciones;

    public MaterialCapacitacion() {
        this.suscripciones=0;
    }       

    public MaterialCapacitacion(String titulo) {
        this();
        this.titulo = titulo;
    } 
       
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }   
    
    
    protected Integer suscripciones(){
        return this.suscripciones;
    }
   
    public void publicar(){
        this.estado = EstadoPromocion.LANZAMIENTO;
        this.fechaPublicacion = new Date();
    }
    
    public void publicar(String fecha){
    try{
        DateFormat formato = new SimpleDateFormat(
        "dd/MM/yyyy");
        Date date = formato.parse(fecha);

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        Calendar calendar2 = new GregorianCalendar();
        
        if(calendar.get(Calendar.DAY_OF_YEAR)>calendar2.get(Calendar.DAY_OF_YEAR)-45){
            if(calendar.get(Calendar.DAY_OF_WEEK)!=Calendar.SATURDAY && calendar.get(Calendar.DAY_OF_WEEK)!=Calendar.SUNDAY){
                        this.fechaPublicacion = date;
            }
            else
                        this.fechaPublicacion = new Date();
        }
        else 
                    this.fechaPublicacion = new Date();
        }catch(ParseException ex){
            System.out.print("\nOcurrio un error de parseo de fechas\n");
        }
    }
    
    public void suscribir()
    {
        suscripciones++;
    }
    
    public void cancelarSuscripcion(){
        suscripciones--;
    }
    
    public abstract Double precio();

    public abstract void liquidar();

    
    @Override
    public boolean equals(Object o){
    if(this.titulo.equalsIgnoreCase(((MaterialCapacitacion)o).getTitulo()))
            return true;
    return false;
    }
    
    final String fechaPublicacion(){
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return df.format(fechaPublicacion);
    }
    
    @Override
    public Long valorOrdenamiento() {
        return Long.valueOf(numerarString(this.titulo)+""+formatoPrecio(this.precio()));
    }
    
    private Long formatoPrecio(Double precio){
        Long precioEntero = Math.round(precio);
        Long x = precioEntero%10000 ;
        Long formato = 10000+ x;
        return formato;
    }

    private Long numerarString(String arg){
        String origen = arg.toUpperCase();
        String resultado = "";
        char unChar;
        for(int i =0;i<4;i++){
            Integer aux;
            if(i>origen.length()-1) 
                aux = 37;
            else {
                unChar = origen.charAt(i);
                if(unChar>='A' && unChar <='Z'){ 
                    aux = unChar-54;}
                else{ aux = 38; }
            }
            resultado +=aux;
        }
        return Long.valueOf(resultado);
    }

   }
