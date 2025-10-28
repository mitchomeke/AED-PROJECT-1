package dataStructures;
import dataStructures.exceptions.*;

import java.io.Serializable;

/**
 * List in Array
 * @author AED  Team
 * @version 1.0
 * @param <E> Generic Element
 *
 */
public class ListInArray<E> implements List<E>, Serializable {

    private static final int FACTOR = 2;
    /**
     * Array of generic elements E.
     */
    private E[] elems;

    /**
     * Number of elements in array.
     */
    private int counter;


    /**
     * Construtor with capacity.
     * @param dimension - initial capacity of array.
     */

    @SuppressWarnings("unchecked")
    public ListInArray(int dimension) {
        elems = (E[]) new Object[dimension];
        counter = 0;
    }
    /**
     * Returns true iff the list contains no elements.
     *
     * @return true if list is empty
     */
    public boolean isEmpty() {
        return counter==0;
    }

    /**
     * Returns the number of elements in the list.
     *
     * @return number of elements in the list
     */
    public int size() {
        return counter;
    }

    /**
     * Returns an iterator of the elements in the list (in proper sequence).
     *
     * @return Iterator of the elements in the list
     */
    public Iterator<E> iterator() {
        return new ArrayIterator<>(elems,counter);
    }

    /**
     * Returns the first element of the list.
     *
     * @return first element in the list
     * @throws NoSuchElementException - if size() == 0
     */
    public E getFirst() {
        //TODO: Left as an exercise.
        if (isEmpty()){
            throw new NoSuchElementException();
        } else {
            return elems[0];
        }
    }

    /**
     * Returns the last element of the list.
     *
     * @return last element in the list
     * @throws NoSuchElementException - if size() == 0
     */
    public E getLast() {
        //TODO: Left as an exercise.
        if (isEmpty()){
            throw new NoSuchElementException();
        } else {
            return elems[size()-1];
        }
    }

    /**
     * Returns the element at the specified position in the list.
     * Range of valid positions: 0, ..., size()-1.
     * If the specified position is 0, get corresponds to getFirst.
     * If the specified position is size()-1, get corresponds to getLast.
     *
     * @param position - position of element to be returned
     * @return element at position
     * @throws InvalidPositionException if position is not valid in the list
     */
    public E get(int position) {
        //TODO: Left as an exercise.
        if (isInvalidPosition(position)){
            throw new InvalidPositionException();
        }
        else if (position == 0){
            return getFirst();
        }
        else if (position == size()-1){
         return getLast();
        }
        else {
            return elems[position];
        }
    }

    /**
     * Returns the position of the first occurrence of the specified element
     * in the list, if the list contains the element.
     * Otherwise, returns -1.
     *
     * @param element - element to be searched in list
     * @return position of the first occurrence of the element in the list (or -1)
     */
    public int indexOf(E element) {
        //TODO: Left as an exercise.
        int index = 0;
        if (element == null){
            return NOT_FOUND;
        }
        while (index < size()){
            if (elems[index].equals(element)){
                return index;
            } else if (elems[index] == null) {
                return NOT_FOUND;
            }
            index++;
        }
        return NOT_FOUND;
    }
    private boolean isFull(){
       return size() == elems.length;
    }

    /**
     * Inserts the specified element at the first position in the list.
     *
     * @param element to be inserted
     */
    @SuppressWarnings("unchecked")
    public void addFirst(E element) {
        //TODO: Left as an exercise.
        if (isFull()){
            E[] temp = (E[]) new Object[size()*FACTOR];
            for (int i = 1; i < size()+1;i++){
                temp[i] = elems[i-1];
            }
            temp[0] = element;
            elems = temp;
        } else {
            shiftArrayRight(elems,element);
        }
        counter++;
    }

    private void shiftArrayRight(E[] elems, E element) {
        for (int i = size()-1; i >= 0 ;i--){
            elems[i+1] = elems[i];
        }
        elems[0] = element;
    }
    @SuppressWarnings("unchecked")
    private void growArray(){
        E[] temp = (E[]) new Object[size()*FACTOR];
        for (int i = 0; i < size();i++){
            temp[i] = elems[i];
        }
        elems = temp;
    }

    /**
     * Inserts the specified element at the last position in the list.
     *
     * @param element to be inserted
     */
    public void addLast(E element) {
        //TODO: Left as an exercise.
        if (isFull()){
            growArray();
        }
        elems[counter++] = element;
    }
    /**
     * Inserts the specified element at the specified position in the list.
     * Range of valid positions: 0, ..., size().
     * If the specified position is 0, add corresponds to addFirst.
     * If the specified position is size(), add corresponds to addLast.
     *
     * @param position - position where to insert element
     * @param element  - element to be inserted
     * @throws InvalidPositionException - if position is not valid in the list
     */
    public void add(int position, E element) {
        if (isInvalidPosition(position)){
            throw new InvalidPositionException();
        }
        else if (position == 0){
            addFirst(element);
        }
        else if (position == size()){
            addLast(element);
        }
        else {
            addMiddle(element,position);
        }
        //TODO: Left as an exercise.
    }

    private void addMiddle(E element,int position) {
        if (isFull()){
            growArray();
        }
        for (int i = size()-1; i >= position;i--){
            elems[i+1] = elems[i];
        }
        elems[position] = element;
        counter++;
    }

    /**
     * Removes and returns the element at the first position in the list.
     *
     * @return element removed from the first position of the list
     * @throws NoSuchElementException - if size() == 0
     */
    public E removeFirst() {
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        E element = elems[0];
            for (int i = 1; i < size();i++){
                elems[i-1] = elems[i];
        }
            counter--;

        return element;
    }

    /**
     * Removes and returns the element at the last position in the list.
     *
     * @return element removed from the last position of the list
     * @throws NoSuchElementException - if size() == 0
     */
    public E removeLast() {
        if (isEmpty()){
            throw new NoSuchElementException();
        }
            E element = elems[size()-1];
            elems[size()-1] = null;
            counter--;
        //TODO: Left as an exercise.
        return element;
    }
    private E removeMiddle(int position){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        E element = elems[position];
            for (int i = position + 1; i < size(); i++){
                elems[i-1] = elems[i];
        }
            elems[size()-1] = null;
            counter--;
            return element;
    }
    private boolean isInvalidPosition(int position){
        return position < 0 || position > size();
    }

    /**
     * Removes and returns the element at the specified position in the list.
     * Range of valid positions: 0, ..., size()-1.
     * If the specified position is 0, remove corresponds to removeFirst.
     * If the specified position is size()-1, remove corresponds to removeLast.
     *
     * @param position - position of element to be removed
     * @return element removed at position
     * @throws InvalidPositionException - if position is not valid in the list
     */
    public E remove(int position) {
        //TODO: Left as an exercise.
        if (isInvalidPosition(position)){
            throw new InvalidPositionException();
        }
        else if (position == 0){
           return removeFirst();
        }
        else if (position == size()-1){
            return removeLast();
        }
        else {
            return removeMiddle(position);
        }
    }
}
