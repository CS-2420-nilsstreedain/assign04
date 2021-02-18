package assign04;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

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
	private BigInteger bigIntOne;
	private BigInteger bigIntTwo;

	private ArrayList<Integer[]> plainArrayList;
	private LinkedList<Integer[]> plainLinkedList;
	private Vector<Integer[]> plainVector;

	private ArrayList<Integer[]> emptyArrayList;
	private ArrayList<Integer[]> largeArrayList;
	private ArrayList<Integer[]> arrayListWithEmptyIntegerArrays;
	// private LargestNumberSolver solver = new LargestNumberSolver();

	@BeforeEach
	void setUp() throws Exception {
		plainArrayList = new ArrayList<>();
		plainArrayList.add(new Integer[] { 3, 3, 3 });
		plainArrayList.add(new Integer[] { 2, 2, 2 });
		plainArrayList.add(new Integer[] { 1, 1, 1 });

		plainLinkedList = new LinkedList<>();
		plainLinkedList.add(new Integer[] { 3, 3, 3 });
		plainLinkedList.add(new Integer[] { 2, 2, 2 });
		plainLinkedList.add(new Integer[] { 1, 1, 1 });

		plainVector = new Vector<>();
		plainVector.add(new Integer[] { 3, 3, 3 });
		plainVector.add(new Integer[] { 2, 2, 2 });
		plainVector.add(new Integer[] { 1, 1, 1 });

		emptyArrayList = new ArrayList<>();

		largeArrayList = new ArrayList<>();
		for (int i = 0; i < 100; i++)
			largeArrayList.add(new Integer[] { i, i, i });

		arrayListWithEmptyIntegerArrays = new ArrayList<>();
		arrayListWithEmptyIntegerArrays.add(new Integer[] { 3, 3, 3 });
		arrayListWithEmptyIntegerArrays.add(new Integer[0]);
		arrayListWithEmptyIntegerArrays.add(new Integer[] { 2, 2, 2 });
		arrayListWithEmptyIntegerArrays.add(new Integer[0]);
		arrayListWithEmptyIntegerArrays.add(new Integer[] { 1, 1, 1 });
	}

	// -------------------------------------------------- insertionSort method tests --------------------------------------------------

	// Tests insertionSort() for an empty Integer array
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

	// -------------------------------------------------- findLargestNumber() method tests --------------------------------------------------

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

	// -------------------------------------------------- findLargestInt() method tests --------------------------------------------------

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

	// -------------------------------------------------- findLargestLong() method tests --------------------------------------------------

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

	// Tests findLargestLong for an array past the bounds of long
	@Test
	void findLargestLongErr() {
		integerArrayOne = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
		assertThrows(OutOfRangeException.class, () -> {
			LargestNumberSolver.findLargestLong(integerArrayOne);
		});
	}

	// ------------------------------------------------------- sum() method tests -------------------------------------------------------

	// Tests sum with an ArrayList containing 3 Integer arrays of 3 elements
	@Test
	void sumSmallArrayList() {
		assertEquals(new BigInteger("666"), LargestNumberSolver.sum(plainArrayList));
	}

	// Tests sum with a LinkedList containing 3 Integer arrays of 3 elements
	@Test
	void sumSmallLinkedList() {
		assertEquals(new BigInteger("666"), LargestNumberSolver.sum(plainLinkedList));
	}

	// Tests sum with a Vector containing 3 Integer arrays of 3 elements
	@Test
	void sumSmallVector() {
		assertEquals(new BigInteger("666"), LargestNumberSolver.sum(plainVector));
	}

	// Tests sum with an empty Integer ArrayList
	@Test
	void sumEmptyArrayList() {
		assertEquals(new BigInteger("0"), LargestNumberSolver.sum(emptyArrayList));
	}

	// Tests sum with a large Integer ArrayList
	@Test
	void sumLargeArrayList() {
		assertEquals(new BigInteger("49550400"), LargestNumberSolver.sum(largeArrayList));
	}

	// Tests sum with a an ArrayList containing some empty Integer arrays
	@Test
	void sumTooShortArrayList() {
		assertEquals(new BigInteger("666"), LargestNumberSolver.sum(arrayListWithEmptyIntegerArrays));
	}

	// -------------------------------------------------- findKthLargest() method tests --------------------------------------------------

	// Tests findKth with an ArrayList containing 3 Integer arrays of 3 elements
	@Test
	void findKthSmallArrayList() {
		assertArrayEquals(new Integer[] { 3, 3, 3 }, LargestNumberSolver.findKthLargest(plainArrayList, 0));
	}

	// Tests findKth with a LinkedList containing 3 Integer arrays of 3 elements
	@Test
	void findKthSmallLinkedList() {
		assertArrayEquals(new Integer[] { 3, 3, 3 }, LargestNumberSolver.findKthLargest(plainLinkedList, 0));
	}

	// Tests findKth with a Vector containing 3 Integer arrays of 3 elements
	@Test
	void findKthSmallVector() {
		assertArrayEquals(new Integer[] { 3, 3, 3 }, LargestNumberSolver.findKthLargest(plainVector, 0));
	}

	// Tests finKth with an empty Integer ArrayList
	@Test
	void findKthEmptyArrayList() {
		assertThrows(IllegalArgumentException.class, () -> {
			LargestNumberSolver.findKthLargest(emptyArrayList, 0);
		});
	}

	// Tests findKth with a an ArrayList containing an empty Integer
	@Test
	void findKthArrayListEmptyIntArray() {
		emptyArrayList.add(new Integer[0]);
		assertArrayEquals(new Integer[0], LargestNumberSolver.findKthLargest(emptyArrayList, 0));
	}

	// Tests findKth with a large Integer ArrayList
	@Test
	void findKthLargeArrayList() {
		assertArrayEquals(new Integer[] { 99, 99, 99 }, LargestNumberSolver.findKthLargest(largeArrayList, 0));
	}

	// Tests last value of findKth with a large Integer ArrayList
	@Test
	void findLastKthLargeArrayList() {
		assertArrayEquals(new Integer[] { 0, 0, 0 }, LargestNumberSolver.findKthLargest(largeArrayList, 99));
	}

	// Tests findKth with a an ArrayList containing some empty Integer arrays
	@Test
	void findKthTooShortArrayList() {
		assertArrayEquals(new Integer[] { 3, 3, 3 },
				LargestNumberSolver.findKthLargest(arrayListWithEmptyIntegerArrays, 0));
	}
	
	
	// -------------------------------------------------- readFile() method tests --------------------------------------------------
	
	// Tests readFile by inputting the file and confirming three indexes
	@Test
	void readFileArrayList() {
		ArrayList<Integer[]> file = (ArrayList<Integer[]>) LargestNumberSolver.readFile("src/assign04/integers.txt");
		assertArrayEquals(new Integer[] { 88, 51 }, file.get(7));
		assertArrayEquals(new Integer[] { 92, 89, 39, 7, 21 }, file.get(13));
		assertArrayEquals(new Integer[] { 21, 75, 100, 99 }, file.get(739));
	}
	
	// Test readFile by inputting an invalid file and expecting an empty array
	@Test
	void readFileNoFile() {
		ArrayList<Integer[]> file = (ArrayList<Integer[]>) LargestNumberSolver.readFile("");
		assertEquals(new ArrayList<Integer[]>(),file);
	}
	
	// Test readFile by inputting an invalid file and expecting an empty file
	@Test
	void readFileEmptyFile() {
		ArrayList<Integer[]> file = (ArrayList<Integer[]>) LargestNumberSolver.readFile("src/assign04/empty.txt");
		assertEquals(new ArrayList<Integer[]>(),file);
	}
}
