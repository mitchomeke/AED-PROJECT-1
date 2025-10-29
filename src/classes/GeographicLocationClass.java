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

    @Override
    public long getLatitude() {
        return latitude;
    }

    @Override
    public long getLongitude() {
        return longitude;
    }

}
