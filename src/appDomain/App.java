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
     /**
     * Main method to run the application.
     * 
     * @param args Command line arguments.
     * @throws IllegalArgumentException if no file path is provided.
     */
    public static void main(String[] args) throws IllegalArgumentException {
        System.out.println("HELLO!!!");              
 
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
        
    /**
     * Helper method to print an object to the console.
     * 
     * @param o The object to print.
     */
    }
    private static void print(Object o){
        System.out.println(o);
    }
}
