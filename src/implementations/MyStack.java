/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementations;

import java.util.EmptyStackException;
import utilities.Iterator;
import utilities.StackADT;

/**
 *
 * @author mailt
 */
public class MyStack<T> implements StackADT<T> {
    private T[] data;//data
    int depth; //size
    int top; // index top
    int capacity;//how many item can contain in the stack
    
    public MyStack(int capacity) {
        this.capacity = capacity;
        data = (T[]) new Object[capacity];
        this.depth = 0;
        this.top = -1;
        
    }

    public MyStack() {
        this.capacity = 100;
        data=(T[])new Object[capacity];
        this.depth = 0;
        this.top = -1;
    }
    
    @Override
    public void push(T element)throws NullPointerException {
        if(element==null){
            throw new NullPointerException("Element is null!!!");
        }
        data[++top]=element;
    }

    

    @Override
    public T peek()throws EmptyStackException {
        if(top < 0){
            throw new EmptyStackException();
        }
        return data[top];
        
    }

    @Override
    public boolean isEmpty() {
         return this.top==-1;
    }

    @Override
    public int size() {
       return this.top + 1;
    }

    @Override
    public void clear() {
        data=null;
        this.depth=0;
        this.top =-1;
    }

    @Override
    public boolean contains(T element) throws NullPointerException {
        if(element != null) {
            for(int i=0;i<data.length;i++){
                if(data[i]!=null){
                    if(data[i].equals(element))return true;
                }
            }
        }
        else
        {
            throw new NullPointerException("Error: Element cannot be null");
        }
        
        return false; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

//    @Override
//    public Iterator<T> iterator() {
//        StackIterator<T> iterator = new StackIterator<>(this);
//        return iterator; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    } 
    @Override
    public int search(T element) {
        //T p = null;
        int depth=depth();
        for(int i=0;i<depth;i++){
            //p=data[top];
            if(peek()==element){
                return top + 1;
            }
            --top;
        }
        return -1;
        
    }

    @Override
    public T[] toArray(T[] toHold) throws NullPointerException {
        if (toHold == null) {
            throw new NullPointerException("Error: array cannot be null.");
        }
        T[] result = toHold;
        int depth=depth();
        for(int i=0;i<depth;i++){
            result[i]=peek();
            --top;
        }
        return result; 
    }
    public int depth(){
        return top+1;
    }
    @Override
    public Object[] toArray() {
        /*
        Object[] result = new Object[depth];
        for(int i=0;i<data.length;i++){
            result[i]=data[i];
        }
        return result; // 
        */
        int depth=depth();//size of stack
        Object[] sublist= new Object[depth];
        for(int i=0;i<depth;i++){
            sublist[i]=peek();
            --top;
        }
        return sublist;
        
    }

    @Override
    public boolean equals(StackADT<T> that) {
        
        if (this == that) {
            return true;
        }
        
        if (!(that instanceof MyStack)) {
            return false;
        }
        
        MyStack<T> otherStack = (MyStack<T>) that;
        
        if (this.size() != otherStack.size()) {
            return false;
        }
        
        for (int i = 0; i < this.size(); i++) {
            if (!this.data[this.top - i].equals(otherStack.data[otherStack.top - i])) {
                return false;
            }
        }
        
        return true;
    }

    @Override
    public boolean stackOverflow() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public T pop() throws EmptyStackException {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return data[top--];
        
    }

    
    
}
