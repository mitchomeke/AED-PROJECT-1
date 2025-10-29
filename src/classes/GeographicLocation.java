package classes;
import java.io.Serializable;

public interface GeographicLocation extends Serializable {
    long getLatitude();
    long getLongitude();

}
