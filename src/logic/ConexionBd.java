package logic;

import java.sql.*;

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

    public static void desconectarBd() {
        try {
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Ha ocurrido un error al cerrar la conexion"
                    + e.getMessage());
        }
    }

}
