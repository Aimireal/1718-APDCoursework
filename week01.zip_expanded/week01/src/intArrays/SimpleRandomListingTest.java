package intArrays;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class SimpleRandomListingTest extends ListingTest {

	private static long testStart, testEnd;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	
	@Rule public TestName testName = new TestName();
	
	@Before
	public void setUp() throws Exception {
		testStart = System.nanoTime();
	}

	@After
	public void tearDown() throws Exception {
		testEnd = System.nanoTime();
		System.out.println("Test \"" + testName.getMethodName() + "\" took " + (testEnd-testStart)/1000 + " microseconds");
	}
	
	@Test
	public void testOneSize() {
		testSize(1,new SimpleRandomListing(1));
	}
	
	@Test
	public void testOneContents() {
		testContents(1,new SimpleRandomListing(1));
	}
	@Test
	public void testTwoSize() {
		testSize(2,new SimpleRandomListing(2));
	}
	
	@Test
	public void testTwoContents() {
		testContents(2,new SimpleRandomListing(2));
	}
	@Test
	public void testFourSize() {
		testSize(4,new SimpleRandomListing(4));
	}
	
	@Test
	public void testFourContents() {
		testContents(4,new SimpleRandomListing(4));
	}
	@Test
	public void testHundredSize() {
		testSize(100,new SimpleRandomListing(100));
	}
	
	@Test
	public void testHundredContents() {
		testContents(100,new SimpleRandomListing(100));
	}

	@Test
	public void testThousandSize() {
		testSize(1000,new SimpleRandomListing(1000));
	}
	
	@Test
	public void testThousandContents() {
		testContents(1000,new SimpleRandomListing(1000));
	}

	@Test
	public void testMillionSize() {
		testSize(1000000,new SimpleRandomListing(1000000));
	}
}
