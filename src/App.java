public class App implements AppInterface{
    AreaClass currentArea;
    //List of services
    //List of Students
    //Map of value: Students & key: Country
    //Map of value: Evaluations & key: Services
    //HashMap of value: Evaluations averages (int) & key: Services
    public  App(){

    }
    private boolean boundsCheck(long topLatitude, long topLongitude, long bottomLatitude, long bottomLongitude) {
        return topLatitude <= bottomLatitude && topLongitude <= bottomLongitude;
    }

    private boolean existingCheck(String areaName) {
      if (currentArea == null){
          return false;
      }
      else return currentArea.equalsName(areaName);
    }

    @Override
    public void addService(String serviceType, long latitude, long longitude, int servicePrice, int serviceValue, String serviceName) {

    }

    @Override
    public void createArea(long TopLatitude, long TopLongitude, long BottomLatitude, long BottomLongitude, String AreaName) {
        if (existingCheck(AreaName)){
            throw new AreaAlreadyExistsException();
        }
        else if (boundsCheck(TopLatitude,TopLongitude,BottomLatitude,BottomLongitude)){
            throw new InvalidBoundsException();
        }
        else {
            currentArea = new AreaClass(AreaName,TopLatitude,TopLongitude,BottomLatitude,BottomLongitude);
        }
    }

    @Override
    public void saveArea() {
        if (currentArea == null){
            throw new BoundsNotDefinedException();
        } else {

        }
    }

    @Override
    public void addStudent(String studentType, String studentName, String Country, String lodgingName) {

    }

    @Override
    public String getCurrentAreaName() {
        return currentArea.getAreaName();
    }

    @Override
    public void leave(String studentName) {

    }

    @Override
    public void go(String studentName, String serviceName) {

    }

    @Override
    public void load(String areaName) {

    }

    @Override
    public void moveStudent(String studentName, String lodgingName) {

    }

    @Override
    public void where(String studentName) {

    }

    @Override
    public void starService(int star, String serviceName, String description) {

    }

    @Override
    public String findMostRelevantService(String studentName, String serviceType) {
        return "";
    }
}
