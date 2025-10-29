package classes;
import java.io.Serializable;

public class Evaluation implements Serializable {
    String description;
    float stars;
    public Evaluation(String description, int stars){
        this.description = description;
        this.stars = stars;

    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getStars() {
        return stars;
    }
}
