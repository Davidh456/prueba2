/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isi.died.tp.ordenamiento;

/**
 *
 * @author mdominguez
 */
public class OrdenarMergeSort extends OrdenadorService{

    @Override
    public ArregloDied ordenar(ArregloDied arreglo) {
        int inicio=0, fin=arreglo.tamanio()-1;
        arregloOrdenado = arreglo.clonar();
        arregloOrdenado.inicializarContadores();
        return guia(arregloOrdenado,inicio, fin);
    }
    
    public ArregloDied guia(ArregloDied arr,int ini, int fin){
        int centro;
        Long[] temp3= new Long[10];
        Long[] temp2= new Long[10];
        Long[] temp= new Long[10];
        if (ini<fin)
        {
            centro = (ini+fin)/2;
            guia(arr,ini,centro);
            for(int i=0;i<fin;i++){
                temp2[i]=arr.get(i).valorOrdenamiento();
            }
            guia(arr,centro+1, fin);
            for(int i=0;i<fin;i++){
                temp3[i]=arr.get(i).valorOrdenamiento();
            }
            arr= merge(arr, ini, centro, fin);
        }
//        for (int i=0; i<arr.tamanio();i++)
//            temp[i]=arr.get(i).valorOrdenamiento();
        return arr;
    }    

    private ArregloDied merge(ArregloDied arr, int ini, int centro, int fin) {
        ArregloDied temp= new ArregloDied(arr.tamanio());
        Long temp2;
        Long temp3;
        int i,d,f;
        i=f=ini;
        d=centro+1;
        while (i<=centro && d<=fin){
                temp2=arr.get(d).valorOrdenamiento();
                temp3=arr.get(i).valorOrdenamiento();
            if(arr.mayorIgual(d, i)){
                temp.agregarEnPosicion(f, arr.get(i));
                f++;
                i++;
            }
            else{
                temp.agregarEnPosicion(f, arr.get(d));
                f++;
                d++;
            }}
        while(i<=centro){
            temp.agregarEnPosicion(f, arr.get(i));
            i++;
            f++;
        }
        while(d<=fin){
            temp.agregarEnPosicion(f, arr.get(d));
            d++;
            f++;
        }
        return temp;
       // System.arraycopy(temp,ini,arr,ini,fin-ini+1);

//        
//        for(int m=0; m<fin-ini+1;m++)
//        {
//            arr.agregarEnPosicion(fin, temp.get(fin));
//            fin--;
//        }
//        return arr;

        /*
        int i,k, z;
        k=medio+1;
        //bucle para la mezcla, utiliza tmp[] como array auxiliar
        while (i<=medio && k<=drcha)
        {
            if(a[i]<=a[k])
                tmp[z++]=a[i++];
            else 
                tmp[z++]=a[k++];
        }
        //se mueven elementos no mezclados de sublistas
        while(i<=medio)
            tmp[z++]= a[i++];
        while(k<=drcha)
        tmp[z++] = a [k++];
        //copia de elementos de tmp[] al array a[]
        System.arraycopy(tmp,izda,a,izda,drcha=izda+1);
        */
    }
}
