package logic;


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

    public boolean search(T elemento) {
        Nodo temporal;
        temporal = inicio;
        while (temporal != null) {
            if (temporal.getDato().equals(elemento)) {
                return true;
            }
            temporal = temporal.getSiguiente();
        }
        return false;
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

}
