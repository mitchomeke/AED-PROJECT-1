package classes;
import java.io.Serializable;

import dataStructures.ArrayIterator;
import dataStructures.FilterIterator;
import dataStructures.Iterator;
import dataStructures.Iterator;

public interface AreaInterface extends Serializable{
    boolean equalsName(String name);
    String getAreaName();
    GeographicLocationClass getAreaLocation();

}
