package classes;
import dataStructures.ArrayIterator;
import dataStructures.ListInArray;

import java.io.Serializable;

public class AreaClass implements AreaInterface, Serializable {
    private final GeographicLocationClass AreaLocation;
    private final String areaName;
    public AreaClass(String name, long topLatitude, long leftLongitude, long bottomLatitude, long rightLongitude){
        this.areaName = name;
        AreaLocation = new GeographicLocationClass(topLatitude,leftLongitude,bottomLatitude,rightLongitude);
    }
    @Override
    public boolean equalsName(String name) {
        return areaName.equals(name);
    }

    @Override
    public String getAreaName() {
        return areaName;
    }

    @Override
    public GeographicLocationClass getAreaLocation() {
        return AreaLocation;
    }


}
