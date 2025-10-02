public class GeographicLocationClass implements GeographicLocation {
    long topLatitude;
    long topLongitude;
    long bottomLatitude;
    long bottomLongitude;
    long longitude;
    long latitude;

    public GeographicLocationClass(long topLatitude, long topLongitude, long bottomLatitude, long bottomLongitude){
        this.topLatitude = topLatitude;
        this.topLongitude = topLongitude;
        this.bottomLatitude = bottomLatitude;
        this.bottomLongitude = bottomLongitude;
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

    public long getTopLongitude() {
        return topLongitude;
    }

    public void setTopLongitude(long topLongitude) {
        this.topLongitude = topLongitude;
    }

    public long getBottomLatitude() {
        return bottomLatitude;
    }

    public void setBottomLatitude(long bottomLatitude) {
        this.bottomLatitude = bottomLatitude;
    }

    public long getBottomLongitude() {
        return bottomLongitude;
    }

    public void setBottomLongitude(long bottomLongitude) {
        this.bottomLongitude = bottomLongitude;
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
