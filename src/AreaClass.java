public class AreaClass implements AreaInterface {
    private GeographicLocationClass AreaLocation;
    private final String areaName;
    public AreaClass(String name, long topLatitude, long topLongitude, long bottomLatitude, long bottomLongitude){
        this.areaName = name;
        AreaLocation = new GeographicLocationClass(topLatitude,topLongitude,bottomLatitude,bottomLongitude);
    }
    @Override
    public boolean equalsName(String name) {
        return areaName.equals(name);
    }

    @Override
    public String getAreaName() {
        return areaName;
    }
}
