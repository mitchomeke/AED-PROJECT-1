package classes;
import java.io.Serializable;

public class GeographicLocationClass implements GeographicLocation, Serializable {
   private long topLatitude;
   private long leftLongitude;
   private long bottomLatitude;
   private long rightLongitude;
   private long longitude;
   private long latitude;

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
    @Override
    public long getTopLatitude() {
        return topLatitude;
    }
    @Override
    public long getLeftLongitude() {
        return leftLongitude;
    }
    @Override
    public long getBottomLatitude() {
        return bottomLatitude;
    }
    @Override
    public long getRightLongitude() {
        return rightLongitude;
    }
}
