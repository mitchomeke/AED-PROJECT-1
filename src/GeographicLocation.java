public interface GeographicLocation {
    long getTopLatitude();
    long getTopLongitude();
    long getBottomLatitude();
    long getBottomLongitude();
    void setTopLatitude(long topLatitude);
    void setTopLongitude(long topLongitude);
    void setBottomLatitude(long bottomLatitude);
    void setBottomLongitude(long bottomLongitude);
    long getLatitude();
    long getLongitude();
    void setLatitude(long latitude);
    void setLongitude(long longitude);
}
