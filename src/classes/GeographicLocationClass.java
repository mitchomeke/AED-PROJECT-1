package classes;
import java.io.Serializable;

public class GeographicLocationClass implements GeographicLocation, Serializable {
    long topLatitude;
    long leftLongitude;
    long bottomLatitude;
    long rightLongitude;
    long longitude;
    long latitude;

    public GeographicLocationClass(long topLatitude, long leftLongitude, long bottomLatitude, long rightLongitude){
        this.topLatitude = topLatitude;
        this.leftLongitude = leftLongitude;
        this.bottomLatitude = bottomLatitude;
        this.rightLongitude = rightLongitude;
    }
    public GeographicLocationClass(long latitude, long longitude){
        this.latitude = latitude;
        this.longitude = longitude;
    }
    public long getTopLatitude() {
        return topLatitude;
    }

    public void setTopLatitude(long topLatitude) {
        this.topLatitude = topLatitude;
    }

    public long getLeftLongitude() {
        return leftLongitude;
    }

    public void setLeftLongitude(long leftLongitude) {
        this.leftLongitude = leftLongitude;
    }

    public long getBottomLatitude() {
        return bottomLatitude;
    }

    public void setBottomLatitude(long bottomLatitude) {
        this.bottomLatitude = bottomLatitude;
    }

    public long getRightLongitude() {
        return rightLongitude;
    }

    public void setRightLongitude(long rightLongitude) {
        this.rightLongitude = rightLongitude;
    }

    @Override
    public long getLatitude() {
        return latitude;
    }

    @Override
    public long getLongitude() {
        return longitude;
    }

    @Override
    public void setLatitude(long latitude) {

    }

    @Override
    public void setLongitude(long longitude) {

    }
}
