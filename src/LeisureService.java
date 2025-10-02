public class LeisureService extends AbstractServices{
    //list of evaluations

    public LeisureService(long latitude, long longitude, int price, int value, String serviceName) {
        super(latitude, longitude, price, value, serviceName);
    }
    public int getTicketPrice(){
        return price;
    }
    public int getDiscount(){
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
