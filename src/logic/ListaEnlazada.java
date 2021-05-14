package logic;

public class ListaEnlazada<T> {

    private Nodo<T> inicio;
    private Nodo<T> fin;
    private int numeroElementos;

    public ListaEnlazada() {
        inicio = null;
        fin = null;
    }

    public boolean isEmpty() {
        return inicio == null;
    }

    public void pushBack(T elemento) {
        Nodo newNodo;
        if (isEmpty()) {
            newNodo = new Nodo(elemento);
            inicio = newNodo;
            fin = newNodo;
        } else {
            newNodo = new Nodo(elemento);
            fin.setSiguiente(newNodo);
            fin = newNodo;
        }
        numeroElementos++;
    }

    public void pushFront(T elemento) {
        Nodo<T> newNodo = new Nodo<>(elemento);
        newNodo.setSiguiente(inicio);
        inicio = newNodo;
        if (fin == null) {
            fin = inicio;
        }
        numeroElementos++;
    }

    public T get(int indice) {
        if (isEmpty() || indice < 0) {
            return null;
        }
        Nodo<T> temporal;
        temporal = inicio;
        if (indice == 0) {
            return inicio.getDato();
        } else {
            for (int j = 0; j < indice; j++) {
                temporal = temporal.getSiguiente();
            }
        }
        return temporal.getDato();

    }

    public T topFront() {
        return isEmpty() ? null : inicio.getDato();
    }

    public void imprimir() {
        if (isEmpty()) {
            System.out.println("La Lista esta vacia");
        } else {
            Nodo temporal;
            temporal = inicio;
            while (temporal != null) {
                System.out.print(temporal.getDato() + " ");
                temporal = temporal.getSiguiente();
            }
            System.out.println("");
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

        if (isEmpty()) {
            System.out.println("No hay elementos en la lista");
            return false;
        }

        Nodo<T> prev = null, temporal = inicio;

        while (temporal != null) {
            if (temporal.getDato().equals(elemento)) {
                if (temporal == inicio) {
                    inicio = inicio.getSiguiente();
                    numeroElementos--;
                    return true;
                }
                prev.setSiguiente(temporal.getSiguiente());
                numeroElementos--;
                return true;
            } else {
                prev = temporal;
                temporal = temporal.getSiguiente();
            }
        }

        return false;
    }

    public T popFront() {
        T r = null;
        if (!isEmpty()) {
            r = inicio.getDato();
            inicio = inicio.getSiguiente();
            if (inicio == null) {
                fin = null;
            }
            numeroElementos--;
        }
        return r;
    }

    public int getNumeroElementos() {
        return this.numeroElementos;
    }

}
