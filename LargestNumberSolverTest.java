package assign04;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 * 
 * @author Kyle Williams, Nils Streedain
 * @version February 17, 2021
 */
class LargestNumberSolverTest {

	private Integer[] integerArrayOne;
	private Integer[] integerArrayTwo;
	private Integer[] integerArrayThree;
	
	
	private ArrayList<Integer[]> arrayList = new ArrayList<>();

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
		integerArrayOne = new Integer[] {0, 1};
		integerArrayTwo = new Integer[] {1, 0};
		LargestNumberSolver.insertionSort(integerArrayTwo, (o1, o2) -> o2 - o1);
		assertArrayEquals(integerArrayOne, integerArrayTwo);
	}

	// Tests insertionSort for an Integer array with five elements
	@Test
	void insertionSortFiveValues() {
		integerArrayOne = new Integer[] {0, 1, 2, 3, 4, 5};
		integerArrayTwo = new Integer[] {5, 3, 2, 4, 1, 0};
		LargestNumberSolver.insertionSort(integerArrayTwo, (o1, o2) -> o2 - o1);
		assertArrayEquals(integerArrayOne, integerArrayTwo);
	}
	
	// Test insertionSort for an Integer array with five of the same elements
	@Test
	void insertionSortSameValues() {
		integerArrayOne = new Integer[] {0, 0, 0, 0, 0, 0};
		integerArrayTwo = new Integer[] {0, 0, 0, 0, 0, 0};
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
}
