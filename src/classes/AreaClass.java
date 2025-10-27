package classes;
import dataStructures.ArrayIterator;
import dataStructures.ListInArray;

import java.io.Serializable;

public class AreaClass implements AreaInterface, Serializable {
    private GeographicLocationClass AreaLocation;
    private final String areaName;
    private ListInArray<ServicesInterface> services;
    private ServicesInterface service;
    public AreaClass(String name, long topLatitude, long leftLongitude, long bottomLatitude, long rightLongitude){
        this.areaName = name;
        AreaLocation = new GeographicLocationClass(topLatitude,leftLongitude,bottomLatitude,rightLongitude);
        services = new ListInArray<>(AppInterface.LIST_DIMENSION);
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

    @Override
    public ArrayIterator<ServicesInterface> servicesIterator() {
        return (ArrayIterator) services.iterator();
    }

    @Override
    public boolean serviceExists(String serviceName) {
        service = null;
        int i = 0;
        while (i < services.size()){
            if (serviceName.equalsIgnoreCase(services.get(i).getserviceName())){
                service = services.get(i);
                return true;
            }
            i++;
        }
        return false;
    }

    @Override
    public void addService(ServicesInterface service) {
        services.addLast(service);
    }

    @Override
    public ServicesInterface service() {
        return service;
    }

}
