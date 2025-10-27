package classes;
import dataStructures.Iterator;

import java.io.Serializable;

public interface StudentInterface extends Serializable {
   String getStudentName();
   String getStudentCountry();
   LodgingService getlodgingLocation();
   void setLodgingLocation(LodgingService lodgingLocation);
   String getCurrentLocation();
   void setCurrentLocation(String serviceName);
   Iterator<ServicesInterface> visitedServices();
   boolean noVisitedLocations();
   void addService(ServicesInterface service);
   boolean serviceExists(ServicesInterface service);

}
