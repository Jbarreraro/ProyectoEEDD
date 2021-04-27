/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;
import java.util.Date;

/**
 *
 * @author User
 */
public class Animales{

    

    
String nombre;
String animal;
String genero;
String adoptable;
String eIngreso;
int fechaIngreso;
int fechaSalida;
int id;



//CONSTRUCTOR
    public Animales(String nombre, String animal, String genero, String adoptable, String eIngreso, int fechaIngreso, int fechaSalida, int id) {
        this.nombre = nombre;
        this.animal = animal;
        this.genero = genero;
        this.adoptable = adoptable;
        this.eIngreso = eIngreso;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.id = id;
        
    }
//SETS
    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setAdoptable(String adoptable) {
        this.adoptable = adoptable;
    }

    public void seteIngreso(String eIngreso) {
        this.eIngreso = eIngreso;
    }

    public void setFechaIngreso(int fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public void setFechaSalida(int fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
 //GETS
    public String getAnimal() {
        return animal;
    }

    public String getGenero() {
        return genero;
    }

    public String getAdoptable() {
        return adoptable;
    }

    public String geteIngreso() {
        return eIngreso;
    }

    public int getFechaIngreso() {
        return fechaIngreso;
    }

    public int getFechaSalida() {
        return fechaSalida;
    }
    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

}
