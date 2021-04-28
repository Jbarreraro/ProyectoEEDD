package logic;


public class ListaEnlazada<T> {

    private Nodo inicio;
    private Nodo fin;
    private int numeroElementos;

    public ListaEnlazada() {
        inicio = null;
        fin = null;
    }

    public boolean isEmpty() {
        return inicio == null;
    }
    
   
    public void pushBack(T elemento) {
        Nodo actual;
        if (isEmpty()) {
            actual = new Nodo(elemento);
            inicio = actual;
            fin = actual;
        } else {
            actual = new Nodo(elemento);
            fin.setSiguiente(actual);
            fin = actual;
        }
        numeroElementos++;
    }
    
        public Object get(int indice) {

        Nodo temporal;
        temporal = inicio;
        if (indice == 0) {
            return temporal.getDato();
        } else {
            for (int j = 0; j < indice; j++) {
                temporal = temporal.getSiguiente();
            }
        }
        return temporal.getDato();

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
            return false;
        }

        Nodo prev = null, temporal = inicio;

        while (temporal != null){
            if (temporal.getDato().equals(elemento)){
                if (temporal == inicio ){
                    inicio = inicio.getSiguiente();
                    numeroElementos--;
                    return true;
                }
                prev.setSiguiente(temporal.getSiguiente());
                numeroElementos--;
                return true;
            }else{
                prev = temporal;
                temporal = temporal.getSiguiente();
            }
        }

        return false;
    }
    
    public int getNumeroElementos(){
        return this.numeroElementos;
    }

}
