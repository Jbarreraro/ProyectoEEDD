package data;

public class Pila {
    private Animal inicio;
    int tamaño;

    public Pila(){
        inicio = null;
        tamaño = 0;
    }


    public boolean estaVacio(){
        return inicio == null;
    }

    public int getTamaño(){
        return tamaño;
    }

    public void insert(String nombre, String animal, String raza, String genero,
                       Date fechaIngreso, Date fechaSalida,
                       String estadoIngreso, String[] medicamentos){
        Animal nuevoAnimal = new Animal();
        nuevoAnimal.setNombre(nombre);
        nuevoAnimal.setAnimal(animal);
        nuevoAnimal.setRaza(raza);
        nuevoAnimal.setGenero(genero);
        nuevoAnimal.setFechaIngreso(fechaIngreso);
        nuevoAnimal.setFechaSalida(fechaSalida);
        nuevoAnimal.setEstadoIngreso(estadoIngreso);
        nuevoAnimal.setMedicamentos(medicamentos);

        if(estaVacio()){
            inicio = nuevoAnimal;

        }else{
            nuevoAnimal.setSiguiente(inicio);
            inicio = nuevoAnimal;
        }
        tamaño ++;
    }
    public void remove(){

        if(!estaVacio()){
            inicio = inicio.getSiguiente();
            tamaño --;
        }
    }
}
