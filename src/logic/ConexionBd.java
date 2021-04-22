package logic;

import data.Animal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;


public class ConexionBd {

    private static final String url = "jdbc:mysql://127.0.0.1:3306/test?useSSL=false&"
            + "useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";

    private static Connection conexion;
    private static final String usuario = "root", pass = "admin";

    public static void conectarBd() {
        try {
            conexion = DriverManager.getConnection(url, usuario, pass);
        } catch (SQLException e) {
            System.out.println("Ha ocurrido un error de conexion: " + e.getMessage());
        }

    }

    public static ResultSet consultarBd(int numeroDatos) {
        ResultSet resultado = null;
        try {
            Statement instruccion = conexion.createStatement();
            String consulta = "SELECT * FROM animal LIMIT" + numeroDatos;
            resultado = instruccion.executeQuery(consulta);

        } catch (SQLException e) {
            System.out.println("Ha ocurrido un error de consulta " + e.getMessage());
        }

        return resultado;
    }

    public static void insertarBd(Object objeto) {

        //Insertar informacion de un animal a la Bd
        if (objeto instanceof Animal) {
            Animal item = (Animal) objeto;

            try {
                PreparedStatement insert = conexion.prepareStatement(
                        "INSERT INTO animal "
                        + "(nombre, animal, genero, fechaIngreso, "
                        + "adoptable, fechaSalida, estadoIngreso) "
                        + "VALUES (?,?,?,?,?,?,?)");
                
                insert.setString(1, item.getNombre());
                insert.setString(2, item.getAnimal());
                insert.setString(3, item.getGenero());
                //Hay que hacer un proceso para que insertar un objeto tipo Date
                //De java a uno de mysql
                //Orden de conversion: LocalDate ----> Date(sql)
                insert.setDate(4, java.sql.Date.valueOf( item.getFechaIngreso()));
                insert.setBoolean(5, item.isAdoptable());
                insert.setDate(6, item.getFechaSalida() != null ? 
                        java.sql.Date.valueOf(item.getFechaSalida()) : null);
                insert.setString(7, item.getEstadoIngreso());
                
                insert.executeUpdate();
                
            } catch (SQLException e) {
                System.out.println("Ocurrio un error en la insercion de deatos"
                        + e.getMessage());
            }

        }
        //Pendiente bloque else-IF por si se va insertar otro tipo de objeto

    }

    public static void desconectarBd() {
        try {
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Ha ocurrido un error al cerrar la conexion"
                    + e.getMessage());
        }
    }

}
