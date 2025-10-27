package classes;
import dataStructures.Iterator;
import dataStructures.ListInArray;

import java.io.Serializable;

public class ThriftyStudent extends AbstractStudent implements Serializable {
    //List of eating services but thrifty students don't store the locations they visited.
    ListInArray<ServicesInterface> visited;
    private int visitedCounter;
    public ThriftyStudent(String studentName, String country, LodgingService lodgingLocation){
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
    public void setCurrentLocation(String serviceName){
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
    public void addService(ServicesInterface service){
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

    public int leastExpensive(){
        int i = 0;
        int price = Integer.MAX_VALUE;
        while (i < visitedCounter){
            if (visited.get(i) instanceof EatingService && ((EatingService) visited.get(i)).getMenuPrice() < price){
                price = ((EatingService) visited.get(i)).getMenuPrice();
            }
            i++;
        }
        return price;
    }


}
