package classes;
import java.io.Serializable;

public class LeisureService extends AbstractServices implements Serializable {
    //list of evaluations

    public LeisureService(long latitude, long longitude, int price, int value, String serviceName, String serviceType) {
        super(latitude, longitude, price, value, serviceName,serviceType);
    }
    public int getTicketPrice(){
        if (getDiscount() > 0){
            price = price - (price * (getDiscount()/100));
            return price;
        }

        return price;
    }
    public int getDiscount(){
        return value;
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
    public boolean noStudents() {
        return false;
    }

    @Override
    public void addEvaluaton(Evaluation evaluation) {
        evaluations.add(evalCounter++,evaluation);
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

    @Override
    public int getPrice() {
        return getTicketPrice();
    }


}
