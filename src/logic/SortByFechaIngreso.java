
package logic;

import data.Animal;
import java.io.Serializable;
import java.util.Comparator;

public class SortByFechaIngreso implements Comparator<Animal>, Serializable{

    @Override
    public int compare(Animal o1, Animal o2) {
        return o1.compareTo(o2);
    }



    
    
    
}
