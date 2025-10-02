abstract class AbstractServices implements ServicesInterface {
    protected int value;
    protected int price;
    protected String serviceName;
    GeographicLocationClass serviceLocation;
    protected int averageEvaluation;
    public AbstractServices(long latitude, long longitude, int price, int value, String serviceName){
        this.price = price;
        this.value = value;
        this.serviceName = serviceName;
        serviceLocation = new GeographicLocationClass(latitude,longitude);
        averageEvaluation = DEFAULT_STAR;
    }
}
