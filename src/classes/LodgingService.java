package classes;
import dataStructures.DoublyLinkedList;
import dataStructures.ListInArray;
import dataStructures.TwoWayIterator;

import java.io.Serializable;

public class LodgingService extends AbstractServices implements Serializable {
   private DoublyLinkedList<StudentInterface> allStudents;
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
    public boolean noStudents() {
        return allStudents.isEmpty();
    }

    @Override
    public int getPrice() {
        return price;
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
