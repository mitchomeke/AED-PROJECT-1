public class LodgingService extends AbstractServices{
    //List Of Students
    //ListOfEvaluations
    public LodgingService(long latitude, long longitude, int price, int value, String serviceName) {
        super(latitude, longitude, price, value, serviceName);
    }
    public int getRoomPrice(){
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
