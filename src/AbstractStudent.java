abstract class AbstractStudent implements StudentInterface {
    protected String studentName;
    protected String country;
    protected LodgingService lodgingLocation;
    protected String currentLocation;
    protected AbstractStudent(String studentName, String country, LodgingService lodgingLocation){
        this.studentName = studentName;
        this.country = country;
        this.lodgingLocation = lodgingLocation;
    }
}
