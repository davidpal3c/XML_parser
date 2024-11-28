/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementations;

import exceptions.EmptyQueueException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilities.Iterator;
import utilities.QueueADT;

/**
 *
 * @author mailt
 */
public class MyQueue<T> implements QueueADT<T> {
    final int DEFAULT_CAPACITY=100;
    private int length;
    private int front;
    private int back;
    private int capacity;
    private T[] data;
    
    public MyQueue(int capacity) {
        this.capacity = capacity;
        data=(T[])new Object[capacity];
        back=-1;
        front=0;
        length=back-front+1;
    }
    
    public MyQueue() {
        this.capacity = DEFAULT_CAPACITY;
        data=(T[])new Object[capacity];
        back=-1;
        front=0;
        length=back-front+1;
    }
    
    @Override
    public void enqueue(T element) throws NullPointerException {
        if(element==null){
            throw new NullPointerException("Element is null");
        }
        data[++back]=element;
        uplength();
    }

    @Override
    public T dequeue()throws EmptyQueueException {
        /*
        T temp=data[front];
        for(int i=1;i<=back;i++){
            data[i-1]=data[i];
        }
        uplength();
        */
        if(length==0){
            throw new EmptyQueueException("The queue is empty");
        }
        T temp=data[front];
        if(front==back){
            clear();
        }
        else{
            front++;
            uplength();
        }
        return temp;
    }

    @Override
    public T peek() {
        return data[front];
    }

    @Override
    public boolean isEmpty() {
        return this.length==0;
    }

    @Override
    public int size() {
        return this.length;
    }

    @Override
    public void clear() {
        data=null;
        back=-1;
        front=0;
        length=back-front+1;
    }
    public void uplength(){
         length=back-front+1;
    }

    @Override
    public T dequeueAll() {
        for(int i=0;i<length;i++){
            try {
                this.dequeue();
            } catch (EmptyQueueException ex) {
                Logger.getLogger(MyQueue.class.getName()).log(Level.SEVERE, null, ex);
            }
            front++;
        }
        return data[0];
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public T[] toArray(T[] toHold) throws NullPointerException {
        if (toHold == null) {
            throw new NullPointerException("Error: array cannot be null.");
        }
        T[] result = toHold;
        for(int i=0;i<length;i++){
            result[i]=peek();
            front++;
        }
        return result;
    }

    @Override
    public Object[] toArray() {
        int depth=length;//size of stack
        Object[] sublist= new Object[depth];
        for(int i=0;i<depth;i++){
            sublist[i]=peek();
            front++;
        }
        return sublist;
    }

    @Override
    public boolean isFull() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean equals(QueueADT<T> that) {
        boolean rs=true;
        try{
            int depth=length;//size of queue
            for(int i=0;i<length;i++){
                if(peek()!=that.peek()){
                    rs=false;
                }      
            }
        }
        catch(Exception e){
        }
        
        return rs;
    }
    
    
}
