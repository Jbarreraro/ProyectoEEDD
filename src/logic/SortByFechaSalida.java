package logic;

import data.Animal;
import java.util.Comparator;

public class SortByFechaSalida implements Comparator<Animal> {

    @Override
    public int compare(Animal o1, Animal o2) {
        return o1.getFechaSalida().compareTo(o2.getFechaSalida());
    }
    
    
}
