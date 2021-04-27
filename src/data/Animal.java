package data;

import java.io.Serializable;
import java.time.LocalDate;

public class Animal implements Serializable{

    //Atributos de cada animal
    private final long idAnimal;
    private final String nombre;
    private final String animal;
    private final String genero;
    private final LocalDate fechaIngreso;
    private boolean adoptable;
    private LocalDate fechaSalida;
    private String estadoIngreso;

    //Constructor
    public Animal(long idAnimal) {
        this(idAnimal, null, null, null, null, null, false, null);
    }

    public Animal(long idAnimal, String nombre, String animal, String genero,
            LocalDate fechaIngreso, LocalDate fechaSalida,
            boolean adoptable, String estadoIngreso) {
        this.idAnimal = idAnimal;
        this.nombre = nombre;
        this.animal = animal;
        this.genero = genero;
        this.fechaIngreso = fechaIngreso;
        this.adoptable = adoptable;
        this.fechaSalida = fechaSalida;
        this.estadoIngreso = estadoIngreso;

    }

    //Accesores
    public long getId() {
        return this.idAnimal;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getAnimal() {
        return this.animal;
    }

    public String getGenero() {
        return this.genero;
    }

    public LocalDate getFechaIngreso() {
        return this.fechaIngreso;
    }

    public boolean isAdoptable() {
        return this.adoptable;
    }

    public LocalDate getFechaSalida() {
        return this.fechaSalida;
    }

    public String getEstadoIngreso() {
        return this.estadoIngreso;
    }

    //Mutadores 
    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public void setEstadoIngreso(String estadoIngreso) {
        this.estadoIngreso = estadoIngreso;
    }

    public void setAdoptable(boolean adoptable) {
        this.adoptable = adoptable;
    }

    @Override
    public String toString() {
        return "id=" + idAnimal
                + ", nombre=" + nombre
                + ", animal=" + animal
                + ", genero=" + genero
                + ", fechaIngreso=" + fechaIngreso
                + ", EsAdoptable=" + adoptable
                + ", fechaSalida=" + fechaSalida
                + ", estadoIngreso=" + estadoIngreso;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (int) (this.idAnimal ^ (this.idAnimal >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Animal other = (Animal) obj;
        if (this.idAnimal != other.idAnimal) {
            return false;
        }
        return true;
    }

}
