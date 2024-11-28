/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementations;

import utilities.Iterator;
import utilities.ListADT;
//import java.lang.reflect.Array;

/**
 *
 * @author user
 */
public class MyDLL<E> implements ListADT<E> {
    
    MyDLLNode<E> head;
    MyDLLNode<E> tail;
    int size;

       
    
    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Error: index out of range");
        }
        
        if (toAdd == null) {
            throw new NullPointerException("Array to add, is null");
        }
        
        MyDLLNode<E> newNode = new MyDLLNode<>(toAdd);
        
        if (index == 0) {
            if(!isEmpty()) {
                newNode.setNext(head);
                head.setPrev(newNode);
                head = newNode; 
            } else {
                head = newNode;
                tail = newNode;
            }
        } else if (index == size) {            
            return add(toAdd); 
        } else {
            MyDLLNode<E> current = getNode(index);
            MyDLLNode<E> prevNode = current.getPrev();
            
            prevNode.setNext(newNode);
            newNode.setPrev(prevNode);
            newNode.setNext(current);
            current.setPrev(newNode);                        
        }
        size++;        
        return true;         
    }

    @Override
    public boolean add(E toAdd) throws NullPointerException {
        
        if(toAdd == null){
            throw new NullPointerException("Error: Element to add is null");
        }
        
        MyDLLNode<E> newNode = new MyDLLNode(toAdd);
        if(isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode; 
        }
        
        size++;
        return true;        
    }
    
    @Override
    public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {        
        if (toAdd == null) {
            throw new NullPointerException("Error: List is null");
        }
        
        for (int i = 0; i < toAdd.size(); i++) {
            E element = toAdd.get(i);
            add(element);
        }
        return true;
    }
    

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Error: Index out of bounds.");
        }
        
        MyDLLNode<E> current = head; 
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        
        return current.getElement();
        
//        if(index < (size / 2)) {
//            current = head;
//            for (int i = 0; i < index; i++) {
//                current = current.getNext();
//            }
//        } else {
//            current = tail;
//            for (int i = size-1; i > index; i--) {
//                current = current.getPrev();
//            }
//        }
//        
//        return current.getElement();
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Error: Index out of range");
        }
        
        MyDLLNode<E> toDelete = this.getNode(index);  
                
        if (index == 0) {
            head = toDelete.getNext();
            if(head != null) 
                head.setPrev(null);
            
        } else if (index == size-1) {
            tail = toDelete.getPrev();
            if(tail != null)
                tail.setNext(null);      
                
        } else {        
            MyDLLNode<E> previous = toDelete.getPrev();
            MyDLLNode<E> after = toDelete.getNext();

            previous.setNext(after);
            after.setPrev(previous);
        }        
        toDelete.setPrev(null);
        toDelete.setNext(null);        
        size--;
        
        return toDelete.getElement();
    }

    
    @Override
    public E remove(E toRemove) throws NullPointerException {
        
        if (toRemove == null) {
            throw new NullPointerException("Error: element to remove is null");
        }
        
        MyDLLNode<E> current = head; 
        
        for (int i = 0;i < this.size();i++) {              
            if (current != null) {
                if (current.getElement().equals(toRemove)){
                    E toDelete = current.getElement();
                    remove(i);
                    
                    return toDelete;
                }                  
                current = current.getNext();
            }                                           
        }        
        
        return null; 
    }    
    

    @Override
    public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
        
       if (toChange == null) {
           throw new NullPointerException("Error: element to replace is null.");
       } 
       
       if(index >= size || index < 0){
           throw new IndexOutOfBoundsException("Error: Index " + index + " is out of bounds");
       }
                 
       MyDLLNode<E> node = getNode(index);    
       E oldElement = node.getElement();    //store element to return
       node.setElement(toChange);              
       return oldElement;
    }

    
    
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(E toFind) throws NullPointerException {
        if(toFind != null) {
            MyDLLNode<E> current = head;
            
            while(current != null){
                if(current.getElement().equals(toFind)) {
                    return true;
                }
                current = current.getNext();
            }
        } else {
            throw new NullPointerException("Error: Element cannot be null");
        }       
        
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] newArray = new Object[size];
        MyDLLNode<E> current = head;        
        
        int i = 0;
        while (current != null) {
            newArray[i++] = current.getElement();
            current = current.getNext();
        }
        
        return newArray;
    }
    

    @Override
    public E[] toArray(E[] toHold) throws NullPointerException {
        if (toHold == null) {
            throw new NullPointerException("Error: array cannot be null.");
        }
        
//        if (toHold.length < size) {
//            toHold = (E[]) Array.newInstance(toHold.getClass().getComponentType(), size);      // create new array of correct size
//        }
        
        MyDLLNode<E> current = head; 
        int i = 0;
        while (current != null) {
            toHold[i++] = current.getElement();
            current = current.getNext();
        }
               
        return toHold;               
    }

    @Override
    public Iterator iterator() {
        MyDLLIterator<E> iterator = new MyDLLIterator<>(this);
        
        return iterator;
    }
    
    //helper method to acces node element
    private MyDLLNode<E> getNode(int index) throws IndexOutOfBoundsException {
        
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Error: Index out of bounds.");
        }

        MyDLLNode<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        return current;  
    }
}
