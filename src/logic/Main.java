package logic;

import adts.AVLTree;
import adts.ArrayDinamico;
import adts.MyHashMap;
import data.Animal;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import ui.*;

public class Main {

    // Estructuras usadas en el proyecto
    private static MyHashMap<String, Animal> hashMap = new MyHashMap<String, Animal>();
    private static AVLTree<Animal> animalsOrderedByFechaIngreso = new AVLTree<Animal>(new SortByFechaIngreso());
    private static AVLTree<Animal> animalsOrderedByFechaSalida = new AVLTree<Animal>(new SortByFechaSalida());

    public static void main(String[] args) {

        // Iniciar programa
        try {
            // Traer los datos almacenados
            Object infoHash = getInfoHash();
            Object infoAvl1 = getInfoAvl1();
            Object infoAvl2 = getInfoAvl2();

            if (infoHash != null && infoAvl1 != null && infoAvl2 != null) {
                hashMap = (MyHashMap<String, Animal>) infoHash;
                animalsOrderedByFechaIngreso = (AVLTree<Animal>) infoAvl1;
                animalsOrderedByFechaSalida = (AVLTree<Animal>) infoAvl2;
            }

            new Splash();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void saveInfoHash() throws IOException {

        ObjectOutputStream svHashMap = new ObjectOutputStream(
                new FileOutputStream("data\\" + "hashmap" + ".dat"));

        svHashMap.writeObject(hashMap);
        svHashMap.close();

    }

    private static void saveInfoAvl1() throws IOException {

        ObjectOutputStream svAvl = new ObjectOutputStream(
                new FileOutputStream("data\\" + "avl1" + ".dat"));

        svAvl.writeObject(animalsOrderedByFechaIngreso);
        svAvl.close();

    }

    private static void saveInfoAvl2() throws IOException {

        ObjectOutputStream svAvl = new ObjectOutputStream(
                new FileOutputStream("data\\" + "avl2" + ".dat"));

        svAvl.writeObject(animalsOrderedByFechaSalida);
        svAvl.close();

    }

    private static Object getInfoHash() throws IOException, ClassNotFoundException {
        Object aux;

        try {
            ObjectInputStream getAvl = new ObjectInputStream(
                    new FileInputStream("data\\" + "hashmap" + ".dat"));
            aux = getAvl.readObject();

            getAvl.close();
        } catch (FileNotFoundException e) {
            return null;
        }

        return aux;
    }

    private static Object getInfoAvl1() throws IOException, ClassNotFoundException {
        Object aux;

        try {
            ObjectInputStream getAvl = new ObjectInputStream(
                    new FileInputStream("data\\" + "avl1" + ".dat"));
            aux = getAvl.readObject();

            getAvl.close();
        } catch (FileNotFoundException e) {
            return null;
        }

        return aux;
    }

    private static Object getInfoAvl2() throws IOException, ClassNotFoundException {
        Object aux;

        try {
            ObjectInputStream getAvl = new ObjectInputStream(
                    new FileInputStream("data\\" + "avl2" + ".dat"));
            aux = getAvl.readObject();

            getAvl.close();
        } catch (FileNotFoundException e) {
            return null;
        }

        return aux;
    }

    public static void saveInfo() throws IOException {
        saveInfoAvl1();
        saveInfoAvl2();
        saveInfoHash();
    }

    public static void addAnimal(String key, Animal value) {
        hashMap.put(key, value);
        //Se debe eliminar por si se realiza una actualizacion
        animalsOrderedByFechaIngreso.delete(value);
        animalsOrderedByFechaSalida.delete(value);
        //Se añade el nuevo animal
        animalsOrderedByFechaIngreso.insert(value);
        animalsOrderedByFechaSalida.insert(value);
    }

    public static Animal getAnimal(String name) {
        return hashMap.get(name);
    }

    public static void deleteHojaDevida(String name) {
        Animal animal = hashMap.get(name);
        hashMap.remove(name);
        animalsOrderedByFechaIngreso.delete(animal);
        animalsOrderedByFechaSalida.delete(animal);
    }

    public static boolean verificarExistenciaHv(String name) {
        return hashMap.containsKey(name);
    }

    public static String[][] getDataOrderedByFechaIngreso() {
        ArrayDinamico<Animal> animals = animalsOrderedByFechaIngreso.inOrderTraversal();
        return getDataFromAvl(animals);

    }

    public static String[][] getDataFromAvl(ArrayDinamico<Animal> animals) {
        String[][] data = new String[animals.getNumeroElementos()][7];
        for (int i = 0; i < animals.getNumeroElementos(); i++) {
            Animal animal = animals.get(i);
            // Añadir a la fila los atributos de cada animal
            data[i][0] = animal.getNombre();
            data[i][1] = animal.getAnimal();
            data[i][2] = animal.getGenero();
            data[i][3] = String.valueOf(animal.getFechaIngreso());
            data[i][4] = animal.isAdoptable() ? "SI" : "NO";
            data[i][5] = String.valueOf(animal.getFechaSalida());
            data[i][6] = animal.getEstadoIngreso();
        }
        return data;
    }

    public static String[][] getDataOrderedByFechaSalida() {
        ArrayDinamico<Animal> animals = animalsOrderedByFechaSalida.inOrderTraversal();
        return getDataFromAvl(animals);
    }

}
