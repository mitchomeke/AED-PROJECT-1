package classes;
import dataStructures.Iterator;
import dataStructures.ListInArray;

import java.io.Serializable;

public class OutgoingStudent extends AbstractStudent implements Serializable {
    ListInArray<ServicesInterface> visited;
    public OutgoingStudent(String studentName, String country, LodgingService lodgingLocation){
        super(studentName,country,lodgingLocation);
        visited = new ListInArray<>(AppInterface.LIST_DIMENSION);
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
            visited.addLast(service);
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
