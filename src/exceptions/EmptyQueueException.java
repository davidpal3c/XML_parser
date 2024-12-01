package exceptions;

/**
 * Exception thrown when an operation is performed on an empty queue.
 */
public class EmptyQueueException extends Exception {

    /**
     * Constructs a new EmptyQueueException with the specified detail message.
     * 
     * @param message The detail message.
     */
    public EmptyQueueException(String message) {
        super(message);
    }