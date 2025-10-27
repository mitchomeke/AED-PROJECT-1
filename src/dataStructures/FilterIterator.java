package dataStructures;

import dataStructures.exceptions.NoSuchElementException;

import java.io.Serializable;

/**
 * Iterator Abstract Data Type with Filter
 * Includes description of general methods for one way iterator.
 * @author AED  Team
 * @version 1.0
 * @param <E> Generic Element
 *
 */
public class FilterIterator<E> implements Iterator<E>, Serializable {

    /**
     *  Iterator of elements to filter.
     */
    private final Iterator<E> iterator;

    /**
     *  Filter.
     */
    private final Predicate<E> filter;

    /**
     * Node with the next element in the iteration.
     */
    private E nextToReturn;

    /**
     *
     * @param list to be iterated
     * @param filter
     */
    public FilterIterator(Iterator<E> list, Predicate<E> filter) {
        //TODO: Left as an exercise.
        iterator = list;
        this.filter = filter;
        advance();
    }

    private void advance() {
        nextToReturn = null;
        while (iterator.hasNext()){
            E current = iterator.next();
            if (filter.check(current)){
                nextToReturn = current;
                break;
            }
        }
    }

    /**
     * Returns true if next would return an element
     *
     * @return true iff the iteration has more elements
     */
    public boolean hasNext() {
        //TODO: Left as an exercise.
        return nextToReturn != null;
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException - if call is made without verifying pre-condition
     */
    public E next() {
        E current = nextToReturn;
        //TODO: Left as an exercise.
        advance();
        return current;
    }

    /**
     * Restarts the iteration.
     * After rewind, if the iteration is not empty, next will return the first element.
     */
    public void rewind() {
        //TODO: Left as an exercise.
        iterator.rewind();
        advance();
    }

}
