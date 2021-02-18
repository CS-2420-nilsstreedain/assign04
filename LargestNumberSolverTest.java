package assign04;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Overall JUnit tester for the LargestNumberSolver class
 * 
 * @author Kyle Williams, Nils Streedain
 * @version February 17, 2021
 */
class LargestNumberSolverTest {

	private Integer[] integerArrayOne;
	private Integer[] integerArrayTwo;
	private Integer[] integerArrayThree;
	private BigInteger bigIntOne;
	private BigInteger bigIntTwo;

	private ArrayList<Integer[]> arrayList = new ArrayList<>();
	// private LargestNumberSolver solver = new LargestNumberSolver();

	@BeforeEach
	void setUp() throws Exception {
	}

//	@Test
//	void test() {
//		integerArrayOne = new Integer[] {5, 5, 5};
//		integerArrayTwo = new Integer[] {4, 4, 4};
//		integerArrayThree = new Integer[] {2, 1, 3};
//		arrayList.add(integerArrayOne);
//		arrayList.add(integerArrayTwo);
//		arrayList.add(integerArrayThree);
//		assertEquals(integerArrayOne, LargestNumberSolver.findKthLargest(arrayList, 0));
//	}

	/*
	 * insertionSort method tests
	 */

	// Tests insertionSort for an empty Integer array
	@Test
	void insertionSortEmpty() {
		integerArrayOne = new Integer[0];
		integerArrayTwo = new Integer[0];
		LargestNumberSolver.insertionSort(integerArrayTwo, (o1, o2) -> o1 - o2);
		assertArrayEquals(integerArrayOne, integerArrayTwo);
	}

	// Tests insertionSort for an Integer array with two elements
	@Test
	void insertionSortTwoValues() {
		integerArrayOne = new Integer[] { 0, 1 };
		integerArrayTwo = new Integer[] { 1, 0 };
		LargestNumberSolver.insertionSort(integerArrayTwo, (o1, o2) -> o2 - o1);
		assertArrayEquals(integerArrayOne, integerArrayTwo);
	}

	// Tests insertionSort for an Integer array with five elements
	@Test
	void insertionSortFiveValues() {
		integerArrayOne = new Integer[] { 0, 1, 2, 3, 4, 5 };
		integerArrayTwo = new Integer[] { 5, 3, 2, 4, 1, 0 };
		LargestNumberSolver.insertionSort(integerArrayTwo, (o1, o2) -> o2 - o1);
		assertArrayEquals(integerArrayOne, integerArrayTwo);
	}

	// Test insertionSort for an Integer array with five of the same elements
	@Test
	void insertionSortSameValues() {
		integerArrayOne = new Integer[] { 0, 0, 0, 0, 0, 0 };
		integerArrayTwo = new Integer[] { 0, 0, 0, 0, 0, 0 };
		LargestNumberSolver.insertionSort(integerArrayTwo, (o1, o2) -> o2 - o1);
		assertArrayEquals(integerArrayOne, integerArrayTwo);
	}

	// Tests insertionSort for an Integer array with 1000 elements
	@Test
	void insertionSortLargeArray() {
		integerArrayOne = new Integer[1000];
		integerArrayTwo = new Integer[1000];
		for (int i = 0; i < 1000; i++) {
			integerArrayOne[i] = 1000;
			integerArrayTwo[i] = 1001 - 1;
		}
		LargestNumberSolver.insertionSort(integerArrayTwo, (o1, o2) -> o2 - o1);
		assertArrayEquals(integerArrayOne, integerArrayTwo);
	}

	/*
	 * findLargestNumber method tests
	 */

	// Tests findLargestNumber for empty array
	@Test
	void findLargestNumberEmptyArray() {
		integerArrayOne = new Integer[] { 0 };
		bigIntOne = LargestNumberSolver.findLargestNumber(integerArrayOne);
		bigIntTwo = new BigInteger("0");
		assertEquals(bigIntTwo, bigIntOne);
	}

	// Tests findLargestNumber for an array with two elements
	@Test
	void findLargestNumberSmallArray() {
		integerArrayOne = new Integer[] { 0, 1 };
		bigIntOne = LargestNumberSolver.findLargestNumber(integerArrayOne);
		bigIntTwo = new BigInteger("10");
		assertEquals(bigIntTwo, bigIntOne);
	}

	// Tests findLargestNumber for an array with five elements
	@Test
	void findLargestNumberMedArray() {
		integerArrayOne = new Integer[] { 1, 2, 3, 4, 5 };
		bigIntOne = LargestNumberSolver.findLargestNumber(integerArrayOne);
		bigIntTwo = new BigInteger("54321");
		assertEquals(bigIntTwo, bigIntOne);
	}

	// Tests findLargestNumber for an array with twenty elements
	@Test
	void findLargestNumberLargeArray() {
		integerArrayOne = new Integer[20];
		for (int i = 0; i < 20; i++) {
			integerArrayOne[i] = i + 1;
		}
		bigIntOne = LargestNumberSolver.findLargestNumber(integerArrayOne);
		bigIntTwo = new BigInteger("9876543220191817161514131211110");
		assertEquals(bigIntTwo, bigIntOne);
	}

	/*
	 * findLargestInt method tests
	 */

	// Tests findLargestInt for empty array
	@Test
	void findLargestIntEmptyArray() {
		integerArrayOne = new Integer[] { 0 };
		int intOne = LargestNumberSolver.findLargestInt(integerArrayOne);
		int intTwo = 0;
		assertEquals(intTwo, intOne);
	}

	// Tests findLargestInt for an array with two elements
	@Test
	void findLargestIntSmallArray() {
		integerArrayOne = new Integer[] { 0, 1 };
		int intOne = LargestNumberSolver.findLargestInt(integerArrayOne);
		int intTwo = 10;
		assertEquals(intTwo, intOne);
	}

	// Tests findLargestInt for an array with five elements
	@Test
	void findLargestIntMedArray() {
		integerArrayOne = new Integer[] { 1, 2, 3, 4, 5 };
		int intOne = LargestNumberSolver.findLargestInt(integerArrayOne);
		int intTwo = 54321;
		assertEquals(intTwo, intOne);
	}

	// Test findLargestInt for an array past the bounds of int
	@Test
	void findLargestIntErr() {
		integerArrayOne = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		assertThrows(OutOfRangeException.class, () -> {
			LargestNumberSolver.findLargestInt(integerArrayOne);
		});
	}

	/*
	 * findLargestLong method tests
	 */

	// Tests findLargestLong for empty array
	@Test
	void findLargestLongEmptyArray() {
		integerArrayOne = new Integer[] { 0 };
		long intOne = LargestNumberSolver.findLargestLong(integerArrayOne);
		long intTwo = 0;
		assertEquals(intTwo, intOne);
	}

	// Tests findLargestLong for an array with two elements
	@Test
	void findLargestLongSmallArray() {
		integerArrayOne = new Integer[] { 0, 1 };
		long intOne = LargestNumberSolver.findLargestLong(integerArrayOne);
		long intTwo = 10;
		assertEquals(intTwo, intOne);
	}

	// Tests findLargestLong for an array with five elements
	@Test
	void findLargestLongMedArray() {
		integerArrayOne = new Integer[] { 1, 2, 3, 4, 5 };
		long intOne = LargestNumberSolver.findLargestLong(integerArrayOne);
		long intTwo = 54321;
		assertEquals(intTwo, intOne);
	}

	// Test findLargestLong for an array past the bounds of long
	@Test
	void findLargestLongErr() {
		integerArrayOne = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
		assertThrows(OutOfRangeException.class, () -> {
			LargestNumberSolver.findLargestLong(integerArrayOne);
		});
	}
}
