package classes;
import dataStructures.*;
import exceptions.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class App implements AppInterface, Serializable {
    private AreaClass currentArea;
    private boolean currentAreaSaved;
    ListInArray<ServicesInterface> allServices;
    private int servicesCounter;
    ListInArray<StudentInterface> allStudents;
    private int studentsCounter;
    public StudentInterface currentStudent;
    private SortedDoublyLinkedList<StudentInterface> sortedStudents;
    Comparator<StudentInterface> comparator;
    ListInArray<ServicesInterface> rank5;
    ListInArray<ServicesInterface> rank4;
    ListInArray<ServicesInterface> rank3;
    ListInArray<ServicesInterface> rank2;
    ListInArray<ServicesInterface> rank1;
    ListInArray<ListInArray<ServicesInterface>> rankingServices;

    ListInArray<ServicesInterface> leisureServices;
    ListInArray<ServicesInterface> eatingServices;
    ListInArray<ServicesInterface> lodgingServices;


    //List of services
    //List of Students
    //Map of value: Students & key: Country
    //Map of value: Evaluations & key: Services
    //HashMap of value: Evaluations averages (int) & key: Services

    public App() {
        allServices = new ListInArray<>(LIST_DIMENSION);
        servicesCounter = 0;
        allStudents = new ListInArray<>(LIST_DIMENSION);
        studentsCounter = 0;
        comparator = (s1, s2) -> s1.getStudentName().compareTo(s2.getStudentName());
        sortedStudents = new SortedDoublyLinkedList<>(comparator);

        rankingServices = new ListInArray<>(LIST_DIMENSION);

        rank5 = new ListInArray<>(LIST_DIMENSION);
        rank4 = new ListInArray<>(LIST_DIMENSION);
        rank3 = new ListInArray<>(LIST_DIMENSION);
        rank2 = new ListInArray<>(LIST_DIMENSION);
        rank1 = new ListInArray<>(LIST_DIMENSION);

        rankingServices.addLast(rank5);
        rankingServices.addLast(rank4);
        rankingServices.addLast(rank3);
        rankingServices.addLast(rank2);
        rankingServices.addLast(rank1);

        leisureServices = new ListInArray<>(LIST_DIMENSION);
        lodgingServices = new ListInArray<>(LIST_DIMENSION);
        eatingServices = new ListInArray<>(LIST_DIMENSION);
    }

    private boolean studentExists(String studentName) {
        int i = 0;
        currentStudent = null;
        while (i < getNumberOfStudents()) {
            if (allStudents.get(i).getStudentName().equalsIgnoreCase(studentName)) {
                currentStudent = allStudents.get(i);
                return true;
            }
            i++;
        }
        return false;
    }

    public AreaClass getCurrentArea() {
        return currentArea;
    }

    public void setCurrentArea(AreaClass currentArea) {
        this.currentArea = currentArea;
    }

    private boolean boundsCheck(long topLatitude, long leftLongitude, long bottomLatitude, long rightLongitude) {
        return topLatitude > bottomLatitude && leftLongitude < rightLongitude;
    }

    private boolean existingCheck(String areaName) {
        if (currentArea == null) {
            return false;
        } else return currentArea.getAreaName().equalsIgnoreCase(areaName);
    }

    @Override
    public void addService(String serviceType, long latitude, long longitude, int servicePrice, int serviceValue, String serviceName) {
        if (AppInterface.isnotValidService(serviceType)) {
            throw new InvalidServiceTypeException();
        } else if (outsideBoundingRectangle(latitude, longitude)) {
            throw new OutsideRectangleException();
        } else if (servicePrice <= 0 && serviceType.equals(LODGING)) {
            throw new InvalidRoomException();
        } else if (servicePrice <= 0 && serviceType.equals(EATING)) {
            throw new InvalidMenuPriceException();
        } else if (servicePrice <= 0 && serviceType.equals(LEISURE)) {
            throw new InvalidTicketPriceException();
        } else if ((serviceValue < 0 || serviceValue > 100) && serviceType.equals(LEISURE)) {
            throw new InvalidDiscountException();
        } else if ((serviceValue <= 0) && ((serviceType.equals(LODGING)) || serviceType.equals(EATING))) {
            throw new InvalidCapacityException();
        } else if (currentArea.serviceExists(serviceName)) {
            throw new ServiceExistsException();
        } else {
            addServiceofType(serviceType, latitude, longitude, servicePrice, serviceValue, serviceName);
        }
    }

    private void addServiceofType(String serviceType, long latitude, long longitude, int servicePrice, int serviceValue, String serviceName) {
        if (serviceType.equals(LODGING)) {
            LodgingService service = new LodgingService(latitude, longitude, servicePrice, serviceValue, serviceName,serviceType);
            allServices.addLast(service);
            currentArea.addService(service);
            rank4.addLast(service);
            lodgingServices.addLast(service);
        } else if (serviceType.equals(EATING)) {
            EatingService service = new EatingService(latitude, longitude, servicePrice, serviceValue, serviceName,serviceType);
            allServices.addLast(service);
            currentArea.addService(service);
            rank4.addLast(service);
            eatingServices.addLast(service);
        } else {
            LeisureService service = new LeisureService(latitude, longitude, servicePrice, serviceValue, serviceName,serviceType);
            allServices.addLast(service);
            currentArea.addService(service);
            rank4.addLast(service);
            leisureServices.addLast(service);
        }
    }

    public ServicesInterface getServiceByName(String Name) {
        if (currentArea.serviceExists(Name)) {
            return currentArea.service();
        }
        return null;
    }

    @Override
    public AppInterface createArea(long TopLatitude, long leftLongitude, long BottomLatitude, long rightLongitude, String AreaName) {
        if (existingCheck(AreaName) || !filenotFound(splitName(AreaName))) {
            throw new AreaAlreadyExistsException();
        } else if (!boundsCheck(TopLatitude, leftLongitude, BottomLatitude, rightLongitude)) {
            throw new InvalidBoundsException();
        } else {
            App app = new App();
            AreaClass area = new AreaClass(AreaName, TopLatitude, leftLongitude, BottomLatitude, rightLongitude);
            app.setCurrentArea(area);
            app.unSaveArea();
            return app;
        }
    }

    @Override
    public boolean canSaveArea() {
        return currentArea != null;
    }

    @Override
    public void addStudent(String studentType, String studentName, String Country, String lodgingName) {
        if (AppInterface.isnotValidStudent(studentType.toUpperCase())) {
            throw new InvalidStudentTypeException();
        }
        ServicesInterface service = getServiceByName(lodgingName);
        if (!(service instanceof LodgingService)) {
            throw new LodgingDoesntExistException();
        } else if (!((LodgingService)service).canAddStudent()) {
            throw new LodgingFullException();
        } else if (studentExists(studentName)) {
            throw new studentExistsException();
        } else {
            addStudentByType(studentType, studentName, Country, (LodgingService) service);
        }

    }

    private void addStudentByType(String studentType, String studentName, String Country, LodgingService lodging) {
        if (studentType.equalsIgnoreCase(BOOKISH)) {
            BookishStudent student = new BookishStudent(studentName, Country, lodging);
            student.setCurrentLocation(lodging.getserviceName());
            lodging.addStudent(student);
            allStudents.addLast(student);
            sortedStudents.add(student);
        } else if (studentType.equalsIgnoreCase(OUTGOING)) {
            OutgoingStudent student = new OutgoingStudent(studentName, Country, lodging);
            student.setCurrentLocation(lodging.getserviceName());
            lodging.addStudent(student);
            allStudents.addLast(student);
            sortedStudents.add(student);
            student.addService(lodging);
        } else {
            ThriftyStudent student = new ThriftyStudent(studentName, Country, lodging);
            student.setCurrentLocation(lodging.getserviceName());
            lodging.addStudent(student);
            allStudents.addLast(student);
            sortedStudents.add(student);
            student.addService(lodging);
        }
    }

    @Override
    public String getCurrentAreaName() {
        return currentArea.getAreaName();
    }

    @Override
    public StudentInterface leave(String studentName) {
        if (!studentExists(studentName)) {
            throw new StudentDoesNotExistsException();
        } else {
            StudentInterface student = getStudentByName(studentName);
            LodgingService location = student.getlodgingLocation();
            location.removeStudent(student);
            int studentIndex = allStudents.indexOf(student);
            allStudents.remove(studentIndex);
            sortedStudents.remove(student);

            removeStudentInEating0rLodging(student);
            return student;
        }
    }

    private void removeStudentInEating0rLodging(StudentInterface student) {
        int i = 0;
        while (i < eatingServices.size()) {
            EatingService service = (EatingService) eatingServices.get(i);
            if (service.hasStudent(student)){
                service.removeStudent(student);
            }
            i++;
        }
        int w = 0;
        while (w < lodgingServices.size()) {
            LodgingService service = (LodgingService) lodgingServices.get(w);
            if (service.hasStudent(student)){
                service.removeStudent(student);
            }
            w++;
        }
    }

    public StudentInterface getStudentByName(String studentName) {
        if (studentExists(studentName)) {
            return currentStudent;
        }
        return null;
    }

    @Override
    public void go(String studentName, String serviceName) {
        ServicesInterface service = getServiceByName(serviceName);
        StudentInterface student = getStudentByName(studentName);
        if (service == null) {
            throw new UnknownLocationException();
        } else if (student == null) {
            throw new StudentDoesNotExistsException();
        } else if (service instanceof LodgingService) {
            throw new ServiceNotValidException();
        } else if (student.getCurrentLocation().equals(service.getserviceName())) {
            throw new StudentAlreadyThereException();
        } else if (service instanceof EatingService && ((EatingService) service).isFull()) {
            throw new EatingServiceIsFullException();
        } else if (student instanceof ThriftyStudent && service instanceof EatingService && ((EatingService) service).getMenuPrice() > ((ThriftyStudent) student).leastExpensive()) {
            student.setCurrentLocation(service.getserviceName());
            ((ThriftyStudent) student).addService(service);
            ((EatingService) service).addStudent(student);
            throw new StudentisDistractedException();
        } else {
            changeStudentLocation(service, student);
        }

    }

    private void changeStudentLocation(ServicesInterface service, StudentInterface student) {
        if (student instanceof BookishStudent && service instanceof LeisureService) {
            ((BookishStudent) student).addService((LeisureService) service);
        } else if (student instanceof ThriftyStudent || student instanceof OutgoingStudent) {
            student.addService(service);
        }
        student.setCurrentLocation(service.getserviceName());
        if (service instanceof EatingService) {
            ((EatingService) service).addStudent(student);
        }
    }

    private boolean filenotFound(String Name) {
        App app = null;
        String FullName = Name + ".ser";
        try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(FullName))) {
            app = (App) stream.readObject();
            if (app != null) {
                return false;
            }
        } catch (IOException | ClassNotFoundException e) {
            return true;
        }

        return false;
    }

    public void load(String areaName) {


    }

    @Override
    public void moveStudent(String studentName, String lodgingName) {
        LodgingService service = (LodgingService) getServiceByName(lodgingName);
        StudentInterface student = getStudentByName(studentName);
        if (service == null) {
            throw new LodgingDoesntExistException();
        } else if (student == null) {
            throw new StudentDoesNotExistsException();
        } else if (student.getlodgingLocation().equals(service)) {
            throw new AlreadyHomeException();
        } else if (!service.canAddStudent()) {
            throw new LodgingFullException();
        } else if (student instanceof ThriftyStudent && service.getRoomPrice() >= student.getlodgingLocation().getRoomPrice()) {
            throw new MoveNotAcceptableException();
        } else {
            service.addStudent(student);
            LodgingService oldLodging = student.getlodgingLocation();
            oldLodging.removeStudent(student);
            ServicesInterface oldService = getServiceByName(student.getCurrentLocation());
            if (oldService instanceof EatingService) {
                ((EatingService) oldService).removeStudent(student);
            }
            if (oldService instanceof LodgingService) {
                ((LodgingService) oldService).removeStudent(student);
            }
            changeStudentLocation(service, student);
            student.setLodgingLocation(service);
        }
    }

    @Override
    public ServicesInterface where(String studentName) {
        StudentInterface student = getStudentByName(studentName);
        if (student == null) {
            throw new StudentDoesNotExistsException();
        } else {
            return getServiceByName(student.getCurrentLocation());
        }
    }

    @Override
    public void starService(int star, String serviceName, String description) {
        if (star < 1 || star > 5) {
            throw new InvalidEvaluationException();
        }
        ServicesInterface service = getServiceByName(serviceName);
        if (service == null) {
            throw new ServiceExistsException();
        } else {
            Evaluation evaluation = new Evaluation(description, star);
            service.addEvaluaton(evaluation);
            if (service.hasEvalChanged()) {
                addToRank(service.getAverageEvaluation(), service);
                removeFromRank(service.getOldEval(), service);
                service.setOldEval(service.getAverageEvaluation());
            }
        }
    }

    private void removeFromRank(int oldEval, ServicesInterface service) {
        switch (oldEval) {
            case 5:
                int rank5pos = rank5.indexOf(service);
                rank5.remove(rank5pos);
                break;
            case 4:
                int rank4pos = rank4.indexOf(service);
                rank4.remove(rank4pos);
                break;
            case 3:
                int rank3pos = rank3.indexOf(service);
                rank3.remove(rank3pos);
                break;
            case 2:
                int rank2pos = rank2.indexOf(service);
                rank2.remove(rank2pos);
                break;
            case 1:
                int rank1pos = rank1.indexOf(service);
                rank1.remove(rank1pos);
                break;
        }
    }

    private void addToRank(int star, ServicesInterface service) {
        switch (star) {
            case 5:
                rank5.addLast(service);
                break;
            case 4:
                rank4.addLast(service);
                break;
            case 3:
                rank3.addLast(service);
                break;
            case 2:
                rank2.addLast(service);
                break;
            case 1:
                rank1.addLast(service);
                break;
        }
    }

    @Override
    public String findMostRelevantService(String studentName, String serviceType) {
        if (AppInterface.isnotValidService(serviceType)){
            throw new InvalidServiceTypeException();
        }
        StudentInterface student = getStudentByName(studentName);
       if (student == null){
            throw new StudentDoesNotExistsException();
        }
       else if (!hasServiceOfType(serviceType)){
           throw new NoServiceOfTypeException();
       }
       else {
         return getMostRelevantService(student,serviceType).getserviceName();
       }
    }
    private ListInArray<ServicesInterface> getServicesOfType(String serviceType){
        if (serviceType.equalsIgnoreCase(EATING)){
            return eatingServices;
        }
        else if (serviceType.equalsIgnoreCase(LEISURE)){
            return leisureServices;
        }
        else {
            return lodgingServices;
        }
    }

    private ServicesInterface getMostRelevantService(StudentInterface student, String serviceType) {
        ListInArray<ServicesInterface> servicesOfType = getServicesOfType(serviceType);
        if (student instanceof BookishStudent || student instanceof OutgoingStudent){
            int bestAverage = Integer.MIN_VALUE;
            for (int i = 0; i < servicesOfType.size();i++){
                if (servicesOfType.get(i).getAverageEvaluation() > bestAverage){
                    bestAverage = servicesOfType.get(i).getAverageEvaluation();
                }
            }
            return getServiceInRank(bestAverage,serviceType);
        }
        else {
            int minimumPrice = Integer.MAX_VALUE;
            ServicesInterface serviceWithMinPrice = null;
            for (int i = 0; i < servicesOfType.size();i++){
                if (servicesOfType.get(i).getPrice() < minimumPrice){
                    minimumPrice = servicesOfType.get(i).getPrice();
                }
            }
            int w = 0;
            while (w < servicesOfType.size()){
                if (servicesOfType.get(w).getPrice() == minimumPrice){
                    serviceWithMinPrice = servicesOfType.get(w);
                    return serviceWithMinPrice;
                }
                w++;
            }
        }
        return null;
    }

    private ServicesInterface getServiceInRank(int bestAverage, String serviceType) {
        switch (bestAverage){
            case 5:
                return mostTimeInRank(rank5,serviceType);
            case 4:
                return mostTimeInRank(rank4,serviceType);
            case 3:
                return mostTimeInRank(rank3,serviceType);
            case 2:
                return mostTimeInRank(rank2,serviceType);
            case 1:
                return mostTimeInRank(rank1,serviceType);
        }
        return null;
    }
    private ServicesInterface mostTimeInRank(ListInArray<ServicesInterface> rank, String serviceType){
        if (!rank.isEmpty()){
            int i = 0;
            while (i < rank.size()){
                if (rank.get(i).getServiceType().equalsIgnoreCase(serviceType)){
                    return rank.get(i);
                }
                i++;
            }
        }
        return null;
    }

    @Override
    public String splitName(String AreaName) {
        return String.join("_", AreaName.split(" "));
    }

    @Override
    public String splitAreaName() {
        if (currentArea != null) {
            return splitName(getCurrentAreaName());
        }
        return "";
    }

    @Override
    public boolean outsideBoundingRectangle(long latitude, long longitude) {
        boolean insideLatitude = latitude <= currentArea.getAreaLocation().topLatitude && latitude >= currentArea.getAreaLocation().bottomLatitude;
        boolean insideLongitude = longitude >= currentArea.getAreaLocation().leftLongitude && longitude <= currentArea.getAreaLocation().rightLongitude;
        return !(insideLatitude && insideLongitude);
    }

    public void unSaveArea() {
        currentAreaSaved = false;
    }

    @Override
    public void saveArea() {
        currentAreaSaved = true;
    }

    @Override
    public boolean isCurrentAreaSaved() {
        return currentAreaSaved;
    }

    @Override
    public ArrayIterator<ServicesInterface> allServices() {
        return (ArrayIterator) allServices.iterator();
    }

    @Override
    public int getNumberOfServices() {
        return allServices.size();
    }

    @Override
    public int getNumberOfStudents() {
        return allStudents.size();
    }

    @Override
    public Iterator<StudentInterface> allStudents() {
        return sortedStudents.iterator();
    }

    @Override
    public int getNumberOfStudentsFromCountry(String studentCountry) {
        int number = 0;
        int index = 0;
        while (index < getNumberOfStudents()) {
            if (allStudents.get(index).getStudentCountry().equalsIgnoreCase(studentCountry)) {
                number++;
            }
            index++;
        }
        return number;
    }

    @Override
    public FilterIterator<StudentInterface> allStudentsFromCountry(String studentCountry) {
        Predicate<StudentInterface> fromCountry = s -> s.getStudentCountry().equalsIgnoreCase(studentCountry);
        return new FilterIterator<>(allStudents.iterator(), fromCountry);
    }

    @Override
    public TwoWayIterator<StudentInterface> users(String insertionOrder, String serviceName) {
        ServicesInterface service = getServiceByName(serviceName);
        if (!AppInterface.isValidInsertion(insertionOrder)) {
            throw new InvalidInsertionException();
        } else if (service == null) {
            throw new ServiceExistsException();
        } else if (!(service instanceof EatingService) && !(service instanceof LodgingService)) {
            throw new InvalidServiceTypeException();
        } else if (service.noStudents()) {
            throw new NoStudentsException();
        } else {
            if (service instanceof EatingService) {
                return ((EatingService) service).studentsInOrder();
            }
            return ((LodgingService) service).studentsInOrder();
        }
    }

    @Override
    public Iterator<ServicesInterface> servicesByStudent(String StudentName) {
        StudentInterface student = getStudentByName(StudentName);
        if (student == null) {
            throw new StudentDoesNotExistsException();
        } else if (student instanceof ThriftyStudent) {
            throw new ThriftyStudentException();
        } else if (student.noVisitedLocations()) {
            throw new NoVisitedLocations();
        } else {
            return student.visitedServices();
        }
    }

    @Override
    public Iterator<ListInArray<ServicesInterface>> servicesByStar() {
        if (getNumberOfServices() == 0) {
            throw new NoStudentsException();
        } else {
            return rankingServices.iterator();
        }
    }

    @Override
    public Iterator<ServicesInterface> closerToRanking(String serviceType, int star, String studentName) {
        if (star > 5 || star < 1) {
            throw new InvalidEvaluationException();
        }
        StudentInterface student = getStudentByName(studentName);
        if (student == null) {
            throw new StudentDoesNotExistsException();
        } else if (AppInterface.isnotValidService(serviceType.toUpperCase())) {
            throw new InvalidServiceTypeException();
        } else if (!hasServiceOfType(serviceType)) {
            throw new NoServiceOfTypeException();
        } else if (!hasServiceOfTypeandStar(serviceType, star)) {
            throw new NoServiceOfTypeAndStar();
        } else {
            return getCloserService(serviceType, star, student.getCurrentLocation());
        }

    }

    @Override
    public Iterator<ServicesInterface> servicesWithTag(String tag) {
        ListInArray<ServicesInterface> servicesWithTag = new ListInArray<>(LIST_DIMENSION);
        for (int i = 0; i < allServices.size();i++){
            if (allServices.get(i).hasTag(tag)){
                ServicesInterface service = allServices.get(i);
                servicesWithTag.addLast(service);
            }
        }
        if (servicesWithTag.isEmpty()){
            throw new NoServicesWithTag();
        }
        return servicesWithTag.iterator();
    }

    private Iterator<ServicesInterface> getCloserService(String serviceType, int star, String currentLocation) {
        ServicesInterface location = getServiceByName(currentLocation);
        switch (star){
            case 5: return servicesOfTypeAndStar(location,serviceType,rank5);
            case 4: return servicesOfTypeAndStar(location,serviceType,rank4);
            case 3: return servicesOfTypeAndStar(location,serviceType,rank3);
            case 2: return servicesOfTypeAndStar(location,serviceType,rank2);
            case 1: return servicesOfTypeAndStar(location,serviceType,rank1);
        }
        return null;
    }

    private Iterator<ServicesInterface> servicesOfTypeAndStar(ServicesInterface location, String serviceType, ListInArray<ServicesInterface> rank) {
        long latitude = location.getserviceLocation().getLatitude();
        long longitude = location.getserviceLocation().getLongitude();
        ListInArray<ServicesInterface> arrayOfServices = new ListInArray<>(AppInterface.LIST_DIMENSION);
        ListInArray<ServicesInterface> listOfLowestDistancedServices = new ListInArray<>(LIST_DIMENSION);
        long minimumValue = Long.MAX_VALUE;
        ServicesInterface lowestDistance = null;
        for (int i = 0; i < rank.size();i++){
            if (serviceType.equalsIgnoreCase(rank.get(i).getServiceType())){
                    arrayOfServices.addLast(rank.get(i));
            }
        }
        for (int i = 0; i < arrayOfServices.size();i++){
            long serviceLatitude = arrayOfServices.get(i).getserviceLocation().getLatitude();
            long serviceLongitude = arrayOfServices.get(i).getserviceLocation().getLongitude();
            long distance = Math.abs(serviceLatitude-latitude) + Math.abs(serviceLongitude-longitude);
            if (distance < minimumValue){
                minimumValue = distance;
                lowestDistance = arrayOfServices.get(i);
            }
        }
        listOfLowestDistancedServices.addLast(lowestDistance);
        for (int i = 0; i < arrayOfServices.size();i++){
            long serviceLatitude = arrayOfServices.get(i).getserviceLocation().getLatitude();
            long serviceLongitude = arrayOfServices.get(i).getserviceLocation().getLongitude();
            long distance = Math.abs(serviceLatitude-latitude) + Math.abs(serviceLongitude-longitude);
            if (distance == minimumValue && !arrayOfServices.get(i).equals(lowestDistance)){
                listOfLowestDistancedServices.addLast(arrayOfServices.get(i));
            }
        }
        return listOfLowestDistancedServices.iterator();
    }

    private boolean hasServiceOfType(String serviceType) {
        int i = 0;
        while (i < allServices.size()) {
            if (serviceType.equalsIgnoreCase(allServices.get(i).getServiceType())) {
                return true;
            }
                i++;
            }
        return false;
    }

    private boolean hasServiceOfTypeandStar(String serviceType, int star) {
        int i = 0;
        while (i < allServices.size()) {
            if (serviceType.equalsIgnoreCase(allServices.get(i).getServiceType()) && allServices.get(i).getAverageEvaluation() == star) {
                    return true;
                }
                i++;
            }
        return false;
    }
}