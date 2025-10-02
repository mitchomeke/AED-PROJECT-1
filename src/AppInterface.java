public interface AppInterface {
  public final String EATING = "EATING";
  public final String LEISURE = "LEISURE";
  public final String LODGING = "LODGING";
  public final String OLDEST_TO_NEWEST = ">";
  public final String NEWEST_TO_OLDEST = "<";

    static boolean isValidInsertion(String insertionOrder){
      return insertionOrder.equals(NEWEST_TO_OLDEST) || insertionOrder.equals(OLDEST_TO_NEWEST);
    }
    static boolean isValidService(String serviceName) {
        return serviceName.equals(EATING) || serviceName.equals(LEISURE) || serviceName.equals(LODGING);
    }
  void addService(String serviceType, long latitude, long longitude, int servicePrice, int serviceValue, String serviceName);
  void createArea(long TopLatitude,long TopLongitude, long BottomLatitude, long BottomLongitude, String AreaName);
  void saveArea();
  void addStudent(String studentType, String studentName, String Country, String lodgingName);
  String getCurrentAreaName();
  void leave(String studentName);
  void go(String studentName, String serviceName);
  void load(String areaName);
  void moveStudent(String studentName, String lodgingName);
  void where(String studentName);
  void starService(int star, String serviceName, String description);
  String findMostRelevantService(String studentName, String serviceType);
}
