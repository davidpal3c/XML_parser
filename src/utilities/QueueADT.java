
package utilities;

import exceptions.EmptyQueueException;
import java.io.Serializable;

/**
 *
 * @author Emily
 */
public interface QueueADT <T> extends Serializable{
    /**
     * Adds an element to the rear of the queue.
     * 
     * @precondition element must not be null
     * @postcondition element is added to the end of the queue, the size of 
     * the queue is increased by 1, and the queue has new element at the end
     * if operation is successful 
     * @param element The element to be added.
     * @return true if the element was successfully added.
     * @throws NullPointerException if the specified element is null.
     */
    public void enqueue(T element) throws NullPointerException;

    /**
     * Removes and returns the element at the front of the queue.
     *
     * @precondition queue must not be empty
     * @postcondition element is removed from the front of the queue and returned.
     * The size of the queue is decreased by 1, and the next element is now at
     * the front of the queue if the operation is successful.
     * @return The element at the front of the queue.
     * @throws java.util.NoSuchElementException if the queue is empty.
     */
    public T dequeue()throws EmptyQueueException;
    
    /**
	 * dequeueAll removes all items in the queue.
	 */
    public T dequeueAll();
    /**
	 * Returns an array containing all of the elements in this list in proper
	 * sequence. Obeys the general contract of the Collection.toArray method.
	 * 
	 * @return an array containing all of the elements in this list in proper
	 *         sequence.
	 */
    public T[] toArray( T[] toHold ) throws NullPointerException;
    public Object[] toArray();
    /**
	 * Returns true if the number of items in the queue equals the
	 * length. This operation is only implement when a fixed length queue is
	 * required.
	 * 
	 * @return <code>true</code> if queue is at capacity.
	 */
    public boolean isFull();
    
    /**
	 * Used to compare two Queue ADT's. To be equal two queues must contain equal
	 * items appearing in the same order.
	 * 
	 * @param that the Queue ADT to be compared to this queue.
	 * @return <code>true</code> if the queues are equal.
	 */
    public boolean equals( QueueADT<T> that );
    
    /*iterator*/
    public Iterator<T> iterator();
    
    /**
     * Returns the element at the front of the queue without removing it.
     *
     * @precondition queue must not be empty
     * @post condition element at the front of the queue is returned.
     * Size of queue remains the same.
     * @return The element at the front of the queue.
     * @throws java.util.NoSuchElementException if the queue is empty.
     */
    public T peek();

    /**
     * Checks if the queue is empty.
     *
     * @postcondition returns true if queue contains no elements, otherwise returns false
     * @return true if the queue contains no elements.
     */
    public boolean isEmpty();

    /**
     * Returns the number of elements in the queue.
     *
     * @postcondition returns the size of the queue 
     * @return The number of elements in the queue.
     */
    public int size();

    /**
     * Removes all elements from the queue.
     * 
     * @postcondition if not null, all element are removed from the queue.
     * The queue is empty
     */
    public void clear();

    /**
     * Returns an iterator over the elements in the queue.
     *
     * @return An iterator over the elements in the queue.
     */
}
