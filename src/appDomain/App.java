/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appDomain;

import implementations.MyQueue;
import implementations.MyStack;
import implementations.MyArrayList;
import implementations.IMyArrayList;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import utilities.StackADT;
import utilities.QueueADT;
import utilities.ListADT;
import java.io.BufferedReader;



/**
*
* Creating ADT's Implementing DS and XML Parser - CPRG304 - SAIT
* Authors: Emily Thieu, Ngoc Tam Nguyen, Yaling Wei, David Palacios
* Instructor: Hani Mohammed
* Date: November 13, 2024
 */

public class App {
    public static void main(String[] args) throws IllegalArgumentException {
        System.out.println("HELLO!!!");
//        MyStack<Integer> stack = new MyStack<Integer>();
//        MyStack<Integer> stack2 = new MyStack<Integer>();
//
//		stack.push( 1 );
//		stack.push( 2 );
//		stack.push( 3 );
//                stack2.push( 1 );
//		stack2.push( 2 );
//		stack2.push( 3 );
//                
//                boolean actual = stack.equals(stack2);
//        print(actual);
//   TODO code application logic here
        /*
        MyStack<Integer> mystack = new MyStack<>();
        for(int i=0;i<3;i++){
            mystack.push(i+1);
        }
        //int actual = mystack.search( 3 );
        //print(actual);
        
        Integer[] array = new Integer[3];
		
        array[0] = 3;
	array[1] = 2;
	array[2] = 1;
        Object[] returnArray = new Integer[3];
	returnArray = mystack.toArray();
        boolean actual = mystack.contains( 3 );
        print(actual);
        */
        
//        print("stack initial size: " + mystack.size());    
//        mystack.clear();
//        print("Stack size after empty: " + mystack.size());    
//
//        MyQueue<Integer> myqueue=new MyQueue<>();
//        for(int i=0;i<10;i++){
//            myqueue.enqueue(i+1);
//        }
//        
//        myqueue.dequeue();
//        //DELETE FIRST
//        print(myqueue.peek());
//        myqueue.dequeue();
//        print(myqueue.peek());
//        print(myqueue.size());
        
        //TEST ARRAY LIST
        //Integer[] linteger={1,2,3,4,5};
//        MyArrayList<Integer> myarraylist=new MyArrayList<>();
//        for(int i=0;i<10;i++){
//            myarraylist.add(i+1);
//        }
//        
//        IMyArrayList<Integer> arr= new IMyArrayList<>(myarraylist);
//        while(arr.hasNext()){
//            print(arr.next());
//        }
//        
//        print(myarraylist.get(2));
//        
        

        //TEST MyArrayList
        /*
        MyArrayList testArr = new MyArrayList<>();
        MyArrayList arr2 = new MyArrayList<>();
       

        testArr.add(8);
        testArr.add(15);
        testArr.add(13);
        arr2.add(100); 
        testArr.addAll(arr2);

 
        for (int i = 0; i<testArr.size(); i++) {
            System.out.println(testArr.get(i));
        }
        */
		
        // Main                 
 
        try {
            if (args.length < 1) {      
                throw new IllegalArgumentException("No file path provided. Please enter the XML file name to parse.");
            }           
            
            Path filepath = Paths.get("../res/" + args[0]);            
            
            if (!Files.exists(filepath)) {
                System.err.println("File does not exist: " + filepath.toString());
            }
               
            XmlParser parser = new XmlParser();
            
            parser.parseFile(filepath); 
                        
        } 
        catch (IllegalArgumentException iae) {
            System.err.println(iae.getMessage());
        }
        
    }
    private static void print(Object o){
        System.out.println(o);
    }
}
