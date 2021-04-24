package logic;
import data.Animal;


public class Nodo{
    private Nodo siguiente;
    private Animal dato;

    public Nodo(Animal dato, Nodo siguiente){
        this.siguiente = siguiente;
        this.dato = dato;

    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Animal getDato() {
        return dato;
    }

    public void setDato(Animal dato) {
        this.dato = dato;
    }



}
