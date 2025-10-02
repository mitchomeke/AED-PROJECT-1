public interface StudentInterface {
   String getStudentName();
   String getStudentCountry();
   LodgingService getlodgingLocation();
   void setLodgingLocation(LodgingService lodgingLocation);
   String getCurrentLocation();
   void setCurrentLocation(String serviceName);
}
