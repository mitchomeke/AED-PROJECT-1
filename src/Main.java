import java.io.*;
import java.util.Scanner;

import dataStructures.*;
import exceptions.*;
import classes.*;
import classes.exceptions.*;

import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final String EXIT_COMMAND = "EXIT";
    private static final String UNKNOWN_COMMAND = "Unknown command. Type help to see available commands\n";
    private static final String EXIT_RESPONSE = "Bye!\n";
    private static final String HELP_COMMAND = "HELP";
    private static final String BOUNDS_COMMAND = "BOUNDS";
    private static final String SAVE_COMMAND = "SAVE";
    private static final String LOAD_COMMAND = "LOAD";
    private static final String SERVICE_COMMAND = "SERVICE";
    private static final String SERVICES_COMMAND = "SERVICES";
    private static final String STUDENT_COMMAND = "STUDENT";
    private static final String LEAVE_COMMAND = "LEAVE";
    private static final String STUDENTS_COMMAND = "STUDENTS";
    private static final String GO_COMMAND = "GO";
    private static final String MOVE_COMMAND = "MOVE";
    private static final String USERS_COMMAND = "USERS";
    private static final String WHERE_COMMAND = "WHERE";
    private static final String VISITED_COMMAND = "VISITED";
    private static final String STAR_COMMAND = "STAR";
    private static final String RANKING_COMMAND = "RANKING";
    private static final String RANKED_COMMAND = "RANKED";
    private static final String TAG_COMMAND = "TAG";
    private static final String FIND_COMMAND = "FIND";
    private static final String BOUNDS_EXISTS = "Bounds already exists. Please load it!\n";
    private static final String INVALID_BOUNDS = "Invalid bounds.\n";
    private static final String AREA_CREATED = "%s created.\n";
    private static final String AREA_SAVED = "%s saved.\n";
    private static final String BOUNDS_NOT_DEFINED = "System bounds not defined.\n";
    private static final String BOUNDS_DOES_NOT_EXIST = "Bounds %s does not exists.\n";
    private static final String BOUNDS_LOADED = "%s loaded.\n";
    private static final String SERVICE_ADDED = "%s %s added.\n";
    private static final String INVALID_SERVICE = "Invalid service type!\n";
    private static final String INVALID_LOCATION = "Invalid location!\n";
    private static final String INVALID_MENU = "Invalid menu price!\n";
    private static final String INVALID_ROOM = "Invalid room price!\n";
    private static final String INVALID_TICKET = "Invalid ticket price!\n";
    private static final String INVALID_DISCOUNT = "Invalid discount price!\n";
    private static final String INVALID_CAPACITY = "Invalid capacity!\n";
    private static final String SERVICE_ALREADY_EXISTS = "%s already exists!\n";
    private static final String NO_SERVICES = "No services yet!\n";
    private static final String SERVICE_LINE = "%s: %s (%d, %d).\n";
    private static final String INVALID_STUDENT = "Invalid student type!\n";
    private static final String LODGING_DOESNT_EXIST = "lodging %s does not exist!\n";
    private static final String LODGING_FULL = "lodging %s is full!\n";
    private static final String STUDENT_EXISTS = "%s already exists!\n";
    private static final String STUDENT_ADDED = "%s added.\n";
    private static final String STUDENT_DOESNT_EXIST = "%s does not exist!\n";
    private static final String STUDENT_LEFT = "%s has left.\n";
    private static final String NO_STUDENTS_YET = "No students yet!\n";
    private static final String NO_STUDENTS_FROM_COUNTRY = "No students from %s!\n";
    private static final String STUDENTS_LINE = "%s: %s at %s.\n";
    private static final String UNKNOWN_LOCATION = "Unknown %s!\n";
    private static final String LOCATION_NOT_VALID = "%s is not a valid service!\n";
    private static final String ALREADY_THERE = "Already there!\n";
    private static final String EATING_SERVICE_IS_FULL = "eating %s is full!\n";
    private static final String STUDENT_DISTRACTED = "%s is now at %s. %s is distracted!\n";
    private static final String STUDENT_WENT = "%s is now at %s.\n";
    private static final String ALREADY_HOME = "That is %s's home!\n";
    private static final String MOVE_NOT_ACCEPTABLE = "Move is not acceptable for %s!\n";
    private static final String STUDENT_HOME_CHANGED = "lodging %s is now %s's home. %s is at home.\n";
    private static final String ORDER_DONT_EXIST = "This order does not exists!\n";
    private static final String NEITHER_EATING_NOR_LODGING = "%s does not control student entry and exit!\n";
    private static final String NO_STUDENTS_FROM_SERVICE = "No students on %s!\n";
    private static final String SERVICE_DONT_EXIST = "%s does not exist!\n";
    private static final String USERS_LINE = "%s: %s\n";
    private static final String STUDENT_LOCATION = "%s is at %s %s (%d, %d).\n";
    private static final String THRIFTY_STUDENT = "%s is thrifty!\n";
    private static final String STUDENT_HAS_NO_LOCATIONS = "%s has not visited any locations!\n";
    private static final String INVALID_EVAL = "Invalid evaluation!\n";
    private static final String EVAL_REGISTERED = "Your evaluation has been registered!\n";
    private static final String NO_SERVICES_IN_SYSTEM = "No services in the system.\n";
    private static final String SERVICES_SORTED = "Services sorted in descending order\n";
    private static final String RANKING_LINE = "%s: %d\n";
    private static final String VISITED_LINE = "%s\n";
    private static final String INVALID_STARS = "Invalid stars!\n";
    private static final String NO_TYPE_OF_SERVICE = "No %s services!\n";
    private static final String NO_TYPE_WITH_AVERAGE = "No %s services with average!\n";
    private static final String RANKED_HEADER = "%s services closer with %d average\n";
    private static final String RANKED_LINE = "%s\n";
    private static final String NO_SERVICES_WITH_TAG = "There are no services with this tag!\n";
    private static final String TAG_LINE = "%s %s\n";
    private static final String FIND_LINE = "%s\n";
    private static final String ALL = "ALL";
    static App application;


    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        application = new App();
        String command;
        do {
                command = input.next().toUpperCase();
                switch (command){
                    case FIND_COMMAND -> find(application,input);
                    case TAG_COMMAND -> tag(application,input);
                    case RANKED_COMMAND -> ranked(application,input);
                    case RANKING_COMMAND -> ranking(application,input);
                    case STAR_COMMAND -> star(application,input);
                    case VISITED_COMMAND -> visited(application,input);
                    case WHERE_COMMAND -> where(application,input);
                    case USERS_COMMAND -> users(application,input);
                    case MOVE_COMMAND -> move(application,input);
                    case GO_COMMAND -> go(application,input);
                    case STUDENTS_COMMAND -> students(application,input);
                    case LEAVE_COMMAND -> leave(application,input);
                    case STUDENT_COMMAND -> student(application,input);
                    case SERVICES_COMMAND -> services(application);
                    case SERVICE_COMMAND -> service(application,input);
                    case LOAD_COMMAND -> load(application,input);
                    case SAVE_COMMAND -> save(application);
                    case BOUNDS_COMMAND -> bounds(application,input);
                    case HELP_COMMAND -> Help();
                    case EXIT_COMMAND -> exitSystem(application);
                    default -> System.out.printf(UNKNOWN_COMMAND);
                }
        } while (!command.equals(EXIT_COMMAND));
    }

    private static void ranking(App application, Scanner input) {
        try {
            Iterator<ListInArray<ServicesInterface>> iterator = application.servicesByStar();
            System.out.printf(SERVICES_SORTED);
            while (iterator.hasNext()){
                ListInArray<ServicesInterface> serviceList = iterator.next();
                Iterator<ServicesInterface> serviceListIterator = serviceList.iterator();
                while (serviceListIterator.hasNext()){
                    ServicesInterface service = serviceListIterator.next();
                    System.out.printf(RANKING_LINE,service.getserviceName(),service.getAverageEvaluation());
                }
            }
        } catch (NoServicesException e){
            System.out.printf(NO_SERVICES_IN_SYSTEM);
        }
    }

    private static void students(App application, Scanner input) {
        String argument = input.nextLine();
        if (application.getCurrentArea() == null){
            System.out.printf(BOUNDS_NOT_DEFINED);
        }
       else if (argument.trim().equalsIgnoreCase(ALL) && application.getNumberOfStudents() == 0){
            System.out.printf(NO_STUDENTS_YET);
        }
        else if (argument.trim().equalsIgnoreCase(ALL) && application.getNumberOfStudents() > 0){
            Iterator<StudentInterface> students = application.allStudents();
            iterateStudents(students);
        }
        else if (!argument.trim().equalsIgnoreCase(ALL) && application.getNumberOfStudentsFromCountry(argument.trim()) == 0){
            System.out.printf(NO_STUDENTS_FROM_COUNTRY,argument.trim());
        }
        else {
            FilterIterator<StudentInterface> students = application.allStudentsFromCountry(argument.trim());
            iterateStudents(students);
        }
    }
    private static void iterateStudents(Iterator<StudentInterface> students){
        while (students.hasNext()){
            StudentInterface student = students.next();
            if (student instanceof BookishStudent){
                System.out.printf(STUDENTS_LINE,student.getStudentName(),AppInterface.BOOKISH.toLowerCase(),student.getCurrentLocation());
            }
            else if (student instanceof OutgoingStudent){
                System.out.printf(STUDENTS_LINE,student.getStudentName(),AppInterface.OUTGOING.toLowerCase(),student.getCurrentLocation());
            }
            else {
                System.out.printf(STUDENTS_LINE,student.getStudentName(),AppInterface.THRIFTY.toLowerCase(),student.getCurrentLocation());
            }
        }
    }

    private static void find(App application, Scanner input){
        String studentName = input.nextLine();
        String serviceType = input.nextLine().toUpperCase();

        String trimmedStudentName = studentName.trim();
        String trimmedServiceType = serviceType.trim();

        try{
           String serviceName = application.findMostRelevantService(trimmedStudentName,trimmedServiceType);
           System.out.printf(FIND_LINE,serviceName);
        } catch (InvalidServiceTypeException e){
            System.out.printf(INVALID_SERVICE);
        } catch (StudentDoesNotExistsException e){
            System.out.printf(STUDENT_DOESNT_EXIST,trimmedStudentName);
        } catch (NoServiceOfTypeException e){
            System.out.printf(NO_TYPE_OF_SERVICE,trimmedServiceType);
        }
    }

    private static void tag(App application, Scanner input) {
        //In order of insertion of services
        String tag = input.next();
        String trimmedTag = tag.trim();

        try {
            Iterator<ServicesInterface> services = application.servicesWithTag(trimmedTag);
            while (services.hasNext()){
                ServicesInterface service = services.next();
                    System.out.printf(TAG_LINE,service.getServiceType().toLowerCase(),service.getserviceName());
            }
        }catch (NoServicesWithTag e){
            System.out.printf(NO_SERVICES_WITH_TAG);
        }

    }

    private static void ranked(App application, Scanner input) {
        String serviceType = input.next().trim();
        int star = input.nextInt();
        String studentName = input.nextLine();

        try {
            Iterator<ServicesInterface> services = application.closerToRanking(serviceType,star,studentName.trim());
            System.out.printf(RANKED_HEADER,serviceType,star);
            while (services.hasNext()){
                ServicesInterface service = services.next();
                System.out.printf(RANKED_LINE,service.getserviceName());
            }
        } catch (InvalidEvaluationException e) {
            System.out.printf(INVALID_STARS);
        } catch (StudentDoesNotExistsException e){
            System.out.printf(STUDENT_DOESNT_EXIST,studentName.trim());
        } catch (InvalidServiceTypeException e) {
            System.out.printf(INVALID_SERVICE);
        } catch (NoServiceOfTypeException e){
            System.out.printf(NO_TYPE_OF_SERVICE,serviceType);
        } catch (NoServiceOfTypeAndStar e){
            System.out.printf(NO_TYPE_WITH_AVERAGE,serviceType);
        }
    }


    private static void star(App application, Scanner input) {
        int stars = input.nextInt();
        String serviceName = input.nextLine();
        String evaluationDescription = input.nextLine();

        String trimmedServiceName = serviceName.trim();
        String trimmedEval = evaluationDescription.trim();

        try {
            application.starService(stars,trimmedServiceName,trimmedEval);
            System.out.printf(EVAL_REGISTERED);
        } catch (InvalidEvaluationException e) {
            System.out.printf(INVALID_EVAL);
        } catch (ServiceExistsException e){
            System.out.printf(SERVICE_DONT_EXIST,trimmedServiceName);
        }
    }

    private static void visited(App application, Scanner input) {
        String studentName = input.nextLine();
        String trimmedStudentName = studentName.trim();

        try {
         Iterator<ServicesInterface> services =  application.servicesByStudent(trimmedStudentName);
         while(services.hasNext()){
             ServicesInterface service = services.next();
             System.out.printf(VISITED_LINE,service.getserviceName());
         }
        } catch (StudentDoesNotExistsException e){
            System.out.printf(STUDENT_DOESNT_EXIST,trimmedStudentName);
        } catch (ThriftyStudentException e){
            System.out.printf(THRIFTY_STUDENT,application.currentStudent.getStudentName());
        } catch (NoVisitedLocations e){
            System.out.printf(STUDENT_HAS_NO_LOCATIONS,application.currentStudent.getStudentName());
        }
    }

    private static void where(App application, Scanner input){
        String studentName = input.nextLine();
        String trimmedStudentName = studentName.trim();
        try{
            ServicesInterface service = application.where(studentName.trim());
            if (service instanceof LeisureService){
                System.out.printf(STUDENT_LOCATION,application.getStudentByName(studentName.trim()).getStudentName(),service.getserviceName(),AppInterface.LEISURE.toLowerCase(),service.getserviceLocation().getLatitude(),service.getserviceLocation().getLongitude());
            }
            else if (service instanceof LodgingService){
                System.out.printf(STUDENT_LOCATION,application.getStudentByName(studentName.trim()).getStudentName(),service.getserviceName(),AppInterface.LODGING.toLowerCase(),service.getserviceLocation().getLatitude(),service.getserviceLocation().getLongitude());
            }
            else {
                System.out.printf(STUDENT_LOCATION,application.getStudentByName(studentName.trim()).getStudentName(),service.getserviceName(),AppInterface.EATING.toLowerCase(),service.getserviceLocation().getLatitude(),service.getserviceLocation().getLongitude());
            }
        } catch (StudentDoesNotExistsException e) {
            System.out.printf(STUDENT_DOESNT_EXIST,trimmedStudentName);
        }
    }
    private static void printStudentLine(StudentInterface student){
        if (student instanceof BookishStudent){
            System.out.printf(USERS_LINE,student.getStudentName(),AppInterface.BOOKISH.toLowerCase());
        }
        else if (student instanceof OutgoingStudent){
            System.out.printf(USERS_LINE,student.getStudentName(),AppInterface.OUTGOING.toLowerCase());
        }
        else {
            System.out.printf(USERS_LINE,student.getStudentName(),AppInterface.THRIFTY.toLowerCase());
        }
    }
    private static void IterateStudentsFromServices(TwoWayIterator<StudentInterface> iterator, String insertionOrder, String trimmedServiceName, App application){
        if (insertionOrder.equals(AppInterface.OLDEST_TO_NEWEST)){
            int counter = 0;
            while (iterator.hasNext()){
                StudentInterface student = iterator.next();
                if (student.getCurrentLocation().equalsIgnoreCase(trimmedServiceName)){
                    printStudentLine(student);
                    counter++;
                }
            }
            if (counter == 0){
              System.out.printf(NO_STUDENTS_FROM_SERVICE,application.getServiceByName(trimmedServiceName).getserviceName());
            }
        } else {
            iterator.fullForward();
            int counter = 0;
            while (iterator.hasPrevious()){
                StudentInterface student = iterator.previous();
                if (student.getCurrentLocation().equalsIgnoreCase(trimmedServiceName)){
                    printStudentLine(student);
                    counter++;
                }
            }
            if (counter == 0){
                System.out.printf(NO_STUDENTS_FROM_SERVICE, application.getServiceByName(trimmedServiceName).getserviceName());
            }
        }
    }

    private static void users(App application, Scanner input) {
        String insertionOrder = input.next();
        String serviceName = input.nextLine();

        String trimmedInsertionOrder = insertionOrder.trim();
        String trimmedServiceName = serviceName.trim();

        try{
           TwoWayIterator<StudentInterface> iterator =  application.users(trimmedInsertionOrder,trimmedServiceName);
           IterateStudentsFromServices(iterator,trimmedInsertionOrder,trimmedServiceName,application);

        } catch (InvalidInsertionException e){
            System.out.printf(ORDER_DONT_EXIST);
        } catch (ServiceExistsException e){
            System.out.printf(SERVICE_DONT_EXIST,trimmedServiceName);
        } catch (InvalidServiceTypeException e){
            System.out.printf(NEITHER_EATING_NOR_LODGING,application.getServiceByName(trimmedServiceName).getserviceName());
        } catch (NoStudentsException e){
            System.out.printf(NO_STUDENTS_FROM_SERVICE,application.getServiceByName(trimmedServiceName).getserviceName());
        }
    }

    private static void move(App app, Scanner input){
        String studentName = input.nextLine();
        String lodgingName = input.nextLine();

        String trimmedStudentName = studentName.trim();
        String trimmedLodgingName = lodgingName.trim();

        try {
            app.moveStudent(trimmedStudentName,trimmedLodgingName);
            System.out.printf(STUDENT_HOME_CHANGED,app.getServiceByName(trimmedLodgingName).getserviceName(),app.currentStudent.getStudentName(),app.currentStudent.getStudentName());
        } catch (LodgingDoesntExistException e) {
            System.out.printf(LODGING_DOESNT_EXIST,trimmedLodgingName);
        } catch (StudentDoesNotExistsException e){
            System.out.printf(STUDENT_DOESNT_EXIST,trimmedStudentName);
        } catch (AlreadyHomeException e){
            System.out.printf(ALREADY_HOME,app.currentStudent.getStudentName());
        } catch (LodgingFullException e){
            System.out.printf(LODGING_FULL,trimmedLodgingName);
        } catch (MoveNotAcceptableException e){
            System.out.printf(MOVE_NOT_ACCEPTABLE,trimmedStudentName);
        }
    }

    private static void go(App application, Scanner input) {
        String studentName = input.nextLine();
        String serviceName = input.nextLine();

        String trimmedStudentName = studentName.trim();
        String trimmedServiceName = serviceName.trim();

        try {
            application.go(trimmedStudentName,trimmedServiceName);
            System.out.printf(STUDENT_WENT,application.currentStudent.getStudentName(),application.getServiceByName(trimmedServiceName).getserviceName());
        } catch (UnknownLocationException e) {
            System.out.printf(UNKNOWN_LOCATION,trimmedServiceName);
        } catch (StudentDoesNotExistsException e){
            System.out.printf(STUDENT_DOESNT_EXIST,trimmedStudentName);
        } catch (ServiceNotValidException e) {
            System.out.printf(LOCATION_NOT_VALID,trimmedServiceName);
        } catch (StudentAlreadyThereException e){
            System.out.printf(ALREADY_THERE);
        } catch (EatingServiceIsFullException e){
            System.out.printf(EATING_SERVICE_IS_FULL,trimmedServiceName);
        } catch (StudentisDistractedException e){
            System.out.printf(STUDENT_DISTRACTED,trimmedStudentName,trimmedServiceName,trimmedStudentName);
        }
    }

    private static void leave(App application, Scanner input) {
        String studentName = input.nextLine();
        try {
           StudentInterface student = application.leave(studentName.trim());
            System.out.printf(STUDENT_LEFT,student.getStudentName());
        } catch (StudentDoesNotExistsException e) {
            System.out.printf(STUDENT_DOESNT_EXIST,studentName.trim());
        }
    }

    private static void student(App app, Scanner input) {
        String studentType = input.next();
        input.nextLine();
        String studentName = input.nextLine();
        String Country = input.nextLine();
        String lodgingName = input.nextLine();

        String trimmedStudentType = studentType.trim();
        String trimmedStudentName = studentName.trim();
        String trimmedCountry = Country.trim();
        String trimmedLodgingName = lodgingName.trim();

        try {
            app.addStudent(trimmedStudentType,trimmedStudentName,trimmedCountry,trimmedLodgingName);
            System.out.printf(STUDENT_ADDED,trimmedStudentName);
        } catch (InvalidStudentTypeException e) {
            System.out.printf(INVALID_STUDENT);
        } catch (LodgingDoesntExistException e){
            System.out.printf(LODGING_DOESNT_EXIST,trimmedLodgingName);
        } catch (LodgingFullException e){
            System.out.printf(LODGING_FULL,trimmedLodgingName);
        } catch (studentExistsException e){
            System.out.printf(STUDENT_EXISTS,app.getStudentByName(trimmedStudentName).getStudentName());
        }
    }

    private static void services(App application) {
        if (application.getCurrentArea() == null){
            System.out.printf(BOUNDS_NOT_DEFINED);
        }
       else if (application.getNumberOfServices() == 0){
            System.out.printf(NO_SERVICES);
        }
        else {
            ArrayIterator<ServicesInterface> iterator = application.allServices();
            while (iterator.hasNext()){
                ServicesInterface service = iterator.next();
                if (service instanceof LeisureService){
                    System.out.printf(SERVICE_LINE,service.getserviceName(),AppInterface.LEISURE.toLowerCase(),service.getserviceLocation().getLatitude(),service.getserviceLocation().getLongitude());
                }
                else if (service instanceof EatingService){
                    System.out.printf(SERVICE_LINE,service.getserviceName(),AppInterface.EATING.toLowerCase(),service.getserviceLocation().getLatitude(),service.getserviceLocation().getLongitude());
                }
                else {
                    System.out.printf(SERVICE_LINE,service.getserviceName(),AppInterface.LODGING.toLowerCase(),service.getserviceLocation().getLatitude(),service.getserviceLocation().getLongitude());
                }
            }
        }
    }

    private static void service(App application, Scanner input) {
        String serviceType = input.next();
        long latitude = input.nextLong();
        long longitude = input.nextLong();
        int servicePrice = input.nextInt();
        int serviceValue = input.nextInt();
        String serviceName = input.nextLine();

        try{
            application.addService(serviceType.toUpperCase().trim(),latitude,longitude,servicePrice,serviceValue,serviceName.trim());
            System.out.printf(SERVICE_ADDED,serviceType.toLowerCase().trim(),serviceName.trim());
        } catch (InvalidServiceTypeException e) {
            System.out.printf(INVALID_SERVICE);
        }
        catch (OutsideRectangleException e){
            System.out.printf(INVALID_LOCATION);
        }
        catch (InvalidMenuPriceException e){
            System.out.printf(INVALID_MENU);
        }
        catch (InvalidRoomException e){
            System.out.printf(INVALID_ROOM);
        }
        catch (InvalidTicketPriceException e){
            System.out.printf(INVALID_TICKET);
        }
        catch (InvalidDiscountException e){
            System.out.printf(INVALID_DISCOUNT);
        }
        catch (InvalidCapacityException e){
            System.out.printf(INVALID_CAPACITY);
        }
        catch (ServiceExistsException e){
            System.out.printf(SERVICE_ALREADY_EXISTS,application.getServiceByName(serviceName.trim()).getserviceName());
        }
    }

    private static void load(App app, Scanner in){
        String areaName = in.nextLine();
        String fileName = app.splitName(areaName.trim())+".ser";
        App streamedObject = null;
            try(ObjectInputStream stream = new ObjectInputStream(new FileInputStream(fileName))){
                streamedObject = (App) stream.readObject();
                stream.close();
                if (streamedObject.canSaveArea()){
                    if (app.canSaveArea()){
                       saveArea(app);
                   }
                    System.out.printf(BOUNDS_LOADED,streamedObject.getCurrentAreaName());
                    setApplication(streamedObject);
                }
                else {
                    System.out.printf(BOUNDS_NOT_DEFINED);
                }
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
         catch (IOException e) {
            System.out.printf(BOUNDS_DOES_NOT_EXIST,areaName.trim());
        }
    }

    private static void setApplication(App streamedObject) {
        application = streamedObject;
        application.unSaveArea();
    }

    private static void exitSystem(App app){
        if (!app.isCurrentAreaSaved()){
         saveArea(app);
        }
        System.out.printf(EXIT_RESPONSE);
    }

    private static void saveArea(App app) {
        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(app.splitAreaName()+".ser"))){
            app.saveArea();
            stream.writeObject(app);
            stream.flush();
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void save(App app){
        if (app.canSaveArea()){
            saveArea(app);
            System.out.printf(AREA_SAVED,app.getCurrentAreaName());
        }
        else {
            System.out.printf(BOUNDS_NOT_DEFINED);
        }

    }
    private static void bounds(App app, Scanner in){
        long TopLatitude = in.nextLong();
        long leftLongitude = in.nextLong();
        long BottomLatitude = in.nextLong();
        long rightLongitude = in.nextLong();
        String AreaName = in.nextLine();
        try {
            App oldArea = app;
            application = (App) app.createArea(TopLatitude,leftLongitude,BottomLatitude, rightLongitude,AreaName.trim());
            if (oldArea.canSaveArea()){
                saveArea(oldArea);
            }
            System.out.printf(AREA_CREATED,AreaName.trim());
        } catch (AreaAlreadyExistsException e) {
            System.out.printf(BOUNDS_EXISTS);
        }
        catch (InvalidBoundsException e){
            System.out.printf(INVALID_BOUNDS);
        }
    }
    private static void Help () {
        HELP[] help = HELP.values();
        for (int i = 0; i < help.length;i++){
            System.out.println(help[i].getHelpMsg());
        }
    }
}