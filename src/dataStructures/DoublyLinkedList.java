package dataStructures;

import dataStructures.exceptions.InvalidPositionException;
import dataStructures.exceptions.NoSuchElementException;
import java.io.Serializable;
/**
 * Doubly Linked List
 *
 * @author AED team
 * @version 1.0
 *
 * @param <E> Generic Element
 */
public class DoublyLinkedList<E> implements TwoWayList<E>,Serializable {
    /**
     *  Node at the head of the list.
     */
    private DoublyListNode<E> head;
    /**
     * Node at the tail of the list.
     */
    private DoublyListNode<E> tail;
    /**
     * Number of elements in the list.
     */
    private int currentSize;

    /**
     * Constructor of an empty double linked list.
     * head and tail are initialized as null.
     * currentSize is initialized as 0.
     */
    public DoublyLinkedList() {
        head = null;
        tail = null;
        currentSize = 0;
        //TODO: Left as an exercise.
    }

    /**
     * Returns true iff the list contains no elements.
     * @return true if list is empty
     */
    public boolean isEmpty() {
        return currentSize == 0;
        //TODO: Left as an exercise.
    }

    /**
     * Returns the number of elements in the list.
     * @return number of elements in the list
     */

    public int size() {
        //TODO: Left as an exercise.
        return currentSize;
    }

    /**
     * Returns a two-way iterator of the elements in the list.
     *
     * @return Two-Way Iterator of the elements in the list
     */

    public TwoWayIterator<E> twoWayiterator() {
        return new TwoWayDoublyIterator<>(head, tail);
    }
    /**
     * Returns an iterator of the elements in the list (in proper sequence).
     * @return Iterator of the elements in the list
     */
    public Iterator<E> iterator() {
        return new DoublyIterator<>(head);
    }

    /**
     * Inserts the element at the first position in the list.
     * @param element - Element to be inserted
     */
    public void addFirst( E element ) {
        DoublyListNode<E> newFirst = new DoublyListNode<>(element);
        if (this.isEmpty()){
            tail = newFirst;
        } else {
            DoublyListNode<E> oldFirst = this.head;
            newFirst.setNext(oldFirst);
            oldFirst.setPrevious(newFirst);
        }
        head = newFirst;
        currentSize++;
        //TODO: Left as an exercise.
    }

    /**
     * Inserts the element at the last position in the list.
     * @param element - Element to be inserted
     */
    public void addLast( E element ) {
        DoublyListNode<E> newLast = new DoublyListNode<>(element);
        if (this.isEmpty()){
            head = newLast;
        } else {
            DoublyListNode<E> oldLast = this.tail;
            oldLast.setNext(newLast);
            newLast.setPrevious(oldLast);
        }
        tail = newLast;
        currentSize++;
        //TODO: Left as an exercise.
    }

    /**
     * Returns the first element of the list.
     * @return first element in the list
     * @throws NoSuchElementException - if size() == 0
     */
    public E getFirst( ) {
        //TODO: Left as an exercise.
        if (size() == 0){
            throw new NoSuchElementException();
        }
        return this.head.getElement();
    }

    /**
     * Returns the last element of the list.
     * @return last element in the list
     * @throws NoSuchElementException - if size() == 0
     */
    public E getLast( ) {
        //TODO: Left as an exercise.
        if (size() == 0){
            throw new NoSuchElementException();
        }
        return tail.getElement();
    }


    /**
     * Returns the element at the specified position in the list.
     * Range of valid positions: 0, ..., size()-1.
     * If the specified position is 0, get corresponds to getFirst.
     * If the specified position is size()-1, get corresponds to getLast.
     * @param position - position of element to be returned
     * @return element at position
     * @throws InvalidPositionException if position is not valid in the list
     */
    public E get( int position ) {
        //TODO: Left as an exercise.
        if (position < 0 || position >= size()){
            throw new InvalidPositionException();
        } else if (position == 0) {
            return this.getFirst();
        } else if (position == size()-1) {
            return this.getLast();
        } else {
            return this.getMiddle(position);
        }
    }

    private E getMiddle(int position) {
        return getNode(position).getElement();
    }

    /**
     * Returns the position of the first occurrence of the specified element
     * in the list, if the list contains the element.
     * Otherwise, returns -1.
     * @param element - element to be searched in list
     * @return position of the first occurrence of the element in the list (or -1)
     */
    public int indexOf( E element ) {
        //TODO: Left as an exercise.
        int index = 0;
        DoublyListNode<E> node = this.head;
        while (!node.getElement().equals(element) && index < size()){
            node = node.getNext();
            index++;
        }
        if (node.getElement() == null){
            return NOT_FOUND;
        }
        return index;
    }

    /**
     * Inserts the specified element at the specified position in the list.
     * Range of valid positions: 0, ..., size().
     * If the specified position is 0, add corresponds to addFirst.
     * If the specified position is size(), add corresponds to addLast.
     * @param position - position where to insert element
     * @param element - element to be inserted
     * @throws InvalidPositionException - if position is not valid in the list
     */
    public void add( int position, E element ){
        if (position < 0 || position > size()){
            throw new InvalidPositionException();
        }
        if (position == 0){
            addFirst(element);
        }
        else if (position == size()) {
            addLast(element);
        }
        else {
            addMiddle(element,position);
        }
        //TODO: Left as an exercise.
    }

    private void addMiddle(E element,int position) {
        DoublyListNode<E> newNode = new DoublyListNode<E>(element);
        DoublyListNode<E> prevNode = this.getNode(position-1);
        DoublyListNode<E> nextNode = prevNode.getNext();
        prevNode.setNext(newNode);
        newNode.setPrevious(prevNode);
        newNode.setNext(nextNode);
        nextNode.setPrevious(newNode);
        currentSize++;
    }

    private DoublyListNode<E> getNode(int position) {
        int i = 0;
        DoublyListNode<E> node = head;
        while (i < position){
            node = node.getNext();
            i++;
        }
        return node;
    }

    /**
     * Removes and returns the element at the first position in the list.
     * @return element removed from the first position of the list
     * @throws NoSuchElementException - if size() == 0
     */
    public E removeFirst( ) {
        //TODO: Left as an exercise.
        DoublyListNode<E> oldFirst = this.head;
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        if (this.head == this.tail){
            head = tail = null;
        } else {
            DoublyListNode<E> newFirst = oldFirst.getNext();
            oldFirst.setNext(null);
            newFirst.setPrevious(null);
            head = newFirst;
        }
        currentSize--;
        return oldFirst.getElement();
    }

    /**
     * Removes and returns the element at the last position in the list.
     * @return element removed from the last position of the list
     * @throws NoSuchElementException - if size() == 0
     */
    public E removeLast( ) {
        DoublyListNode<E> oldLast = this.tail;
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        if (this.head == this.tail){
            head = tail = null;
        } else {
            DoublyListNode<E> newLast = oldLast.getPrevious();
            oldLast.setPrevious(null);
            newLast.setNext(null);
            tail = newLast;
        }
        currentSize--;
        return oldLast.getElement();
    }

    /**
     *  Removes and returns the element at the specified position in the list.
     * Range of valid positions: 0, ..., size()-1.
     * If the specified position is 0, remove corresponds to removeFirst.
     * If the specified position is size()-1, remove corresponds to removeLast.
     * @param position - position of element to be removed
     * @return element removed at position
     * @throws InvalidPositionException - if position is not valid in the list
     */
    public E remove( int position ) {
        //TODO: Left as an exercise.
        if (position < 0 || position > size()-1){
            throw new InvalidPositionException();
        }
        else if (position == 0){
            return removeFirst();
        }
        else if (position == size()-1) {
            return removeLast();
        }
        else
            return removeMiddle(position);
    }

    private E removeMiddle(int position){
        DoublyListNode<E> toBeRemoved = getNode(position);
        DoublyListNode<E> previous = toBeRemoved.getPrevious();
        DoublyListNode<E> next = toBeRemoved.getNext();
        toBeRemoved.setNext(null);
        toBeRemoved.setPrevious(null);
        previous.setNext(next);
        next.setPrevious(previous);
        currentSize--;
        return toBeRemoved.getElement();
    }
}