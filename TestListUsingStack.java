package lab7;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class TestListUsingStack {

	private ListUsingStack<Integer> emptyList;
	private ListUsingStack<Integer> exampleList;

	/**
	 * Initializes the ListUsingStacks that are used in the test methods
	 */
	@Before
	public void setUp() {

		emptyList = new ListUsingStack<Integer>();
		exampleList = new ListUsingStack<Integer>();
		exampleList.add(5);
		exampleList.add(6);
		exampleList.add(7);

	}

	/**
	 * Checks whether or not the ListUsingStack contains the same elements as an
	 * array hypothetically containing the same elements.
	 */

	public boolean check(ListUsingStack<Integer> lus, int[] arr) {

		if (arr.length != lus.getLength()) {

			return false;
		}

		for (int i = arr.length - 1; i > 0; i--) {

			if (arr[i - 1] != lus.getEntry(i)) {

				return false;
			}
		}
		return true;
	}

	/**
	 * Test method for add
	 */
	@Test
	public void testAdd() {
		int[] check = { 5, 6, 7, 8 };
		exampleList.add(8);
		int[] empty = { 1 };
		assertEquals(true, check(exampleList, check));
		emptyList.add(1);
		assertEquals(true, check(emptyList, empty));
		emptyList.remove(1);

	}

	/**
	 * Test method for addAtPosition
	 */
	@Test
	public void testAddAtPosition() {
		int[] check = { 5, 6, 9, 7 };
		exampleList.add(3, 9);
		assertEquals(true, check(exampleList, check));

		try {
			emptyList.add(5, 5);
			fail();
		} catch (IndexOutOfBoundsException e) {

		}

		emptyList.add(1, 1);
		int[] empty = { 1 };
		assertEquals(true, check(emptyList, empty));
		emptyList.remove(1);
		exampleList.remove(3);
	}

	/**
	 * Test method for remove
	 */
	@Test
	public void testRemove() {
		int[] check = { 5, 7 };
		int rem = exampleList.remove(2);
		assertEquals(6, rem);
		assertEquals(true, check(exampleList, check));

		try {
			emptyList.remove(5);
			fail();
		} catch (IndexOutOfBoundsException e) {

		}
	}

	/**
	 * Test method for clear
	 */
	@Test
	public void testClear() {
		int[] check = {};
		ListUsingStack<Integer> temp = exampleList;
		temp.clear();
		assertEquals(true, check(temp, check));
		emptyList.clear();
		assertEquals(true, check(emptyList, check));

	}

	/**
	 * Test method for replace
	 */
	@Test
	public void testReplace() {
		int[] check = { 5, 8, 7 };
		exampleList.replace(2, 8);
		assertEquals(true, check(exampleList, check));
		exampleList.replace(2, 6);
		try {
			exampleList.replace(10, 10);
			fail();
		} catch (IndexOutOfBoundsException e) {

		}
	}

	/**
	 * Test method for getEntry
	 */
	@Test
	public void testGetEntry() {
		int entry = exampleList.getEntry(2);
		assertEquals(6, entry);
		try {
			emptyList.getEntry(1);
			fail();
		} catch (IndexOutOfBoundsException e) {

		}
	}

	/**
	 * Test method for contains
	 */
	@Test
	public void testContains() {
		ListUsingStack<Integer> tempstack = new ListUsingStack<Integer>();
		tempstack.add(5);
		assertEquals(true, tempstack.contains(5));
		assertEquals(false, tempstack.contains(4));
	}

}
