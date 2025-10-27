package classes;
import java.io.Serializable;

public interface ServicesInterface extends Serializable {
    public final int DEFAULT_STAR = 4;
    int getAverageEvaluation();
    String getserviceName();
    GeographicLocationClass getserviceLocation();
    boolean noStudents();
    void addEvaluaton(Evaluation evaluation);
    void computeEvaluation();
    void setOldEval(int eval);
    int getOldEval();
    boolean hasEvalChanged();
    boolean hasTag(String tag);
    int getPrice();
    String getServiceType();
}
