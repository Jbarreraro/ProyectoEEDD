/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

/**
 *
 * @author sanch
 */
import javax.sound.midi.SysexMessage;
import javax.swing.*;


public class ListaEnlazada<T> {

    private Nodo inicio;
    private Nodo fin;

    public ListaEnlazada() {
        inicio = null;
        fin = null;
    }

    public boolean estaVacio() {
        return inicio == null;
    }

    public void pushBack(T elemento) {
        Nodo actual;
        if (estaVacio()) {
            actual = new Nodo(elemento);
            inicio = actual;
            fin = actual;
        } else {
            actual = new Nodo(elemento);
            fin.setSiguiente(actual);
            fin = actual;
        }
    }

    public void imprimir() {
        if (estaVacio()) {
            System.out.println("La Lista esta vacia");
        } else {
            Nodo temporal;
            temporal = inicio;
            while (temporal != null) {
                System.out.print(temporal.getDato() + " ");
                temporal = temporal.getSiguiente();
            }
        }

    }

    public Object Obtener(int i) {
        
        Nodo temporal;
        temporal = inicio;
        if(i==0){
          return temporal.getDato();  
        }else{
         for(int j=0 ;j<i; j++) {
          temporal = temporal.getSiguiente();  
        }   
        }
        return temporal.getDato();
   
    }

    public boolean remove(T elemento) {

        if (estaVacio()) {
            return false;
        }

        Nodo prev = null, temporal = inicio;

        while (temporal != null){
            if (temporal.getDato().equals(elemento)){
                if (temporal == inicio ){
                    inicio = inicio.getSiguiente();
                    return true;
                }
                prev.setSiguiente(temporal.getSiguiente());
                return true;
            }else{
                prev = temporal;
                temporal = temporal.getSiguiente();
            }
        }

        return false;
    }
     public int tamaño() {
         int size=1;
         Nodo temporal;
         temporal = inicio;
            while (temporal != null) {
                
                System.out.print(temporal.getDato() + " ");
                temporal = temporal.getSiguiente();
                size=size+1;
            }
            return size;
     }    

}
