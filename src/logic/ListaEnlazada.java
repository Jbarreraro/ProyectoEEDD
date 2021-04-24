package logic;
import data.Animal;
import logic.Nodo;

import javax.sound.midi.SysexMessage;

public class ListaEnlazada {
    private Nodo inicio;
    private Nodo fin;

    public ListaEnlazada(){
        inicio = null;
        fin = null;
    }
    public boolean estaVacia(){
        if(inicio == null){
            return true;
        }else{
            return false;
        }
    }
    public void agregar(Animal animal){
        Nodo actual;
        if(estaVacia()){
            actual = new Nodo(animal,null);
            inicio = actual;
            fin = actual;
        }else{
            actual = new Nodo(animal,null);
            fin.setSiguiente(actual);
            fin = actual;
        }
    }
    public void mostar(){
        if(estaVacia()){
            System.out.println("La Lista esta vacia");
        }else{
            Nodo temporal;
            temporal = inicio;
            while (temporal != null){
                System.out.println(temporal.getDato());
                temporal = temporal.getSiguiente();
            }
        }

    }

}
