
package utilities;

import java.io.Serializable;
import java.util.EmptyStackException;

/**
 *
 * @author Emily
 */
public interface StackADT<T> extends Serializable {
     /**
     * Pushes an element onto the top of the stack.
     *
     * @precondition element must not be null
     * @postcondition element is added at the top of the stack.
     * The size of the stack increases  by 1 and element is put 
     * over the previous top element
     * @param element The element to be pushed onto the stack.
     * @return true if the element was successfully pushed.
     * @throws NullPointerException if the specified element is null.
     */
    public void push(T element)throws NullPointerException;

    /**
     * Removes and returns the top element from the stack.
     *
     * @precondition stack cannot be empty
     * @postcondition element at the top is removed from the stack and returned.
     * The size of the stack is decreased by 1 and the new next element
     * is now the top element.
     * @return The top element of the stack.
     * @throws java.util.EmptyStackException if the stack is empty.
     */
    public T pop()throws EmptyStackException;

    /**
     * Returns the top element of the stack without removing it.
     *
     * @precondition stack must not be empty
     * @postcondition element at the top is of the stack is returned.
     * The size of the stack remains the same.
     * @return The top element of the stack.
     * @throws java.util.EmptyStackException if the stack is empty.
     */
    public T peek()throws EmptyStackException;

    /**
     * Checks if the stack is empty.
     *
     * @postcondition returns true if stack has no elements, otherwise it returns false
     * @return true if the stack contains no elements.
     */
    public boolean isEmpty();

    /**
	 * Returns the depth of the current stack as an integer value.
	 * 
	 * @return the current size to the stack as an integer.
    */
    public int size();

    /**
     * Removes all elements from the stack.
     * 
     * @postconditions removes all elements from stack
     */
    public void clear();
    
    /**
	 * Returns true if this list contains the specified element. More formally,
	 * returns true if and only if this list contains at least one element e such
	 * that (o==null ? e==null : o.equals(e)).
	 * 
	 * @param toFind element whose presence in this list is to be tested.
	 * @return true if this list contains the specified element.
	 * @throws NullPointerException if the specified element is null and this list
	 *                              does not support null elements.
	 */
    public boolean contains(T toFind);
    /**
	 * Returns an iterator over the elements in this stack in proper sequence.
	 * 
	 * @return an iterator over the elements in this stack in proper sequence.
	 */
    public Iterator<T> iterator();
    /**
	 * Returns the 1-based position where an object is on this stack. If the object
	 * o occurs as an item in this stack, this method returns the distance from the
	 * top of the stack of the occurrence nearest the top of the stack; the topmost
	 * item on the stack is considered to be at distance 1. The equals method is
	 * used to compare o to the items in this stack.
	 * 
	 * @param toFind the desired object.
	 * @return the 1-based position from the top of the stack where the object is
	 *         located; the return value -1 indicates that the object is not on the
	 *         stack.
    */
    public int search(T toFind);
    
    /**
	 * Returns an array containing all of the elements in this list in proper
	 * sequence; the runtime type of the returned array is that of the specified
	 * array. Obeys the general contract of the Collection.toArray(Object[]) method.
	 * 
	 * @param toHold the array into which the elements of this stack are to be
	 *               stored, if it is big enough; otherwise, a new array of the same
	 *               runtime type is allocated for this purpose.
	 * @return an array containing the elements of this stack.
	 * @throws NullPointerException if the specified array is null.
	 */
    public T[] toArray( T[] toHold ) throws NullPointerException;
    /**
	 * Returns an array containing all of the elements in this list in proper
	 * sequence. Obeys the general contract of the Collection.toArray method.
	 * 
	 * @return an array containing all of the elements in this list in proper
	 *         sequence.
    */
    public Object[] toArray();
    
    /**
	 * Used to compare two Stack ADT's. To be equal two stacks must contain equal
	 * items appearing in the same order.
	 * 
	 * @param that the Stack ADT to be compared to this stack.
	 * @return <code>true</code> if the stacks are equal.
	 */
    public boolean equals( StackADT<T> that );
    
    /**
	 * Returns true if the number of items in the stack equals the length.  
	 * This operation is only implement when a fixed size stack is required.
	 * @return <code>true</code> if stack is at capacity.
	 */
    public boolean stackOverflow();
    

}
