/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementations;

import utilities.Iterator;
import utilities.ListADT;

/**
 *
 * @author mailt
 */
public class MyArrayList<E> implements ListADT<E> {
    private E[] elements;
    private int size;

    public MyArrayList(E[] elements) {
        this.elements = elements;
        this.size=elements.length;
    }
    
    public MyArrayList() {
        this.size=0;
        this.elements=(E[])new Object[size];
    }

    public E[] getElements() {
        return elements;
    }
    
    
    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {
        elements=null;
        this.size=0;
    }

    @Override
    public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException{
        if(toAdd == null){
            throw new NullPointerException("Error: index out of range");
        }
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Error: index out of range");
        }
        else{
            Object[] objects= new Object[size + 1];
            E[] newdata=(E[]) objects;
            for(int i=0;i<index;i++){
                newdata[i]=elements[i];
            }
            newdata[index]=toAdd;
            for(int i=index;i<size;i++){
                newdata[i+1]=elements[i];
            }
            elements=newdata;
            size++;
        }
        
        return true;
    }

    @Override
    public boolean add(E toAdd) throws NullPointerException {
        if(toAdd==null){
            throw new NullPointerException("Error: index out of range");
        }
        Object[] objects= new Object[size + 1];
        E[] newdata=(E[]) objects;
        for(int i=0;i<size;i++){
            newdata[i]=elements[i];
        }
        newdata[size++]=toAdd;
        elements=newdata;
        return true;
    }

    @Override
    public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
       
       if(toAdd == null) {
           throw new NullPointerException("Error: array is null");
       } 
       
//       if(size) {
            for(int i=0;i<toAdd.size();i++){
                //elements[i] = toAdd.get(i);
                add(toAdd.get(i));
            }
//       }

       return true;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        
        if (index >= size || index < 0)
            throw new  IndexOutOfBoundsException("Error: Index out of range.");
        
        return elements[index];
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Error: Index out of range");
        }
        E removed = null;
        Object[] objects= new Object[size - 1];
        E[] newdata=(E[]) objects;
        
        int j=0;
        for(int i=0;i<size;i++)
        {
            if(i!=index){
                newdata[j++]=elements[i];
            }
            else{
                removed = elements[index];
            }
        }
        elements = newdata;
        size--;
        return removed;        
        
    }

    @Override
    public E remove(E toRemove) throws NullPointerException {
        if (toRemove == null) {
            throw new NullPointerException("Error: element to remove is null");
        }
        for (int i = 0; i < elements.length; i++) {
            if (elements[i].equals(toRemove)) {
                return remove(i);
            }
        }          
        
        return null;
    }

    @Override
    public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
        if (toChange == null) {
           throw new NullPointerException("Error: element to replace is null.");
        } 
        if (index >= size || index < 0) {
           throw new IndexOutOfBoundsException("Error: Index out of range");
        }
        
        E prevElement = elements[index];

        for(int i = 0;i<elements.length;i++){
            if(index == i){
                elements[i] = toChange;
            }
        }   
        
        return prevElement;
    }

    @Override
    public boolean isEmpty() {
        return this.size==0;
    }

    @Override
    public boolean contains(E toFind) throws NullPointerException {
        if(toFind != null) {
            for(int i=0;i<elements.length;i++){
                if(elements[i].equals(toFind))return true;
            }
        }
        else
        {
            throw new NullPointerException("Error: Element cannot be null");
        }
        
        return false;
    }

    @Override
    public E[] toArray(E[] toHold) throws NullPointerException {
        if (toHold == null) {
            throw new NullPointerException("Error: array cannot be null.");
        }
        
        E[] result = toHold;
            
        for(int i=0;i<elements.length;i++){
            result[i]=elements[i];
        }
        return result;
    }
    

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        for(int i=0;i<elements.length;i++){
            result[i]=elements[i];
        }
        return result;
    }

    @Override
    public utilities.Iterator<E> iterator() {
        return new IMyArrayList<>(this);
//        return iterator;
      
    }
    
}


