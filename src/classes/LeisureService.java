package classes;
import java.io.Serializable;

public class LeisureService extends AbstractServices implements Serializable {
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
    public boolean noStudents() {
        return false;
    }

    @Override
    public void addEvaluaton(Evaluation evaluation) {
        evaluations.add(evalCounter++,evaluation);
    }

    @Override
    public int getPrice() {
        return getTicketPrice();
    }


}
