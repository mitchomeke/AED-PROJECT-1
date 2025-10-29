package classes;
import dataStructures.DoublyLinkedList;
import dataStructures.TwoWayIterator;

import java.io.Serializable;
import java.security.Provider;

public class EatingService extends AbstractServices implements Serializable {
    //DoublyLinkedListOfStudents
    DoublyLinkedList<StudentInterface> students;
    //List of evaluations

    public EatingService(long latitude, long longitude, int price, int value, String serviceName, String serviceType){
        super(latitude,longitude,price,value,serviceName,serviceType);
        students = new DoublyLinkedList<>();
    }
    public int getMenuPrice(){
        return price;
    }
    public int getCapacity(){
        return value;
    }

    @Override
    public boolean noStudents() {
        return students.isEmpty();
    }

    @Override
    public void addEvaluaton(Evaluation evaluation) {
        evaluations.add(evalCounter++,evaluation);
    }

    @Override
    public int getPrice() {
        return getMenuPrice();
    }

    public boolean isFull(){
        return students.size() == value;
    }
    public void addStudent(StudentInterface student){
        if (!isFull()){
            students.addLast(student);
        }
    }
    public void removeStudent(StudentInterface student){
        if (hasStudent(student)){
            int studentIndex = students.indexOf(student);
            students.remove(studentIndex);
        }
    }
    public boolean hasStudent(StudentInterface student){
        int i = 0;
        while (i < students.size()){
            if (students.get(i).equals(student)){
                return true;
            }
            i++;
        }
        return false;
    }
    public TwoWayIterator<StudentInterface> studentsInOrder(){
        return students.twoWayiterator();
    }
}
