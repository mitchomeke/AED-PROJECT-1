public class OutgoingStudent extends AbstractStudent{
    //List of all services Visited
    public OutgoingStudent(String studentName, String country, LodgingService lodgingLocation){
        super(studentName,country,lodgingLocation);
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

}
