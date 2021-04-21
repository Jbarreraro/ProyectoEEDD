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

        //Test
        try {
            almacenarInformacion(datos);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        
        generarDatos();
        
        
        

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

    private static void generarDatos() {
        Random random = new Random();
        
        //Proceso para generar 100000000 datos
        //String random de 7 caracteres
        String nombre = random.ints(97, 122 + 1)
                .limit(5)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        //Escoger entre animal perro gato
        String animal = new String[]{"perro","gato"}[random.nextInt(2)];
        System.out.println(animal);
    }

}
