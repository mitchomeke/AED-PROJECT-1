package classes;
import java.io.Serializable;

abstract class AbstractStudent implements StudentInterface , Serializable {
    protected String studentName;
    protected String country;
    protected LodgingService lodgingLocation;
    protected String currentLocation;
    protected AbstractStudent(String studentName, String country, LodgingService lodgingLocation){
        this.studentName = studentName;
        this.country = country;
        this.lodgingLocation = lodgingLocation;
    }

    public abstract void addService(ServicesInterface service);

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
