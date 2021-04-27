package data;

import java.io.*;
import java.time.LocalDate;
import java.util.Random;

public class Serializando {

    public static void escribirFichero(String nombreArchivo, int numeroDatos) {
        try {
            ObjectOutputStream escribiendoFichero = new ObjectOutputStream(
                    new FileOutputStream("data\\" + nombreArchivo + ".dat"));
            for (int i = 0; i < numeroDatos; i++) {

                Animal o = generarDatoAnimal(i);
                escribiendoFichero.writeObject(o);

            }
            escribiendoFichero.writeObject(null);
            escribiendoFichero.close();

        } catch (IOException e) {
            System.out.println("Ha ocuriddo un error escribiendo el archivo"
                    + e.getMessage());
        }
    }

    public static ObjectInputStream leerFichero(String nombreArchivo) {
        ObjectInputStream objeto = null;
        try {

            ObjectInputStream leyendoFichero = new ObjectInputStream(
                    new FileInputStream("data\\" + nombreArchivo + ".dat"));
            objeto = leyendoFichero;

        } catch (Exception e) {
            System.out.println("Ha ocurrido un error leyendo el archivo"
                    + e.getMessage());
        }
        return objeto;
    }

    private static Animal generarDatoAnimal(long id) {
        Random random = new Random();

        //Proceso para generar 100000000 datos
        long idAnimal = id;
        //String random de 7 caracteres
        String nombre = random.ints(97, 122 + 1)
                .limit(5)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        nombre = nombre.toUpperCase();
        //Escoger entre animal perro gato
        String animal = new String[]{"PERRO", "GATO"}[random.nextInt(2)];
        //Escoger genero del animal 
        String genero = new String[]{"MASCULINO", "FEMENINO"}[random.nextInt(2)];
        //Fecha ingreso del animal
        int año = random.nextInt(2021 - 2010) + 2010;
        int mes = random.nextInt(13 - 1) + 1;
        int dia = random.nextInt(28 - 1) + 1;
        LocalDate fechaIngreso = LocalDate.of(año, mes, dia);
        //Escoger si es adoptable o no
        boolean adoptable = (random.nextInt(2) == 1);
        // Fecha de salida del animal
        LocalDate fechaSalida = (random.nextInt(2) == 1) && adoptable
                ? LocalDate.of(año + random.nextInt(2 - 1) + 1,
                        mes < 8 ? random.nextInt(2 - 1) + 1 : mes,
                        dia < 20 ? random.nextInt(2 - 1) + 1 : dia) : null;
        String estadoIngreso = new String[]{"Muy mal", "Mal", "Bueno", "Muy Bueno"}[random.nextInt(4)];
        estadoIngreso = estadoIngreso.toUpperCase();
        //Crear objeto Animal con la informacion creada por animal
        return new Animal(idAnimal, nombre, animal, genero,
                fechaIngreso, fechaSalida, adoptable, estadoIngreso);

    }

}
