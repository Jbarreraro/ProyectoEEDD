package data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Animal implements Serializable {

    //Atributos de cada animal
    private String nombre;
    private String animal;
    private String genero;
    private LocalDate fechaIngreso;
    private boolean adoptable;
    private LocalDate fechaSalida;
    private String estadoIngreso;

    //Constructor
    public Animal(String nombreAnimal) {
        this(nombreAnimal, null, null, null, null, false, null);
    }

    public Animal(String nombre, String animal, String genero,
            LocalDate fechaIngreso, LocalDate fechaSalida,
            boolean adoptable, String estadoIngreso) {

        this.nombre = nombre;
        this.animal = animal;
        this.genero = genero;
        this.fechaIngreso = fechaIngreso;
        this.adoptable = adoptable;
        this.fechaSalida = fechaSalida;
        this.estadoIngreso = estadoIngreso;

    }

    //Accesores
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
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public void setAdoptable(boolean adoptable) {
        this.adoptable = adoptable;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public void setEstadoIngreso(String estadoIngreso) {
        this.estadoIngreso = estadoIngreso;
    }

    @Override
    public String toString() {
        return "nombre=" + nombre
                + ", animal=" + animal
                + ", genero=" + genero
                + ", fechaIngreso=" + fechaIngreso
                + ", EsAdoptable=" + adoptable
                + ", fechaSalida=" + fechaSalida
                + ", estadoIngreso=" + estadoIngreso;
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

        if (Objects.equals(this.nombre, other.nombre)) {
            return true;
        }
        if (this.adoptable != other.adoptable) {
            return false;
        }
        if (!Objects.equals(this.animal, other.animal)) {
            return false;
        }
        if (!Objects.equals(this.genero, other.genero)) {
            return false;
        }
        if (!Objects.equals(this.estadoIngreso, other.estadoIngreso)) {
            return false;
        }
        if (!Objects.equals(this.fechaIngreso, other.fechaIngreso)) {
            return false;
        }
        if (!Objects.equals(this.fechaSalida, other.fechaSalida)) {
            return false;
        }
        return true;
    }

}
