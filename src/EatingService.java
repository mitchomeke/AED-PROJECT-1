import java.security.Provider;

public class EatingService extends AbstractServices{
    //DoublyLinkedListOfStudents
    //List of evaluations

    public EatingService(long latitude, long longitude, int price, int value, String serviceName){
        super(latitude,longitude,price,value,serviceName);
    }
    public int getMenuPrice(){
        return price;
    }
    public int getCapacity(){
        return value;
    }

    @Override
    public int getAverageEvaluation() {
        return averageEvaluation;
    }

    @Override
    public String getserviceName() {
        return serviceName;
    }
    @Override
    public GeographicLocationClass getserviceLocation() {
        return serviceLocation;
    }
}
