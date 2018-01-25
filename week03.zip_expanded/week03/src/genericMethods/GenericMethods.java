package genericMethods;

public class GenericMethods {	
	/**
	 * Check if two objects are equal
	 * @param object1 the first object
	 * @param object2 the second object
	 * @return true if the objects are equal (according to the equals() method)
	 */
	public static <T> boolean equals(T object1,T object2) {
		if (object1==null) {
			return object2==null;
		} else {
			return object1.equals(object2);
		}
	}
	/**
	 * Find the largest element in an array of Comparables
	 * @param array the array to be searched
	 * @return the largest element in the array, or null, if the array is empty
	 * Note: this exercise makes use of bounded generics, introduced in week 4
	 */
	public static <T extends Comparable<T>> T max(T[] array) {
		if (array.length == 0) { // if the array is empty
			return null; // no largest value to return, so return null
		}
		T currentLargest = array[0]; // current largest value is the first element
		for (T element: array) { // for all values in the array
			if (element.compareTo(currentLargest) > 0) { // if this value is larger than the current largest
				currentLargest = element; // update the current largest to the new, larger value
			}
		} // have now checked all values in the array, so current largest is the maximum value in the whole array
		return currentLargest;
	}
}