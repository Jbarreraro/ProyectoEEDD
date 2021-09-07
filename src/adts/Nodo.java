package adts;

import java.io.Serializable;


public class Nodo<T> implements Serializable{

    private Nodo siguiente;
    private T dato;

    public Nodo(T dato) {
        this.dato = dato;

    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

}
