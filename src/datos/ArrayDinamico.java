/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

/**
 *
 * @author sanch
 */
public class ArrayDinamico<T> {

    private int numeroElementos, capacidad;

 
    private T array[];

    //Constructor 
    public ArrayDinamico(int capacidad) {
        this.capacidad = capacidad;
        this.array = (T[]) new Object[capacidad];
    }

    public ArrayDinamico() {
        //Por defecto la capacidad es de 16 elementos
        this(16);
    }
      public boolean isEmpty() {
        return array[0] == null;
    }
    //Metodo para acceder a un elemento del arreglo dinamico dado un indice
    //retorna null si el indice es incorrecto
    public T get(int indice) {
        if (indice < 0 || indice >= capacidad) {
            System.out.println("Ha introducido un indice incorrecto");
            return null;
        }
        return array[indice];
    }

    //Metodo para insertar un elemento del arregl0 dinamico dado un indice
    public void set(int indice, T elemento) {
        if (indice < 0 || indice >= capacidad) {
            System.out.println("Ha introducido un indice incorrecto");
        } else {
            if (array[indice] == null) {
                numeroElementos++;
            }
            array[indice] = elemento;
        }
    }

    //Insertar un elemento al final del arreglo dinamico
    public void pushBack(T elemento) {
        if (numeroElementos == capacidad) {
            //Debemos duplicar el tamaño de nuestro arreglo
            //Creamos un nuevo arreglo con la doble capacidad
            T newArray[] = (T[]) new Object[2 * capacidad];
            //Copiar los elementos al nuevo array
            for (int i = 0; i < capacidad; i++) {
                newArray[i] = array[i];
            }
            //El puntero array apunta al nuevoArray redimensionado
            array = newArray;
            //Duplicamos la capacidad 
            capacidad = 2 * capacidad;
        }
        array[numeroElementos] = elemento;
        numeroElementos++;

    }

    //Eliminar un elemento del arreglo dinamico dado un indice
    public boolean remove(int indice) {
        if (indice < 0 || indice >= capacidad) {
            System.out.println("Ha introducido un indice incorrecto");
            return false;
        } else {
            for (int i = indice; i <= numeroElementos - 2; i++) {
                array[i] = array[i + 1];
            }
            //Como se eliminó un elemento debemos restar el numeroElementos
            numeroElementos--;
            return true;
        }
    }

    //Metodo para buscar un elemento en la lista
    public boolean search(T elemento) {

        for (int i = 0; i < numeroElementos; i++) {
            if (array[i].equals(elemento)) {
                return true;
            }
        }
        return false;
    }

    //Metodo para iprimir la lista
    public void imprimir() {
        for (int i = 0; i < numeroElementos; i++) {
            System.out.println(array[i]);
        }
    }
   public int getNumeroElementos() {
        return numeroElementos;
    }

    public int getCapacidad() {
        return capacidad;
    }
}