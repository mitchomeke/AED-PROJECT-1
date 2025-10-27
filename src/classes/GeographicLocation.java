package classes;
import java.io.Serializable;

public interface GeographicLocation extends Serializable {
    long getTopLatitude();
    long getLeftLongitude();
    long getBottomLatitude();
    long getRightLongitude();
    void setTopLatitude(long topLatitude);
    void setLeftLongitude(long topLongitude);
    void setBottomLatitude(long bottomLatitude);
    void setRightLongitude(long bottomLongitude);
    long getLatitude();
    long getLongitude();
    void setLatitude(long latitude);
    void setLongitude(long longitude);
}
