/** Assignment 3            Queue12.java         Due. May 10
 * login: cs12sat
 **/


import java.util.*;


/**
 * This class tests the methods of the BoundedDeque<E> implementation
 * Deque12 using JUnit.
 * @author Timothy Chang 
 * @see junit.framework.TestCase
 */
public class BoundedDequeTester extends junit.framework.TestCase
{
  /**
   * This method tests the constructor of Deque12<E> and whether it throws
   * the correct exceptions and it initializes the data fields correctly.
   */
  public void testConstructor()
  {
    Deque12<String> test = new Deque12<String>(0);
    assertTrue(test.capacity()==0);
    try
    {
      test = new Deque12<String>(-5);
      fail();
    }
    catch(IllegalArgumentException ex) //testing IllegalArgumentException
    {
    }
    catch(Throwable ex)
    {
      fail("Unexpected exception was thrown");
    }
    try
    {
      test = new Deque12<String>(0);
    }
    catch(IllegalArgumentException ex)
    {
      fail("Unexpected IllegalArgumentException thrown");
    }
    catch(Throwable ex)
    {
      fail("Unexpected exception was thrown");
    }
  }
  
  /**
   * This method tests the AddFront method of the class Deque12<E>.
   */
  public void testAddFront()
  {
    Deque12<String> test = new Deque12<String>(5);
    assertTrue(test.capacity()==5);
    assertTrue(test.size()==0);
    assertTrue(test.addFront("A"));
    assertTrue(test.peekFront().equals("A"));
    test.addFront("B");
    assertTrue(test.peekFront().equals("B"));
    assertTrue(test.size()==2);
    test.addFront("C");
    test.addFront("D");
    test.addFront("E");
    assertFalse(test.addFront("F"));
   // assertFalse(test.addFront(null));
  }  
  
  /**
   * This method tests the exceptions of the AddFront method. 
   */
  public void testAddFrontExceptions()
  {
    Deque12<String> test = new Deque12<String>(3);
    test.addFront("A");
    test.addFront("B");
    try
    {
      test.addFront(null);
      fail();
    }
    catch(NullPointerException ex) //testing whether NullPointerException throws
    {
    }
    catch(Throwable ex)
    {
      fail("Unexpected exception was thrown");
    }
  }
  
  /**
   * This method tests the AddBack method of the Deque12<E> method.
   */
  public void testAddBack()
  {
    Deque12<String> test = new Deque12<String>(5);
    assertTrue(test.capacity()==5);
    assertTrue(test.size()==0);
    assertTrue(test.addBack("B"));
    assertTrue(test.peekBack().equals("B"));
    test.addBack("A");
    assertTrue(test.peekBack().equals("A"));
    assertTrue(test.size()==2);
    test.addBack("C");
    assertTrue(test.peekBack().equals("C"));
    test.addBack("D");
    test.addBack("E");
    assertFalse(test.addBack("F"));
   // assertFalse(test.addBack(null));
  }
  
  /**
   * This method tests the exceptions of the AddBack method.
   */
  public void testAddBackExceptions()
  {
    Deque12<String> test = new Deque12<String>(3);
    try
    {
      test.addBack("A");
      test.addBack("B");
      test.addBack(null);
      fail();
    }
    catch(NullPointerException ex)//testing whether NullPointerException throws
    {
    }
    catch(Throwable ex)
    {
      fail("Unexpected exception was thrown");
    }
  }
  
  /**
   * This method tests the capacity() method of Deque12<E>
   */
  public void testCapacity()
  {
    Deque12<String> test = new Deque12<String>(3);
    assertTrue(test.capacity()==3);
    Deque12<String> test1 = new Deque12<String>(0);
    assertTrue(test1.capacity()==0);
  } 
  
  /**
   * This method tests the equals() method of Deque12<E>
   */
  public void testEquals()
  {
    Deque12<Integer> test = new Deque12<Integer>(3);
    Deque12<Integer> test2 = new Deque12<Integer>(3);
    Deque12<Integer> test3 = new Deque12<Integer>(3);
    for(int i = 0; i < test.capacity(); i++)
    {
      test.addFront(i);
      test2.addFront(i);
    }
    assertTrue(test.equals(test2));
    assertFalse(test.equals(test3));
    
  }
  
  /**
   * This method tests the peekFront() method of the Deque12<E> class.
   */
  public void testPeekFront()
  {
    Deque12<String> test = new Deque12<String>(3);
    assertTrue(test.peekFront()==null);
    test.addBack("B");
    assertTrue(test.peekFront()=="B");
    test.addFront("A");
    assertTrue(test.peekFront().equals("A"));
    test.addFront("C");
    assertTrue(test.peekFront().equals("C"));
    test = new Deque12<String>(0);
    assertTrue(test.peekFront()==null);
  }  
  
  /**
   * This method tests the peekBack() method of the Deque12<E> class
   */
  public void testPeekBack()
  {
    Deque12<String> test = new Deque12<String>(3);
    assertTrue(test.peekBack()==null);
    test.addFront("B");
    assertTrue(test.peekBack()=="B");
    test.addBack("A");
    assertTrue(test.peekBack().equals("A"));
    test.addBack("C");
    assertTrue(test.peekBack().equals("C"));
    test = new Deque12<String>(0);
    assertTrue(test.peekFront()==null);
  }  

  /**
   * This method tests the removeFront() method of the Deque12<E> class
   */
  public void testRemoveFront()
  {
    Deque12<String> test = new Deque12<String>(0);
    assertTrue(test.removeFront() == null);
    test = new Deque12<String>(4);
    assertTrue(test.removeFront() == null);
    test.addFront("A");
    test.addFront("B");
    test.addFront("C");
    test.addFront("D");
    assertTrue(test.removeFront().equals("D"));
    assertTrue(test.size() == 3);
    assertFalse(test.peekFront().equals("D"));
    assertTrue(test.peekBack().equals("A"));
    assertTrue(test.removeFront().equals("C"));
    assertTrue(test.size() == 2);
    assertTrue(test.removeFront().equals("B"));
    assertTrue(test.size() == 1);
    assertTrue(test.removeFront().equals("A"));
    assertTrue(test.size() == 0);
  }
  
  /**
   * This method tests the removeBack method of the Deque12<E> class.
   */
  public void testRemoveBack()
  {
    Deque12<String> test = new Deque12<String>(0);
    assertTrue(test.removeBack() == null);
    test = new Deque12<String>(4);
    assertTrue(test.removeBack() == null);
    test.addBack("A");
    test.addBack("B");
    test.addBack("C");
    test.addBack("D");
    assertTrue(test.removeBack().equals("D"));
    assertTrue(test.size() == 3);
    assertFalse(test.peekBack().equals("D"));
    assertTrue(test.peekFront().equals("A"));
    assertTrue(test.removeBack().equals("C"));
    assertTrue(test.size() == 2);
    assertTrue(test.removeBack().equals("B"));
    assertTrue(test.size() == 1);
    assertTrue(test.removeBack().equals("A"));
    assertTrue(test.size() == 0);
  }
  
  /**
   * This method tests the size() method for Deque12<E> class
   */
  public void testSize()
  {
    Deque12<String> test = new Deque12<String>(0);
    assertTrue(test.size() == 0);
    test = new Deque12<String>(10);
    assertTrue(test.size() == 0);
    Deque12<String> compare = new Deque12<String>(10);
    assertTrue(test.equals(compare)); //checking if test is unchanged by size()
    test.addFront("A");
    assertTrue(test.size()==1);
    test.addFront("B");
    assertTrue(test.size()==2);
  }
  
  /**
   * This method runs the class as a text-output program.
   */
  public static void main(String[] args)
  {
    junit.textui.TestRunner.main(new String[] {"BoundedDequeTester"});
  }
}
