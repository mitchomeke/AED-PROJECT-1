package classes;
import dataStructures.DoublyLinkedList;
import dataStructures.ListInArray;
import dataStructures.TwoWayIterator;

import java.io.Serializable;

public class LodgingService extends AbstractServices implements Serializable {
    //List Of Students
    DoublyLinkedList<StudentInterface> allStudents;
    //ListOfEvaluations
    public LodgingService(long latitude, long longitude, int price, int value, String serviceName, String seviceType) {
        super(latitude, longitude, price, value, serviceName,seviceType);
        allStudents = new DoublyLinkedList<>();
    }
    public int getRoomPrice(){
        return price;
    }
    public int getCapacity(){
        return value;
    }

    @Override
    public int getAverageEvaluation() {
        computeEvaluation();
        return averageEvaluation;
    }

    @Override
    public String getserviceName() {
        return serviceName;
    }

    @Override
    public GeographicLocationClass getserviceLocation() {
        return serviceLocation;
    }

    @Override
    public boolean noStudents() {
        return allStudents.isEmpty();
    }

    @Override
    public void addEvaluaton(Evaluation evaluation) {
        evaluations.add(evalCounter++,evaluation);
    }

    @Override
    public void computeEvaluation() {
        float average = 0;
        for (int i = 0; i < evaluations.size();i++){
            average = average + evaluations.get(i).getStars();
        }
        averageEvaluation = Math.round(average/evalCounter);
    }

    @Override
    public void setOldEval(int eval) {
        oldAverageEval = eval;

    }

    @Override
    public int getOldEval() {
        return oldAverageEval;
    }

    @Override
    public boolean hasEvalChanged() {
        return oldAverageEval != getAverageEvaluation();
    }

    @Override
    public int getPrice() {
        return getRoomPrice();
    }


    public boolean canAddStudent(){
       return allStudents.size() < getCapacity();
    }
    public void addStudent(StudentInterface student){
        if (canAddStudent()){
            allStudents.addLast(student);
        }
    }
    public void removeStudent(StudentInterface student){
        if (hasStudent(student)){
            int studentIndex = allStudents.indexOf(student);
            allStudents.remove(studentIndex);
        }
    }
    public boolean hasStudent(StudentInterface student) {
        int i = 0;
        while (i < allStudents.size()){
            if (allStudents.get(i).equals(student)){
                return true;
            }
            i++;
        }
        return false;
    }

    public TwoWayIterator<StudentInterface> studentsInOrder(){
        return allStudents.twoWayiterator();
    }
}
