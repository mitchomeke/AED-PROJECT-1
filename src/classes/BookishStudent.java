package classes;
import dataStructures.Iterator;
import dataStructures.ListInArray;

import java.io.Serializable;

public class BookishStudent extends AbstractStudent implements Serializable {
    ListInArray<ServicesInterface> leisureServices;
    public BookishStudent(String studentName, String country, LodgingService lodgingLocation){
        super(studentName,country,lodgingLocation);
        leisureServices = new ListInArray<>(AppInterface.LIST_DIMENSION);
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
            leisureServices.addLast(service);
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
