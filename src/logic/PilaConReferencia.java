package logic;

public class PilaConReferencia<T> implements Pila<T>{

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
    @Override
    public boolean isEmpty() {
        return cabeza == null;
    }

   
    //Metodo para apilar un elemento a la pila
    @Override
    public void push(T elemento){
        Nodo<T> nuevoNodo = new Nodo<T>(elemento);
        nuevoNodo.siguiente = this.cabeza;
        cabeza = nuevoNodo;
    }
    
    //Metodo para desapilar un elemento de la pila
    @Override
    public T pop(){
        T elemento = null;
        if ( !isEmpty() ){
            elemento = cabeza.dato;
            cabeza = cabeza.siguiente;
        }else{
            System.out.println("La pila esta vacia");
        }
        return elemento;
    }
    
        
}
