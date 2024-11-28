/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementations;

import java.util.NoSuchElementException;
import utilities.Iterator;

/**
 *
 * @author user
 */
public class MyDLLIterator<E> implements Iterator<E> {

    MyDLL<E> dll;
    int size;
    MyDLLNode<E> currentNode;
    

    public MyDLLIterator(MyDLL<E> dll) {
        this.dll = dll;
        this.currentNode = dll.head;
        size = dll.size;
    }
    
    @Override
    public boolean hasNext() {
        return currentNode != null;
    }

    @Override
    public E next() throws NoSuchElementException {
        
        if(!hasNext()) {
            throw new NoSuchElementException();
        }        
        
        E element = currentNode.getElement();
        currentNode = currentNode.getNext();
        
        return element; 
    }
    
    
}
