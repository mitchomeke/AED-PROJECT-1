package dataStructures;

import dataStructures.exceptions.*;

import java.io.Serializable;


/**
 * Sorted Doubly linked list Implementation
 * @author AED  Team
 * @version 1.0
 * @param <E> Generic Element
 *
 */
public class SortedDoublyLinkedList<E> implements SortedList<E>, Serializable {

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
     * Comparator of elements.
     */
    private final Comparator<E> comparator;
    /**
     * Constructor of an empty sorted double linked list.
     * head and tail are initialized as null.
     * currentSize is initialized as 0.
     */
    public SortedDoublyLinkedList(Comparator<E> comparator) {
        //TODO: Left as an exercise.
        this.comparator = comparator;
        head = null;
        tail = null;
        currentSize = 0;
    }

    /**
     * Returns true iff the list contains no elements.
     * @return true if list is empty
     */
    public boolean isEmpty() {
        return currentSize==0;
    }

    /**
     * Returns the number of elements in the list.
     * @return number of elements in the list
     */

    public int size() {
        return currentSize;
    }

    /**
     * Returns an iterator of the elements in the list (in proper sequence).
     * @return Iterator of the elements in the list
     */
    public Iterator<E> iterator() {
        return new DoublyIterator<>(head);
    }

    /**
     * Returns the first element of the list.
     * @return first element in the list
     * @throws NoSuchElementException - if size() == 0
     */
    public E getMin( ) {
        //TODO: Left as an exercise.
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return head.getElement();
    }

    /**
     * Returns the last element of the list.
     * @return last element in the list
     * @throws NoSuchElementException - if size() == 0
     */
    public E getMax( ) {
        //TODO: Left as an exercise.
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return tail.getElement();
    }
    /**
     * Returns the first occurrence of the element equals to the given element in the list.
     * @return element in the list or null
     */
    public E get(E element) {
        DoublyListNode<E> temp = head;
        while (temp != null) {
            if (temp.getElement().equals(element))
                return temp.getElement();
            temp = temp.getNext();
        }
        return null;
    }


    /**
     * Returns true iff the element exists in the list.
     *
     * @param element to be found
     * @return true iff the element exists in the list.
     */
    public boolean contains(E element) {
        if (isEmpty()) return false;

        DoublyListNode<E> temp = head;
        while (temp != null) {
            int cmp = comparator.compare(element, temp.getElement());
            if (cmp == 0) return true;
            if (cmp < 0) return false;
            temp = temp.getNext();
        }
        return false;
    }



    /**
     * Inserts the specified element at the list, according to the natural order.
     * If there is an equal element, the new element is inserted after it.
     * @param element to be inserted
     */
    public void add(E element) {
        DoublyListNode<E> newNode = new DoublyListNode<>(element);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            DoublyListNode<E> current = head;

            while (current != null && comparator.compare(element, current.getElement()) >= 0) {
                current = current.getNext();
            }
            if (current == head) {
                newNode.setNext(head);
                head.setPrevious(newNode);
                head = newNode;
            } else if (current == null) {
                tail.setNext(newNode);
                newNode.setPrevious(tail);
                tail = newNode;
            } else {
                DoublyListNode<E> prev = current.getPrevious();
                prev.setNext(newNode);
                newNode.setPrevious(prev);
                newNode.setNext(current);
                current.setPrevious(newNode);
            }
        }
        currentSize++;
    }



    /**
     * Removes and returns the first occurrence of the element equals to the given element in the list.
     * @return element removed from the list or null if !belongs(element)
     */
    public E remove(E element) {
        if (isEmpty()) return null;
        DoublyListNode<E> node = head;
        while (node != null) {
            int cmp = comparator.compare(element, node.getElement());
            if (cmp == 0) break;
            if (cmp < 0) return null;
            node = node.getNext();
        }
        if (node == null) return null;
        E removedElement = node.getElement();
        if (node == head) removeHead();
        else if (node == tail) removeTail();
        else removeMiddle(node);
        return removedElement;
    }

    private void removeHead() {
        head = head.getNext();
        if (head != null) head.setPrevious(null);
        else tail = null;
        currentSize--;
    }

    private void removeTail() {
        tail = tail.getPrevious();
        if (tail != null) tail.setNext(null);
        else head = null;
        currentSize--;
    }

    private void removeMiddle(DoublyListNode<E> node) {
        DoublyListNode<E> before = node.getPrevious();
        DoublyListNode<E> after = node.getNext();
        before.setNext(after);
        after.setPrevious(before);
        currentSize--;
    }
}
