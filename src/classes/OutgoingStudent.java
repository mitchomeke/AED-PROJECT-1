package classes;
import dataStructures.Iterator;
import dataStructures.ListInArray;

import java.io.Serializable;

public class OutgoingStudent extends AbstractStudent implements Serializable {
    //List of all services Visited
    ListInArray<ServicesInterface> visited;
    private int visitedCounter;
    public OutgoingStudent(String studentName, String country, LodgingService lodgingLocation){
        super(studentName,country,lodgingLocation);
        visited = new ListInArray<>(AppInterface.LIST_DIMENSION);
        visitedCounter = 0;
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
        currentLocation = serviceName;
    }

    @Override
    public Iterator<ServicesInterface> visitedServices() {
        return visited.iterator();
    }

    @Override
    public boolean noVisitedLocations() {
        return visited.isEmpty();
    }

    @Override
    public void addService (ServicesInterface service){
        if (!serviceExists(service)){
            visited.add(visitedCounter++,service);
        }
    }

    @Override
    public boolean serviceExists(ServicesInterface service) {
        int i = 0;
        while (i < visited.size()){
            if (visited.get(i).equals(service)){
                return true;
            }
            i++;
        }
        return false;
    }

}
