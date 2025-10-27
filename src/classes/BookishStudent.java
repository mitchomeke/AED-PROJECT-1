package classes;
import dataStructures.Iterator;
import dataStructures.ListInArray;

import java.io.Serializable;

public class BookishStudent extends AbstractStudent implements Serializable {
    //List of leisure services Visited
    ListInArray<ServicesInterface> leisureServices;
    private int serviceCounter;
    public BookishStudent(String studentName, String country, LodgingService lodgingLocation){
        super(studentName,country,lodgingLocation);
        leisureServices = new ListInArray<>(AppInterface.LIST_DIMENSION);
        serviceCounter = 0;
    }

    @Override
    public String getStudentName() {
        return studentName;
    }

    @Override
    public String getStudentCountry() {
        return country;
    }

    @Override
    public LodgingService getlodgingLocation() {
        return lodgingLocation;
    }
    @Override
    public void setLodgingLocation(LodgingService lodgingLocation) {
        this.lodgingLocation = lodgingLocation;
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void setCurrentLocation(String serviceName) {
        this.currentLocation = serviceName;
    }

    @Override
    public Iterator<ServicesInterface> visitedServices() {
        return leisureServices.iterator();
    }
    @Override
    public boolean noVisitedLocations() {
        return leisureServices.isEmpty();
    }

    @Override
    public void addService(ServicesInterface service){
        if (!serviceExists(service)){
            leisureServices.add(serviceCounter++,service);
        }
    }
    @Override
    public boolean serviceExists(ServicesInterface service) {
        int i = 0;
        while (i < leisureServices.size()){
            if (leisureServices.get(i).equals(service)){
                return true;
            }
            i++;
        }
        return false;
    }
}
