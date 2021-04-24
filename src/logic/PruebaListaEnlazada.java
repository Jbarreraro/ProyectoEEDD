package logic;
import data.Animal;
import logic.*;
import javax.swing.JOptionPane;
import java.time.*;
public class PruebaListaEnlazada {
    public static void main(String[] args){
        ListaEnlazada Lista1 = new ListaEnlazada();
        int op = 0;
        do{
            String opcion = JOptionPane.showInputDialog(null,"Lista Simple \n 1-Insertar \n 2-Mostrar \n 3-Buscar \n 4-Salir");
            op = Integer.parseInt(opcion);

            switch (op){
                case 1:{
                    String id,nombre,animal,genero,fechaIn,fechaSal,estado,adoptable;
                    int id1;
                    LocalDate entrada,salida;
                    boolean esAdoptable = false;
                    id = JOptionPane.showInputDialog(null,"Ingrese el id del animal");
                    nombre = JOptionPane.showInputDialog(null,"Ingrese el nombre del animal");
                    animal = JOptionPane.showInputDialog(null,"Ingrese el animal");
                    genero = JOptionPane.showInputDialog(null,"Ingrese el genero del animal");
                    fechaIn = JOptionPane.showInputDialog(null,"Ingrese la fecha de ingreso del animal");
                    fechaSal = JOptionPane.showInputDialog(null,"Ingrese la fecha de salida del animal");
                    estado = JOptionPane.showInputDialog(null,"Ingrese el estado del animal");
                    adoptable = JOptionPane.showInputDialog(null,"Especifique si se puede adoptar el animal");
                    if(adoptable == "Si"){
                        esAdoptable = true;
                    }
                    if(adoptable == "No"){
                        esAdoptable = false;
                    }
                    String [] fechaIngreso = fechaIn.split("/");
                    int año = Integer.parseInt(fechaIngreso[2]);
                    int mes = Integer.parseInt(fechaIngreso[1]);
                    int dia = Integer.parseInt(fechaIngreso[0]);
                    entrada = LocalDate.of(año,mes,dia);
                    String [] fechaSalida = fechaSal.split("/");
                    int año1 = Integer.parseInt(fechaSalida[2]);
                    int mes1 = Integer.parseInt(fechaSalida[1]);
                    int dia1 = Integer.parseInt(fechaSalida[0]);
                    salida = LocalDate.of(año1,mes1,dia1);
                    id1 = Integer.parseInt(id);
                    Lista1.agregar(new Animal(id1,nombre,animal,genero,entrada,salida, esAdoptable, estado));
                    break;
                }
                case 2:{
                    Lista1.mostar();
                    break;
                }
                case 3:{
                    String id = JOptionPane.showInputDialog(null,"Ingrese el id del animal");
                    int idBuscar = Integer.parseInt(id);
                    Lista1.buscar(idBuscar);
                }
            }
        }while(op != 4);
    }
}
