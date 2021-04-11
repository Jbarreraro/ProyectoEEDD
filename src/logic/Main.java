package logic;

import data.Animal;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        Animal perrito1 = new Animal("rocky", "perro", "pug", "M", new Date(),
                 null, "Mala", new String[]{"medicamento1", "medicamento2"});
        
        System.out.println(perrito1);
    }

}
