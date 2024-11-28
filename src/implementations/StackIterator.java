/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementations;

import java.util.NoSuchElementException;
import utilities.Iterator;

/**
 *
 * @author Emily
 */
public class StackIterator<T> implements Iterator<T> {
    MyStack<T> data;
    int size;
    int index;

    public StackIterator(MyStack<T> data) {
        this.data = data;
        this.size= data.size();
        this.index=-1;
    }
    
    @Override
    public boolean hasNext() {
        return this.index < this.size -1;
    }

//    @Override
//    public T next() throws NoSuchElementException {
//        return data.get(++index);
//    }

    
    @Override
    public T next() throws NoSuchElementException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
