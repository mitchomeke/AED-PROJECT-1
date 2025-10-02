import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.PrimitiveIterator;
import java.util.Scanner;
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
    private static final String GO_COMMAND = "GO";
    private static final String MOVE_COMMAND = "MOVE";
    private static final String USERS_COMMAND = "USERS";
    private static final String WHERE_COMMAND = "WHERE";
    private static final String VISITED_COMMAND = "VISITED";
    private static final String STAR_COMMAND = "STAR";
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

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        App application = new App();
        String command;
        do {
                command = input.next().toUpperCase();
                switch (command){
                    case FIND_COMMAND -> find(application,input);
                    case TAG_COMMAND -> tag(application,input);
                    case RANKED_COMMAND -> ranked(application,input);
                    case STAR_COMMAND -> star(application,input);
                    case VISITED_COMMAND -> visited(application,input);
                    case WHERE_COMMAND -> where(application,input);
                    case USERS_COMMAND -> users(application,input);
                    case MOVE_COMMAND -> move(application,input);
                    case GO_COMMAND -> go(application,input);
                    case LEAVE_COMMAND -> leave(application,input);
                    case STUDENT_COMMAND -> student(application,input);
                    case SERVICES_COMMAND -> services(application);
                    case SERVICE_COMMAND -> service(application,input);
                    case LOAD_COMMAND -> load(application,input);
                    case SAVE_COMMAND -> save(application);
                    case BOUNDS_COMMAND -> bounds(application,input);
                    case HELP_COMMAND -> Help();
                    case EXIT_COMMAND -> System.out.printf(EXIT_RESPONSE);
                    default -> System.out.printf(UNKNOWN_COMMAND);
                }
        } while (!command.equals(EXIT_COMMAND));
    }
    private static void find(App application, Scanner input){
        String studentName = input.nextLine();
        String serviceType = input.nextLine();



    }

    private static void tag(App application, Scanner input) {
        //In order of insertion of services
        String tag = input.nextLine();

    }

    private static void ranked(App application, Scanner input) {
        String serviceType = input.next().trim();
        int star = input.nextInt();
        String studentName = input.nextLine();
    }


    private static void star(App application, Scanner input) {
        int stars = input.nextInt();
        String serviceName = input.nextLine();
        String evaluationDescription = input.nextLine();

        try {
            application.starService(stars,serviceName.trim(),evaluationDescription.trim());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void visited(App application, Scanner input) {
    }

    private static void where(App application, Scanner input){
        String studentName = input.nextLine();
        try{
            application.where(studentName.trim());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void users(App application, Scanner input) {
        String insertionOrder = input.next().trim();
        String serviceName = input.nextLine();
    }

    private static void move(App application, Scanner input){
        String studentName = input.nextLine();
        String lodgingName = input.nextLine();

        try {
            application.moveStudent(studentName.trim(),lodgingName.trim());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void go(App application, Scanner input) {
        String studentName = input.nextLine();
        String serviceName = input.nextLine();

        try {
            application.go(studentName.trim(),serviceName.trim());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private static void leave(App application, Scanner input) {
        String studentName = input.next().trim();
        try {
            application.leave(studentName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void student(App application, Scanner input) {
        String studentType = input.next().trim();
        String studentName = input.nextLine();
        String Country = input.nextLine();
        String lodgingName = input.nextLine();

        try {
            application.addStudent(studentType,studentName,Country,lodgingName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private static void services(App application) {

    }

    private static void service(App application, Scanner input) {
        String serviceType = input.next();
        long latitude = input.nextLong();
        long longitude = input.nextLong();
        int servicePrice = input.nextInt();
        int serviceValue = input.nextInt();
        String serviceName = input.nextLine();

        try{
            application.addService(serviceType,latitude,longitude,servicePrice,serviceValue,serviceName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void load(App app, Scanner in){
        String areaName = in.nextLine();
        try {
            app.load(areaName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    private static void save(App app){
        try{
            app.saveArea();
            System.out.printf(AREA_CREATED,app.getCurrentAreaName());
        } catch (BoundsNotDefinedException e){
            System.out.printf(BOUNDS_NOT_DEFINED);
        }
    }
    private static void bounds(App app, Scanner in){
        long TopLatitude = in.nextLong();
        long TopLongitude = in.nextLong();
        long BottomLatitude = in.nextLong();
        long BottomLongitude = in.nextLong();
        String AreaName = in.nextLine();
        try {
            app.createArea(TopLatitude,TopLongitude,BottomLatitude,BottomLongitude,AreaName.trim());
            System.out.printf(AREA_CREATED,AreaName.trim());
        } catch (AreaAlreadyExistsException e) {
            System.out.printf(BOUNDS_EXISTS);
        }
        catch (InvalidBoundsException e){
            System.out.printf(INVALID_BOUNDS);
        }
    }
    private static void Help () throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\PC\\IdeaProjects\\AED Project 1\\src\\help-commands"));
        String line;
        while ((line = reader.readLine()) != null){
            System.out.println(line);
        }
    }
}