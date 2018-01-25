package genericMethods;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class GenericMethodsTest {

	/**
	 * A selection of tests for equals
	 */
	
	@Test
	public void testEqualIntegers() {
		assertEquals(true,GenericMethods.equals(3, 3));
	}
	
	@Test
	public void testNotEqualIntegers() {
		assertEquals(false,GenericMethods.equals(3, 7));
	}

	@Test
	public void testEqualStrings() {
		assertEquals(true,GenericMethods.equals("Hugh", "Hugh"));
	}
	
	@Test
	public void testNotEqualStrings() {
		assertEquals(false,GenericMethods.equals("Hugh", "hugh"));
	}

	@Test
	public void testEqualNull() {
		assertEquals(true,GenericMethods.equals(null, null));
	}

	@Test
	public void testNotEqualNull1() {
		assertEquals(false,GenericMethods.equals(null, 4));
	}

	@Test
	public void testNotEqualNull2() {
		assertEquals(false,GenericMethods.equals("Hugh", null));
	}
	
	/**
	 * A selection of tests for max
	 */
	
	@Test
	public void testNullFromEmpty() {
		Integer[] array = new Integer[0];
		assertNull(GenericMethods.max(array));
	}
	
	@Test
	public void testMaxInteger() {
		Integer[] array = {3,8,2,9,6,5,1};
		assertEquals(new Integer(9),GenericMethods.max(array));
	}
	
	@Test
	public void testMaxString() {
		String[] array = {"antelope","a","aardvark"};
		assertEquals("antelope",GenericMethods.max(array));
	}
	
	/**
	 * Create own comparable class to test max
	 * Class "boxes" two comparables
	 */
	private class Box<A extends Comparable<A>,B extends Comparable<B>> implements Comparable<Box<A,B>> {
		private A first;
		private B second;
		
		public Box(A first,B second) {
			this.first = first;
			this.second = second;
		}
		
		public A getFirst() {
			return first;
		}
		
		public B getSecond() {
			return second;
		}
		
		/**
		 * In comparisons first entry takes precedence over second
		 */
		public int compareTo(Box<A,B> box) {
			if (getFirst().compareTo(box.getFirst())!=0) {
				return getFirst().compareTo(box.getFirst());
			} else {
				return getSecond().compareTo(box.getSecond());
			}
		}
		
		/**
		 * Need to define equality as well
		 */
		public boolean equals(Object object) {
			if (!(object instanceof Box<?,?>)) {
				return false;
			}
			Box<?,?> box = (Box<?,?>) object; 
			return getFirst().equals(box.getFirst()) && getSecond().equals(box.getSecond());
		}

	}
	
	@Test
	public void testBox1() {
		@SuppressWarnings("unchecked") // can't create array of Box<String,Integer>[], so create Box[] instead
		Box<String,Integer>[] array = new Box[5];
		array[0] = new Box<String,Integer>("antelope",7);
		array[1] = new Box<String,Integer>("aardwolf",7);
		array[2] = new Box<String,Integer>("aardvark",7);
		array[3] = new Box<String,Integer>("aardvark",9);
		array[4] = new Box<String,Integer>("aardvark",7);
		assertEquals(new Box<String,Integer>("antelope",7),GenericMethods.max(array));
	}
	
	@Test
	public void testBox2() {
		@SuppressWarnings("unchecked") // can't create array of Box<String,Integer>[], so create Box[] instead
		Box<String,Integer>[] array = new Box[5];
		array[0] = new Box<String,Integer>("aardvark",8);
		array[1] = new Box<String,Integer>("aardvark",3);
		array[2] = new Box<String,Integer>("aardvark",1);
		array[3] = new Box<String,Integer>("aardvark",9);
		array[4] = new Box<String,Integer>("aardvark",5);
		assertEquals(new Box<String,Integer>("aardvark",9),GenericMethods.max(array));
	}
	
	@Test
	public void testBox3() {
		@SuppressWarnings("unchecked") // can't create array of Box<String,Integer>[], so create Box[] instead
		Box<String,Integer>[] array = new Box[5];
		array[0] = new Box<String,Integer>("aardvark",5);
		array[1] = new Box<String,Integer>("aardvark",5);
		array[2] = new Box<String,Integer>("aardvark",5);
		array[3] = new Box<String,Integer>("aardvark",5);
		array[4] = new Box<String,Integer>("aardvark",5);
		assertEquals(new Box<String,Integer>("aardvark",5),GenericMethods.max(array));
	}
}