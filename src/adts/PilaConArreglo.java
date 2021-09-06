package adts;

public class PilaConArreglo<T> implements Pila<T> {

    //Atributos de una PilaConArreglo
    private int tamaño, cabeza;
    private T[] arreglo;

    //Constructor 
    public PilaConArreglo(int tamaño) {
        this.tamaño = tamaño;
        arreglo = (T[]) new Object[tamaño];
    }

    //Metodo para saber si la pila esta vacia
    @Override
    public boolean isEmpty() {
        return cabeza == 0;
    }

    //Metodo para saber si la pila esta llena
    public boolean estaLleno() {
        return cabeza == tamaño;
    }

    //Metodo para apilar un elemento de la pila
    @Override
    public void push(T elemento) {
        if (estaLleno()) {
            System.out.println("La pila esta llena");
        } else {
            arreglo[cabeza] = elemento;
            cabeza++;
        }
    }

    //Metodo para desapilar un elemento de la pila
    @Override
    public T pop() {
        if (isEmpty()) {
            System.out.println("La pila esta vacia");
            return null;
        }
        cabeza--;
        return arreglo[cabeza];
    }
}
