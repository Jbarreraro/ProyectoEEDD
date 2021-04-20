package data;

import java.util.*;
import java.text.SimpleDateFormat;

public class Animal {

    //Atributos de cada animal
    private final long id;
    private final String nombre;
    private final String animal;
    private final String raza;
    private final String genero;
    private final Date fechaIngreso;
    private boolean adoptable;
    private Date fechaSalida;
    private String estadoIngreso;
    private String[] medicamentos;

    //Constructor
    public Animal(int id, String nombre, String animal, String raza, String genero,
            Date fechaIngreso, Date fechaSalida,
            boolean adoptable, String estadoIngreso, String[] medicamentos) {
        this.id = id;
        this.nombre = nombre;
        this.animal = animal;
        this.raza = raza;
        this.genero = genero;
        this.fechaIngreso = fechaIngreso;
        this.adoptable = adoptable;
        this.fechaSalida = fechaSalida;
        this.estadoIngreso = estadoIngreso;
        this.medicamentos = medicamentos;
    }

    //Accesores
    public long getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getAnimal() {
        return this.animal;
    }

    public String getRaza() {
        return this.raza;
    }

    public String getGenero() {
        return this.genero;
    }

    public Date getFechaIngreso() {
        return this.fechaIngreso;
    }

    public boolean isAdoptable() {
        return this.adoptable;
    }

    public Date getFechaSalida() {
        return this.fechaSalida;
    }

    public String getEstadoIngreso() {
        return this.estadoIngreso;
    }

    public String[] getMedicamentos() {
        return this.medicamentos;
    }

    //Mutadores 
    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public void setEstadoIngreso(String estadoIngreso) {
        this.estadoIngreso = estadoIngreso;
    }

    public void setMedicamentos(String[] medicamentos) {
        this.medicamentos = medicamentos;
    }

    public void setAdoptable(boolean adoptable) {
        this.adoptable = adoptable;
    }

    @Override
    public String toString() {
        return "id=" + id
                +"\nnombre=" + nombre
                + "\nanimal=" + animal
                + "\nraza=" + raza
                + "\ngenero=" + genero
                + "\nfechaIngreso=" + (new SimpleDateFormat("MM/dd/yyyy")).format(fechaIngreso)
                + "\nEsAdoptable=" + adoptable
                + "\nestadoIngreso=" + estadoIngreso
                + "\nmedicamentos=" + Arrays.asList(medicamentos);
    }

}
