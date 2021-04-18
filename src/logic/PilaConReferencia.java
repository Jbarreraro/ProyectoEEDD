package logic;

public class PilaConReferencia<T> {

    private class Nodo<T> {

        //Atributos Clase Nodo
        private T dato;
        private Nodo<T> siguiente;

        //Constructor 
        public Nodo(T dato) {
            this.dato = dato;
            siguiente = null;
        }

    }

    //Atributos de una PilaConReferencia
    private Nodo<T> cabeza;
    
    
    //Constructor PilaConReferencia
    public PilaConReferencia() {
        cabeza = null;
    }
    
    //Metodo para comprobar si la pila esta vacia
    public boolean estaVacio() {
        return cabeza == null;
    }

   
    //Metodo para apilar un elemento a la pila
    public void apilar(T elemento){
        Nodo<T> nuevoNodo = new Nodo<T>(elemento);
        nuevoNodo.siguiente = this.cabeza;
        cabeza = nuevoNodo;
    }
    
    //Metodo para desapilar un elemento de la pila
    public T desapilar(){
        T elemento = null;
        if ( !estaVacio() ){
            elemento = cabeza.dato;
            cabeza = cabeza.siguiente;
        }
        return elemento;
    }
    
        
}
