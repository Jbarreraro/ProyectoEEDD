package adts;


public class Nodo<T> {

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
