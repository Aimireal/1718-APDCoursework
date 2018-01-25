package search;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This is just a small collection of tests.
 * A full test suite would be much more extensive.
 *
 */

public class CleverSearchTimerTest extends TimedTests {

	private SearchTimer searcher = new CleverSearchTimer();
	
	@Test
	public void test3of10() throws IndexingError {
		testKofN(searcher,3,10);
	}
	
	@Test(expected=IndexingError.class)
	public void test0of10() throws IndexingError {
		testKofN(searcher,0,10);
	}

	@Test
	public void test10of10() throws IndexingError {
		testKofN(searcher,10,10);
	}
	
	@Test(expected=IndexingError.class)
	public void test11of10() throws IndexingError {
		testKofN(searcher,11,10);
	}
	
	@Test
	public void test5of10() throws IndexingError {
		testKofN(searcher,5,10);
	}
	
	@Test
	public void test5of100() throws IndexingError {
		testKofN(searcher,5,100);
	}
	
	@Test
	public void test5of1000() throws IndexingError {
		testKofN(searcher,5,1000);
	}
	
	@Test
	public void test5of10000() throws IndexingError {
		testKofN(searcher,5,10000);
	}
	
	@Test
	public void test5of100000() throws IndexingError {
		testKofN(searcher,5,100000);
	}
	
	@Test
	public void test5of1000000() throws IndexingError {
		testKofN(searcher,5,1000000);
	}
}