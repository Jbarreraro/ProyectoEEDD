package logic;

import adts.AVLTree;
import adts.ArrayDinamico;
import adts.MyHashMap;
import data.Animal;
import javax.swing.JFrame;
import ui.*;

public class Main {
    
    // Estructuras usadas en el proyecto
    private static MyHashMap<String, Animal> hashMap = new MyHashMap<String, Animal>();
    private static AVLTree<Animal> animalsOrderedByFechaIngreso = new AVLTree<Animal>();
    private static AVLTree<Animal> animalsOrderedByFechaSalida = new AVLTree<Animal>(new SortByFechaSalida());

    public static void main(String[] args) {

        // Iniciar programa
        try {
            new Splash();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        

    }
    
    public static void addAnimal(String key, Animal value){
        hashMap.put(key, value);
        animalsOrderedByFechaIngreso.insert(value);
        animalsOrderedByFechaSalida.insert(value);
    }
    
    public static Animal getAnimal(String name){
        return hashMap.get(name);
    }
    
    public static void deleteHojaDevida(String name){
        Animal animal = hashMap.get(name);
        hashMap.remove(name);
        animalsOrderedByFechaIngreso.delete(animal);
        animalsOrderedByFechaSalida.delete(animal);
    }
    
    public static boolean verificarExistenciaHv(String name){
        return hashMap.containsKey(name);
    }
    
    
    public static String[][] getDataOrderedByFechaIngreso(){
        ArrayDinamico<Animal> animals = animalsOrderedByFechaIngreso.inOrderTraversal();
        String[][] data = new String[animals.getNumeroElementos()][7];
        for (int i = 0; i < animals.getNumeroElementos(); i++){
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
    
    
    public static String[][] getDataOrderedByFechaSalida(){
        ArrayDinamico<Animal> animals = animalsOrderedByFechaSalida.inOrderTraversal();
        String[][] data = new String[animals.getNumeroElementos()][7];
        for (int i = 0; i < animals.getNumeroElementos(); i++){
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
    
}
