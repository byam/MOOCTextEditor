/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		// TODO: Add more tests here

		// remove index out of bounds
		try {
			shortList.remove(2);
			fail("Check index of bounds");
		}
		catch (IndexOutOfBoundsException e){

		}
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test

		// test null element adding
		try {
			emptyList.add(null);
			fail("Check null pointer");
		}
		catch (NullPointerException e) {
		}

		// test usual add works
		assertEquals("Check add end", true, shortList.add("i am bya"));
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // TODO: implement this test

		// test null element
		try {
			shortList.add(0, null);
			fail("Check null element adding");
		}
		catch (NullPointerException e){

		}

		// test out of bounds: minus
		try {
			shortList.add(-1, "Minus index");
			fail("Check minus index");
		}
		catch (IndexOutOfBoundsException e){

		}

		shortList.add(0, "C");
		assertEquals("Check adding first index", "C",
				shortList.get(0));

		longerList.add(5, 100);
		assertEquals("Check adding specific index", "100",
				longerList.get(5).toString());
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // TODO: implement this test
	    assertEquals("Change element", "A", shortList.set(0, "C"));

		try{
			shortList.set(-1, "C");
			fail("Check index out of bounds");
		}
		catch (IndexOutOfBoundsException e){

		}

		try{
			shortList.set(2, "C");
			fail("Check index out of bounds");
		}
		catch (IndexOutOfBoundsException e){

		}

		try{
			shortList.set(1, null);
			fail("Check null element");
		}
		catch (NullPointerException e){

		}
	}
	
	
	// TODO: Optionally add more test methods.

	/** Testing add, remove, and add on new list */
	@Test
	public void testNesListAddRemove(){
		MyLinkedList<String> myLinkedList = new MyLinkedList<>();
		myLinkedList.add(0, "A");
		assertEquals("Add on new list", "A", myLinkedList.get(0));
	}
}
