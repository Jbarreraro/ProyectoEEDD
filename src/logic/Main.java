package logic;

import data.Serializando;
import java.io.ObjectInputStream;

public class Main {

    public static void main(String[] args) {
        
        

    }

    public static void almacenarDatosArrayDinamico(String nombreArchivo, ArrayDinamico<Object> arr) {

        try {
            ObjectInputStream leyendoFichero = Serializando.leerFichero(nombreArchivo);
            // Se lee el primer objeto
            Object aux = leyendoFichero.readObject();

            // Mientras haya objetos
            while (aux != null) {
                if (aux instanceof Object) {
                    arr.pushBack(aux);
                }
                
                aux = leyendoFichero.readObject();

            }
            leyendoFichero.close();
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error obteniendo los datos");
        }

    }
    
    public static void almacenarDatosLinkedList(String nombreArchivo, ListaEnlazada<Object> list) {

        try {
            ObjectInputStream leyendoFichero = Serializando.leerFichero(nombreArchivo);
            // Se lee el primer objeto
            Object aux = leyendoFichero.readObject();

            // Mientras haya objetos
            while (aux != null) {
                if (aux instanceof Object) {
                    list.pushBack(aux);
                }
                
                aux = leyendoFichero.readObject();

            }
            leyendoFichero.close();
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error obteniendo los datos");
        }

    }
}
