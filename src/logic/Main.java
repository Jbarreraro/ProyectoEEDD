package logic;

import data.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        //Conexion a base de datos 
        ConexionBd.conectarBd();

        //Obtener filas de datos guardadas en la Bd, el parametro indica el
        //numero de filas a obtener-- numero de animales
        ResultSet datos = ConexionBd.consultarBd(1);

        //Almacenar info localmente obtenida de la BD
//        try {
//            almacenarInformacion(datos);
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }

        //Generar datos
        for (long i = 1; i < (long)Math.pow(10, 8)+1; i++) {
            generarDatos(i);
        }
        

        //Desconectar BD
        ConexionBd.desconectarBd();

    }

    //Metodo para almacenarInformacion en las estructuras que vamos 
    //implementar
    public static void almacenarInformacion(ResultSet datos) throws SQLException {
        while (datos.next()) {

            //Recibir datos de cada animalito 
            long idAnimal = datos.getLong("idAnimal");
            String nombre = datos.getString("nombre");
            String animal = datos.getString("animal");
            String genero = datos.getString("genero");
            LocalDate fechaIngreso = procesarFechaMysql(datos.getString("fechaIngreso"));
            boolean adoptable = datos.getBoolean("adoptable");
            LocalDate fechaSalida = procesarFechaMysql(datos.getString("fechaSalida"));
            String estadoIngreso = datos.getString("estadoIngreso");

            //Crear objeto Animal con la informacion obtenida por animal
            Animal item = new Animal(idAnimal, nombre, animal, genero,
                    fechaIngreso, fechaSalida, adoptable, estadoIngreso);

            System.out.println(item);

        }
    }

    //Las fechas vienen en formato YYYY-MM-DD
    private static LocalDate procesarFechaMysql(String fechaString) {
        if (fechaString == null) {
            return null;
        }

        String[] arrFecha = fechaString.split("-");
        int año = Integer.parseInt(arrFecha[0]);
        int mes = Integer.parseInt(arrFecha[1]);
        int dia = Integer.parseInt(arrFecha[2]);

        return LocalDate.of(año, mes, dia);

    }

    private static void generarDatos(long id) {
        Random random = new Random();

        //Proceso para generar 100000000 datos
        long idAnimal = id;
        //String random de 7 caracteres
        String nombre = random.ints(97, 122 + 1)
                .limit(5)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        //Escoger entre animal perro gato
        String animal = new String[]{"perro", "gato"}[random.nextInt(2)];
        //Escoger genero del animal 
        String genero = new String[]{"M", "F"}[random.nextInt(2)];
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
                        mes < 8  ? random.nextInt(2 - 1) + 1 : mes, 
                        dia < 20 ? random.nextInt(2 - 1) + 1 : dia) : null;
        String estadoIngreso = new String[]{"Muy mal", "Mal", "Bueno", "Muy Bueno"}[random.nextInt(4)];

        //Crear objeto Animal con la informacion obtenida por animal
        Animal item = new Animal(idAnimal, nombre, animal, genero,
                fechaIngreso, fechaSalida, adoptable, estadoIngreso);
        //System.out.println("item = " + item);
    }

}
