package implementations;

import java.util.NoSuchElementException;
import utilities.Iterator;

/**
 * Iterator for the MyArrayList implementation.
 *
 * @param <E> The type of elements in the array list.
 */
public class IMyArrayList<E> implements Iterator<E> {
    
    private MyArrayList<E> data;
    int size;
    int index;

    /**
     * Constructs an iterator for the specified MyArrayList.
     * 
     * @param data The MyArrayList to iterate over.
     */
    public IMyArrayList(MyArrayList<E> data) {
        this.data = data;
        this.size = data.size();
        this.index = -1;
    }

    @Override
    public boolean hasNext() {
        return index < size -1;
    }

    @Override
    public E next() throws NoSuchElementException {
        if (!hasNext()) {
            throw new NoSuchElementException("No more elements to iterate over.");
        }
        
        return data.get(++index);
    }
}