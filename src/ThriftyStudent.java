public class ThriftyStudent extends AbstractStudent{
    //List of eating services but thrifty students don't store the locations they visited.
    public ThriftyStudent(String studentName, String country, LodgingService lodgingLocation){
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
    public void setCurrentLocation(String serviceName){
        currentLocation = serviceName;
    }


}
