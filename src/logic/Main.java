package logic;

import adts.MyHashMap;
import data.Animal;
import javax.swing.JFrame;
import ui.*;

public class Main {
    
    private static MyHashMap<String, Animal> hashMap = new MyHashMap<String, Animal>();

    public static void main(String[] args) {

        // Iniciar programa
        try {
            new Splash();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        

    }
    
    public static void addAnimalToHashMap(String key, Animal value){
        hashMap.put(key, value);
    }
    
    public static Animal getAnimal(String name){
        return hashMap.get(name);
    }
    
    public static void deleteHojaDevida(String name){
        hashMap.remove(name);
    }
    
    public static boolean verificarExistenciaHv(String name){
        return hashMap.containsKey(name);
    }

}
