package classes;
import dataStructures.ListInArray;
import java.io.Serializable;


abstract class AbstractServices implements ServicesInterface, Serializable{
    protected int value;
    protected int price;
    protected String serviceName;
    GeographicLocationClass serviceLocation;
    protected int averageEvaluation;
    ListInArray<Evaluation> evaluations;
    protected int evalCounter;
    protected int oldAverageEval;
    protected String serviceType;
    public AbstractServices(long latitude, long longitude, int price, int value, String serviceName, String serviceType){
        this.price = price;
        this.value = value;
        this.serviceName = serviceName;
        serviceLocation = new GeographicLocationClass(latitude,longitude);
        averageEvaluation = DEFAULT_STAR;
        evaluations = new ListInArray<>(AppInterface.LIST_DIMENSION);
        evalCounter = 0;
        evaluations.add(evalCounter++,new Evaluation("DEFAULT",DEFAULT_STAR));
        oldAverageEval = DEFAULT_STAR;
        this.serviceType = serviceType;
    }
    public String getServiceType(){
        return serviceType;
    }
    public boolean hasTag(String tag){
        for (int i = 0; i < evaluations.size();i++){
            String[] splitDesc = evaluations.get(i).getDescription().split(" ");
            int w = 0;
            while (w < splitDesc.length){
                if (splitDesc[w].equalsIgnoreCase(tag)){
                    return true;
                }
                w++;
            }
        }
        return false;
    }
    @Override
    public int getAverageEvaluation() {
        computeEvaluation();
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
    @Override
    public void computeEvaluation() {
        float average = 0;
        for (int i = 0; i < evaluations.size();i++){
            average = average + evaluations.get(i).getStars();
        }
        averageEvaluation = Math.round(average/evalCounter);
    }
    @Override
    public void setOldEval(int eval) {
        oldAverageEval = eval;

    }
    @Override
    public int getOldEval() {
        return oldAverageEval;
    }
    @Override
    public boolean hasEvalChanged() {
        return oldAverageEval != getAverageEvaluation();
    }



}
