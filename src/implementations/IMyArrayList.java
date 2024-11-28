/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementations;

import java.util.NoSuchElementException;
import utilities.Iterator;

/**
 *
 * @author mailt
 */
public class IMyArrayList<E> implements Iterator<E> {
    
    private MyArrayList<E> data;
    int size;
    int index;

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
