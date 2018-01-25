package search;
import java.util.Arrays; // in order to use the <tt>sort</tt> method

import intArrays.CleverRandomListing;

/**
 * A concrete implementation of {@link TimedSearch} using the "clever"
 * method from week 1's lecture.
 * 
 * @author Hugh Osborne
 * @version 2017
 */

public class CleverSearchTimer extends SearchTimer
{
    /**
     * Find the kth largest element in an array of Comparables
     * using the "clever" solution from the lecture
     * @param array array of Comparables
     * @param k index of desired element
     * @return kth largest element of array
     * @throws IndexingError if k is an invalid index
     * 
     * Pseudo code:
     * copy first k elements of large array to small array and sort it
     * for all remaining elements of large array {
     *   if new element is larger than smallest element of small array {
     *     throw away smallest element of small array, creating a space
     *     // fit new element into correct position in small array
     *     while there are more elements in the small array
     *           AND the next element is smaller than the new element {
     *       move small element down into space creating new space
     *     }
     *     put new element in last space created
     *     // end of fitting new element in the small array
     *   }
     * }
     * // small array now contains k largest elements of big array
     * return smallest element of small array 
     */
    public int findKthElement(int[] array, int k) throws IndexingError {
        if (k <= 0 || k > array.length) { // check for indexing error
            throw new IndexingError();
        }
    	int[] smallArray = Arrays.copyOf(array, k); // copy first k elements of large array to small array
    	Arrays.sort(smallArray);; // and sort it
    	for (int largeIndex = k; largeIndex < array.length; largeIndex++) {  // for all elements of large array
    		int newElement = array[largeIndex];
    		int smallIndex = 0;
    		if (newElement > smallArray[smallIndex]) { // if new element is larger than smallest element of small array
    			smallIndex = 1; // can (virtually) throw away smallest element of small array, creating a space
    			while (smallIndex < k && // while there are more elements in the small array
    					newElement > smallArray[smallIndex]) { // AND the next element is smaller than the new element
    				smallArray[smallIndex-1] = smallArray[smallIndex]; // move small element down into space
    				smallIndex++; // creating new space
    			}
    			smallArray[smallIndex-1] = newElement; // put new element in last space created
    		} // end of fitting new element in the small array
    	} // small array now contains k largest elements of big array
    	return smallArray[0]; // return smallest element of small array
    } // end of clever solution method
}