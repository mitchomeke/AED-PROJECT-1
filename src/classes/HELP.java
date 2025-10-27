package classes;

public enum HELP {
    BOUNDS("bounds - Defines the new geographic bounding rectangle"),
    SAVE("save - Saves the current geographic bounding rectangle to a text file"),
    LOAD("load - Load a geographic bounding rectangle from a text file"),
    SERVICE("service - Adds a new service to the current geographic bounding rectangle. The service may be eating, lodging or leisure"),
    SERVICES("services - Displays the list of services in current geographic bounding rectangle, in order of registration"),
    STUDENT("student - Adds a student to the current geographic bounding rectangle"),
    STUDENTS("students - Lists all the students or those of a given country in the current geographic bounding rectangle, in alphabetical order of the student's name"),
    LEAVE("leave - Removes a student from the the current geographic bounding rectangle"),
    GO("go - Changes the location of a student to a leisure service, or eating service"),
    MOVE("move - Changes the home of a student"),
    USERS("users - List all students who are in a given service (eating or lodging)"),
    STAR("star - Evaluates a service"),
    WHERE("where - Locates a student"),
    VISITED("visited - Lists locations visited by one student"),
    RANKING("ranking - Lists services ordered by star"),
    RANKED("ranked - Lists the service(s) of the indicated type with the given score that are closer to the student location"),
    TAG("tag - Lists all services that have at least one review whose description contains the specified word"),
    FIND("find - Finds the most relevant service of a certain type, for a specific student"),
    HELP("help - Shows the available commands"),
    EXIT("exit - Terminates the execution of the program");

    String helpMsg;

    HELP(String s){
        helpMsg = s;
    }
    public String getHelpMsg(){
        return helpMsg;
    }


}
