/** Assignment 3            Queue12.java         Due. May 10
 **/


import java.util.*;
/**
 * This class is a double ended queue which implements BoundedDeque<E>.
 * It uses a circular array of Generic type and can only be added elements 
 * at the front and the back. 
 * @author Timothy Chang 
 */
public class Deque12<E> //implements BoundedDeque<E>
{
 private E[] deque; // circular array to hold elements
 private int capacity; //number of elements array can hold 
 private int size; //number of elements in the array
 private int front; //head of the array element
 private int rear; //tail element of the array
 
 /**
  * Constructor for the Deque12 class. Initializes front, rear, and size to 0
  * and capacity to the passed value. 
  * @param i capacity of the array
  * @throws IllegalArgumentException if capacity is negative
  */
 public Deque12(int i)
 {
   
   if(i < 0) // if capacity is less than 0, throw exception
   {
      throw new IllegalArgumentException();
   }
   capacity = i; //set capacity to passed int
   front = 0;
   rear = 0;
   size = 0;
   deque = (E[])new Object[capacity]; 
 }
  
  /**
   * Adds the specified element to the back of this Deque. 
   * Returns true if the operation succeeded, else false. 
   * PRECONDITION: the Deque's size is less than its capacity. 
   * POSTCONDITION: the element is now the back element in this Deque,
   * none of the other elements have been changed, 
   * and the size is increased by 1.
   * @param e the element to add to the back of the list
   * @return true if the element was aded, else false
   * @throws NullPointerException - if specified element is null, and size is
   * less than capacity
   */
  public boolean addBack(E e)
  {
   if(this.size == this.capacity) // return false if array is full
   {
     return false;
   }
   if(e == null) //if element is null, throw exception
   {
     throw new NullPointerException();
   }
   deque[rear] = e;
   rear += 1;
   if(rear == capacity) // wrap around array
   rear = 0;
   size++;
   return true;
  }
  
  /**
   * Adds the specified element to the front of this Deque. 
   * Returns true if the operation succeeded, else false. 
   * PRECONDITION: the Deque's size is less than its capacity. 
   * POSTCONDITION: the element is now the front element in this Deque, 
   * none of the other elements have been changed, 
   * and the size is increased by 1.
   * @param e the element to add to the front of the list
   * @return true if the element was added, else false
   * @throws NullPointerException - if the specified element is null, and size
   * is less than capacity
   */
  public boolean addFront(E e)
  {
   if(this.size == this.capacity) //if array is full, return false
   {
     return false;
   }
   if(e == null) //if element is null, throw exception
   throw new NullPointerException();
   front -= 1;
   if(front == -1) //wrap around array
   front = capacity - 1;
   deque[front] = e; //assign element to array
   size++;
   return true;
  }
  
  /**
   * Returns the capacity of this Deque, that is, 
   * the maximum number of elements it can hold. 
   * PRECONDITION: none 
   * POSTCONDITION: the queue is unchanged.
   * @return the capacity of this queue
   */
  public int capacity()
  {
    return this.capacity;
  }
  
  /**
   * Compares the specified object with this Deque for equality. 
   * Returns true if and only if the specified object is also a 
   * Deque of the same type, both have the same size, 
   * and the corresponding pairs of elements in the two are equal. 
   * Two elements e1 and e2 are equal if e1.equals(e2).
   * "Corresponding pairs" means: the pair of front elements, 
   * the pair of next-to-front elements, 
   * and so on through to the pair of back elements.
   * @param o - the Object to compare to this queue for equality
   * @return true of the specified Object is equal to this queue
   */
  public boolean equals(java.lang.Object o)
  {
    if(o instanceof Deque12 == false) //check instanceof
      return false;
    Deque12<E> compare = (Deque12<E>)o;
    if(this.size != compare.size) //check sizes
    {
      return false;
    }
    
    int i = this.front; 
    int b = compare.front;
    for(int num = 0; num <= this.size; num++, i++, b++)
    {
      if(i == this.capacity) //set indices
         i = 0;
      if(b == compare.capacity)
         b = 0; 
     if(this.deque[i] != null && compare.deque[b] != null) //if both not null
      if(this.deque[i].equals(compare.deque[b]) == false) //compare objects
      {
        //System.out.println(this.deque[i].equals(compare.deque[b]));
        return false;
      }
    }
    //System.out.println(this.deque[i].equals(compare.deque[b]));
    return true;
  }
  
  /**
   * Returns the element at the back of this Deque, 
   * or null if there was no such element. 
   * PRECONDITION: the Deque's size is greater than zero. 
   * POSTCONDITION: The Deque is unchanged.
   * @return the element at the back, or null if size was zero
   */
  public E peekBack()
  {
    if(rear - 1 == -1)
      return deque[capacity - 1];
    return deque[rear - 1];
  }
  
  /**
   * Returns the element at the front of this deque, 
   * or null if there was no such element. 
   * PRECONDITION: the deque's size is greater than zero. 
   * POSTCONDITION: The deque is unchanged.
   * @return
   */
  public E peekFront()
  {
    if(size== 0)
       return null;
    return deque[front];
  }
  
  /**
   * Removes the element at the front of this Deque.
   * Returns the element removed, or null if there was no such element. 
   * PRECONDITION: the Deque's size is greater than zero. 
   * POSTCONDITION: the front element in this Deque has been removed, 
   * none of the other elements have been changed, 
   * and the size is decreased by 1.
   * @return the element removed, or null if size was zero
   */
  public E removeFront()
  {
   if(size == 0) //if size is zero, return null
      return null;
    E temp = deque[front];
    deque[front] = null;
    front++;
    size--;
    return temp;
  }
  
  /**
   * Removes the element at the back of this Deque. 
   * Returns the element removed, or null if there was no such element. 
   * PRECONDITION: the Deque's size is greater than zero. 
   * POSTCONDITION: the back element in this Deque has been removed, 
   * none of the other elements have been changed, 
   * and the size is decreased by 1.
   * @return the element removed, or null if size was zero
   */
  public E removeBack()
  {
    if(size == 0)
      return null;
    rear--;
    if(rear == -1) //wrap around array
       rear = capacity - 1;
    E temp = deque[rear];
    deque[rear] = null;
    size--;
    return temp;
  }
  
  /**
   * Returns the number of elements in this Deque. 
   * PRECONDITION: none 
   * POSTCONDITION: the Deque is unchanged.
   * @return the number of elements in this deque
   */
  public int size()
  {
    return this.size;
  }
} 






