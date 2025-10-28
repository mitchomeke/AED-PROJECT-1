package classes;
import java.io.Serializable;

import dataStructures.*;

public interface AppInterface extends Serializable {
  public final String EATING = "EATING";
  public final String LEISURE = "LEISURE";
  public final String LODGING = "LODGING";
  public final String BOOKISH = "BOOKISH";
  public final String OUTGOING = "OUTGOING";
  public final String THRIFTY = "THRIFTY";
  public final String OLDEST_TO_NEWEST = ">";
  public final String NEWEST_TO_OLDEST = "<";
  public final int LIST_DIMENSION = 5;
  public final int ZERO = 0;
  public final int ONE = 1;
  public final int TWO = 2;
  public final int THREE = 3;
  public final int FOUR = 4;
  public final int FIVE = 5;
  public final int HUNDRED = 100;
  public final String FILE_EXTENSION = ".ser";

    static boolean isValidInsertion(String insertionOrder){
      return insertionOrder.equals(NEWEST_TO_OLDEST) || insertionOrder.equals(OLDEST_TO_NEWEST);
    }
    static boolean isnotValidService(String serviceName) {
        return !serviceName.equals(EATING) && !serviceName.equals(LEISURE) && !serviceName.equals(LODGING);
    }
    static boolean isnotValidStudent(String studentType){
      return !studentType.equals(BOOKISH) && !studentType.equals(OUTGOING) && !studentType.equals(THRIFTY);
    }
    static boolean outOfValueBounds(int value){
      return value < ZERO || value > HUNDRED;
    }
  void addService(String serviceType, long latitude, long longitude, int servicePrice, int serviceValue, String serviceName);
  AppInterface createArea(long TopLatitude,long TopLongitude, long BottomLatitude, long BottomLongitude, String AreaName);
  boolean canSaveArea();
  void addStudent(String studentType, String studentName, String Country, String lodgingName);
  String getCurrentAreaName();
  StudentInterface leave(String studentName);
  void go(String studentName, String serviceName);
  void moveStudent(String studentName, String lodgingName);
  ServicesInterface where(String studentName);
  void starService(int star, String serviceName, String description);
  String findMostRelevantService(String studentName, String serviceType);
  String splitName(String AreaName);
  String splitAreaName();
  boolean outsideBoundingRectangle(long latitude, long longitude);
  void saveArea();
  boolean isCurrentAreaSaved();
  ArrayIterator<ServicesInterface> allServices();
  int getNumberOfServices();
  int getNumberOfStudents();
  Iterator<StudentInterface> allStudents();
  int getNumberOfStudentsFromCountry(String studentCountry);
  FilterIterator<StudentInterface> allStudentsFromCountry(String studentCountry);
  TwoWayIterator<StudentInterface> users(String insertionOrder, String serviceName);
  Iterator<ServicesInterface> servicesByStudent(String StudentName);
  Iterator<ListInArray<ServicesInterface>> servicesByStar();
  Iterator<ServicesInterface> closerToRanking(String serviceType, int star, String studentName);
  Iterator<ServicesInterface> servicesWithTag(String tag);

}
