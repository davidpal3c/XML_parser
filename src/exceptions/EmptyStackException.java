/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions;

/**
 * Exception thrown when an operation is performed on an empty stack.
 */
public class EmptyStackException extends Exception {

    /**
     * Constructs a new EmptyStackException with the specified detail message.
     * 
     * @param message The detail message.
     */
    public EmptyStackException(String message) {
        super(message);
    }

    /**
     * Constructs a new EmptyStackException with no detail message.
     */
    public EmptyStackException() {
    }
}