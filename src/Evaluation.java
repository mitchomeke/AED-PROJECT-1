public class Evaluation {
    String description;
    int stars;
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

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}
